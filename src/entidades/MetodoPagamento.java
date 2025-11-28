package entidades;

public interface MetodoPagamento {
    public boolean processarPagamento(double valor);
    public String getMetodo();
    

    }

