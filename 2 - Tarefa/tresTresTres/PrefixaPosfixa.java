class PrefixaPosfixa {
    
    // FUNÇÃO PARA VER SE O CARACTER É UM OPERADOR OU NÃO.
    public boolean isOperator(char x) {
        switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
        case '@':
            return true;
        }
        return false;
    }
 
    // CONVERSOR PREFIXA PARA POSFIXA.
    public String prefixaParaPosfixa(String prefixa){
        PilhaString pilha = new PilhaString();
        // tamanho de uma expressão.
        int tamanho = prefixa.length();
 
        //leitura da direita para a esquerda. 
        for (int i = tamanho - 1; i >= 0; i--) {
            // checar se o simbolo é um operador.
            if (isOperator(prefixa.charAt(i))) {

                // popar dois operandos da pilha.
                String op1 = "" + pilha.pop();
                String op2 = "" + pilha.pop();

                // concatenar os operandos e os operador.
                String temp = op1 + op2 + prefixa.charAt(i);

                // empurrar o temp de volta pra pilha.
                pilha.push(temp);
            }
 
            // se o símbolo é um operando.
            else {
                // empurre o oeprandopra dentro da pilha;
                pilha.push(prefixa.charAt(i) + "");
            }
        }

        return pilha.peek();
    }
}