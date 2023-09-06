package br.com.senai.sa6uc9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sa6uc9.orm.Agendamento;
import br.com.senai.sa6uc9.orm.Cadastro;
import br.com.senai.sa6uc9.servico.AgendamentoServico;
import br.com.senai.sa6uc9.servico.CadastroServico;

@Controller
public class sa6uc9Controller {
	
	@Autowired
	private AgendamentoServico servico;

	private CadastroServico servicoCadastro;
	
	@GetMapping({"/agendamento", "/"})
	public String listarAgendamento(Model modelo) {
		modelo.addAttribute("agendamento", servico.listarAgendamentos());
		return "agendamento";
	}
	
	@GetMapping({"/agendamento/{id}"})
	public String apagarAgendamento(@PathVariable Integer id) {
		servico.apagarAgendamentos(id);
		return "redirect:/agendamento";
	}
	
	@GetMapping("/agendamento/adicionar")
	public String adicionarAgendamento(Model modelo) {
		Agendamento agendamento = new Agendamento();
		modelo.addAttribute("agendamento", agendamento);
		return "formAgendamento";
	}
	
	@PostMapping("/agendamento")
	public String salvarAgendamento(@ModelAttribute("agendamento") Agendamento agendamento) {
		servico.salvarAgendamentos(agendamento);
		return "redirect:/agendamento";
	}
	
	@GetMapping({"/agendamento/editar/{id}"})
	public String editarAgendamento(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("agendamento", servico.consultarAgendamentosId(id));
		return "editarAgendamento";
	}
	
	@PostMapping("/agendamento/{id}")
	public String atualizarAgendamento(@PathVariable Integer id, @ModelAttribute("agendamento") Agendamento agendamento, Model modelo) {
		Agendamento age = servico.consultarAgendamentosId(id);
		age.setId(id);
		age.setNome_usuario(agendamento.getNome_usuario());
		age.setHorario_agendamento(agendamento.getHorario_agendamento());
		age.setHorario_agendamento_final(agendamento.getHorario_agendamento_final());
		age.setData_agendamento(agendamento.getData_agendamento());
		servico.atualizarAgendamentos(age);
		return "redirect:/agendamento";
	}
	
	@GetMapping("/cadastro/adicionar")
	public String adicionarCadastros(Model modelo) {
		Cadastro cadastro = new Cadastro();
		modelo.addAttribute("cadastros", cadastro);
		return "formCadastro";
	}
	
	@PostMapping("/cadastro")
	public String salvarCadastros(@ModelAttribute("cadastros") Cadastro cadastro) {
		servicoCadastro.salvarCadastros(cadastro);
		return "redirect:/cadastro";
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
}