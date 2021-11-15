
public class SelectionSort {
    int contOp = 0;
    int[] sort(int array[]) {
        int n = array.length;
 
        for (int i = 0; i < n - 1; i++) {
            // Ache o valor mínimo no array não-ordenado.
            contOp++;
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                contOp++;
            }

            int temp = array[min];
            contOp++;
            array[min] = array[i];
            contOp++;
            array[i] = temp;
            contOp++;


        }
        return array;
    }
}