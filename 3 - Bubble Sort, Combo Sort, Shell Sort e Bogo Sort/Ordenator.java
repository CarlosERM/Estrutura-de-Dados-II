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
      h = h *3 + 1;
    }
    h = (int) Math.floor(h / 3);

    int elemento, j;
    while(h > 0) {
      for(int i = h; i < n; i++) {
        elemento = array[i];
        j = i;
        while ( j >= h && array[j - h] > elemento) {
          array[j] = array[j - h];
          j = j - h;
        }
        array[j] =  elemento;
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
    while(ordenado == false) {
      ordenado = true;
      // Verificar se está ordenado;
      for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]) {
          ordenado = false;
          break;
        }
      }

      // Embaralhar
      if(ordenado == false) {
        for (int i = 0; i < array.length; i++) {
          int j = (int)(Math.random() * i);
          int aux = array[i];
          array[i] = array[j];
          array[j] = aux;    
        }
      }
    }
  
    long tudo[]  = new long[2];
    tudo[0] = comparacao;
    tudo[1] = movimentacao;
    return tudo;
  }
}
