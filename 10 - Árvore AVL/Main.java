public class Main {
    public static void main(String[] args) {
        BinaryTreeAVL arvoreBinariaAVL = new BinaryTreeAVL();
        
        arvoreBinariaAVL.inserirElemento(13);
        arvoreBinariaAVL.inserirElemento(10);
        arvoreBinariaAVL.inserirElemento(15);
        arvoreBinariaAVL.inserirElemento(5);
        arvoreBinariaAVL.inserirElemento(11);
        arvoreBinariaAVL.inserirElemento(4);
        arvoreBinariaAVL.inserirElemento(6);
        arvoreBinariaAVL.inserirElemento(14);
        arvoreBinariaAVL.inserirElemento(16);

        arvoreBinariaAVL.passadaEmNivel();
    }
}
