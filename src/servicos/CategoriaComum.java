package servicos;

public class CategoriaComum extends CategoriaCorrida{
    public CategoriaComum(int tarifaBase, int multiplicador, int kilometragem, double preco) {
        super(tarifaBase, multiplicador, preco);
    }


    public double calcularPreco(int tarifaBase, double multiplicador, double kilometragem, double preco) {
        tarifaBase = 5;
        multiplicador = 1;
        return super.calcularPreco(tarifaBase,multiplicador,kilometragem);
    }
}


