package entidades;

public class Passageiro extends UsuarioComum {
    private boolean saldoPendente = false;
    MetodoPagamento tipoPagamento;

    public Passageiro(String nome, String cpf, String email, String senha, String telefone) {
        super(nome, cpf, email,senha, telefone);

    }

	public boolean isSaldoPendente() {
		return saldoPendente;
	}

	public void setSaldoPendente(boolean saldoPendente) {
		this.saldoPendente = saldoPendente;
	}

}
