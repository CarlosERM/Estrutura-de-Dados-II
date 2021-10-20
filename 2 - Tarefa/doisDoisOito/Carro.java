public class Carro {
    private String placa;
    private String situacao;
    int deslocamento;

    Carro(String placa, String situacao) {
        this.placa = placa;
        this.situacao = situacao;
        this.deslocamento = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    


    @Override
    public String toString() {
        return "Carro [placa=" + placa + ", situacao=" + situacao + "]";
    }
    
}
