public class Ordenation {
    static long cont = 0;

    // BUBBLE SORT
    static void bubbleSort(int arr[]) {
		int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    temp = arr[j];
                    cont++;

                    arr[j] = arr[j + 1];
                    cont++;

                    arr[j + 1] = temp;
                    cont++;

                    swapped = true;

                }
                cont++;
            }

            if (swapped == false)
                break;
            cont++;

        }
    }

    // COMBO SORT

	// acha a distância entre os elementos.
	static int getNextGap(int gap) {
	    // calculo do fator de encolhimento.
        // gap = (gap*10)/13;
        // gap = gap / 2;
        gap--;
        cont++;
		if (gap < 1){
			return 1;
        }
		return gap;
	}

	static void comboSort(int arr[]) {
		int n = arr.length;
		// inicializa o gap.
		int gap = n;
		boolean swapped = true;

		// Continue executando enquanto o gap for maior que um ou se houve uma troca na última execução.
		while (gap != 1 || swapped == true) {
			// ache a próxima distância
			gap = getNextGap(gap);
			swapped = false;
			// comparar todos os elementos com o gap.
			for (int i=0; i<n-gap; i++) {

				if (arr[i] > arr[i+gap]) {
					
					int temp = arr[i];
                    cont++;

					arr[i] = arr[i+gap];
                    cont++;

                    arr[i+gap] = temp;
                    cont++;

					swapped = true;
				}
                cont++;
			}
            cont++;

        }
    }

    // BOGO SORT
    static void bogoSort(int[] a) {
        // se o array não estiver em ordem, embaralhe ele de novo.
        while (isSorted(a) == false){
            cont++;
            shuffle(a);
        }

    }

    // embaralhador.
    static void shuffle(int[] arr) {
        int n = arr.length-1;
        
        for (int i = 1; i <= n; i++){
            cont++;
            swap(arr, i, (int)(Math.random()*i));
        }
    }

    // troca dois elementos de lugar.
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        cont++;

        a[i] = a[j];
        cont++;

        a[j] = temp;
        cont++;

    }

    // checar se o array está ordenado ou não
    static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i-1]) {
                return false;
            }
            cont++;
        }

        return true;
    }

    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
    }
}
