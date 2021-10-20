
class Pilha {
    private final int MAXIMO = 1000;
    private int topo;
    private int armazem[] = new int[MAXIMO]; // Maximum size of Stack
 
    public boolean isEmpty() {
        return (topo < 0);
    }

    Pilha() {
        topo = -1;
    }
 
    public boolean push(int x) {
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
 
    public int pop()
    {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = armazem[topo--];
            return x;
        }
    }
 
    public int peek() {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = armazem[topo];
            return x;
        }
    }
}