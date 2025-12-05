package entidades;

import enums.StatusMotorista;
import servicos.Corrida;
import enums.StatusCorrida;

import java.util.ArrayList;
import java.util.List;

public class Motorista extends UsuarioComum {
    private String cnh;
    private StatusMotorista status;
    Veiculo carro;
    Corrida viagem;

    private List<Nota> notas = new ArrayList<>();
    private List<Corrida> historicoCorridas = new ArrayList<>();


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

    public void darNota(double notaValor, String comentario) {
        Nota n = new Nota(notaValor, comentario);
        notas.add(n);
    }
    public double calcularNota() {
        if (notas.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Nota n : notas) {
            soma += n.getNota();
        }
        return soma / notas.size();
    }

    public List<Nota> getListaDeNotas() {
        return notas;
    }

    public void setStatus(StatusMotorista statusMotorista) {
        this.status = statusMotorista;
    }

    public void adicionarCorridaAoHistorico(Corrida c) {
        this.historicoCorridas.add(c);
    }

    public List<Corrida> getHistoricoCorridas() {
        return historicoCorridas;
    }

}
