package servicos;

import entidades.Motorista;
import entidades.Passageiro;
import enums.StatusCorrida;
import exceptions.EstadoInvalidoDaCorridaException;

public class Corrida {
    private String localPartida, localFinal;
    private double kilometragem;
    private StatusCorrida status;

    private Passageiro p;

    private Motorista motorista;
    private double valorCalculado;

    public Corrida(String localPartida, String localFinal, double kilometragem) {
        this.localPartida = localPartida;
        this.localFinal = localFinal;
        this.kilometragem = kilometragem;
        this.status = StatusCorrida.SOLICITADA;
    }

    public void setPassageiro(Passageiro passageiroRecebido) {
        this.p = passageiroRecebido;
    }

    public Passageiro getPassageiro() {
        return this.p;
    }


    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setValorCalculado(double valorCalculado) {
        this.valorCalculado = valorCalculado;
    }

    public double getValorCalculado() {
        return valorCalculado;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalFinal() {
        return localFinal;
    }

    public double getKilometragem() {
        return kilometragem;
    }

    @Override
    public String toString() {
        String nomeP = (this.p != null) ? this.p.getNome() : "Sem Passageiro";
        String nomeM = (this.motorista != null) ? this.motorista.getNome() : "Sem Motorista";

        return "Corrida de " + nomeP + " (Motorista: " + nomeM + ")";
    }

    public boolean isViagemIniciada() {
        return this.status == StatusCorrida.EM_ANDAMENTO;
    }

    public void finalizarViagem() throws EstadoInvalidoDaCorridaException {
        if (this.status != StatusCorrida.EM_ANDAMENTO) {
            throw new EstadoInvalidoDaCorridaException("Não é possível finalizar uma corrida que está " + this.status);
        }

        this.status = StatusCorrida.FINALIZADA;
        System.out.println("Viagem finalizada com sucesso (Status atualizado).");
    }


}