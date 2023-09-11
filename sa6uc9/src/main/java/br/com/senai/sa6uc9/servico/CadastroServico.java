package br.com.senai.sa6uc9.servico;

import java.util.List;

import br.com.senai.sa6uc9.orm.Cadastro;

public interface CadastroServico {
public List<Cadastro> listarCadastros();
		
	public Cadastro consultarCadastrosId(Integer id);
	
	public Cadastro atualizarCadastros(Cadastro cadastro);
	
	public Cadastro salvarCadastros(Cadastro cadastro);

	public Cadastro consultarPorEmail(String email);
	
	List<Cadastro> listarMeuCadastro();

}
