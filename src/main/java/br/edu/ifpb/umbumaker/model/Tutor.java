package br.edu.ifpb.umbumaker.model;

import br.edu.ifpb.umbumaker.presentation.dto.TutorContaAcessoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Tutor implements IModel<TutorContaAcessoDto> {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idContaAcesso")
	private ContaAcesso contaAcesso;
	
	public Tutor(ContaAcesso contaAcesso) {
		super();
		this.contaAcesso = contaAcesso;
	}

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdTutor() {
		return id;
	}

	public void setIdTutor(Long id) {
		this.id = id;
	}

	public ContaAcesso getContaAcesso() {
		return contaAcesso;
	}

	public void setContaAcesso(ContaAcesso contaAcesso) {
		this.contaAcesso = contaAcesso;
	}

	@Override
	public TutorContaAcessoDto toDto() {
		// TODO Auto-generated method stub
		return new TutorContaAcessoDto(this);
	}
}