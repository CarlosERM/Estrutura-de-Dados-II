import java.util.ArrayList;
import java.util.Collections;

class Ordenator {
  long comparacao = 0;
  long movimentacao = 0;

  void cocktailSort(int array[]) {
        boolean trocou = true;
        int comeco = 0;
        int fim = array.length;
 
        while (trocou == true) {
          // Reset da variável trocou porque ela pode ser true na última iteração.
          trocou = false;
 
          // A mesma coisa do bubble sort. Debaixo pra cima.
            for (int i = comeco; i < fim - 1; ++i) {
              comparacao++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    movimentacao++;
                    array[i] = array[i + 1];
                    movimentacao++;
                    array[i + 1] = temp;
                    movimentacao++;
                    trocou = true;
                }
            }
 
            comparacao++;
            // Se nada moveu o array está ordenado.
            if (trocou == false)
                break;

            // Se algo moveu, resete a variável para ela ser utilizado no próximo passo.
            trocou = false;

            // Mover o fim para uma posição atrás, porque o que está nessa posição já está ordenado.
            fim = fim - 1;
 
            // Bubble sort de cima pra baixo.
            for (int i = fim - 1; i >= comeco; i--) {
                comparacao++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    movimentacao++;
                    array[i] = array[i + 1];
                    movimentacao++;
                    array[i + 1] = temp;
                    movimentacao++;
                    trocou = true;
                }
            }
 
            // Aumenta o ponto de começo em um porque no último estágio o menor valor já vai
            // estar no começo.
            comeco = comeco + 1;
        }
    }

    // Bucket Sort
    int pegarMaior(int array[]) {
      int maior = Integer.MIN_VALUE;
      for(int a = 0; a < array.length; a++) {
        comparacao++;
        if(maior < array[a]) {
          movimentacao++;
          maior = array[a];
        }
      }
      return maior;
    
     }
    
     int pegarMenor(int array[]) {
      int menor = Integer.MAX_VALUE;
      for(int a = 0; a < array.length; a++) {
        if(menor > array[a]) {
          menor = array[a];
        }
      }
    
    
      return menor;
     }
    void bucketSort(int[] array) {
      int menor = pegarMenor(array);
      for (int i = 0; i < array.length; i++) {
            array[i] -= menor;
      }
      int maior = pegarMaior(array);
      int numeroBaldes = maior / 5;

      // Criação dos baldes.
      ArrayList<ArrayList<Integer>> baldes = new ArrayList<ArrayList<Integer>>(numeroBaldes);
      for (int i = 0; i < numeroBaldes; i++) {
            baldes.add(new ArrayList<Integer>());
      }

      // Coloca os valores no balde respectivo:
      for (int i = 0; i < array.length; i++) {
            int j = numeroBaldes - 1;
            while (true) {
              if (j < 0) {
                break;
              }
              if (array[i] >= (j * 5)) {
                baldes.get(j).add(array[i]);
                break;
              }
              j--;
            }
      }
      int indice = 0;
      for (int i = 0; i < numeroBaldes; i++) {

            int[] array2 = new int[baldes.get(i).size()];

            // Cada balde individual é despejado dentro do array.
            for (int j = 0; j < array2.length; j++) {
              array2[j] = (Integer) baldes.get(i).get(j);
            }
            
            cocktailSort(array2); // algoritmo escolhido para ordenação.
            // Devolve os valores ao array de entrada:
            for (int j = 0; j < array2.length; j++, indice++) {
                  array[indice] = array2[j];
            }

      }
      for (int i = 0; i < array.length; i++) {
            array[i] += menor;
      }
    }      
}
  
