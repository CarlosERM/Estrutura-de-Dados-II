import java.util.ArrayList;

class Ordenator {
  long comparacao = 0;
  long movimentacao = 0;

  void cocktailSort(int array[]) {
        boolean trocou = true;
        int comeco = 0;
        int fim = array.length;
 
        while (trocou == true) {
          // Reset da variável trocou porque ela pode ser true na última iteração.
          trocou = false;
 
          // A mesma coisa do bubble sort. Debaixo pra cima.
            for (int i = comeco; i < fim - 1; ++i) {
              comparacao++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    movimentacao++;
                    array[i] = array[i + 1];
                    movimentacao++;
                    array[i + 1] = temp;
                    movimentacao++;
                    trocou = true;
                }
            }
 
            comparacao++;
            // Se nada moveu o array está ordenado.
            if (trocou == false)
                break;

            // Se algo moveu, resete a variável para ela ser utilizado no próximo passo.
            trocou = false;

            // Mover o fim para uma posição atrás, porque o que está nessa posição já está ordenado.
            fim = fim - 1;
 
            // Bubble sort de cima pra baixo.
            for (int i = fim - 1; i >= comeco; i--) {
                comparacao++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    movimentacao++;
                    array[i] = array[i + 1];
                    movimentacao++;
                    array[i + 1] = temp;
                    movimentacao++;
                    trocou = true;
                }
            }
 
            // Aumenta o ponto de começo em um porque no último estágio o menor valor já vai
            // estar no começo.
            comeco = comeco + 1;
        }
    }
    void bucketSortMixed(int[] array) {
        int n = array.length;
        ArrayList<Integer> negativos = new ArrayList<Integer>();
        ArrayList<Integer> positivos = new ArrayList<Integer>();
        
        // Agrupar os valores negativos e os valores positivos.
        for(int i = 0; i < n; i++){
          if(array[i] < 0){
            negativos.add(-1 * array[i]);
          } else {
            positivos.add(array[i]);
          }
        }
        
        // Ordenar cada um separadamente.
        bucketSort(negativos);
        bucketSort(positivos);
        
        // Armazenamento dos valores negativos primeiro.
        for (int i = 0; i < negativos.size(); i++){ 
            array[i] = -1 * negativos.get(negativos.size() - 1 - i);
        }
        
        // Armazenamento dos valores positivos.
        for(int j = negativos.size(); j < n; j++) {
            array[j] = positivos.get(j - negativos.size()); 
        }
      } 
    void bucketSort(ArrayList<Integer> array) {
    }


}
