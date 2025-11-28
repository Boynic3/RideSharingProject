package entidades;

public interface MetodoPagamento {
    static boolean validaPagamento(Passageiro passageiro) {
        return true;
    }

    public boolean processarPagamento(double valor);
    public String getMetodo();
    

    }

