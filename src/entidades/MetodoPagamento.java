package entidades;

public interface MetodoPagamento {
    static boolean validaPagamento(Passageiro passageiro) { //como é static, não precisa implementar em cada classe que implementa a interface
        return true;
    }

    public boolean processarPagamento(double valor);
    public String getMetodo();
    

    }

