package entidades;

import servicos.Corrida;

public class Motorista extends UsuarioComum {
    private String cnh;
    private String statusMotorista;
    Veiculo carro;
    Corrida viagem;

    public Motorista(String nome, String cpf, String email, String senha, String telefone, String statusMotorista) {
        super(nome,cpf,email,senha,telefone);
        this.setStatusMotorista(statusMotorista);
        this.cnh = cnh;
    }

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getStatusMotorista() {
		return statusMotorista;
	}

	public void setStatusMotorista(String statusMotorista) {
		this.statusMotorista = statusMotorista;
	}
}
