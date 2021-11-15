
//INEFICIENTE.
public class DuasPilha {
    int armazem[];
    int tamanho;
    int topo1, topo2;

    DuasPilha(int numero) {
        tamanho = numero;
        armazem = new int[numero];

        topo1 = numero/2 + 1;
        topo2 = numero / 2;

    }

//    colocar elementos na pilha 1.
    void push1(int x) {
//    Tem pelo menos um espaço vazio para um novo elemento.
        if(topo1 > 0) {
            topo1--;
            armazem[topo1]=x;
        }
        else {
            System.out.println("Stack Overflow.\n"
            + "Pelo elemento: " + x + "\n");
            return;
        }
    }
//    colocar elementos na pilha 2.
    void push2(int x) {
//        Tem pelo menos um espaço vazio para um novo elemento.
        if(topo2 < tamanho - 1) {
            topo2++;
            armazem[topo2] = x;
        } else {
            System.out.println("Stack Overflow.\n"
                             + "Pelo elemento: " + x + "\n");
            return;

        }
    }
//    retirar elemento da pilha 1;
    int pop1() {
        if (topo1 <= tamanho / 2) {
            int x = armazem[topo1];
            topo1++;
            return x;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (topo2 >= tamanho/2 + 1) {
            int x = armazem[topo2];
            topo2--;
            return x;
        } else {
            System.out.print("Stack UnderFlow");
            System.exit(1);
        }
        return 1;
    }
}
