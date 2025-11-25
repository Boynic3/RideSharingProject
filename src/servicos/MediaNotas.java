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
        if (Notas.length > 0) { 
        return media / Notas.length;
    } else {
    	return 0;
    }
}
		public Avaliacao[] getNotas() {
			return Notas;
	}
	
		public void setNotas(Avaliacao notas[]) {
		Notas = notas;
	}
}
