import java.util.ArrayList;
import java.util.HashMap;

class Ordenator {

   public  int radixSort(Integer array[], int cont) {
      int RADIX = 10;

      //aqui eu crio o array no qual vou armazenar os valores enquanto a ordenação ocorre.
      ArrayList<Integer> baldes[] = new ArrayList[RADIX];

      //dentro de cada casa desse array bades haverá um array list armazenado.
      for (int i = 0; i < baldes.length; i++) {
         baldes[i] = new ArrayList<>();
         cont++;
      }

      //essa variável irá m dizer se o algoritmo já alcançou o valor de digito maximo.
      boolean digitoMaximoAlcancado = false;

      int temp = -1; //variável temporária.
      int casaDecimal = 1;//esse valor vai permitir que eu consigo ir pegando todos os digitos do meu número.

      while(!digitoMaximoAlcancado) {
         cont++;
         digitoMaximoAlcancado = true;

         for(int elemento : array) {
            cont++;

            // 100 / 1
            // 100 % 10
            // 0

            //100 / 10
            // 10 % 10
            // 0

            //100 / 100
            //1 % 10
            // 1

            temp = elemento / casaDecimal; // na primeira repetição casaDecimal = 1, na segunda igual a 10.... 100 1000. O objetivo dele é extrair os digitos necessários.

            baldes[Math.abs(temp % RADIX)].add(elemento); // bem extraímos o último digito do número e o uutilizamos como indíce no array.

            cont++;

            // caso o temp seja maior que zero.
            if (digitoMaximoAlcancado && temp > 0) {
               cont++;
               //Nessa repetição, caso temp for igual a zero, isso significa que o ígito máximo foi alcançado.
               digitoMaximoAlcancado = false;
            }
         }

         int a = 0;
         for (int b = 0; b < RADIX; b++) {
            cont++;
            for (Integer j : baldes[b]) {
               cont++;
               array[a++] = j;
            }
            baldes[b].clear();
         }
         casaDecimal = casaDecimal * RADIX;      
      }
      return cont;
   }

   public int gnomeSort(Integer[] array, int cont) {
      int tamanho = array.length;
      int index = 0;

      while (index < tamanho) {
         
         cont++;
         if (index == 0) {
            cont++;
            index++;
         }
            
         if (array[index] >= array[index - 1]) {
            cont++;
            index++;
         }  else {
            cont++;
            int temp = 0;
            cont++;
            temp = array[index];
            cont++;
            array[index] = array[index - 1];
            cont++;
            array[index - 1] = temp;
            cont++;
            index--;
         }
      }
      return cont;
    }
}
