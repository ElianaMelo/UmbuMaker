package br.edu.ifpb.umbumaker.presentation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.umbumaker.business.service.AssociadoService;
import br.edu.ifpb.umbumaker.model.associados.Associado;
import br.edu.ifpb.umbumaker.presentation.dto.AssociadoContaAcessoDto;


//acho que esta indo bem 

@RestController
@RequestMapping("/api/umbumaker")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService; 
	
	//converter para lista de dtos?
	@GetMapping("/associados")
    public ResponseEntity<Iterable<Associado>> listarAssociados(){
		Iterable<Associado> associados = associadoService.listarAssociados();
		return ResponseEntity.status(HttpStatus.OK).body(associados);
    }
	@GetMapping("/associados/{id}")
    public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Long id){
		try {
			Optional<Associado> associados = associadoService.listarPorId(id);
			Associado associado = associados.get();
			return ResponseEntity.status(HttpStatus.OK).body(associado.toDto());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
    }
	
	@PostMapping("/associados")
	public ResponseEntity<Object> criarAssociado(@RequestBody AssociadoContaAcessoDto associadoDto) {
		try {
			Associado associadoCriado = associadoService.criarAssociado(associadoDto.toModel());
			return new ResponseEntity<Object>(associadoCriado.toDto(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/associados/{id}")
	public ResponseEntity<Object> atualizarAssociado(@PathVariable(value = "id") Long id,
			@RequestBody AssociadoContaAcessoDto associadoDto){
		try {			
			Associado associadoatualizado = associadoService.atualizarAssociado(id, associadoDto.toModel());
			return ResponseEntity.status(HttpStatus.OK).body(associadoatualizado.toDto());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/associados/{id}")
    public ResponseEntity<Object> deleteAssociado(@PathVariable(value = "id") Long id){
        
		associadoService.deletarAssociado(id);
        return ResponseEntity.status(HttpStatus.OK).body("Associado deletado com sulcesso.");
    }
	

}
