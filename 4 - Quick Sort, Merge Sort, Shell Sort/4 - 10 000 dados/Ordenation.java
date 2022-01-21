public class Ordenation {
    
    static int cont = 0;

    public static void trocar(int[] vetor, int esquerda, int direita) {
        cont++;
        int aux = vetor[esquerda];
        cont++;
        vetor[esquerda] = vetor[direita];
        cont++;
        vetor[direita] = aux;
    }

    public static void quickSort(int[] vetor, int esquerda, int direita) {
        cont++;
        if (esquerda >= direita) {
            return;
        }
            int pivo = vetor[(esquerda + direita) / 2];
            int indice = particao(vetor, esquerda, direita, pivo);
            quickSort(vetor, esquerda, indice - 1);
            quickSort(vetor, indice, direita);
    }

    public static int particao(int[] vetor, int esquerda, int direita, int pivo) {
       while(esquerda <= direita) {
           cont++;
            while(vetor[esquerda] < pivo) {
                cont++;
                esquerda++;
            }   
            cont++;
            while(vetor[direita] > pivo) {
                cont++;
                direita--;
            }
            cont++;
            if(esquerda <= direita) {
                cont++;
                trocar(vetor, esquerda, direita);
                esquerda++;
                direita--;
            }
       }
        return esquerda;

    }

    
    // Une dois subarrays de arr[].
    //O primeiro subarray é arr[esquerda...meio]
    // O segundo subarray é arr[meio+1...direita]
    public static void merge(int arr[], int esquerda, int meio, int direita) {
        // Acha o tamanho dos dois subarrays que serão unidos.
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
  
        /* Cria arrays temporários.*/
        int Esquerda[] = new int[n1];
        int Direita[] = new int[n2];
  
        /*Copia os dados para os arrays temporários.*/
        for (int i = 0; i < n1; ++i) {
            cont++;
            Esquerda[i] = arr[esquerda + i];
        }
            
        for (int j = 0; j < n2; ++j){
            cont++;
            Direita[j] = arr[meio + 1 + j];
        }
  
        /* Une os arrays temporários.*/
  
        // O índices iniciais dos dois subarrays.
         int i = 0, j = 0;
  
        // Índice inicial do subarray unido.
        int k = esquerda;
        while (i < n1 && j < n2) {
            cont++;
            if (Esquerda[i] <= Direita[j]) {
                arr[k] = Esquerda[i];
                cont++;
                i++;
            }
            else {
                cont++;
                arr[k] = Direita[j];
                j++;
            }
            k++;
        }
  
        // Copiando os elementos remanescentes de Esquerda[], caso existam
        while (i < n1) {
            cont++;
            arr[k] = Esquerda[i];
            i++;
            k++;
        }
  
        // Copiando os elementos remanescentes de Direita[], caso existam
        while (j < n2) {
            cont++;
            arr[k] = Direita[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[], int esquerda, int direita) {
        cont++;
        if(esquerda < direita) {
            //encontra o meio.
            int meio = esquerda + (direita - esquerda) / 2;

            //Ordena a primeira e a segudna metade.
            mergeSort(arr, esquerda, meio);
            mergeSort(arr, meio + 1, direita);

            //une as duas metades.
            merge(arr, esquerda, meio, direita);

        }
    }

    
    static int shellSort(int arr[]) {
        int n = arr.length;
 
        // Comece com uma grande lacuna, depois diminua essa lacuna ao longo do tempo. 
        for (int gap = n/2; gap > 0; gap /= 2) {
            cont++;
            //Faça um insertion sort espaçado para esse gap.
            for (int i = gap; i < n; i += 1) {
                cont++;     
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    cont++;     
                }
                arr[j] = temp;
            }
        }
        return 0;
    }
    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
    }
}
