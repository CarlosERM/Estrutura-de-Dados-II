import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {


        File file = new File("dados50_mil.txt");

      

        Writer writer = new Writer();

        String i[] = new String[50000];
        int iInteger[] = new int[50000];

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                i = scan.nextLine().split(", ");
            }

            for (int a = 0; a < i.length; a++) {
                iInteger[a] = Integer.parseInt(i[a]);
            }
            
            long comeco = System.currentTimeMillis();
            Ordenation.shellSort(iInteger);
            long fim = System.currentTimeMillis();

            // long comeco = System.currentTimeMillis();
            // Ordenation.mergeSort(iInteger, 0, iInteger.length -1);
            // long fim = System.currentTimeMillis();  

            // long comeco = System.currentTimeMillis();
            // Ordenation.quickSort(iInteger, 0, iInteger.length - 1);
            // long fim = System.currentTimeMillis(); 

            long duracao = fim - comeco;
            long milisegundos = (duracao%1000) / 100;
            long segundos = (duracao/1000) % 60;
            long minutos = (duracao/(1000*60)) % 60;
            long horas = (duracao/ (1000*60*60) ) % 24;

            String tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);
            System.out.println("Duração: " + tempo);
            System.out.println("Quantidade de Movimentos: " + Ordenation.cont);
            System.out.println();

            writer.writeDocument(iInteger);

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}