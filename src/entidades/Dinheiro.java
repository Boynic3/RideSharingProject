package entidades;

public class Dinheiro implements MetodoPagamento{
    private double saldo;

    public Dinheiro(Double saldo) {
        this.saldo = saldo;
    }

    @Override
	public void processarPagamento() {
		System.out.println("Pagamento recebido em Dinheiro.");
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
