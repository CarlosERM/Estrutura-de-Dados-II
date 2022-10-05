
class Ordenator {
  long comparacao = 0;
  long movimentacao = 0;
  void gnomeSort(Integer array[]) {
    int n = array.length;

    int index = 0;
    
    while (index < n) {
      comparacao++;
      // Se o index for 0, segue um passo pra frente.
      if (index == 0) {
        index++;
      }

      comparacao++;
      // Enquanto o que está na frente é maior ou igual ao que está atrás, continue seguindo em frente.
      if (array[index] >= array[index - 1]) {
        index++;
      }
      // Se não. Troque os dois e volte um passo. Depois na próxima repetição ele vai comparar de novo e de novo. 
      else {
        int temp = 0;
        movimentacao++;
        temp = array[index];
        movimentacao++;
        array[index] = array[index - 1];
        movimentacao++;
        array[index - 1] = temp;
        index--;
      }
  }
    return;
 }

 

 void countingSort(Integer array[]) {

 }

}
