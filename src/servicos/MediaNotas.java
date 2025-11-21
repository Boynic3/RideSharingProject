package servicos;

public class MediaNotas {
    private Avaliacao Notas[];
    public MediaNotas(){
    }
    public double calcularNota(Avaliacao Notas[]) {
        double media = 0;
        for (int i = 0; i < Notas.length; i++) {
            media += Notas[i].getNota();
    }
            return media / Notas.length;
    }
}
