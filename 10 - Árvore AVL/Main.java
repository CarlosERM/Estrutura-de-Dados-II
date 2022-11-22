public class Main {
    public static void main(String[] args) {
        BinaryTreeAVL arvoreAVL = new BinaryTreeAVL();
        arvoreAVL.inserir(1);
        arvoreAVL.inserir(5);
        arvoreAVL.inserir(4);
        arvoreAVL.inserir(3);
        arvoreAVL.inserir(2);
        arvoreAVL.inserir(7);
        arvoreAVL.inserir(
            6
        );
        arvoreAVL.inOrder(arvoreAVL.raiz);

        arvoreAVL.deletar(1);
        arvoreAVL.inOrder(arvoreAVL.raiz);

    }
}
