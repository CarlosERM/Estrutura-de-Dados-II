class BinaryTreeAVL {
    NodeAVL raiz;
 
    // Pega a altura da árvore.
    int altura(NodeAVL node) {
        if (node == null)
            return 0;
        return node.altura;
    }
 
    // Pega o máximo de dois números.
    int maior(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // Roda a subárvore para a direita.
    NodeAVL rotacaoDireita(NodeAVL node) {
        NodeAVL novaRaiz = node.esquerda;
        NodeAVL subarvore2 = novaRaiz.direita;
 
        // Rotação
        novaRaiz.direita = node;
        node.esquerda = subarvore2;
 
        // Atualizar altura dos nodes.
        node.altura = maior(altura(node.esquerda), altura(node.direita)) + 1;
        novaRaiz.altura = maior(altura(novaRaiz.esquerda), altura(novaRaiz.direita)) + 1;
 
        return novaRaiz;
    }
 
    // Rodar pra esquerda.
    NodeAVL rotacaoEsquerda(NodeAVL node) {
        NodeAVL novaRaiz = node.direita;
        NodeAVL subarvore2 = novaRaiz.esquerda;
 
        novaRaiz.esquerda = node;
        node.direita = subarvore2;
 
        node.altura = maior(altura(node.esquerda), altura(node.direita)) + 1;
        novaRaiz.altura = maior(altura(novaRaiz.esquerda), altura(novaRaiz.direita)) + 1;
 
        return novaRaiz;
    }
 
    int getBalanceamento(NodeAVL node) {
        if (node == null)
            return 0;
 
        return altura(node.direita) - altura(node.direita);
    }

    void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }
 
    NodeAVL inserir(NodeAVL node, int valor) {
 
        /* 1.  INSERÇÃO NORMAL */
        if (node == null)
            return (new NodeAVL(valor));
 
        if (valor < node.valor)
            node.esquerda = inserir(node.esquerda, valor);
        else if (valor > node.valor)
            node.direita = inserir(node.direita, valor);
        else // Valores iguais não são permitidos.
            return node;
 
        // 2. Atualizar a altura do node.
        node.altura = 1 + maior(altura(node.esquerda), altura(node.direita));
 
        // Pega o fator de balanceamento do node para checar se ele está desbalanceado.
        int balanceamento = getBalanceamento(node);
 

        if (balanceamento > 1 && valor < node.esquerda.valor)
            return rotacaoDireita(node);
 
        // Caso Direita Direita.
        if (balanceamento < -1 && valor > node.direita.valor)
            return rotacaoEsquerda(node);
 
        // Caso Esquerda Direita.
        if (balanceamento > 1 && valor > node.esquerda.valor) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }
 
        // caso Direita Esquerda.
        if (balanceamento < -1 && valor < node.direita.valor) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }
 
        return node;
    }

    // Retorna o menor valor da árvore.
    NodeAVL menorValor(NodeAVL node) { 
        NodeAVL atual = node; 
  
        // O loop vai até a folha na extrema-esquerda. Que é o menor valor possível na árvore.
        while (atual.esquerda != null) 
            atual = atual.esquerda; 
  
        return atual; 
    } 
  
    void deletar(int valor) {
        raiz = deletarNode(raiz, valor);
    }
    
    NodeAVL deletarNode(NodeAVL raiz, int valor) { 
        // 1. Remoção padrão.
        if (raiz == null) 
            return raiz; 
  
        // Se o valor a ser deletador é menor que o valor da raiz, então ele está
        // na subárvore à esquerda.
        if (valor < raiz.valor) 
            raiz.esquerda = deletarNode(raiz.esquerda, valor); 
  
        // Se o valor a ser deletado é maior que o valor da raiz, então ele está
        // na subárvore à direita.
        else if (valor > raiz.valor) 
            raiz.direita = deletarNode(raiz.direita, valor); 
  
        // Se o valor é o mesmo que o valor de raiz, então esse é o node
        // que deve ser deletado.
        else { 
            // Node com apenas um filho ou nenhum filho. 
            if ((raiz.esquerda == null) || (raiz.direita == null)) { 
                NodeAVL temp = null; 
                if (temp == raiz.esquerda) 
                    temp = raiz.direita; 
                else
                    temp = raiz.esquerda; 
  
                // Caso sem filhos. 
                if (temp == null) { 
                    temp = raiz; 
                    raiz = null; 
                } 
                else // Caso com um filho.
                    raiz = temp; // Copia o conteúdo do filho não-vazio.
            } 
            else { 

                // Node com dois filhos: Pega o sucessor em ordem(O menor na subárvore à direita.)
                NodeAVL temp = menorValor(raiz.direita); 
  
                // Copia o sucessor em ordem para esse node.
                raiz.valor = temp.valor; 
  
                // Deletar o sucessor em ordem.  
                raiz.direita = deletarNode(raiz.direita, temp.valor); 
            } 
        } 
  
        // Se a árvore tiver apenas um node.
        if (raiz == null) 
            return raiz; 
  
        // 2. Pega a altura atual de um node;
        raiz.altura = maior(altura(raiz.esquerda), altura(raiz.direita)) + 1; 
  
        // 3. Pega o fator de balanceamento desse node. Para ver se ele está desbalancadeado.
        int balanceamento = getBalanceamento(raiz); 
  
        // Se o node está desbalanceado, então temos 4 casos.
        // esquerda esquerda Case 
        if (balanceamento > 1 && getBalanceamento(raiz.esquerda) >= 0) 
            return rotacaoDireita(raiz); 
  
        // esquerda direita Case 
        if (balanceamento > 1 && getBalanceamento(raiz.esquerda) < 0) { 
            raiz.esquerda = rotacaoEsquerda(raiz.esquerda); 
            return rotacaoDireita(raiz); 
        } 
  
        // direita direita Case 
        if (balanceamento < -1 && getBalanceamento(raiz.direita) <= 0) 
            return rotacaoEsquerda(raiz); 
  
        // direita esquerda Case 
        if (balanceamento < -1 && getBalanceamento(raiz.direita) > 0) { 
            raiz.direita = rotacaoDireita(raiz.direita); 
            return rotacaoEsquerda(raiz); 
        } 
        return raiz; 
    } 

   
    // Passadas
    public void passadaEmOrdem(NodeAVL node) {
        if (node != null) {
            passadaEmOrdem(node.esquerda);
            System.out.print(" " + node.valor);
            passadaEmOrdem(node.direita);
        }
    }

    public void passadaPreOrdem(NodeAVL node) {
        if (node != null) {
            System.out.print(" " + node.valor);
            passadaPreOrdem(node.esquerda);
            passadaPreOrdem(node.direita);
        }
    }

    public void passadaPosOrdem(NodeAVL node) {
        if (node != null) {
            passadaPosOrdem(node.esquerda);
            passadaPosOrdem(node.direita);
            System.out.print(" " + node.valor);
        }
    }
 
}