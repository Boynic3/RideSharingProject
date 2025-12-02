package entidades;
import exceptions.SaldoInsuficienteException;

public interface MetodoPagamento {
    void processarPagamento(double valor) throws SaldoInsuficienteException;
    String getMetodo();
}