package br.com.agenda.projetoagenda.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cod_agenda;
	@NotNull
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy H:mm")
	private Date data_agenda;
	@NotNull
	@Column(length=10000)
	private String status_agenda;
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy H:mm")
	private Date hora_inicial;
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy H:mm")
	private Date hora_final;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Cliente cliente;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Usuario usuario;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Sala sala;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Servico servico;
	
	public long getCodAgenda() {
		return cod_agenda;
	}
	public void setCodAgenda(long cod_agenda) {
		this.cod_agenda = cod_agenda;
	}
	//
	public Date getDataAgenda() {
		return data_agenda;
	}
	public void setDataAgenda(Date data_agenda) {
		this.data_agenda = data_agenda;
	}
	//
	public String getStatusAgenda() {
		return status_agenda;
	}
	public void setStatusAgenda(String status_agenda) {
		this.status_agenda = status_agenda;
	}
	//
	public Date getHoraInicial() {
		return hora_inicial;
	}
	public void setHoraInicial(Date hora_inicial) {
		this.hora_inicial = hora_inicial;
	}
	//
	public Date getHoraFinal() {
		return hora_final;
	}
	public void setHoraFinal(Date hora_final) {
		this.hora_final = hora_final;
	}
	//
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	//
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
