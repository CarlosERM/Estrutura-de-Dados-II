
public class DuasPilhaDif {
        int tamanho;
        int topo1, topo2;
        int armazem[];

        DuasPilhaDif(int n) {
            armazem = new int[n];
            tamanho = n;
            topo1 = -1;
            topo2 = tamanho;
        }

//        colocar um elemento na pilha 1.
        void push1(int x) {
//            Tem pelo menos um espaço vazio.
            if (topo1 < topo2 - 1) {
                topo1++;
                armazem[topo1] = x;
            } else {
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

//         Método para colocar um elemento na pilha 2;
        void push2(int x) {
//            Tem pelo menos um espaço vazio.
            if (topo1 < topo2 -1) {
                topo2--;
                armazem[topo2] = x;
            } else {
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

//         método para retirar elementos da pilha 1
        int pop1() {
            if (topo1 >= 0) {
                int x = armazem[topo1];
                topo1--;
                return x;
            } else {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            return 0;
        }

//     método para retirar elementos da pilha 2
        int pop2() {
            if(topo2 < tamanho) {
                int x =armazem[topo2];
                topo2++;
                return x;
            } else {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            return 0;
        }
}
