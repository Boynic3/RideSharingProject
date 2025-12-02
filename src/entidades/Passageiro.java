package entidades;

import exceptions.SaldoPendenteException;
import java.util.ArrayList;
import java.util.List;

public class Passageiro extends UsuarioComum {
    private boolean saldoPendente = false;
    private MetodoPagamento tipoPagamento;

    private List<Double> notas = new ArrayList<>();

    public Passageiro(String nome, String cpf, String email, String senha, String telefone) {
        super(nome, cpf, email, senha, telefone);
    }

    public void verificarSePodeViajar() throws SaldoPendenteException {
        if (this.saldoPendente) {
            throw new SaldoPendenteException("O passageiro " + getNome() + " possui débitos pendentes.");
        }
    }

    public boolean isSaldoPendente() { return saldoPendente; }
    public void setSaldoPendente(boolean saldoPendente) { this.saldoPendente = saldoPendente; }
    public void setPagamento(MetodoPagamento tipoPagamento) { this.tipoPagamento = tipoPagamento; }
    public MetodoPagamento getPagamento() { return this.tipoPagamento; }

    public void darNota(double nota) {
        this.notas.add(nota);
    }

    public double calcularNota() {
        if(notas.isEmpty()) return 5.0;
        double soma = 0.0;
        for (Double n : notas) soma += n;
        return soma / notas.size();
    }
}