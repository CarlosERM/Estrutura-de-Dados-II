import java.util.Random;

class Ordenator {
  long comparacao = 0;
  long movimentacao = 0;
  
  // QUICK SORT
    void quickSort(Integer[] array, int indicePequeno, int indiceAlto) {
    comparacao++;
    if (indicePequeno >= indiceAlto) {
      return;
    }

    int indicePivo = new Random().nextInt(indiceAlto - indicePequeno) + indicePequeno;
    int pivo = array[indicePivo];
    trocar(array, indicePivo, indiceAlto);

    int ponteiroEsquerdo = particao(array, indicePequeno, indiceAlto, pivo);

    quickSort(array, indicePequeno, ponteiroEsquerdo - 1);
    quickSort(array, ponteiroEsquerdo + 1, indiceAlto);

  }

    int particao(Integer[] array, int indicePequeno, int indiceAlto, int pivo) {
      int ponteiroEsquerdo = indicePequeno;
      int ponteiroDireito = indiceAlto - 1;

      while (ponteiroEsquerdo < ponteiroDireito) {
        comparacao++;
        // Anda da esquerda para a direita até encontrar um número maior que o pivô ou 
        // até se encontrar com o ponteiroDireito.
        while (array[ponteiroEsquerdo] <= pivo && ponteiroEsquerdo < ponteiroDireito) {
          comparacao++;
          ponteiroEsquerdo++;
        }

        // Anda da direita para a esquerda até encontrar um número menor que o pivô ou
        // até se encontrar com o ponteiroEsquerdo.
        while (array[ponteiroDireito] >= pivo && ponteiroEsquerdo < ponteiroDireito) {
          comparacao++;

          ponteiroDireito--;
        }

        trocar(array, ponteiroEsquerdo, ponteiroDireito);
      }

      comparacao++;
      if(array[ponteiroEsquerdo] > array[indiceAlto]) {
        trocar(array, ponteiroEsquerdo, indiceAlto);
      } else {
        ponteiroEsquerdo = indiceAlto;
      }
      
      return ponteiroEsquerdo;
  }

  void trocar(Integer[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
    movimentacao++;
    movimentacao++;
    movimentacao++;

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
