package servicos;

import entidades.UsuarioComum;

public class Avaliacao {
    private double nota;
    UsuarioComum avaliador;
    UsuarioComum avaliado;

    public  Avaliacao(double nota) {
        this.nota = nota;
    }
    public double getNota() {
        return nota;
    }
}
