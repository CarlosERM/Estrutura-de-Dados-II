import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        File file = new File("dados5.txt");
        InsertionSort insertSort = new InsertionSort();
        String i[] = new String[5];
        int iInteger[] = new int[5];
        int cont = 0;
        try {
            Scanner scan = new Scanner(file);
            //pegar todos os valores dos arquivos e colocar dentro de um array aqui no java.
            while(scan.hasNextLine()) {
                i = scan.nextLine().split(", ");
            }
            //converter esses valores em int.
            for (int a = 0; a < i.length; a++) {
                iInteger[a] = Integer.parseInt(i[a]);
            }   
            //ativar a função de ordenação e coloca o array ordenado dentro de sorted.
            int sorted[] = insertSort.sort(iInteger);
            //imprime o array ordenado.
            while(cont < sorted.length) {
                System.out.println(sorted[cont]);
                cont++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}