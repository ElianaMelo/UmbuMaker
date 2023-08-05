package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.presentation.dto.GestorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gestor extends ContaAcesso implements IModel<GestorDto> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	public Gestor(String nome, String email, String senha,
			String telefone,
			String linkWhatsapp,
			boolean ativo,
			String qrcode) {
		
		this.nome = nome; 
		this.email = email; 
		this.senha = senha;
		this.telefone = telefone;
		this.linkWhatsapp = linkWhatsapp;
		this.ativo = ativo;
		this.qrcode = qrcode;
		
	}
	
	public Gestor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public GestorDto toDto() {
		// TODO Auto-generated method stub
		return new GestorDto(this.nome, this.email, this.senha,this.telefone,
				this.linkWhatsapp,this.ativo,this.qrcode);
	}

}