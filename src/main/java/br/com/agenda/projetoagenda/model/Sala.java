package br.com.agenda.projetoagenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cod_sala;
	@Column(length=10000)
	private String nome_sala;
	
	public long getCodSala() {
		return cod_sala;
	}
	public void setCodSala(long cod_sala) {
		this.cod_sala = cod_sala;
	}
	//
	public String getNomeSala() {
		return nome_sala;
	}
	public void setNomeSala(String nome_sala) {
		this.nome_sala = nome_sala;
	}
}
