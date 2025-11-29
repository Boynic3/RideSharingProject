package exceptions;
//Se o passageio no momento não possui saldo para pagar
public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}

}
