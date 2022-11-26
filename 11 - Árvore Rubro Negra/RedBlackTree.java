public class RedBlackTree {
    Node raiz;

    boolean RED = false;
    boolean BLACK = true;

    private void substituirCriancaDoPai(Node pai, Node filhoVelho, Node novoFilho) {
        if (pai == null) {
          raiz = novoFilho;
        } else if (pai.esquerda == filhoVelho) {
          pai.esquerda = novoFilho;
        } else if (pai.direita == filhoVelho) {
          pai.direita = novoFilho;
        } else {
          throw new IllegalStateException("Node não é filho do seu pai");
        }
      
        if (novoFilho != null) {
          novoFilho.pai = pai;
        }
    }

    void rotacaoDireita(Node node) {
        Node pai = node.pai;
        Node filhoEsquerdo = node.esquerda;
      
        node.esquerda = filhoEsquerdo.direita;
        if (filhoEsquerdo.direita != null) {
          filhoEsquerdo.direita.pai = node;
        }
      
        filhoEsquerdo.direita = node;
        node.pai = filhoEsquerdo;
      
        substituirCriancaDoPai(pai, node, filhoEsquerdo);
    }

    void rotacaoEsquerda(Node node) {
        Node pai = node.pai;
        Node filhoDireito = node.direita;
      
        node.direita = filhoDireito.esquerda;
        if (filhoDireito.esquerda != null) {
            filhoDireito.esquerda.pai = node;
        }
      
        filhoDireito.esquerda = node;
        node.pai = filhoDireito;
      
        substituirCriancaDoPai(pai, node, filhoDireito);
    }

    public Node pesquisar(int valor) {
        Node node = raiz;
        while (node != null) {
          if (valor == node.valor) {
            return node;
          } else if (valor < node.valor) {
            node = node.esquerda;
          } else {
            node = node.direita;
          }
        }
      
        return null;
    }

    public void inserir(int valor) {
        Node node = raiz;
        Node pai = null;
      
        // Passada pela árvore da esquerda ou direita dependendo do valor.
        while (node != null) {
          pai = node;
          if (valor <= node.valor) {
            node = node.esquerda;
          } else if (valor > node.valor) {
            node = node.direita;
          } 
        }
      
        // Inserir novo Node.
        Node novoNode = new Node(valor);
        novoNode.cor = RED; // 5 regra: Todos os caminhos de um node para as folhas devem conter o mesmo número de nodes pretos.
        if (pai == null) {
          raiz = novoNode;
        } else if (valor < pai.valor) {
          pai.esquerda = novoNode;
        } else {
          pai.direita = novoNode;
        }
        novoNode.pai = pai;
      
        //  Se o node pai do node inserido for vermelho, então a regra 4 foi violada. 
        //  Por isso precisamos reparar a árvore recolorindo e rotacionando para que 
        //  todas as regras sejam satisfeitas.
        consertarPropriedadesArvoreRubroNegraDepoisDoInserir(novoNode);
      }

      void consertarPropriedadesArvoreRubroNegraDepoisDoInserir(Node node) {
        Node pai = node.pai;

        // Caso 1: O pai é nulo, nós alcançamos a raiz, portanto é o fim da recursão.
        if (pai == null) {
          node.cor = BLACK;
          return;
        }

        // Pai é preto --> não faça nada.
        if (pai.cor == BLACK) {
          return;
        }

        // De agora em diante o pai é vermelho.
        Node avo = pai.pai;

        // Pega o tio( pode ser null/nil, nesse caso a sua cor é BLACK.)
        Node tio = pegarTio(pai);

        // Caso 3: O tio é vermelho --> recolorir o pai, avô e tio.
        if (tio != null && tio.cor == RED) {
          pai.cor = BLACK;
          avo.cor = RED;
          tio.cor = BLACK;

          // Chama recursivamente para o avô, que agora é vermelho.
          // Pode ser raiz ou ter um pai vermelho, nesse caso nós precisamos consertar mais.
          consertarPropriedadesArvoreRubroNegraDepoisDoInserir(avo);
        }

        // Pai é o filho esquerdo do avô.
        else if (pai == avo.esquerda) {
          // Caso 4a: Tio é preto e o node é esquerda --> direita "neto interno" do seu avô.
          if (node == pai.direita) {
            rotacaoEsquerda(pai);
            // Deixe "pai" apontar para o novo nó raiz da sub-árvore rotacionada.
            // Ele será recolorido na próxima etapa, para a qual iremos cair.
            pai = node;
          }

          // Caso 5: Tio é preto e o node é esquerda --> esquerda "Neto Externo" do seu avô.
          rotacaoDireita(avo);
          
          // Recolorir o pai original e o avô.
          pai.cor = BLACK;
          avo.cor = RED;
        } else { // Pai é filho direito do avô.
          // Caso 4b: Tio é preto e o node é direita --> esquerda "neto interno" do seu avô.
          if (node == pai.esquerda) {
            rotacaoDireita(pai);
            // Deixe "pai" apontar para o novo nó raiz da sub-árvore rotacionada.
            // Ele será recolorido na próxima etapa, para a qual iremos cair.
            pai = node;
          }

          // Caso 5b: O tio é preto e o node é Direita --> Direita "neto externo" do seu avô.
          rotacaoEsquerda(avo);

          // Recolorir o pai original e o avô.
          pai.cor = BLACK;
          avo.cor = RED;
        }
      }

      Node pegarTio(Node pai) {
        Node avo = pai.pai;
        if (avo.esquerda == pai) {
          return avo.direita;
        } else if (avo.direita == pai) {
          return avo.esquerda;
        } else {
          throw new IllegalStateException("O pai não é um filho do seu avô.");
        }
      }

      public void deletar(int valor) {
        Node node = raiz;
      
        // Acha o node que vai ser deletado.
        while (node != null && node.valor != valor) {
          // Atravessa a árvore da esquerda para a direita dependendo do valor.
          if (valor <= node.valor) {
            node = node.esquerda;
          } else {
            node = node.direita;
          }
        }
      
        // Node não foi encontrado.
        if (node == null) {
          return;
        }
      
        // At this point, "node" is the node to be deleted
        // A partir desse ponto o node é o node que vai ser deletado.

        Node nodeSubiu;
        boolean corNodeDeletado;
      
        // O node tem 0 ou 1 filho.
        if (node.esquerda == null || node.direita == null) {
          nodeSubiu = deletarNodeComZeroUmFilho(node);
          corNodeDeletado = node.cor;
        }
      
        // Node tem 2 filhos.
        else {
          // Acha o node mínimo da sub-árvore à direita. ( O sucessor em-ordem do node atual). 
          Node sucessor = acheMinimo(node.direita);
      
          // Copia o valor do sucessor para node atual(mantenha a sua cor);
          node.valor = sucessor.valor;
      
          // Delete o sucessor em-ordem como se ele fosse um node com 0 ou 1 filho.
          nodeSubiu = deletarNodeComZeroUmFilho(sucessor);
          corNodeDeletado = sucessor.cor;
        }
      
        if (corNodeDeletado == BLACK) {
          fixRedBlackPropertiesAfterDelete(nodeSubiu);
      
          // Remova o node NIL temporário.
          if (nodeSubiu.getClass() == NilNode.class) {
            substituirCriancaDoPai(nodeSubiu.pai, nodeSubiu, null);
          }
        }

      }
      
      Node deletarNodeComZeroUmFilho(Node node) {
        // Node tem apenas um filho esquerdo --> substitua pelo filho esquerdo.
        if (node.esquerda != null) {
          substituirCriancaDoPai(node.pai, node, node.esquerda);
          return node.esquerda; // Node que subiu.
        }
      
        // Node tem apenas um filho direito --> subsituta pelo filho direito.
        else if (node.direita != null) {
          substituirCriancaDoPai(node.pai, node, node.direita);
          return node.direita; // Node que subiu.
        }
      
        // Node não tem nenhum filho. -->
        // Node é vermelho --> Apenas remova.
        // Node é preto --> substitua por um NIL node temporário(necessário para consertar as regras R-B).
        else {
          Node novoFilho = node.cor == BLACK ? new NilNode() : null;
          substituirCriancaDoPai(node.pai, node, novoFilho);
          return novoFilho;
        }
      }

      Node acheMinimo(Node node) {
        while (node.esquerda != null) {
          node = node.esquerda;
        }
        return node;
      }

      void fixRedBlackPropertiesAfterDelete(Node node) {
        // Caso 1: O node examido é a raiz. Fim da recursão.
        if (node == raiz) {
          node.cor = BLACK;
          return;
        }
      
        Node irmao = pegarIrmao(node);
      
        // Caso 2: Irmão Vermelho
        if (irmao.cor == RED) {
          lidarIrmaoVermelho(node, irmao);
          irmao = pegarIrmao(node); // Obtenha um novo irmão para os casos 3-6
        }
      
        // Casos 3 + 4: Irmão preto com dois filhos pretos.
        if (ePreto(irmao.esquerda) && ePreto(irmao.direita)) {
          irmao.cor = RED;
      
          // Caso 3: Irmão preto com dois filhos pretos + pai vermelho.
          if (node.pai.cor == RED) {
            node.pai.cor = BLACK;
          }
      
          // Caso 4: Irmão preto com dois filhos pretos + pai preto.
          else {
            fixRedBlackPropertiesAfterDelete(node.pai);
          }
        }
      
        // Caso 5 + 6: Irmão preto com pelo menos um filho vermelho.
        else {
          lidarComIrmaoPretoComPeloMenosUmFilhoVermelho(node, irmao);
        }
      }
      private Node pegarIrmao(Node node) {
        Node pai = node.pai;
        if (node == pai.esquerda) {
          return pai.direita;
        } else if (node == pai.direita) {
          return pai.esquerda;
        } else {
          throw new IllegalStateException("Pai não é um filho do seu avô.");
        }
      }
      
      private boolean ePreto(Node node) {
        return node == null || node.cor == BLACK;
      }

      private void lidarIrmaoVermelho(Node node, Node sibling) {
        // Recolorir.
        sibling.cor = BLACK;
        node.pai.cor = RED;
      
        // .. e rodar.
        if (node == node.pai.esquerda) {
          rotacaoEsquerda(node.pai);
        } else {
          rotacaoDireita(node.pai);
        }
      }
      private void lidarComIrmaoPretoComPeloMenosUmFilhoVermelho(Node node, Node irmao) {
        boolean nodeEFilhoEsquerdo = node == node.pai.esquerda;

        // Caso 5: O irmão preto com pelo menos um filho vermelho + "sobrinho exterior" é preto.
        // --> Recolorir irmão e seu filho, e rodar ao redor de um irmão.
        if (nodeEFilhoEsquerdo && ePreto(irmao.direita)) {
          irmao.esquerda.cor = BLACK;
          irmao.cor = RED;
          rotacaoDireita(irmao);
          irmao = node.pai.direita;
        } else if (!nodeEFilhoEsquerdo && ePreto(irmao.esquerda)) {
          irmao.direita.cor = BLACK;
          irmao.cor = RED;
          rotacaoEsquerda(irmao);
          irmao = node.pai.esquerda;
        }
      
        // Caso 6.
      
        // Caso 6: Irmão preto com pelo menos um filho vermelho + "sobrinho externo" é vermelho.
        // --> Recolorir irmão + pai + filho do irmão e rodar ao redor do pai.
        irmao.cor = node.pai.cor;
        node.pai.cor = BLACK;
        if (nodeEFilhoEsquerdo) {
          irmao.direita.cor = BLACK;
          rotacaoEsquerda(node.pai);
        } else {
          irmao.esquerda.cor = BLACK;
          rotacaoDireita(node.pai);
        }
      }

      // Passadas
    public void passadaEmOrdem(Node node) {
      if (node != null) {
          passadaEmOrdem(node.esquerda);
          System.out.print(" " + node.valor);
          passadaEmOrdem(node.direita);
      }
    }

    public void passadaPreOrdem(Node node) {
        if (node != null) {
            System.out.print(" " + node.valor);
            passadaPreOrdem(node.esquerda);
            passadaPreOrdem(node.direita);
        }
    }

    public void passadaPosOrdem(Node node) {
        if (node != null) {
            passadaPosOrdem(node.esquerda);
            passadaPosOrdem(node.direita);
            System.out.print(" " + node.valor);
        }
    }

}
