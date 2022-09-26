
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Writer writer = new Writer();
        int numero;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("                   ORDENADOR                    ");
            System.out.println("------------------------------------------------");
            System.out.println();
            System.out.println("1 - 5 números");
            System.out.println("2 - 100 números");
            System.out.println("3 - 1000 números");
            System.out.println("4 - 10 000 números");
            System.out.println("5 - 50 000 números");
            System.out.println("6 - 100 000 números(CASO MÉDIO)");
            System.out.println("7 - 100 000 números(PIOR CASO)");
            System.out.println("8 - 100 000 números(MELHOR CASO)");
            System.out.println("9 - 500 000 números");
            System.out.println("0 - Desligar");

            System.out.println();
            numero= input.nextInt();
            if(numero < 10 && numero > 0) {
                writer.choose(numero);
            }
        } while(numero < 10 && numero > 0);
        input.close();

        System.out.println("O programa foi encerrado.");
        
    }
}