package br.com.senai.sa6uc9.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sa6uc9.orm.Cadastro;
import br.com.senai.sa6uc9.servico.CadastroServico;

public class cadastroController {
	
	@Autowired
	private CadastroServico servicoCadastro;
	
	
	@GetMapping("/cadastro/adicionar")
	public String adicionarCadastros(Model modelo) {
		Cadastro cadastro = new Cadastro();
		modelo.addAttribute("cadastros", cadastro);
		return "formCadastro";
	}
	
	@PostMapping("/cadastro")
	public String salvarCadastros(@ModelAttribute("cadastros") Cadastro cadastro) {
		servicoCadastro.salvarCadastros(cadastro);
		return "/login";
	}
	
	@GetMapping({"/cadastro/editar/{id}"})
	public String editarCadastros(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("cadastro", servicoCadastro.consultarCadastrosId(id));
		return "editarCadastro";
	}
	@PostMapping("/cadastro/{id}")
	public String atualizarCadastros(@PathVariable Integer id, @ModelAttribute("cadastro") Cadastro cadastro, Model modelo) {
		Cadastro cad = servicoCadastro.consultarCadastrosId(id);
		cad.setId(id);
		cad.setNome(cadastro.getNome());
		cad.setEmail(cadastro.getEmail());
		cad.setApartamento(cadastro.getApartamento());
		cad.setBloco(cadastro.getBloco());
		servicoCadastro.atualizarCadastros(cad);
		return "redirect:/cadastro";
	}
	@GetMapping("/cadastro/{nome}")
	public String listarMeuCadastro(Model model, Principal principal) {
	    model.addAttribute("cadastro", servicoCadastro.listarMeuCadastro());
	    return "redirect:/agendamento";
	}
}

