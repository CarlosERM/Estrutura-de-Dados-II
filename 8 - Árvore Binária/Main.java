import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinaryTree arvoreBinaria = new BinaryTree();
        Random gerador = new Random();
        int[] numerosAleatorios = new int[5];
        for(int i = 0; i < 20; i++){
            int numero = gerador.nextInt(101);
            arvoreBinaria.adicionar(numero);
            if(i < 5) {
                numerosAleatorios[i] = numero;
            }
        }

        System.out.println();
        System.out.println("Sequência Pré-Ordem.");
        arvoreBinaria.passadaPreOrdem(arvoreBinaria.raiz);
        System.out.println();

        System.out.println();
        System.out.println("Sequência In-Ordem.");
        arvoreBinaria.passadaEmOrdem(arvoreBinaria.raiz);
        System.out.println();

        System.out.println();
        System.out.println("Sequência Pós-Ordem.");
        arvoreBinaria.passadaPosOrdem(arvoreBinaria.raiz);
        System.out.println();

        System.out.println();
        System.out.println("Sequência Em Nível.");
        arvoreBinaria.passadaEmNivel();
        System.out.println();

        System.out.println();
        
        for (int i : numerosAleatorios) {
            System.out.println(i + " Excluído");
            arvoreBinaria.deletar(i);
        }

        System.out.println();
        System.out.println("Sequência Pré-Ordem.");
        arvoreBinaria.passadaPreOrdem(arvoreBinaria.raiz);
        System.out.println();

        System.out.println();
        System.out.println("Sequência In-Ordem.");
        arvoreBinaria.passadaEmOrdem(arvoreBinaria.raiz);
        System.out.println();

        System.out.println();
        System.out.println("Sequência Pós-Ordem.");
        arvoreBinaria.passadaPosOrdem(arvoreBinaria.raiz);
        System.out.println();

        System.out.println();
        System.out.println("Sequência Em Nível.");
        arvoreBinaria.passadaEmNivel();
        System.out.println();

    }
}
