package br.com.senai.sa6uc9.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sa6uc9.orm.Agendamento;
import br.com.senai.sa6uc9.repository.AgendamentoRepository;

@Service
public class AgendamentoServicoCRUD implements AgendamentoServico {
	
	@Autowired
	private AgendamentoRepository repositorio;

	@Override
	public List<Agendamento> listarAgendamentos() {
		return (List<Agendamento>) repositorio.findAll();
	}

	@Override
	public void apagarAgendamentos(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public Agendamento consultarAgendamentosId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Agendamento atualizarAgendamentos(Agendamento agendamento) {
		return repositorio.save(agendamento);
	}

	public Agendamento salvarAgendamentos(Agendamento agendamento) {
		return repositorio.save(agendamento);
	}

	@Override
	public List<Agendamento> listarMeusAgendamentos() {
		return (List<Agendamento>) repositorio.findAll();	}
}
