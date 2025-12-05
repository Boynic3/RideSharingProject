package entidades;

public class Veiculo {
    private String modelo, cor, placa;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabrica() {
        return anoFabrica;
    }

    public void setAnoFabrica(int anoFabrica) {
        this.anoFabrica = anoFabrica;
    }

    @Override
    public String toString() {
        return modelo + " " + cor + " (" + placa + ")";
    }
}
