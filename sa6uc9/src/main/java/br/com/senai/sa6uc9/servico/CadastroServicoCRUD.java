package br.com.senai.sa6uc9.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sa6uc9.orm.Cadastro;
import br.com.senai.sa6uc9.repository.CadastroRepository;

@Service
public class CadastroServicoCRUD {

	@Autowired
	private CadastroRepository repositorio;

	public List<Cadastro> listarCadastros() {
		return (List<Cadastro>) repositorio.findAll();
	}


	public Cadastro consultarCadastrosId(Integer id) {
		return repositorio.findById(id).get();
	}

	public Cadastro atualizarCadastros(Cadastro cadastro) {
		return repositorio.save(cadastro);
	}

	public Cadastro salvarCadastros(Cadastro cadastro) {
		return repositorio.save(cadastro);
	}
	
	public Cadastro consultarPorEmail(String email) {
		return repositorio.findByEmail(email).get();
	}
	public List<Cadastro> listarCadastro() {
		return (List<Cadastro>) repositorio.findAll();	
		}
}

