class InsertionSort {
	int contOp = 0;

	int[] sort(int array[]) {
		int tamanho = array.length;
		for (int i = 1; i < tamanho; ++i) {
			int chave = array[i]; 
			int j = i - 1; //Isso significa que a chave é o segundo número dentro do array. É sempre um valor a mais.
			contOp++;
            // Mover os elementos do array que são maiores que a chave uma posição à frente da sua posição atual.
			while (j >= 0 && array[j] > chave) { // se o valor logo atrás da chave for maior que ela.
                contOp++;             
							//para onde o valor da chave vai?
                array[j + 1] = array[j]; // eu faço o array, exatamente na posição da chave, trocar de posições. 
				contOp++;
				j = j - 1; //A posição em que estava a chave agora vai receber o valor que está logo atrás dela.
                // depois disso eu dou um j - 1, retornando o j para a posição anterior. Lembrando que não anterior a chave, ele já estava lá. Ele só está andando mais ainda pra trás.
			    // e ele vai retornando até chegar num número menor que zero. É interessante observar que a troca vai sendo feita.
                // A medida que ele vai indo para trás o valor que está logo a frente irá receber o valor que está logo atrás.
                // com isso, pelo que eu entendi bem, todos os menores serão jogados lá para trás. Surreal.
			}
			array[j + 1] = chave; //no fim, quando tudo parar o valor da chave vai ficar aqui. Genial. 
			contOp++;
		}
        return array;
	}
}
