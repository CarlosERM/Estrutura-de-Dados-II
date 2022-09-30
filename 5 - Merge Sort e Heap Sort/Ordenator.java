class Ordenator {
  long comparacao = 0;
  long movimentacao = 0;
  
  // QUICK SORT
    void mergeSort(Integer[] array) {
      int tamanho = array.length;

      comparacao++;
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
        movimentacao++;
        parteEsquerda[i] = array[i];
      }

      // Popular o array parteDireita[]
      for(int i = meio; i < tamanho; i++) {
        movimentacao++;
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
        comparacao++;
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
        movimentacao++;
        array[k] = parteEsquerda[iEsquerda];
        iEsquerda++;
        k++;
      }

      // Se pegamos todos os valores, jDireita seria maior que tamanhoDireita.  
      while(jDireita < tamanhoDireita) {
        movimentacao++;
        array[k] = parteDireita[jDireita];
        jDireita++;
        k++;
      }
    }

    // Heap Sort
    
    void heapSort(Integer[] array) {
      int tamanho = array.length;

      // Graças a natureza da estrutura de filhos da árvore binária só precisamos
      // percorrer metade do vetor menos um.
      for(int i = tamanho / 2 - 1; i>= 0; --i ) {
        fazHeap(array, tamanho, i);
      }
      // Já é garantido que as raízes são os maiores elementos. Agora eu pego o maior elemento e jogo para o fim.

      for(int i = tamanho - 1; i > 0; i--) {
        int aux = array[0]; // Maior elemento no heap.
        array[0] = array[i]; // Coloco o menor no topo do heap.
        array[i] = aux; // Coloco o maior no último lugar.
        movimentacao++;
        movimentacao++;
        movimentacao++;

        // A cada troca o vetor fica bagunçado. Por isso: 
        fazHeap(array, i, 0);
      }

    }

    void fazHeap(Integer[] array, int tamanho, int i) {
      int raiz = i;

      //As coordenadas dos filhos em um heap.
      int filhoEsquerdo = 2 * i + 1;
      int filhoDireito = 2 * i + 2;

      comparacao++;
      // Se o filho a esquerda é maior que o pai, o filho a esquerda é o novo pai.
      if(filhoEsquerdo < tamanho && array[filhoEsquerdo] > array[raiz] ) {
        raiz = filhoEsquerdo;
        movimentacao++;

      }

      comparacao++;
      // Se o filho a direita é maior que o pai, o filho a direita é o novo pai.
      if(filhoDireito < tamanho && array[filhoDireito] > array[raiz] ) {
        raiz = filhoDireito;
      }

      comparacao++;
      // Se houve alguma troca.
      if(raiz != i) {
        int aux = array[i];
        array[i] = array[raiz];
        array[raiz] = aux;
        movimentacao++;
        movimentacao++;
        movimentacao++;

        // Se houve troca, eu preciso fazer o heap novamente para verificar se o maior é de fato o maior.
        fazHeap(array, tamanho, raiz);
      }
    }
}
