package entidades;

import servicos.Corrida;

public class Motorista extends UsuarioComum {
    private boolean cnhValida = true;
    private String statusMotorista;
    Veiculo carro;
    Corrida viagem;

    public Motorista(String nome, String cpf, String email, String senha, String telefone, String statusMotorista, boolean cnhValida) {
        super(nome,cpf,email,senha,telefone);
        this.statusMotorista = statusMotorista;
    }
}
