package br.edu.ifpb.umbumaker.model;

import java.io.Serializable;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ContaAcesso implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nome;
    public String email;
    public String senha;
    public String telefone;
    public String linkWhatsapp;
    public boolean ativo;
    public String qrcode;
	
    
}