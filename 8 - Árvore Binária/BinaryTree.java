import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node raiz;

    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private Node adicionarRecursivo(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor);
        }
        if (valor <= atual.valor) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarRecursivo(atual.direita, valor);
        } 
        return atual;
    }

    public boolean pesquisar(int valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    private boolean pesquisarRecursivo(Node atual, int valor) {
        if (atual == null) {
            return false;
        } 
        if (valor == atual.valor) {
            return true;
        } 
        return valor < atual.valor
          ? pesquisarRecursivo(atual.esquerda, valor)
          : pesquisarRecursivo(atual.direita, valor);
    }

    public void deletar(int valor) {
        raiz = deletarRecursivo(raiz, valor);
    }

    private Node deletarRecursivo(Node atual, int valor) {
        if (atual == null) {
            return null;
        }
    
        if (valor == atual.valor) {
            // Node sem nenhum filho.
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // Node com apenas um filho.
            if (atual.direita == null) {
                return atual.esquerda;
            }
            
            if (atual.esquerda == null) {
                return atual.direita;
            }

            // Node com dois filhos.
            int menorValor = acharMenorValor(atual.direita);
            atual.valor = menorValor;
            atual.direita = deletarRecursivo(atual.direita, menorValor);
            return atual;

        } 

        if (valor < atual.valor) {
            atual.esquerda = deletarRecursivo(atual.esquerda, valor);
            return atual;
        }

        atual.direita = deletarRecursivo(atual.direita, valor);
        return atual;
    }
    private int acharMenorValor(Node raiz) {
        return raiz.esquerda == null ? raiz.valor : acharMenorValor(raiz.esquerda);
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
    
    public void passadaEmNivel() {
        if (raiz == null) {
            return;
        }
    
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(raiz);
    
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
    
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
