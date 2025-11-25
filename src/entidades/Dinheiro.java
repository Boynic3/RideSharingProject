package entidades;

public class Dinheiro implements MetodoPagamento{
    public Dinheiro(){
    }

	@Override
	public boolean processarPagamento(double valor) {
		System.out.println("Pagamento de R$"  + valor + " recebido em Dinheiro.");
		return true;
	}

	@Override
	public String getMetodo() {
		return "Dinheiro";
	}

}
