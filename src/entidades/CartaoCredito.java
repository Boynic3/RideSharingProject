package entidades;

public class CartaoCredito implements MetodoPagamento {
    private String numeroCartao, bandeira, numValidade, CVV;
    public CartaoCredito(String numeroCartao, String bandeira, String numValidade, String CVV) {
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.numValidade = numValidade;
        this.CVV = CVV;
    }
    public void processarPagamento(){
    	System.out.println("Pagamento processado no Crédito...");
    	}
    
    public String getMetodo() {
    	return "Cartão de Crédito";
    }

    @Override
    public String toString() {
        return "Cartão de Crédito";    // Se quiser mostrar a bandeira: return "Cartão de Crédito (" + this.bandeira + ")";
    }
}
