import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeAVL  {  
    private NodeAVL raiz;       

    public BinaryTreeAVL() {  
        raiz = null;  
    }  

    // Faz a árvore avl vazia.
    public void removerTodos()  {  
        raiz = null;  
    }  

    // Checa se a árvore está vazia ou não.
    public boolean checaVazio() {  
        if(raiz == null)  
            return true;
        else   
            return false;  
    }

    // Insere um elemento na Árvore Binária AVL.
    public void inserirElemento(int valor)  {  
        raiz = inserirElemento(valor, raiz);  
    }  
      
    // Pega a altura da árvore AVL.
    private int pegarAltura(NodeAVL node ) {  
        return node == null ? -1 : node.altura;  
    }  

    // Pega a altura máxima do node. 
    private int pegaAlturaMaxima(int alturaNodeEsquerda, int alturaNodeDireita) {  
        return alturaNodeEsquerda > alturaNodeDireita ? alturaNodeEsquerda : alturaNodeDireita;  
    }  
      
    // Método para inserir dados na Árvore AVL recursivamente.
    private NodeAVL inserirElemento(int valor, NodeAVL node) {  
        // Checa se o node é nulo ou não.
        if (node == null)  
            node = new NodeAVL(valor);  
        // Insere um node caso o valor seja menor que o valor da raiz.
        else if (valor < node.valor) {  
            node.esquerda = inserirElemento( valor, node.esquerda );  
            if( pegarAltura( node.esquerda ) - pegarAltura( node.direita ) == 2 )  
                if( valor < node.esquerda.valor )  
                    node = duplaComFilhoEsquerdo( node );  
                else  
                    node = duplaComFilhoEsquerdo( node );  
        } else if( valor > node.valor ) {  
            node.direita = inserirElemento( valor, node.direita );  
            if( pegarAltura( node.direita ) - pegarAltura( node.esquerda ) == 2 )  
                if( valor > node.direita.valor)  
                    node = rotacaoComFilhoDireito( node );  
                else  
                    node = duplaComFilhoDireito( node );  
        }  else;  // Se o valor está presente na árvore, não faz nada.
        node.altura = pegaAlturaMaxima( pegarAltura( node.esquerda ), pegarAltura( node.direita ) ) + 1;  
        return node;  
    }  
      
    // Rotação com o Filho Esquerdo.      
    private NodeAVL rotacaoComFilhoEsquerdo(NodeAVL node2) {  
        NodeAVL node1 = node2.esquerda;  
        node2.esquerda = node1.direita;  
        node1.direita = node2;  
        node2.altura = pegaAlturaMaxima( pegarAltura( node2.esquerda ), pegarAltura( node2.direita ) ) + 1;  
        node1.altura = pegaAlturaMaxima( pegarAltura( node1.esquerda ), node2.altura ) + 1;  
        return node1;  
    }  
  
    // Rotação com o Filho Direito    
    private NodeAVL rotacaoComFilhoDireito(NodeAVL node1) {  
        NodeAVL node2 = node1.direita;  
        node1.direita = node2.esquerda;  
        node2.esquerda = node1;  
        node1.altura = pegaAlturaMaxima( pegarAltura( node1.esquerda ), pegarAltura( node1.direita ) ) + 1;  
        node2.altura = pegaAlturaMaxima( pegarAltura( node2.direita ), node1.altura ) + 1;  
        return node2;  
    }  
  
    // Faz a rotação dupla da Árvore Binária.
    private NodeAVL duplaComFilhoEsquerdo(NodeAVL node3) {  
        node3.esquerda = rotacaoComFilhoDireito( node3.esquerda );  
        return rotacaoComFilhoEsquerdo( node3 );  
    }  
  
    // Faz a rotação dupla da Árvore Binária.
    private NodeAVL duplaComFilhoDireito(NodeAVL node1) {  
        node1.direita = rotacaoComFilhoEsquerdo( node1.direita );  
        return rotacaoComFilhoDireito( node1 );  
    }      
  
    // Pega a quantidade de nodes na Árvore AVL
    public int pegarTotalNumeroNodes() {  
        return pegarTotalNumeroNodes(raiz);  
    }  

    private int pegarTotalNumeroNodes(NodeAVL cabeca) {  
        if (cabeca == null)  
            return 0;  
        else {  
            int tamanho = 1;  
            tamanho = tamanho + pegarTotalNumeroNodes(cabeca.esquerda);  
            tamanho = tamanho + pegarTotalNumeroNodes(cabeca.direita);  
            return tamanho;  
        }  
    }  
  
    // Pesquisar Elemento
    public boolean pesquisarElemento(int element) {  
        return pesquisarElemento(raiz, element);  
    }  
  
    private boolean pesquisarElemento(NodeAVL cabeca, int element) {  
        boolean check = false;  
        while ((cabeca != null) && !check)  {
            int elementoCabeca = cabeca.valor;
            if (element < elementoCabeca)
                cabeca = cabeca.esquerda;
            else if (element > elementoCabeca)
                cabeca = cabeca.direita;
            else {
                check = true;
                break;
            }  
            check = pesquisarElemento(cabeca, element);  
        }  
        return check;  
    } 

    // Passagem Em Ordem.
    public void passagemEmOrdem() {  
        passagemEmOrdem(raiz);  
    } 

    private void passagemEmOrdem(NodeAVL cabeca) {  
        if (cabeca != null) {  
            passagemEmOrdem(cabeca.esquerda);  
            System.out.print(cabeca.valor+" ");  
            passagemEmOrdem(cabeca.direita);  
        }  
    }  
  
    // Passagem Pré Ordem.
    public void passagemPreOrdem() {  
        passagemPreOrdem(raiz);  
    }

    private void passagemPreOrdem(NodeAVL head) {  
        if (head != null) {  
            System.out.print(head.valor + " ");  
            passagemPreOrdem(head.esquerda);               
            passagemPreOrdem(head.direita);  
        }  
    }  
      
    //  Passagem Pós Ordem.
    public void passagemPosOrdem() {  
        passagemPosOrdem(raiz);  
    }  
      
    private void passagemPosOrdem(NodeAVL cabeca) {  
        if (cabeca != null) {  
            passagemPosOrdem(cabeca.esquerda);               
            passagemPosOrdem(cabeca.direita);  
            System.out.print(cabeca.valor + " ");  
        }  
    }

    public void passadaEmNivel() {
        if (raiz == null) {
            return;
        }
    
        Queue<NodeAVL> nodes = new LinkedList<>();
        nodes.add(raiz);
    
        while (!nodes.isEmpty()) {
            NodeAVL node = nodes.remove();

            System.out.print(" " + node.valor);
    
            if (node.esquerda != null) {
                nodes.add(node.esquerda);
            }
    
            if (node.direita != null) {
                nodes.add(node.direita);
            }
        }
    }
}