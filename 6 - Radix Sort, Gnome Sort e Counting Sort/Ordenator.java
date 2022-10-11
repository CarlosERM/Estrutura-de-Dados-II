import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
 // Counting Sort
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

 void countingSort(int array[]) {

  int maior = pegarMaior(array);
  int menor = pegarMenor(array);

  int intervalo = maior - menor + 1; // Para garantir que os valores negativos não sejam ignorados.
  int count[] = new int[intervalo];

  for (int i : array) {
      count[i - menor]++; // Contar os números de ocorrências utilizando a fórmula.
  }

  int indiceArray = 0;

  for(int i = 0; i < intervalo; i++) {
    while(count[i] > 0) {
      array[indiceArray] = i + menor; // Pegamos o indice e acrescentamos  + menor porque ele foi decrementado lá em cima.
      movimentacao++;
      count[i]--;
      indiceArray++;
    }
  }
 }

  public void sort(int[] array) {
    Map<Boolean, List<Integer>> splitArray = Arrays.stream(array).boxed().collect(Collectors.partitioningBy(i -> i < 0));
    // Valores negativos.
    int[] negativeInts = radixSort(splitArray.get(true).stream().mapToInt(Integer::intValue).map(Math::abs).toArray());
    // Valores positivos.
    int[] positiveInts = radixSort(splitArray.get(false).stream().mapToInt(Integer::intValue).toArray());
    
    // Voltando os valores negativos.
    for (int i = negativeInts.length - 1, j = 0; i >= 0; i--, j++) array[j] = -negativeInts[i];
    
    // Juntando todos os valores.
    System.arraycopy(positiveInts, 0, array, negativeInts.length, positiveInts.length);
  }

  public int[] radixSort(int[] array) {
    int max = pegarMaior(array);
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSort2(exp, array);
    }
    return array;
  } 

  private void countingSort2(int exp, int[] array) {

    int[] saida = new int[array.length];
    int[] count = new int[10];

    // Contagem das ocorrências.
    for (int i : array) {
      count[(i / exp) % 10]++; // Pega o dígito e depois pontua a ocorrência.
    }

    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1]; // Cálculo maluco.
    }

    for (int i = array.length - 1; i >= 0; i--) {
        int presente = array[i];
        movimentacao++;
        int posicaoNoArray = count[(presente / exp) % 10] - 1;
        saida[posicaoNoArray] = presente;
        movimentacao++;
        count[(presente / exp) % 10]--;
    }

    System.arraycopy(saida, 0, array, 0, array.length);
  }
}
