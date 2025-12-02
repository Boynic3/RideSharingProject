package entidades;

public class Pix implements MetodoPagamento {
    private String chavePix;
    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }
	@Override
	public boolean processarPagamento(double valor) {
		System.out.println("Pagamento de R$" + valor + " recebido em Pix.");
		return true;
	}

	@Override
	public String getMetodo() {
		return "Pix";
	}

    @Override
    public String toString() {
        return "Pix";   // Se quiser mostrar a chave: return "Pix (Chave: " + this.chavePix + ")";
    }
}
