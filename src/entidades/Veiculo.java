package entidades;

public class Veiculo {
    String modelo, cor, placa;
    int anoFabrica, anoModelo;

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAnoFabrica() {
        return anoFabrica;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAnoFabrica(int anoFabrica) {
        this.anoFabrica = anoFabrica;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

}
