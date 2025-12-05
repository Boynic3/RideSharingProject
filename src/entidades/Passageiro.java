package entidades;

import exceptions.SaldoPendenteException;
import servicos.Corrida;
import java.util.ArrayList;
import java.util.List;

public class Passageiro extends UsuarioComum {
    private boolean saldoPendente = false;
    private MetodoPagamento tipoPagamento;

    private List<Nota> notas = new ArrayList<>();
    private List<Corrida> historicoCorridas = new ArrayList<>();

    public Passageiro(String nome, String cpf, String email, String senha, String telefone) {
        super(nome, cpf, email, senha, telefone);
    }

    public void verificarSePodeViajar() throws SaldoPendenteException {
        if (this.saldoPendente) {
            throw new SaldoPendenteException("O passageiro " + getNome() + " possui débitos pendentes.");
        }
    }

    public boolean isSaldoPendente() {
        return saldoPendente;
    }
    public void setSaldoPendente(boolean saldoPendente) {
        this.saldoPendente = saldoPendente;
    }
    public void setPagamento(MetodoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public MetodoPagamento getPagamento() {
        return this.tipoPagamento;
    }

    public void darNota(double notaValor, String comentario) {
        Nota n = new Nota(notaValor, comentario);
        this.notas.add(n);
    }

    public double calcularNota() {
        if(notas.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Nota n : notas) {
            soma += n.getNota();
        }
        return soma / notas.size();
    }

    public List<Nota> getListaDeNotas() {
        return notas;
    }

    public void adicionarCorridaAoHistorico(Corrida c) {
        this.historicoCorridas.add(c);
    }

    public List<Corrida> getHistoricoCorridas() {
        return historicoCorridas;
    }

}