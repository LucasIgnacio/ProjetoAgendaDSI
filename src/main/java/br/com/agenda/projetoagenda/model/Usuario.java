package br.com.agenda.projetoagenda.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cod_usuario;
	@NotNull
	@Length(min=2, max=1000, message="O tamanho deve ser entre {min} e {max}")
	private String nome_usuario;
	@NotNull
	private String cpf_usuario;
	private Date   aniver_usuario;
	private String sexo_usuario;
	private String end_usuario;
	
	public long getCodUsuario() {
		return cod_usuario;
	}
	public void setCodUsuario(long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	//
	public String getNomeUsuario() {
		return nome_usuario;
	}
	public void setNomeUsuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	//
	public String getCpfUsuario() {
		return cpf_usuario;
	}
	public void setCpfUsuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	//
	}
	public Date getAniverUsuario() {
		return aniver_usuario;
	}
	public void setAniverUsuario(Date aniver_usuario) {
		this.aniver_usuario = aniver_usuario;
	}
	//
	public String getSexoUsuario() {
		return sexo_usuario;
	}
	public void setSexoUsuario(String sexo_usuario) {
		this.sexo_usuario = sexo_usuario;
	}
	//
	public String getEndUsuario() {
		return end_usuario;
	}
	public void setEndUsuario(String end_usuario) {
		this.end_usuario = end_usuario;
	}
	
}

