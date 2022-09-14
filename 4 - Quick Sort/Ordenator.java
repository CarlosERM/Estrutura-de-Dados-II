
class Ordenator {
  long comparacao;
  long movimentacao;
  
  // QUICK SORT
  long[] quickSort(Integer array[], int inicio, int fim) {
    if(inicio < fim) {
      int pivo = particao(array, inicio, fim);

      try {
        quickSort(array, inicio, pivo - 1);
        quickSort(array, pivo + 1, fim);
      } catch (StackOverflowError e) {
        System.out.println("");
      }
     
    }
    long tudo[]  = new long[2];
    tudo[0] = comparacao;
    tudo[1] = movimentacao;
    return tudo;
  }

  int particao(Integer array[], int inicio, int fim) {
    int pivo = array[fim];
    int barraAzul = inicio - 1;
    Integer aux;
    Integer aux2;
    comparacao++;
    for(int barraVerde = inicio; barraVerde < fim; barraVerde++) {
    comparacao++;
    
    comparacao++;
        if(array[barraVerde] <= pivo) {
          barraAzul++;
          aux = array[barraVerde];
          movimentacao++;
          array[barraVerde] = array[barraAzul];
          movimentacao++;
          array[barraAzul] = aux;
          movimentacao++;
        }
    }
    aux2 = array[barraAzul + 1];
    movimentacao++;
    array[barraAzul + 1] = array[fim];
    movimentacao++;
    array[fim] = aux2;
    movimentacao++;
    return barraAzul + 1;
  }
    // MERGE SORT

    void merge(Integer array[], int esquerda, int meio, int direita)
    {
        // Find sizes of two subarrays to be merged
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = array[esquerda + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
              array[k] = L[i];
                i++;
            }
            else {
              array[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
          array[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
          array[k] = R[j];
            j++;
            k++;
        }
    }
  
    long[] mergeSort(Integer array[], int esquerda, int direita) {
      
      if (esquerda < direita) {
        // Find the middesquerdae point
        int m =esquerda+ (direita-esquerda)/2;
       
        // Sort first and second haesquerdaves
        mergeSort(array, esquerda, m);
        mergeSort(array, m + 1, direita);

        // Merge the sorted haesquerdaves
        merge(array, esquerda, m, direita);
      }
    
      long tudo[]  = new long[2];
      tudo[0] = comparacao;
      tudo[1] = movimentacao;
      return tudo;
    }
  
}
