import java.io.*;
public class Writer {

    void writeDocument(int array[]) {
        try {
            File file = new File("dados5Ordenado.txt"); //cria um objeto File chamado file.
            FileWriter writer = new FileWriter(file);
            PrintWriter print = new PrintWriter(writer); // cria um objeto printWriter chamado de print.
            for ( int x = 0; x < array.length; x++) {
                print.println(array[x]);
            }
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       
    }
}