package servicos;

public class CategoriaComum extends CategoriaCorrida{
    public CategoriaComum(int tarifaBase,  double multiplicador, double preco){
        super(tarifaBase, multiplicador, preco);
    }

    @Override
    public double calcularPreco(int tarifaBase, double multiplicador, double kilometragem, double preco) {
        tarifaBase = 5;
        multiplicador = 1;
        return super.calcularPreco(tarifaBase,multiplicador,kilometragem,preco);
    }
}


