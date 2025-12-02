package servicos;

public class CategoriaCorrida {
    private int tarifaBase;
    private double multiplicador, preco, kilometragem;

    public CategoriaCorrida(int tarifaBase, double multiplicador, double preco) {
        this.setTarifaBase(tarifaBase);
        this.setMultiplicador(multiplicador);
        this.setPreco(preco);
        this.setKilometragem(preco * tarifaBase);
    }

    public double calcularPreco(int tarifaBase, double multiplicador, double kilometragem){
        return tarifaBase + multiplicador * kilometragem;;
    }

	public int getTarifaBase() {
		return tarifaBase;
	}

	public void setTarifaBase(int tarifaBase) {
		this.tarifaBase = tarifaBase;
	}

	public double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(double kilometragem) {
		this.kilometragem = kilometragem;
	}
}
