package br.com.senai.sa6uc9.servico;

import java.util.List;

import br.com.senai.sa6uc9.orm.Agendamento;

public interface AgendamentoServico {
	
	public List<Agendamento> listarAgendamentos();
	
	public void apagarAgendamentos(Integer id);
	
	public Agendamento consultarAgendamentosId(Integer id);
	
	public Agendamento atualizarAgendamentos(Agendamento agendamento);
	
	public Agendamento salvarAgendamentos(Agendamento agendamento);

	List<Agendamento> listarMeusAgendamentos();
}
