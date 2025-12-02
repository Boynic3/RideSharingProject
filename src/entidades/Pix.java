package entidades;

import exceptions.SaldoInsuficienteException;

public class Pix implements MetodoPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("Valor inválido para Pix.");
        }
        System.out.println("Pagamento de R$ " + valor + " recebido com sucesso via Pix (Chave: " + chavePix + ").");
    }

    @Override
    public String getMetodo() {
        return "Pix";
    }

    @Override
    public String toString() {
        return "Pix (Chave: " + this.chavePix + ")";
    }
}