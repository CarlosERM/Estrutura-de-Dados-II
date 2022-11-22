public class NodeAVL {
    int valor;
    int altura; 
    NodeAVL esquerda;
    NodeAVL direita;
      
    public NodeAVL() {  
        esquerda = null;  
        direita = null;  
        valor = 0;  
        altura = 0;  
    }

    public NodeAVL(int valor) {  
        esquerda = null;  
        direita = null;  
        this.valor = valor;  
        altura = 0;  
    }       
}
