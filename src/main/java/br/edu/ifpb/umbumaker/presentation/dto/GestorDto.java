package br.edu.ifpb.umbumaker.presentation.dto;

import br.edu.ifpb.umbumaker.model.Gestor;

public class GestorDto implements IDto<Gestor>{
	
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String linkWhatsapp;
	private boolean ativo;
	private String qrcode;
	
	public GestorDto(String nome, String email, String senha, String telefone,
			String linkWhatsapp, boolean ativo, String qrcode) {
		
		this.nome = nome; 
		this.email = email; 
		this.senha = senha;
		this.telefone = telefone;
		this.linkWhatsapp = linkWhatsapp;
		this.ativo = ativo;
		this.qrcode = qrcode;
		
	}
	
	public GestorDto() {
		
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLinkWhatsapp() {
		return linkWhatsapp;
	}

	public void setLinkWhatsapp(String linkWhatsapp) {
		this.linkWhatsapp = linkWhatsapp;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	@Override
	public Gestor toModel() {
		// TODO Auto-generated method stub
		return new Gestor(this.nome,this.email,this.senha,this.telefone,
				this.linkWhatsapp,this.ativo,this.qrcode);
	}
	
	

}
