public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);

        for(int x = 0; x <5; x++) {
            System.out.println(pilha.pop());
        }

    }
}
