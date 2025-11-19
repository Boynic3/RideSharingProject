package entidades;


public class UsuarioComum {
    private String nome,
    cpf,
    email,
    senha,
    telefone;
    
    public UsuarioComum(String nome) {
    	this.nome = nome;
    }
    public UsuarioComum(String cpf) {
    	this.cpf = cpf;
    }

}
