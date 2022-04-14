package br.com.springboot.dev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	
	
	/*Método GET, para listar todos os usuários*/
	@GetMapping(value = "usuarios")
	@ResponseBody /* Retorna os dados para o corpo da resposta*/
    public ResponseEntity<List<Usuario>> listarUsuarios(){
		
		List<Usuario> usuarios = usuarioRepository.findAll();
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
	
	
	/*Método POSt, salvar usuáiro no banco de dados*/
	@PostMapping(value = "cadastrar")
	@ResponseBody
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
}



















