import java.io.*;
import java.util.Scanner;
public class Writer {
    void choose(int qtdNumeros) {
        File file;
        long cont[]= new long[2];
        String i[];
        Integer iInteger[];
        Ordenator ordenador = new Ordenator();
        int qtdPrint;
        switch(qtdNumeros) {
            case 1:
                file = new File("dados5.txt");
                i = new String[5];
                iInteger = new Integer[5];
                qtdPrint = 5;
            break;
            case 2:
                file = new File("dados100.txt");
                i = new String[100];
                iInteger = new Integer[100];
                qtdPrint = 100;

            break;
            case 3:
                file = new File("dados1000.txt");
                i = new String[1000];
                iInteger = new Integer[1000];
                qtdPrint = 1000;
            break;
            case 4:
                file = new File("dados10_mil.txt");
                i = new String[10000];
                iInteger = new Integer[10000];
                qtdPrint = 10000;
            break;
            case 5:
                file = new File("dados50_mil.txt");
                i = new String[50000];
                iInteger = new Integer[50000];
                qtdPrint = 50000;
            break;
            case 6:
                file = new File("dados100_mil.txt");
                i = new String[100000];
                iInteger = new Integer[100000];
                qtdPrint = 100000;
            break;
            case 7:
                file = new File("dados100_mil(pior_caso).txt");
                i = new String[100000];
                iInteger = new Integer[100000];
                qtdPrint = 100000;
            break;
            case 8:
                file = new File("dados100_mil(melhor_caso).txt");
                i = new String[100000];
                iInteger = new Integer[100000];
                qtdPrint = 100000;
            break;
            case 9:
                file = new File("dados500_mil.txt");
                i = new String[500000];
                iInteger = new Integer[500000];
                qtdPrint = 500000;
            break;
            default:
                file = new File("dados5.txt");
                i = new String[1];
                iInteger = new Integer[1];
                qtdPrint = 5;
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
           
            long comeco = System.currentTimeMillis();
            ordenador.countingSort(iInteger);
            long fim = System.currentTimeMillis(); 
            
            long duracao = fim - comeco;
            long milisegundos = (duracao%1000) / 100;
            long segundos = (duracao/1000) % 60;
            long minutos = (duracao/(1000*60)) % 60;
            long horas = (duracao/ (1000*60*60) ) % 24;

            String tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

            System.out.println();
            System.out.println("----------" + qtdPrint + " NÚMEROS----------");
            System.out.println();

            System.out.println("Duracao: " + tempo);
            System.out.println("Quantidade de Comparações: " + ordenador.comparacao);
            System.out.println("Quantidade de Movimentos: " + ordenador.movimentacao);
            System.out.println();
            writeDocument(iInteger, qtdPrint, "Counting Sort", tempo, 
            ordenador.comparacao, ordenador.movimentacao);

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       


    }
    void writeDocument(Integer array[], int qtd, String nomeAlgoritmo, String tempoExecucao, long comparacoes, long movimentacoes) {
        File file;
        try {
            
            switch(qtd) {
                case 5:
                    file = new File("1 - dados5Ordenado.txt"); //cria um objeto File chamado file.
                break;
                case 100:
                    file = new File("2 - dados100Ordenado.txt"); //cria um objeto File chamado file.

                break;
                case 1000:
                    file = new File("3 - dados1000Ordenado.txt"); //cria um objeto File chamado file.

                break;
                case 10000:
                    file = new File("4 - dados10_milOrdenado.txt"); //cria um objeto File chamado file.

                break;
                case 50000:
                    file = new File("5 - dados50_milOrdenado.txt"); //cria um objeto File chamado file.

                break;
                case 100000:
                    file = new File("6 - dados100_milOrdenado.txt"); //cria um objeto File chamado file.

                break;
                case 500000:
                    file = new File("7 - dados500_milOrdenado.txt"); //cria um objeto File chamado file.

                break;
                default:
                    file = new File("8 - dados5Ordenado.txt"); //cria um objeto File chamado file.

                break;
            }
            FileWriter writer = new FileWriter(file);
            PrintWriter print = new PrintWriter(writer); // cria um objeto printWriter chamado de print.
            print.println("Nome do aluno: Carlos Eduardo Rocha Miranda");
            print.println("Nome do Algoritmo: " + nomeAlgoritmo);
            print.println("Tempo de Execucao: " + tempoExecucao);
            print.println("Quantidade de Comparacoes: " + comparacoes);
            print.println("Quantidade de Movimentacoes: " + movimentacoes);
            print.println();
            

            for ( int x = 0; x < array.length; x++) {
                if(x == array.length - 1) {
                    print.print(array[x] + "]" );
                } else if(x == 0) {
                    print.print("[" + array[x]+ ", ");
                } else {
                    print.print(array[x]+ ", ");
                }
            }
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       
    }
    void invert(Integer[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Integer temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}