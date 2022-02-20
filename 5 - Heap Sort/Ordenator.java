class Ordenator {

   public  int heapSort(Integer array[], int cont) {
      int tamanho = array.length;
      // Regra dos filhos: 
      //2 * i + 1
      //2 * i + 2
      //Eu consgio montar  a árvore heap andando apenas metade do vetor.

      for(int i = tamanho / 2 - 1; i >= 0 ; i--) {
         fazerHeap(array, tamanho, i, cont );
         cont++;
      }

      // Agora, depois do heap aplicado, temos a certeza de que as raízes da arvore heap possuem osmaiores elementos. Portanto basta pegar esses maiores e jogá-los na última posição do vetor.
     for (int j = tamanho - 1; j > 0 ; j--) {
         int aux = array[0]; //O primeiro elemento da árvore heap é o maior de todos.
         cont++;
         array[0] =  array[j]; // a raiz recebe o valor que está na última posição do heap.
         cont++;
         array[j] = aux; // a última posição recebe o maior valor da árvore heap.
         cont++;
         //No momento que essa troca é feita, todo o heap é bagunçado. Por isso é necessário aplicá-lo de novo.
         fazerHeap(array, j, 0, cont);
         cont++;
      }

      return cont;
   }

   //Função que monta a árvore heap.
   public void fazerHeap(Integer[] array, int tamanho, int i, int cont) {
         int raiz = i; 
         int esquerda = 2 * i + 1;
         int direita = 2 * i + 2;

         // Para não pegar nenhum elemento fora do vetor.
         if(esquerda < tamanho && array[esquerda] > array[raiz]) {
            //Se o filho a esquerda for maior que o pai, faça com que os dois troquem de lugar. 
            cont++;
            raiz = esquerda;
         }

         // Para não pegar nenhum elemento fora do vetor.
         if(direita < tamanho && array[direita] > array[raiz]) {
            //Se o filho a direita for maior que o pai, faça com que os dois troquem de lugar. 
            raiz = direita;
            cont++;
         }

         //Eu agora quero saber se uma dessas duas condições aqui em cima foram atendidas
         if(raiz != i) {
            cont++;
            //Caso tenha passado pelas duas condições, isso significa que a raiz já não é mais igual ao i. Ela tem o valor ou da esquerda ou da direita. 
            int aux = array[i];
            cont++;
            array[i] = array[raiz]; //Eu armazeno a raiz na posição de pai.
            cont++;
            array[raiz] = aux; // e coloco o antigo pai na posição do filho.
            cont++;
            //Essa condição faz a troca. Caso o filho seja maior que a raiz, troco os dois de lugar. 
            // Caso a troca aconteça, devo chamar o heap mais uma vez, pois talvez o novo filho tenha filhos que sejam mais grandes que ele. É necessário fazer a verificação. 
            // a partir do elmento raiz, aplicamos recursivamente o algoritmo.
            fazerHeap(array, tamanho, raiz,  cont);
            cont++;   
         }

   }
}
