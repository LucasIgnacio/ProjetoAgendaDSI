package br.com.agenda.projetoagenda.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long   cod_cliente;
	private Date   aniver_cliente;
	@NotNull
	@Length(min=2, max=1000, message="O tamanho deve ser entre {min} e {max}")
	private String nome_cliente;
	@NotNull
	private String end_cliente;
	private String cell_cliente;
	@NotNull
	private String cidade_cliente;
	@NotNull
	private String bairro_cliente;
	private int    cep_cliente;
	private String sexo_cliente;
	@NotNull
	private String cpf_cliente;
	
	public long getCodCliente() {
		return cod_cliente;
	}
	public void setCodCliente(long cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	//
	public Date getAniverCliente() {
		return aniver_cliente;
	}
	public void setAniverCliente(Date aniver_cliente) {
		this.aniver_cliente = aniver_cliente;
	}
	//
	public String getNomeCliente() {
		return nome_cliente;
	}
	public void setNomeCliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	//
	public String getEndCliente() {
		return end_cliente;
	}
	public void setEndCliente(String end_cliente) {
		this.end_cliente = end_cliente;
	}
	//
	public String getCellCliente() {
		return cell_cliente;
	}
	public void setCellCliente(String cell_cliente) {
		this.cell_cliente = cell_cliente;
	}
	//
	public String getCidadeCliente() {
		return cidade_cliente;
	}
	public void setCidadeCliente(String cidade_cliente) {
		this.cidade_cliente = cidade_cliente;
	}
	//
	public String getBairroCliente() {
		return bairro_cliente;
	}
	public void setBairroCliente(String bairro_cliente) {
		this.bairro_cliente = bairro_cliente;
	}
	//
	public int getCepCliente() {
		return cep_cliente;
	}
	public void setCepCliente(int cep_cliente) {
		this.cep_cliente = cep_cliente;
	}
	//
	public String getSexoCliente() {
		return sexo_cliente;
	}
	public void setSexoCliente(String sexo_cliente) {
		this.sexo_cliente = sexo_cliente;
	}
	//
	public String getCpfCliente() {
		return cpf_cliente;
	}
	public void setCpfCliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
}
