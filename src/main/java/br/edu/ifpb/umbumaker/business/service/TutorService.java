package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.umbumaker.model.Tutor;
import br.edu.ifpb.umbumaker.model.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;

public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;

	public Tutor criarTutor(Tutor tutor) {
		return tutorRepository.save(tutor);
	}

	public Tutor atualizarTutor(Long id, Tutor tutor) {
		Tutor tutorExitente = tutorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Tutor não encontrado."));

//		tutorExitente.nome = tutor.nome;
//		tutorExitente.email = tutor.email;
//		tutorExitente.senha = tutor.senha;
//		tutorExitente.telefone = tutor.telefone;
//		tutorExitente.linkWhatsapp = tutor.linkWhatsapp;
//		tutorExitente.ativo = tutor.ativo;
//		tutorExitente.tipo = tutor.tipo;
//		tutorExitente.qrcode = tutor.qrcode;

		return tutorRepository.save(tutorExitente);
	}

	public void deletarTutor(Long id) {
		if (!tutorRepository.existsById(id)) {
			throw new EntityNotFoundException("Tutor não encontrado.");
		}

		tutorRepository.deleteById(id);
	}

	public List<Tutor> listarTutor() {
		return tutorRepository.findAll();
	}

//    public List<Tutor> listarTutorPorNome(String nome) {
//        return tutorRepository.findByNome(nome);
//    }

}
