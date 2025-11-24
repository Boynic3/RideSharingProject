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


    public double corridaPreço(double preco) {
        this.preco = preco;
        return preco;
    }

    public inicializarViagem(){

    }
    public finalizarViagem(){

    }
    public cancelarViagem(){

    }
}
