package entidades;

import enums.StatusMotorista;
import servicos.Corrida;
import enums.StatusCorrida;

public class Motorista extends UsuarioComum {
    private String cnh;
    private StatusMotorista status;
    Veiculo carro;
    Corrida viagem;

    public Motorista(String nome, String cpf, String email, String senha, String telefone, String cnh, String statusMotorista) {
        super(nome, cpf, email, senha, telefone);
        this.status = StatusMotorista.valueOf(statusMotorista);
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public StatusMotorista getStatusMotorista() {
        return status;
    }

    public void setStatusMotorista(String novoStatusTexto) {
        try {
            this.status = StatusMotorista.valueOf(novoStatusTexto);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Status '" + novoStatusTexto + "' não existe no sistema.");
        }
    }

    public String getCarro() {
        return carro.toString();
    }
    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }
}