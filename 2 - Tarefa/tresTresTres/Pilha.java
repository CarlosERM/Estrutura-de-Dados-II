
class Pilha {
    private final int MAXIMO = 1000;
    private int topo;
    private char armazem[] = new char[MAXIMO]; // Maximum size of Stack
 
    public boolean isEmpty() {
        return (topo < 0);
    }

    Pilha() {
        topo = -1;
    }
 
    public boolean push(char x) {
        if (topo >= (MAXIMO - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }

        else {
            armazem[++topo] = x;
            System.out.println(x + " foi empilhado na Pilha.");
            return true;
        }
    }
 
    public char pop()
    {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            char x = armazem[topo--];
            return x;
        }
    }
 
    public char peek() {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            char x = armazem[topo];
            return x;
        }
    }
}