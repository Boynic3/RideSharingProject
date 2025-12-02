package entidades;
import exceptions.SaldoInsuficienteException;

public class Dinheiro implements MetodoPagamento {
    private double saldo;

    public Dinheiro(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void processarPagamento(double valor) throws SaldoInsuficienteException {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Pagamento de R$" + valor + " realizado com Dinheiro. Saldo restante: " + this.saldo);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente! Necessário: " + valor + ", Disponível: " + this.saldo);
        }
    }

    @Override
    public String getMetodo() {
        return "Dinheiro";
    }

    @Override
    public String toString() {
        return "Dinheiro (Saldo: " + saldo + ")";
    }
}