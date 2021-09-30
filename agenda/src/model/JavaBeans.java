package model;

public class JavaBeans {
	private String nome;
	private String email;
	private String id;
	private String telefone;
	
	
	
	
	public JavaBeans() {
		super();
		
	}
	
	
	
	
	public JavaBeans(String nome, String email, String id, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.id = id;
		this.telefone = telefone;
	}




	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
