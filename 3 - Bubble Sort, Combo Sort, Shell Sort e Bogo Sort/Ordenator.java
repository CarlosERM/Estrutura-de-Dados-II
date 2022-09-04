import java.util.Random;

class Ordenator {

  // BUBBLE SORT
  long[] bubbleSort(Integer array[],  long comparacao, long movimentacao) {
    int n = array.length;
    int aux;

    for(int i = 0; i < n; i++){
      comparacao++;

      for(int j = 0; j < n - 1; j++){
        comparacao++;

        comparacao++;
        if(array[j] > array[j + 1]){
          movimentacao++;
          aux = array[j];

          movimentacao++;
          array[j] = array[j + 1];
          
          movimentacao++;
          array[j + 1] = aux;
        }
      }
    }
    long tudo[]  = new long[2];
    tudo[0] = comparacao;
    tudo[1] = movimentacao;
    return tudo;
  }
  
  // COMBO SORT

  int pegaProximoGap(int gap) {
      
      gap = (gap * 10) / 13;
      if (gap < 1)
          return 1;
      return gap;
  }


  long[] comboSort(Integer array[],  long comparacao, long movimentacao) {
    int n = array.length;
 
    // Inicializa o gap como sendo o tamanho do array.
    int gap = n;

    // Inicializa troca como true para garantir que o loop vai rodar.
    boolean troca = true;

  
    // Continua rodando enquanto o gap é maior que 1 ou se na última iteração houve um a troca.
    while (gap != 1 || troca == true) {
        comparacao++;
        gap = pegaProximoGap(gap);

        // Inicializa troca como false para ver se a troca ocorreu ou não.
        troca = false;

        // Compara todos os elementos com o gap atual.
        for (int i=0; i<n-gap; i++) {
          comparacao++;

            comparacao++;
            if (array[i] > array[i+gap]) {
                movimentacao++;
                int temp = array[i];

                movimentacao++;
                array[i] = array[i+gap];

                movimentacao++;
                array[i+gap] = temp;

                troca = true;
            }
        }
    }
    long tudo[]  = new long[2];
    tudo[0] = comparacao;
    tudo[1] = movimentacao;
    return tudo;
  }

  // SHELL SORT

  long[] shellSort(Integer array[],  long comparacao, long movimentacao) {
    int n = array.length;
    int h = 1;
    while (h < n) {
      comparacao++;
      h = h * 3 + 1;
    }
    h = (int) Math.floor(h / 3);

    int elemento, j;
    while(h > 0) {
      comparacao++;

      comparacao++;
      for(int i = h; i < n; i++) {
        comparacao++;

        elemento = array[i];
        j = i;

        comparacao++;
        while ( j >= h && array[j - h] > elemento) {
          comparacao++;

          array[j] = array[j - h];
          movimentacao++;
          j = j - h;
        }
        array[j] =  elemento;
        movimentacao++;
      }
      h = h / 2;
    }
    long tudo[]  = new long[2];
    tudo[0] = comparacao;
    tudo[1] = movimentacao;
    return tudo;
  }

  // BOGO SORT
  long[] bogoSort(Integer array[],  long comparacao, long movimentacao) {
    boolean ordenado = false;
    Random random = new Random();
    comparacao++;
    while(ordenado == false) { 
      comparacao++;
      
      ordenado = true;

      comparacao++;
      // Verificar se está ordenado;
      for (int i = 1; i < array.length; i++) {
        comparacao++;
        if (array[i] < array[i - 1]) {
          ordenado = false;
          break;
        }
      }

      comparacao++;
      // Embaralhar
      if(ordenado == false) {
        comparacao++;
        for (int i = 0; i < array.length; i++) {
          comparacao++;
          int j = random.nextInt(array.length);
          int aux = array[i];
          movimentacao++;
          array[i] = array[j];
          movimentacao++;
          array[j] = aux;
          movimentacao++;    
        }
      }
    }
  
    long tudo[]  = new long[2];
    tudo[0] = comparacao;
    tudo[1] = movimentacao;
    return tudo;
  }
}
