package servicos;

public class CategoriaCorrida {
    private int tarifaBase;
    private double multiplicador, preco, kilometragem;

    public CategoriaCorrida(int tarifaBase, double multiplicador, double preco) {
        this.tarifaBase = tarifaBase;
        this.multiplicador = multiplicador;
        this.preco = preco;
        this.kilometragem = preco * tarifaBase;
    }

    public double calcularPreco(int tarifaBase, double multiplicador, double kilometragem, double preco){
        preco = tarifaBase + multiplicador * kilometragem;
        return preco;
    }
}
