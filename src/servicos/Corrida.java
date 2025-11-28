package servicos;

import entidades.MetodoPagamento;
import entidades.Passageiro;
import exceptions.EstadoInvalidoDaCorridaException;
import exceptions.PagamentoRecusadoException;
import exceptions.PassageiroPendenteException;

public class Corrida {
    private String localPartida, localFinal;
    private double preco;
    private boolean viagemIniciada;
    Passageiro passageiro;
    boolean b = MetodoPagamento.validaPagamento(passageiro);

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

    public void inicializarViagem() throws PassageiroPendenteException {
        if (this.passageiro == null) {
            throw new PassageiroPendenteException("Erro ao iniciar viagem! Passageiro pendente");
        }
        System.out.println("Viagem iniciada!");
        viagemIniciada = true;
    }

    public void finalizarViagem(boolean b) throws PagamentoRecusadoException {
        if (b == false) {
            throw new PagamentoRecusadoException("Erro ao finalizar viagem! Método de pagamento invalido");
        }
        System.out.println("Viagem finalizada!");
    }

    public void cancelarViagem(boolean viagemIniciada) throws EstadoInvalidoDaCorridaException {
        if (viagemIniciada == false) {
            throw new EstadoInvalidoDaCorridaException("Erro ao cancelar viagem! Estado da viagem invalido");
        }
        System.out.println("Erro ao cancelar viagem!");
    }
}