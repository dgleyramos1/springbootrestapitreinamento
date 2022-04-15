package br.com.springboot.dev_treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.dev_treinamento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**@Query(value = "select u from Usuario u where upper(trim(u.name)) like %?1%")
	List<Usuario> buscarPorNome(String name);
	*/
}
