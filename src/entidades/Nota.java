package entidades;

public class Nota {
    private double nota;

    public Nota(double nota) {
        this.nota = nota;
    }

    public void darNota(double nota) {
        this.nota = nota;
    }
    public double getNota() {
        return nota;
    }
}
