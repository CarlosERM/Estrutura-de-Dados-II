import java.util.Random;
import java.util.ArrayList;

public class Main {
    // Fazer um programa utilizando uma árvore Rubro-Negra. Inserir 1000 elementos variando de 0 a 1000. 
    // Fazer a impressão em ordem, pré-ordem e pós-ordem dos dados.  O programa deve marcar o tempo 
    // para a impressão de todos os dados. Remova os números primos da árvore e refaça a impressão em ordem, 
    // pré-ordem e pós-ordem dos dados Fazer um vídeo de 5 a 15 min.  apresentando o programa, explicando o código e mostrando 
    // os resultados para cada arquivo.
    private static boolean ePrimo(int numero) {
        for (int j = 2; j < numero; j++) {
            if (numero % j == 0)
                return false;   
        }
        return true;
    }


    public static void main(String[] args) {
        RedBlackTree arvoreRubroNegra = new RedBlackTree();
        ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
        Random gerador = new Random();

        long comeco1 = System.currentTimeMillis();
        
        for(int i= 0; i < 1000; i++) {
            int numero = gerador.nextInt(1001);
            arvoreRubroNegra.inserir(numero);
            if(ePrimo(numero)) {
                numerosPrimos.add(numero);
            }
        }

        System.out.println();
        System.out.println("Em ordem: ");
        System.out.println();

        arvoreRubroNegra.passadaEmOrdem(arvoreRubroNegra.raiz);

        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("Pré ordem: ");
        System.out.println();

        arvoreRubroNegra.passadaPreOrdem(arvoreRubroNegra.raiz);

        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("Pós ordem: ");
        System.out.println();

        arvoreRubroNegra.passadaPosOrdem(arvoreRubroNegra.raiz);

        System.out.println();
        System.out.println();


        long fim1 = System.currentTimeMillis();
            
        long duracao1 = fim1 - comeco1;
        long milisegundos1 = (duracao1%1000) / 100;
        long segundos1 = (duracao1/1000) % 60;
        long minutos1 = (duracao1/(1000*60)) % 60;
        long horas1 = (duracao1/ (1000*60*60) ) % 24;

        String tempo1 = String.format("%02d:%02d:%02d:%02d", horas1, minutos1, segundos1, milisegundos1);


        for (Integer n : numerosPrimos) {
            arvoreRubroNegra.deletar(n);
        }

        long comeco2 = System.currentTimeMillis();
        
        System.out.println();
        System.out.println("Em ordem: ");
        System.out.println();

        arvoreRubroNegra.passadaEmOrdem(arvoreRubroNegra.raiz);

        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("Pré ordem: ");
        System.out.println();

        arvoreRubroNegra.passadaPreOrdem(arvoreRubroNegra.raiz);

        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println("Pós ordem: ");
        System.out.println();

        arvoreRubroNegra.passadaPosOrdem(arvoreRubroNegra.raiz);

        System.out.println();
        System.out.println();


        long fim2 = System.currentTimeMillis();
            
        long duracao2 = fim2 - comeco2;
        long milisegundos2 = (duracao2%1000) / 100;
        long segundos2 = (duracao2/1000) % 60;
        long minutos2 = (duracao2/(1000*60)) % 60;
        long horas2 = (duracao2/ (1000*60*60) ) % 24;

        String tempo2 = String.format("%02d:%02d:%02d:%02d", horas2, minutos2, segundos2, milisegundos2);

        System.out.println("Com números primos: " + tempo1);
        System.out.println("Sem números primos: " + tempo2);
    }
}
