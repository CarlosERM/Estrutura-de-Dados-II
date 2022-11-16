import java.util.ArrayList; // import the ArrayList class
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
    Node raiz;
    ArrayList<Integer> numeros = new ArrayList<Integer>();

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


    public void transformaVetor(Node node) {
        if (node != null) {
            transformaVetor(node.esquerda);
            numeros.add(node.valor);
            transformaVetor(node.direita);
        }

    }

    // Passada
    public void passadaEmOrdem(Node node) {
        if (node != null) {
            passadaEmOrdem(node.esquerda);
            System.out.print(" " + node.valor);
            passadaEmOrdem(node.direita);
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

   public Node arrayOrdenadoParaArvoreBinaria(ArrayList<Integer> array, int inicio, int fim) {
        if (inicio > fim) {
            return null;
        }
 
        int meio = (inicio + fim) / 2;
        Node node = new Node(array.get(meio));
 

        node.esquerda = arrayOrdenadoParaArvoreBinaria(array, inicio, meio - 1);
        node.direita = arrayOrdenadoParaArvoreBinaria(array, meio + 1, fim);
         
        return node;
    }
    

    // Função que converte a árbore binária que entra em uma lista encadeada à direita.
    public int arvoreBinariaParaListaEncadeada(Node node) {
        int contador = 0;
 
        // Faz um ponteiro temporário para atravessar e amassar a árvore binária.
        Node temp = node.direita;
 
        // Atravessa até que temp se torne null;
        while (temp != null) {
            // Se a esquerda existe para o node apontado por temp
            // então rode pra direita.
            if (temp.esquerda != null) {
                Node velhoTemp = temp;
                temp = temp.esquerda;
                velhoTemp.esquerda = temp.direita;
                temp.direita = velhoTemp;
                node.direita = temp;
            }

            // Se a esquerda não exisitr, adiciona um para contador
            // e atravesse para a direita para amassar o restante da árvore binária.
            else {
                contador++;
                node = temp;
                temp = temp.direita;
            }
        }
 
        return contador;
    }
 
    // Função para comprimir uma árvore.
    public void comprimir(Node node, int m) {

        Node temp = node.direita;
 
        // Atravesse e rode para esquerda m vezes para comprimir para uma árvore binária.
        for (int i = 0; i < m; i++) {
            Node velhoTemp = temp;
            temp = temp.direita;
            node.direita = temp;
            velhoTemp.direita = temp.esquerda;
            temp.esquerda = velhoTemp;
            node = temp;
            temp = temp.direita;
        }
    }
 
    // Função para calcular o log de base 2 de um inteiro.
    public int log2(int N) {
        int resultado = (int)(Math.log(N) / Math.log(2));
        return resultado;
    }
 
    // Function to implement the algorithm

    // Função que implementa o algoritmo DSW;
    public Node balanceamentoDSW(Node raiz) {
        // Node de mentira com o valor 0;
        Node node = new Node(0);
 
        // Fazer com que à direita do node de mentira esteja a arvore binária.
        node.direita = raiz;
 
        // Pega o número de nodes da árvore binária e ao mesmo tempo converte ela 
        // em uma lista encadeada.
        int count = arvoreBinariaParaListaEncadeada(node);

        // Pega a altura da árvore em que todos os níveis estão complemente preenchidos.
        int h = log2(count + 1);
 
        // Pega o número de nodes até o último segundo nível.
        int m = (int)Math.pow(2, h) - 1;
 
        // Roda para a esquerda para os nodes em excesso no último nível.
        comprimir(node, count - m);

        // Roda para a esquerda até que m se torne 0;
        // Isso é feito para balancear a árvore.
        for (m = m / 2; m > 0; m /= 2) {
            comprimir(node, m);
        }
 
        return node.direita;
    }
}
