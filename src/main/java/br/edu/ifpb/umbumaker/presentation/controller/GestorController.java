package br.edu.ifpb.umbumaker.presentation.controller;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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

import br.edu.ifpb.umbumaker.business.service.GestorService;
import br.edu.ifpb.umbumaker.model.Gestor;
import br.edu.ifpb.umbumaker.presentation.dto.GestorDto;
//import br.edu.ifpb.umbumaker.presentation.dto.GestorResponseDto;

@RestController
@RequestMapping("/api/umbumake")
public class GestorController {
	
	@Autowired
	private GestorService gestorService; 
	
	//converter para lista de dtos?
	@GetMapping("/gestores")
    public ResponseEntity<List<Gestor>> listarGestor(){
        return ResponseEntity.status(HttpStatus.OK).body(gestorService.listarGestor());
    }
	
	
	@PostMapping("/gestores")
	public ResponseEntity<Object> criarGestor(@RequestBody GestorDto gestorDto) {
		try {
			Gestor gestorCriado = gestorService.criarGestor(gestorDto.toModel());
			return new ResponseEntity<Object>(gestorCriado.toDto(), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	// Analizar como vai ser utilizado o DTO, se for para utlizar o "BeanUtils"
	//vamos ter que utilizar dois tipo de DTO, o de entrada e o de saida.
	//No momento esse metodo só esta copiando o objeto gestor, não esta
	// oferencendo nenhuna segurança de dados
	@PutMapping("/gestores/{id}")
	public ResponseEntity<Object> atualizarGestor(@PathVariable(value = "id") Long id,
			@RequestBody GestorDto gestorDto){
		try {			
			Gestor gestoratualizado = gestorService.atualizarGestor(id, gestorDto.toModel());
			return ResponseEntity.status(HttpStatus.OK).body(gestoratualizado.toDto());
		}catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/gestor/{id}")
    public ResponseEntity<Object> deleteGestor(@PathVariable(value = "id") Long id){
        
        gestorService.deletarGestor(id);
        return ResponseEntity.status(HttpStatus.OK).body("Gestor deletado com sulcesso.");
    }
	
	

	
	

}
