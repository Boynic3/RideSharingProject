package servicos;

public class CategoriaLuxo extends CategoriaCorrida {
    public CategoriaLuxo(int tarifaBase, double multiplicador, double kilometragem) {
        super(tarifaBase, multiplicador,  kilometragem);
    }

    @Override
    public double calcularPreco(int tarifaBase, double multiplicador, double kilometragem) {
        tarifaBase = 9;
        multiplicador = 2.20;
        return super.calcularPreco(tarifaBase,multiplicador,kilometragem);
    }
}
