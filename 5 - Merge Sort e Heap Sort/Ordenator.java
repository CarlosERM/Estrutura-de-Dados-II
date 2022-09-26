class Ordenator {
  long comparacao = 0;
  long movimentacao = 0;
  
  // QUICK SORT
    void mergeSort(Integer[] array) {
      int tamanho = array.length;
      
      if(tamanho < 2) {
        // Array com apenas um elemento está ordenado.
        return;
      }
      
      int meio = tamanho / 2;

      Integer[] parteEsquerda = new Integer[meio];
      Integer[] parteDireita = new Integer[tamanho - meio]; // para garantir que terá o tamanho correto
                                                    // no caso de tamanhos ímpares.
      // Popular o array parteEsquerda[]
      for(int i = 0; i < meio; i++) {
        parteEsquerda[i] = array[i];
      }

      // Popular o array parteDireita[]
      for(int i = meio; i < tamanho; i++) {
        parteDireita[i - meio] = array[i];
      }

      // Chamada recursiva. 
      mergeSort(parteEsquerda);
      mergeSort(parteDireita);

      // Juntar tudo e ordenar.
      merge(array, parteEsquerda, parteDireita);

    }

    void merge(Integer[] array, Integer[] parteEsquerda, Integer[] parteDireita) {
      int tamanhoEsquerda = parteEsquerda.length;
      int tamanhoDireita = parteDireita.length;

      int iEsquerda = 0, jDireita = 0, k = 0;

      // Continua o loop até que acabem os elementos do array parteEsquerda ou
      // até que os elementos do array parteDireita acabem. 
      while(iEsquerda < tamanhoEsquerda && jDireita < tamanhoDireita) {
        // O valor que está no array esquerdo é menor ou igual ao valor
        // que está no array direito.
        if(parteEsquerda[iEsquerda] <= parteDireita[jDireita]) {
          array[k] = parteEsquerda[iEsquerda];
          iEsquerda++;
        } else {
          array[k] = parteDireita[jDireita];
          jDireita++;
        }
        k++;
      }
      // Caso sobrem elementos, eles precisam ser colocados no array.
      // Se pegamos todos os valores, iEsquerda seria maior que tamanhoEsquerda.  
      while(iEsquerda < tamanhoEsquerda) {
        array[k] = parteEsquerda[iEsquerda];
        iEsquerda++;
        k++;
      }

      // Se pegamos todos os valores, jDireita seria maior que tamanhoDireita.  
      while(jDireita < tamanhoDireita) {
        array[k] = parteDireita[jDireita];
        jDireita++;
        k++;
      }
    }
}
