package br.com.agenda.projetoagenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@Entity
public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cod_servico;
	@NotNull
	private String tipo_servico;
	@Column(length=10000)
	private String desc_servico;
	
	public long getCodServico() {
		return cod_servico;
	}
	public void setCodServico(long cod_servico) {
		this.cod_servico = cod_servico;
	}
	//
	public String getTipoServico() {
		return tipo_servico;
	}
	public void setTipoServico(String tipo_servico) {
		this.tipo_servico = tipo_servico;
	}
	//
	public String getDescServico() {
		return desc_servico;
	}
	public void setDescServico(String desc_servico) {
		this.desc_servico = desc_servico;
	}
	
}
