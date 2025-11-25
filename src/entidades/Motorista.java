package entidades;

import servicos.Corrida;

public class Motorista extends UsuarioComum {
    private boolean cnhValida = true;
    private String statusMotorista;
    Veiculo carro;
    Corrida viagem;

    public Motorista(String nome, String cpf, String email, String senha, String telefone, String statusMotorista, boolean cnhValida) {
        super(nome,cpf,email,senha,telefone);
        this.setStatusMotorista(statusMotorista);
        this.cnhValida = cnhValida;
    }

	public boolean isCnhValida() {
		return cnhValida;
	}

	public void setCnhValida(boolean cnhValida) {
		this.cnhValida = cnhValida;
	}

	public String getStatusMotorista() {
		return statusMotorista;
	}

	public void setStatusMotorista(String statusMotorista) {
		this.statusMotorista = statusMotorista;
	}
}
