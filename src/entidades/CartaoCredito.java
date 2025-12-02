package entidades;

import exceptions.SaldoInsuficienteException;

public class CartaoCredito implements MetodoPagamento {
    private String numeroCartao, bandeira, numValidade, CVV;

    public CartaoCredito(String numeroCartao, String bandeira, String numValidade, String CVV) {
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.numValidade = numValidade;
        this.CVV = CVV;
    }

    @Override
    public void processarPagamento(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("Valor inválido para cartão.");
        }

        System.out.println("Pagamento de R$ " + valor + " processado no Crédito (" + bandeira + ")... Aprovado!");
    }

    @Override
    public String getMetodo() {
        return "Cartão de Crédito";
    }

    @Override
    public String toString() {
        return "Cartão de Crédito (" + this.bandeira + ")";
    }
}