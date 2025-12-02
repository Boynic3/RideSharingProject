package entidades;

public class Dinheiro implements MetodoPagamento{
    private double saldo;

    public Dinheiro(Double saldo) {
        this.saldo = saldo;
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

    @Override
    public String toString() {
        return "Dinheiro"; //Pra mostrar o saldo    return "Dinheiro (saldo: " + this.saldo + ")";
    }

}
