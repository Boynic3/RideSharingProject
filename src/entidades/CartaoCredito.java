package entidades;

public class CartaoCredito implements MetodoPagamento {
    private String numeroCartao, bandeira, numValidade, CVV;
    public CartaoCredito(String numeroCartao, String bandeira, String numValidade, String CVV) {
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.numValidade = numValidade;
        this.CVV = CVV;
    }
    public boolean processarPagamento(double valor){
    	System.out.println("Processando pagamento R$" + valor + " no Crédito...");
    	return true;
    	}
    
    public String getMetodo() {
    	return "Cartão de Crédito";
    }

    @Override
    public String toString() {
        return "Cartão de Crédito";    // Se quiser mostrar a bandeira: return "Cartão de Crédito (" + this.bandeira + ")";
    }
}
