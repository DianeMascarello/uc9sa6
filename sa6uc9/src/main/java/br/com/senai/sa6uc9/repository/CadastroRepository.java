package br.com.senai.sa6uc9.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.sa6uc9.orm.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

	Optional<Cadastro> findByEmail(String email);
	List<Cadastro> listarMeuCadastro(String nome);

}
