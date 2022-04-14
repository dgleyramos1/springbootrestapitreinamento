package br.com.springboot.dev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.dev_treinamento.model.Usuario;
import br.com.springboot.dev_treinamento.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 * @author Dgley Ramos
 */
@RestController
public class GreetingsController {
	
	@Autowired /*IC - ICD - Injeção de dependencia*/
	private UsuarioRepository usuarioRepository;
	
	
	
	
	/*Método GET, para listar todos os usúarios*/
	@GetMapping(value = "usuarios")
	@ResponseBody /* Retorna os dados para o corpo da resposta*/
    public ResponseEntity<List<Usuario>> listUsuarios(){
		
		List<Usuario> usuarios = usuarioRepository.findAll();
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
}



















