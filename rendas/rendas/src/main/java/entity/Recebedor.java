package entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="recebedor_seq", sequenceName="recebedor_seq", initialValue=1, allocationSize=10)
public class Recebedor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recebedor_seq")
	private Integer id;
	
	@Column(length=45)
	private String nome;
	@Column(length=1)
	private String tp_pessoa;
	@Column(length=11)
	private String nu_cpf;
	@Column(length=14)
	private String nu_cnpj;
	@Column(length=9)
	private String nu_tel;
	@Column(length=45)
	private String no_contato;
	@Column
	private BigDecimal va_tx_adm;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="recebedor")
	@JoinColumn(name="Recebedor_id")
	private Contrato contrato;

	//getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTp_pessoa() {
		return tp_pessoa;
	}

	public void setTp_pessoa(String tp_pessoa) {
		this.tp_pessoa = tp_pessoa;
	}

	public String getNu_cpf() {
		return nu_cpf;
	}

	public void setNu_cpf(String nu_cpf) {
		this.nu_cpf = nu_cpf;
	}

	public String getNu_cnpj() {
		return nu_cnpj;
	}

	public void setNu_cnpj(String nu_cnpj) {
		this.nu_cnpj = nu_cnpj;
	}

	public String getNu_tel() {
		return nu_tel;
	}

	public void setNu_tel(String nu_tel) {
		this.nu_tel = nu_tel;
	}

	public String getNo_contato() {
		return no_contato;
	}

	public void setNo_contato(String no_contato) {
		this.no_contato = no_contato;
	}

	public BigDecimal getVa_tx_adm() {
		return va_tx_adm;
	}

	public void setVa_tx_adm(BigDecimal va_tx_adm) {
		this.va_tx_adm = va_tx_adm;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
}
