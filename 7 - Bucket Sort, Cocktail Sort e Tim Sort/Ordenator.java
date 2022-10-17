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
            movimentacao++;
      }

      // Coloca os valores no balde respectivo:
      for (int i = 0; i < array.length; i++) {
            int j = numeroBaldes - 1;
            while (true) {
              comparacao++;
              if (j < 0) {
                break;
              }
              comparacao++;
              if (array[i] >= (j * 5)) {
                baldes.get(j).add(array[i]);
                movimentacao++;
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
              movimentacao++;
            }
            
            cocktailSort(array2); // algoritmo escolhido para ordenação.
            // Devolve os valores ao array de entrada:
            for (int j = 0; j < array2.length; j++, indice++) {
              array[indice] = array2[j];
              movimentacao++;
            }

      }

      for (int i = 0; i < array.length; i++) {
        array[i] += menor;
      }
    }  

    static int MIN_MERGE = 32;

    public static int minRunLength(int n) {
      assert n >= 0;

      int r = 0;
      while (n >= MIN_MERGE) {
          r |= (n & 1);
          n >>= 1;
      }

      return n + r;
    }
    
    void insertionSort(int[] array, int esquerda, int direita) { 
      for (int i = esquerda + 1; i <= direita; i++) {
        movimentacao++;
        int temp = array[i];
        int j = i - 1;

        while (j >= esquerda && array[j] > temp) {
          array[j + 1] = array[j];
        movimentacao++;

          j--;
        }
        movimentacao++;
        array[j + 1] = temp;
      }
    }
 
    // A função merge une as runs sorteadas.
    void merge(int[] array, int esquerda, int meio, int direita) {
      // O array original está quebrado em duas partes, esquerdas e direitas.
      int tamanho1 = meio - esquerda + 1;
      int tamanho2 = direita - meio;
      
      int[] esquerdas = new int[tamanho1];
      int[] direitas = new int[tamanho2];
      
      for (int x = 0; x < tamanho1; x++) {
        movimentacao++;
        esquerdas[x] = array[esquerda + x];
      }

      for (int x = 0; x < tamanho2; x++) {
        direitas[x] = array[meio + 1 + x];
        movimentacao++;
      }

      int i = 0;
      int j = 0;
      int k = esquerda;

      // Depois de comparar, unimos.
      while (i < tamanho1 && j < tamanho2) {
          comparacao++;
          if (esquerdas[i] <= direitas[j]) {
            movimentacao++;
            array[k] = esquerdas[i];
              i++;
          }
          else {
            movimentacao++;
            array[k] = direitas[j];
              j++;
          }
          k++;
      }
      // Copiar elementos remanescentes de esquerdas.
      while (i < tamanho2) {
        movimentacao++;
        array[k] = esquerdas[i];
        k++;
        i++;
      }

      // Copiar elementos remanescentes de direitas.
      while (j < tamanho2) {
        movimentacao++;
        array[k] = direitas[j];
        k++;
        j++;
      }
    }
    
  void timSort(int[] array) {
    int n = array.length;
    int minRun = minRunLength(MIN_MERGE);
    
    // Sortear os arrays de cada balde do tamanho da Run.
    for (int i = 0; i < n; i += minRun) {
      insertionSort(array, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
    }

    for (int tamanho = minRun; tamanho < n; tamanho = 2 * tamanho) {
      for (int esquerda = 0; esquerda < n; esquerda += 2 * tamanho) {
        int meio = esquerda + tamanho - 1;
        int direita = Math.min((esquerda + 2 * tamanho - 1), (n - 1));

        comparacao++;
        if(meio < direita)
          merge(array, esquerda, meio, direita);
      }
    }
  }
}
  
