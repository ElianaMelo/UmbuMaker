package br.edu.ifpb.umbumaker.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.umbumaker.model.associados.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByEmail(String email);
    
}
