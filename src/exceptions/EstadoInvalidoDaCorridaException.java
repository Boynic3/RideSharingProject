package exceptions;
//Se a corrida estiver em um estado invalido para a operação solicitada
public class EstadoInvalidoDaCorridaException extends Exception{
	public EstadoInvalidoDaCorridaException(String mensagem) {
		super(mensagem);
	}

}
