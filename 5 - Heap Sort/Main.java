import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileWriter writer;
        Ordenator ordenador = new Ordenator();

        Scanner dados5 = new Scanner(new File("dados5.txt")).useDelimiter(", ");
        Scanner dados100 = new Scanner(new File("dados100.txt")).useDelimiter(", ");
        Scanner dados1000 = new Scanner(new File("dados1000.txt")).useDelimiter(", ");
        Scanner dados10_mil = new Scanner(new File("dados10_mil.txt")).useDelimiter(", ");
        Scanner dados50_mil = new Scanner(new File("dados50_mil.txt")).useDelimiter(", ");
        Scanner dados100_mil = new Scanner(new File("dados100_mil.txt")).useDelimiter(", ");
        Scanner dados500_mil = new Scanner(new File("dados500_mil.txt")).useDelimiter(", ");

        int cont5 = 0;
        int cont100 = 0;
        int cont1000 = 0;
        int cont10_mil = 0;
        int cont50_mil = 0;
        int cont100_mil = 0;
        int cont500_mil = 0;


        List<Integer> temps5 = new ArrayList<Integer>();
        List<Integer> temps100 = new ArrayList<Integer>();
        List<Integer> temps1000 = new ArrayList<Integer>();
        List<Integer> temps10_mil = new ArrayList<Integer>();
        List<Integer> temps50_mil = new ArrayList<Integer>();
        List<Integer> temps100_mil = new ArrayList<Integer>();
        List<Integer> temps500_mil = new ArrayList<Integer>();


        while(dados5.hasNext()) {
            int toke = dados5.nextInt();
            temps5.add(toke);
        }

        while(dados100.hasNext()) {
            int toke = dados100.nextInt();
            temps100.add(toke);
        }

        while(dados1000.hasNext()) {
            int toke = dados1000.nextInt();
            temps1000.add(toke);
        }

        while(dados10_mil.hasNext()) {
            int toke = dados10_mil.nextInt();
            temps10_mil.add(toke);
        }

        while(dados50_mil.hasNext()) {
            int toke = dados50_mil.nextInt();
            temps50_mil.add(toke);
        }

        while(dados100_mil.hasNext()) {
            int toke = dados100_mil.nextInt();
            temps100_mil.add(toke);
        }
        while(dados500_mil.hasNext()) {
            int toke = dados500_mil.nextInt();
            temps500_mil.add(toke);
        }

        dados5.close();
        dados100.close();
        dados1000.close();
        dados50_mil.close();
        dados100_mil.close();
        dados500_mil.close();

        Integer[] tempsArray5 =  temps5.toArray(new Integer[0]);
        Integer[] tempsArray100 =  temps100.toArray(new Integer[0]);
        Integer[] tempsArray1000 =  temps1000.toArray(new Integer[0]);
        Integer[] tempsArray10_mil =  temps10_mil.toArray(new Integer[0]);
        Integer[] tempsArray50_mil =  temps50_mil.toArray(new Integer[0]);
        Integer[] tempsArray100_mil =   temps100_mil.toArray(new Integer[0]);
        Integer[] tempsArray500_mil =   temps500_mil.toArray(new Integer[0]);

        long comeco5 = System.currentTimeMillis();
        cont5 = ordenador.heapSort(tempsArray5, 0);
        long fim5 = System.currentTimeMillis();

        long comeco100 = System.currentTimeMillis();
        cont100 = ordenador.heapSort(tempsArray100, 0);
        long fim100 = System.currentTimeMillis();

        long comeco1000 = System.currentTimeMillis();
        cont1000 = ordenador.heapSort(tempsArray1000, 0);
        long fim1000 = System.currentTimeMillis();

        long comeco10_mil = System.currentTimeMillis();
        cont10_mil = ordenador.heapSort(tempsArray10_mil, 0);
        long fim10_mil  = System.currentTimeMillis();

        long comeco50_mil = System.currentTimeMillis();
        cont50_mil = ordenador.heapSort(tempsArray50_mil, 0);
        long fim50_mil = System.currentTimeMillis();

        long comeco100_mil = System.currentTimeMillis();
        cont100_mil = ordenador.heapSort(tempsArray100_mil, 0);
        long fim100_mil = System.currentTimeMillis();

        long comeco500_mil = System.currentTimeMillis();
        cont500_mil = ordenador.heapSort(tempsArray500_mil, 0);
        long fim500_mil = System.currentTimeMillis();

        // esccrevendo os arquivos.
        try {
            writer = new FileWriter("1 - dados5Ordenado.txt");
            for(int a: tempsArray5) {
                writer.write(a + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer = new FileWriter("2 - dados100Ordenado.txt");
            for(int a: tempsArray100) {
                writer.write(a + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            writer = new FileWriter("3 - dados1000Ordenado.txt");
            for(int a: tempsArray1000) {
                writer.write(a + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            writer = new FileWriter("4 - dados10_milOrdenado.txt");
            for(int a: tempsArray10_mil) {
                writer.write(a + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer = new FileWriter("5 - dados50_milOrdenado.txt");
            for(int a: tempsArray50_mil) {
                writer.write(a + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer = new FileWriter("6 - dados100_milOrdenado.txt");
            for(int a: tempsArray100_mil) {
                writer.write(a + System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer = new FileWriter(" 7 - dados500_milOrdenado.txt");
            for(int a: tempsArray500_mil) {
                writer.write(a + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long duracao5 = fim5 - comeco5;
        long duracao100 = fim100 - comeco100;
        long duracao1000 = fim1000 - comeco1000;
        long duracao10_mil = fim10_mil - comeco10_mil;
        long duracao50_mil = fim50_mil - comeco50_mil;
        long duracao100_mil = fim100_mil - comeco100_mil;
        long duracao500_mil = fim500_mil - comeco500_mil;

        System.out.println("-----------------------");
        System.out.println("ORDENAÇÃO DE 5 NÚMEROS");
        System.out.println("-----------------------");

        long milisegundos = (duracao5%1000) / 100;
        long segundos = (duracao5/1000) % 60;
        long minutos = (duracao5/(1000*60)) % 60;
        long horas = (duracao5/ (1000*60*60) ) % 24;

        String tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont5);
        System.out.println();
        System.out.println();


        System.out.println("--------------------------");
        System.out.println("ORDENAÇÃO DE 100 NÚMEROS");
        System.out.println("--------------------------");

        milisegundos = (duracao100%1000) / 100;
        segundos = (duracao100/1000) % 60;
        minutos = (duracao100/(1000*60)) % 60;
        horas = (duracao100/ (1000*60*60) ) % 24;

        tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont100);
        System.out.println();
        System.out.println();


        System.out.println("---------------------------");
        System.out.println("ORDENAÇÃO DE 1000 NÚMEROS");
        System.out.println("---------------------------");

        milisegundos = (duracao1000%1000) / 100;
        segundos = (duracao1000/1000) % 60;
        minutos = (duracao1000/(1000*60)) % 60;
        horas = (duracao1000/ (1000*60*60) ) % 24;

        tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont1000);
        System.out.println();
        System.out.println();


        System.out.println("-----------------------------");
        System.out.println("ORDENAÇÃO DE 10 000 NÚMEROS");
        System.out.println("-----------------------------");

        milisegundos = (duracao10_mil%1000) / 100;
        segundos = (duracao10_mil/1000) % 60;
        minutos = (duracao10_mil/(1000*60)) % 60;
        horas = (duracao10_mil/ (1000*60*60) ) % 24;

        tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont10_mil);
        System.out.println();
        System.out.println();


        System.out.println("-----------------------------");
        System.out.println("ORDENAÇÃO DE 50 000 NÚMEROS");
        System.out.println("-----------------------------");

        milisegundos = (duracao50_mil%1000) / 100;
        segundos = (duracao50_mil/1000) % 60;
        minutos = (duracao50_mil/(1000*60)) % 60;
        horas = (duracao50_mil/ (1000*60*60) ) % 24;

        tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont50_mil);
        System.out.println();
        System.out.println();
        
        System.out.println("-----------------------------");
        System.out.println("ORDENAÇÃO DE 100 000 NÚMEROS");
        System.out.println("-----------------------------");

        milisegundos = (duracao100_mil%1000) / 100;
        segundos = (duracao100_mil/1000) % 60;
        minutos = (duracao100_mil/(1000*60)) % 60;
        horas = (duracao100_mil/ (1000*60*60) ) % 24;

        tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont100_mil);
        System.out.println();
        System.out.println();
        
        System.out.println("----------------------------");
        System.out.println("ORDENAÇÃO DE 500 000 NÚMEROS");
        System.out.println("----------------------------");

        milisegundos = (duracao500_mil%1000) / 100;
        segundos = (duracao500_mil/1000) % 60;
        minutos = (duracao500_mil/(1000*60)) % 60;
        horas = (duracao500_mil/ (1000*60*60) ) % 24;

        tempo = String.format("%02d:%02d:%02d:%02d", horas, minutos, segundos, milisegundos);

        System.out.println();
        System.out.println("Duração: " + tempo);
        System.out.println("Quantidade de Movimentos: " + cont500_mil);
    }
}