package br.com.senai.sa6uc9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.sa6uc9.orm.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

	List<Agendamento> listarMeusAgendamentos(String nome_usuario);

}
