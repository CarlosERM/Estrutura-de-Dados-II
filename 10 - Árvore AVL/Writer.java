import java.io.*;
import java.util.Scanner;
public class Writer {

    int[] choose(int qtdNumeros) {
        File file;
        String i[];
        int iInteger[];
        switch(qtdNumeros) {
            case 5:
                file = new File("dados5.txt");
                i = new String[5];
                iInteger = new int[5];
            break;
            case 100:
                file = new File("dados100.txt");
                i = new String[100];
                iInteger = new int[100];
            break;
            case 1000:
                file = new File("dados1000.txt");
                i = new String[1000];
                iInteger = new int[1000];
            break;
            case 10000:
                file = new File("dados10_mil.txt");
                i = new String[10000];
                iInteger = new int[10000];
            break;
            case 50000:
                file = new File("dados50_mil.txt");
                i = new String[50000];
                iInteger = new int[50000];
            break;
            case 100000:
                file = new File("dados100_mil.txt");
                i = new String[100000];
                iInteger = new int[100000];
            break;
            case 100001:
                file = new File("dados100_mil(pior_caso).txt");
                i = new String[100000];
                iInteger = new int[100000];
            break;
            case 100002:
                file = new File("dados100_mil(melhor_caso).txt");
                i = new String[100000];
                iInteger = new int[100000];
            break;
            case 500000:
                file = new File("dados500_mil.txt");
                i = new String[500000];
                iInteger = new int[500000];
            break;
            default:
                file = new File("dados5.txt");
                i = new String[1];
                iInteger = new int[1];
            break;
        }

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                i = scan.nextLine().split(", ");
            }
            i[0]= i[0].split("\\[")[1];
            i[i.length - 1] = i[i.length - 1].split("\\]")[0];
            
            for (int a = 0; a < i.length; a++) {
                iInteger[a] = Integer.parseInt(i[a]);
            }
           
            scan.close();
            return iInteger;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return iInteger;
    }

}