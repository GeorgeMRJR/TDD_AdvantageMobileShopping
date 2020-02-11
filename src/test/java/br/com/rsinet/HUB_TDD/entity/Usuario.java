package br.com.rsinet.HUB_TDD.entity;

public class Usuario {
	private String nomeDeUsuario;
	private String email;
	private String senha;
	private String reSenha;
	private String nome;
	private String sobreNome;
	private String telefone;
	private String pais;
	private String estado;
	private String endereco;
	private String cidade;
	private String cep;

	public Usuario(String nomeDeUsuario, String email, String senha, String reSenha, String nome, String sobreNome,
			String telefone, String pais, String estado, String endereco, String cidade, String cep) {
		this.nomeDeUsuario = nomeDeUsuario;
		this.email = email;
		this.senha = senha;
		this.reSenha = reSenha;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
		this.pais = pais;
		this.estado = estado;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
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

	public String getReSenha() {
		return reSenha;
	}

	public void setReSenha(String reSenha) {
		this.reSenha = reSenha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
