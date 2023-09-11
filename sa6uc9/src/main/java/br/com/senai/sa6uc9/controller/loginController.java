package br.com.senai.sa6uc9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sa6uc9.orm.Cadastro;
import br.com.senai.sa6uc9.servico.CadastroServico;

@Controller
public class loginController {

    @Autowired
    private CadastroServico servicoCadastro;
 
    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        Cadastro cadastro = new Cadastro(); 
        model.addAttribute("cadastro", cadastro);
        return "login"; 
    }

    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("cadastro") Cadastro cadastro, Model model) {
        Cadastro usuarioExistente = servicoCadastro.consultarPorEmail(cadastro.getEmail());

        if (usuarioExistente != null && usuarioExistente.getSenha().equals(cadastro.getSenha())) {
            return "agendamento.htm";
        } else {
            model.addAttribute("erro", "E-mail ou senha incorretos. Tente novamente.");
            return "login";
        }
    }
}