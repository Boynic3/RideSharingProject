package servicos;

public class CategoriaLuxo extends CategoriaCorrida {
    public CategoriaLuxo(int tarifaBase,  double multiplicador, double preco){
        super(tarifaBase, multiplicador, preco);
    }

    @Override
    public double calcularPreco(int tarifaBase, double multiplicador, double kilometragem, double preco) {
        tarifaBase = 9;
        multiplicador = 2.20;
        return super.calcularPreco(tarifaBase,multiplicador,kilometragem,preco);
    }
}
