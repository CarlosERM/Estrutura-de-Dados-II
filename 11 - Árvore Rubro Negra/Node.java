public class Node {
  int valor;

  Node esquerda;
  Node direita;
  Node pai;

  boolean cor;

  public Node(int valor) {
    this.valor = valor;
  }
}