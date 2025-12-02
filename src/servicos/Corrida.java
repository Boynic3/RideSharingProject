package servicos;

import entidades.Motorista;
import entidades.Passageiro;
import enums.StatusCorrida;

public class Corrida {
    private String localPartida, localFinal;
    private double kilometragem;
    private StatusCorrida status;
    private Passageiro p;
    private Motorista motorista;
    private double valorCalculado;
    private CategoriaCorrida categoria;

    public Corrida(String localPartida, String localFinal, double kilometragem) {
        this.localPartida = localPartida;
        this.localFinal = localFinal;
        this.kilometragem = kilometragem;
        this.status = StatusCorrida.SOLICITADA;
    }

    public void setCategoria(CategoriaCorrida categoria) {
        this.categoria = categoria;
    }

    public void calcularValorFinal() {
        if (this.categoria != null) {
            this.valorCalculado = this.categoria.calcularPreco(this.kilometragem);
        }
    }

    public void setPassageiro(Passageiro p) { this.p = p; }
    public Passageiro getPassageiro() { return p; }
    public void setMotorista(Motorista m) { this.motorista = m; }
    public Motorista getMotorista() { return motorista; }
    public void setValorCalculado(double v) { this.valorCalculado = v; }
    public double getValorCalculado() { return valorCalculado; }
    public void setStatus(StatusCorrida s) { this.status = s; }
    public StatusCorrida getStatus() { return status; }
    public String getLocalPartida() { return localPartida; }
    public String getLocalFinal() { return localFinal; }
    public double getKilometragem() { return kilometragem; }

    public boolean isViagemIniciada() { return this.status == StatusCorrida.EM_ANDAMENTO; }
    public void finalizarViagem() { this.status = StatusCorrida.FINALIZADA; }

    @Override
    public String toString() {
        String nomeP = (p != null) ? p.getNome() : "N/A";
        return "Corrida de " + nomeP + " (R$ " + String.format("%.2f", valorCalculado) + ")";
    }
}