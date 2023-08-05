package br.edu.ifpb.umbumaker.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.umbumaker.model.Gestor;
import br.edu.ifpb.umbumaker.model.repository.GestorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GestorService {
	
	@Autowired
	private GestorRepository gestorRepository;
	
	public Gestor criarGestor(Gestor gestor) {
		return gestorRepository.save(gestor);
	}
	
	public Gestor atualizarGestor(Long id, Gestor gestor) {
		Gestor gestorExitente = gestorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Gestor não encontrado."));
		
		gestorExitente.nome = gestor.nome;
		gestorExitente.email = gestor.email;
		gestorExitente.senha = gestor.senha;
		gestorExitente.telefone = gestor.telefone;
		gestorExitente.linkWhatsapp = gestor.linkWhatsapp;
		gestorExitente.ativo = gestor.ativo;
		gestorExitente.qrcode = gestor.qrcode;
		
		return gestorRepository.save(gestorExitente);
	}
	
	public void deletarGestor(Long id) {
        if (!gestorRepository.existsById(id)) {
            throw new EntityNotFoundException("Gestor não encontrado.");
        }

        gestorRepository.deleteById(id);
    }

    public List<Gestor> listarGestor() {
        return gestorRepository.findAll();
    }
    
    public List<Gestor> listarGestorPorNome(String nome) {
        return gestorRepository.findByNome(nome);
    }

}
