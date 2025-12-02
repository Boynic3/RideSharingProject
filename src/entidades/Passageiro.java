package entidades;

import java.util.ArrayList;
import java.util.List;

public class Passageiro extends UsuarioComum {
    private boolean saldoPendente = false;
    private MetodoPagamento tipoPagamento;
    private static double nota = 0.0;

    private static List<Nota> notas = new ArrayList<>();

    public Passageiro(String nome, String cpf, String email, String senha, String telefone) {
        super(nome, cpf, email, senha, telefone);
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
    public void darNota(double nota) {
        this.nota = nota;
        notas.add(nota);
    }
    public double calcularNota() {
        double temp = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            notas[i] += temp;
            temp = temp/notas.size();
        }
        return temp;
    }

}
