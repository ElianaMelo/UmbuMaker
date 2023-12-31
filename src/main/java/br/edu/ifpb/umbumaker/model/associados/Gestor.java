package br.edu.ifpb.umbumaker.model.associados;

import br.edu.ifpb.umbumaker.model.IModel;
import br.edu.ifpb.umbumaker.presentation.dto.GestorContaAcessoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//Gestor estar se convertando para GestorContaAcessoDto e esta passando 
// a senha da conta, o que não deveria acontecer. :-X

@Entity
public class Gestor implements IModel<GestorContaAcessoDto>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idContaAcesso")
	private ContaAcesso contaAcesso;
	
	public Gestor(ContaAcesso contaAcesso) {
		this.contaAcesso = contaAcesso;
	}
	
	public Gestor() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdGestor() {
		return id;
	}

	public void setIdGestor(Long id) {
		this.id = id;
	}

	public ContaAcesso getContaAcesso() {
		return contaAcesso;
	}

	public void setContaAcesso(ContaAcesso contaAcesso) {
		this.contaAcesso = contaAcesso;
	}

	@Override
	public GestorContaAcessoDto toDto() {
		// TODO Auto-generated method stub
		return new GestorContaAcessoDto(this);
	}
	

}