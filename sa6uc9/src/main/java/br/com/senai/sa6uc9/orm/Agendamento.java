package br.com.senai.sa6uc9.orm;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="agendamentos")
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome_usuario;
	private Time horario_agendamento;
	private Time horario_agendamento_final;
	private Date data_agendamento;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public Time getHorario_agendamento() {
		return horario_agendamento;
	}
	public void setHorario_agendamento(Time horario_agendamento) {
		this.horario_agendamento = horario_agendamento;
	}
	public Date getData_agendamento() {
		return data_agendamento;
	}
	public void setData_agendamento(Date data_agendamento) {
		this.data_agendamento = data_agendamento;
	}
	public Time getHorario_agendamento_final() {
		return horario_agendamento_final;
	}
	public void setHorario_agendamento_final(Time horario_agendamento_final) {
		this.horario_agendamento_final = horario_agendamento_final;
	}
	
}