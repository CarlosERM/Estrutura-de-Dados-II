import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        BinaryTreeAVL arvoreAVL = new BinaryTreeAVL();
        BinaryTree arvoreBinaria = new BinaryTree();
        Writer pegaArquivo = new Writer();
        int[] valores = {5, 100, 1000, 10000, 50000, 100000, 100001, 100002, 500000};

        for (int valor : valores) {
            int[] numeros = pegaArquivo.choose(valor);

            long comeco = System.currentTimeMillis();

            for (int n : numeros) {
                arvoreAVL.inserir(n);
            }

            System.out.println();
            System.out.println("-------------");
            System.out.println("Árvore AVL");
            System.out.println("-------------");
            System.out.println();
            
            System.out.println();
            System.out.println("Pré Ordem:");
            System.out.println();
            
            arvoreAVL.passadaPreOrdem(arvoreAVL.raiz);
            
            System.out.println();
            System.out.println("Em Ordem:");
            System.out.println();
            
            arvoreAVL.passadaEmOrdem(arvoreAVL.raiz);
            
            System.out.println();
            System.out.println("Pós Ordem:");
            System.out.println();
            
            arvoreAVL.passadaPosOrdem(arvoreAVL.raiz);

            long fim = System.currentTimeMillis();
            
            long duracao = fim - comeco;
            long milisegundos = (duracao%1000) / 100;
            long segundos = (duracao/1000) % 60;
            long minutos = (duracao/(1000*60)) % 60;
            long horas = (duracao/ (1000*60*60) ) % 24;
            String tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);
           
            long comeco2 = System.currentTimeMillis();
            for (int n : numeros) {
                arvoreBinaria.adicionar(n);
            }

            System.out.println();
            System.out.println("--------------");
            System.out.println("Árvore Binária");
            System.out.println("--------------");
            System.out.println();

            System.out.println();
            System.out.println("Pré Ordem:");
            System.out.println();
            
            arvoreAVL.passadaPreOrdem(arvoreAVL.raiz);
            
            System.out.println();
            System.out.println("Em Ordem:");
            System.out.println();
            
            arvoreAVL.passadaEmOrdem(arvoreAVL.raiz);
            
            System.out.println();
            System.out.println("Pós Ordem:");
            System.out.println();
            
            arvoreAVL.passadaPosOrdem(arvoreAVL.raiz);

            long fim2 = System.currentTimeMillis();
            
            long duracao2 = fim2 - comeco2;
            long milisegundos2 = (duracao2%1000) / 100;
            long segundos2 = (duracao2/1000) % 60;
            long minutos2 = (duracao2/(1000*60)) % 60;
            long horas2 = (duracao2/ (1000*60*60) ) % 24;
            String tempo2 = String.format("%02d:%02d:%02d:%02d", horas2, minutos2, segundos2, milisegundos2);
            
            System.out.println();
            System.out.println("Árvore Binária - " + valor);
            System.out.println(tempo);
            System.out.println("Árvore AVL - " + valor);
            System.out.println(tempo2);
            System.out.println();
            System.out.println("---------------------------------------------");

            
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
