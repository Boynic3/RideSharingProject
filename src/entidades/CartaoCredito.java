package entidades;

public class CartaoCredito implements MetodoPagamento {

    public boolean processarPagamento(double valor){
    	System.out.println("Processando pagamento R$" + valor + " no Crédito...");
    	return true;
    	}
    
    public String getMetodo() {
    	return "Cartão de Crédito";
    }
}
