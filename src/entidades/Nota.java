package entidades;

public class Nota {
    private double nota;
    private String comentario;

    public Nota(double nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }
    public Nota(double nota) { //adcionei esse pra quando a gente
        this.nota = nota;      // for dar só nota sem o comentário
        this.comentario = "";
    }

    public void darNota(double nota) {
        this.nota = nota;
    }
    public double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        if (comentario == null || comentario.isEmpty()) {
            return String.valueOf(nota);
        }
        return nota + " - \"" + comentario + "\"";
    }
}
