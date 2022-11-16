import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinaryTree arvoreBinaria = new BinaryTree();
        Random gerador = new Random();
        for(int i = 0; i < 100; i++){
            arvoreBinaria.adicionar(gerador.nextInt(101));    
        }

        System.out.println("--------------------------------------");
        System.out.println("---------ALGORITMO DO VETOR-----------");
        System.out.println("--------------------------------------");

        System.out.println();
        System.out.println();
        System.out.println("Níveis da Árvore antes do balanceamento.");
        arvoreBinaria.passadaEmNivel();

        arvoreBinaria.transformaVetor(arvoreBinaria.raiz);
        arvoreBinaria.raiz = arvoreBinaria.arrayOrdenadoParaArvoreBinaria(arvoreBinaria.numeros, 0, arvoreBinaria.numeros.size() - 1);
        
        System.out.println();
        System.out.println();
        System.out.println("Níveis da Árvore depois do balanceamento.");
        arvoreBinaria.passadaEmNivel();


        for(int i = 0; i < 20; i++){
            arvoreBinaria.adicionar(gerador.nextInt(101));    
        }

        System.out.println();
        System.out.println();

        System.out.println("Níveis da Árvore depois de adicionar 20 números.");
        arvoreBinaria.passadaEmNivel();

        System.out.println();
        System.out.println();

        System.out.println("--------------------------------------");
        System.out.println("-------------ALGORITMO DSW------------");
        System.out.println("--------------------------------------");


        arvoreBinaria.raiz = arvoreBinaria.balanceamentoDSW(arvoreBinaria.raiz);
        
        System.out.println();
        System.out.println();
        arvoreBinaria.passadaEmNivel();

    }
}
