package servicos;

public abstract class CategoriaCorrida {
    protected double tarifaBase;
    protected double multiplicador;

    public CategoriaCorrida(double tarifaBase, double multiplicador) {
        this.tarifaBase = tarifaBase;
        this.multiplicador = multiplicador;
    }

    public double calcularPreco(double kilometragem) {
        return tarifaBase + (multiplicador * kilometragem);
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
}