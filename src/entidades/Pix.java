package entidades;

public class Pix implements MetodoPagamento {
    private String chavePix;
    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }
	@Override
	public void processarPagamento() {
		System.out.println("Pagamento recebido em Pix.");
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
