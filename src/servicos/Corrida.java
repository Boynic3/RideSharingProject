package servicos;

import entidades.Passageiro;

public class Corrida {
    private String localPartida, localFinal;
    private double preco;
    Passageiro passageiro;

    public Corrida(String localPartida, String localFinal, double kilometragem) {
        this.localPartida = localPartida;
        this.localFinal = localFinal;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalFinal() {
        return localFinal;
    }
    
    public double getPreco() {
    	return this.preco;
    }


    public double corridaPreco(double preco) {
        this.preco = preco;
        return preco;
    }

    public void inicializarViagem(){
        System.out.println("Viagem iniciada!");
    }
    public void finalizarViagem(){
        System.out.println("Viagem finalizada!");
    }
    public void cancelarViagem(){
        System.out.println("Viagem cancelada!");
    }
}
