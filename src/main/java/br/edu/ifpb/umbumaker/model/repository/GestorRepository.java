package br.edu.ifpb.umbumaker.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.umbumaker.model.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Long> {
	
	//List<Gestor> findByNome(String nome);

}
