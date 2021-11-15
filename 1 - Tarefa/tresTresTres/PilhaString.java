
class PilhaString {
    private final int MAXIMO = 1000;
    private int topo;
    private String armazem[] = new String[MAXIMO]; // Maximum size of Stack
 
    public boolean isEmpty() {
        return (topo < 0);
    }

    PilhaString() {
        topo = -1;
    }
 
    public boolean push(String x) {
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
 
    public String pop()
    {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return "";
        }
        else {
            String x = armazem[topo--];
            return x;
        }
    }
 
    public String peek() {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return "";
        }
        else {
            String x = armazem[topo];
            return x;
        }
    }
}