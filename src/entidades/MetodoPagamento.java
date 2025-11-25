package entidades;

public interface MetodoPagamento {
    boolean processarPagamento(double valor);
    String getMetodo();
    

    }

