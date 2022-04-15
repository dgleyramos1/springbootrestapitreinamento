package br.com.springboot.dev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired /*IC/CD ou CDI - Injeção de dependencia*/
	public GreetingsController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}


	/*Método GET, para listar todos os usuários*/
	@GetMapping(value = "/usuarios")
	@ResponseBody /* Retorna os dados para o corpo da resposta*/
    public ResponseEntity<List<Usuario>> listarUsuarios(){
		
		List<Usuario> usuarios = usuarioRepository.findAll();
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
	
	
	/*Método POST, salvar usuário no banco de dados*/
	@PostMapping(value = "/cadastrar")
	@ResponseBody
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	
	
	/*Método PUT, atualizar usuário no banco de dados*/
	@PutMapping(value = "/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){
		
		if (usuario.getId() == null) {
			return new ResponseEntity<String>("Id nao informado!", HttpStatus.NOT_FOUND);
		}
		Usuario user = usuarioRepository.saveAndFlush(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	
	/*Método DELETE, deletar usuário do banco de dados*/
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam(name = "idUSer") Long idUser){
		usuarioRepository.deleteById(idUser);
		return new ResponseEntity<String>("Usuário deletato com sucesso!", HttpStatus.OK);
	}
	
	
	/*Método GET BY ID, buscar usuário pelo id no banco de dados*/
	@GetMapping(value = "/buscarPorId")
	@ResponseBody
	public ResponseEntity<Usuario> buscarPorId(@RequestParam(name = "idUSer") Long idUser){
		Usuario user =  usuarioRepository.findById(idUser).get();
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	/*Método GET BY NOME, buscar usuário pelo nome no banco de dados*/
	/**
	@GetMapping(value = "/buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(name = "name") String name){
		List<Usuario> user =  usuarioRepository.buscarPorNome(name.trim().toUpperCase());
		return new ResponseEntity<List<Usuario>>(user, HttpStatus.OK);
	}
	*/
	
}
















