package exceptions;
//Se o passageiro ainda não pagou uma corrida anterior
public class SaldoPendenteException extends Exception{
    public SaldoPendenteException(String mensagem) {
        super(mensagem);
    }

}