package servicos;

import entidades.MetodoPagamento;
import entidades.Passageiro;
import enums.StatusCorrida;
import exceptions.EstadoInvalidoDaCorridaException;


public class Corrida {
    private String localPartida, localFinal;
    private double kilometragem;
    private boolean viagemIniciada = false;
    private StatusCorrida status;
    Passageiro p;


    public Corrida(String localPartida, String localFinal, double kilometragem) {
        this.localPartida = localPartida;
        this.localFinal = localFinal;
        this.kilometragem = kilometragem;
        this.status = StatusCorrida.SOLICITADA;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalFinal() {
        return localFinal;
    }



    public void inicializarViagem() {
        System.out.println("Viagem iniciada!");
        viagemIniciada = true;
    }

    public void finalizarViagem() {
        viagemIniciada = false;
        System.out.println("Viagem finalizada!");
    }
    public boolean isViagemIniciada(){
        return viagemIniciada;
    }

    public void cancelarViagem(boolean viagemIniciada) throws EstadoInvalidoDaCorridaException {
        if (viagemIniciada == false) {
            throw new EstadoInvalidoDaCorridaException("Erro ao cancelar viagem! Corrida não iniciada.");
        }
        System.out.println("Erro ao cancelar viagem!");
    }
    public double getKilometragem() {
        return kilometragem;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }
}