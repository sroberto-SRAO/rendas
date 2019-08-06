package entity;

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
@SequenceGenerator(name="inquilino_seq", sequenceName="inquilino_seq", initialValue=1, allocationSize=10)
public class Inquilino {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="inquilino_seq")
	private Integer id;
	
	@Column(nullable=false,length=45)
	private String  nome;
	@Column(nullable=false, length=11)
	private Integer cpf;
	@Column(updatable=false)
	private Integer id_contr;
	@Column(updatable=false)
	private Integer nu_contr;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Inquilino_id")
	private Contrato contrato;
	
	// getters e setters
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
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getId_contr() {
		return id_contr;
	}
	public void setId_contr(Integer id_contr) {
		this.id_contr = id_contr;
	}
	public Integer getNu_contr() {
		return nu_contr;
	}
	public void setNu_contr(Integer nu_contr) {
		this.nu_contr = nu_contr;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
}
