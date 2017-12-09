package tcc.usjt.felix113;

import java.util.ArrayList;

public class ClienteCustom extends ArrayList<ClienteCustom> {

	private Long id;

	public ClienteCustom(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;

	}

	private String nome;

	private String sobrenome;
	
	private String telefone;

	private String email;

	private String senha;


    public String getNome() {return nome;}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
