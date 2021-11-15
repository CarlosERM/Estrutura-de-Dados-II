public class EstacionamentoPilha {
    private final int MAXIMO = 10;
    private int topo;
    private Carro estacionamento[]; // Maximum size of Stack
    int totalElementos = 0;
    private Carro aux;

    public EstacionamentoPilha() {
        topo = -1;
        this.estacionamento = new Carro[MAXIMO];
    }

    public Carro sairEstacionamento(String placa) {
        for(int i = 0 ; i < 10; i++) {
            try{
                if(estacionamento[i].getPlaca().equals(placa)) {
                    aux = estacionamento[i];
                    estacionamento[i] = null;
                    for(int j = i + 1; j < 10; j++) {
                        if(estacionamento[j] != null) {
                            estacionamento[j-1] = estacionamento[j];
                            estacionamento[j-1].deslocamento++;
                            estacionamento[j] = null; 
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Posição vazia.");
            }
  
        }

        totalElementos--;
        return aux;
    }
    public boolean isEmpty() {
        return (topo < 0);
    }
    
    public boolean push(Carro x) {
        if (topo >= (MAXIMO - 1)) {
            return false;
        } else {
            estacionamento[++topo] = x;
            totalElementos++;
            return true;
        }
    }

    public Carro pop() {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            Carro x = estacionamento[topo--];
            x.deslocamento++;
            totalElementos--;
            return x;
        }
    }

    public Carro peek() {
        if (topo < 0) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            Carro x = estacionamento[topo];
            return x;
        }
    }

    public int getMAXIMO() {
        return MAXIMO;
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public Carro[] getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Carro[] estacionamento) {
        this.estacionamento = estacionamento;
    }

    public Carro getAux() {
        return aux;
    }

    public void setAux(Carro aux) {
        this.aux = aux;
    }


    
}
