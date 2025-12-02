package entidades;

public class Veiculo {
    String modelo, cor, placa;
    int anoFabrica, anoModelo;

    public Veiculo(String modelo, String cor, String placa, int anoFabrica, int anoModelo) {
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.anoFabrica = anoFabrica;
        this.anoModelo = anoModelo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {}
}
