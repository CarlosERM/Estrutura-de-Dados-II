
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
 int pegarMaior(Integer array[]) {
  int maior = Integer.MIN_VALUE;
  for(int a = 0; a < array.length; a++) {
    if(maior < array[a]) {
      maior = array[a];
    }
  }
  return maior;

 }

 int pegarMenor(Integer array[]) {
  int menor = Integer.MAX_VALUE;
  for(int a = 0; a < array.length; a++) {
    if(menor > array[a]) {
      menor = array[a];
    }
  }


  return menor;
 }

 void countingSort(Integer array[]) {

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
}
