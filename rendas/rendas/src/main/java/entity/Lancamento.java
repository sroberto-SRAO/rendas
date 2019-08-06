package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="lancamento_seq", sequenceName="lancamento_seq", initialValue=1, allocationSize=10)
public class Lancamento {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lancamento_seq")
	private Integer 	id;
	
	@Column(length=45)
	private String 		descricao_lanc;
	@Column
	private Date   		da_lanc;
	@Column
	private BigDecimal 	va_lanc;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="lancamento")
	@JoinColumn(name="lancamento_id")
	private List<Receb_Lanc> receb_lanctos;
	
	@ManyToOne
	@JoinColumn(name="id_cc")
	private Conta_Corrente conta_corrente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao_lanc() {
		return descricao_lanc;
	}

	public void setDescricao_lanc(String descricao_lanc) {
		this.descricao_lanc = descricao_lanc;
	}

	public Date getDa_lanc() {
		return da_lanc;
	}

	public void setDa_lanc(Date da_lanc) {
		this.da_lanc = da_lanc;
	}

	public BigDecimal getVa_lanc() {
		return va_lanc;
	}

	public void setVa_lanc(BigDecimal va_lanc) {
		this.va_lanc = va_lanc;
	}

	public List<Receb_Lanc> getReceb_lanctos() {
		return receb_lanctos;
	}

	public void setReceb_lanctos(List<Receb_Lanc> receb_lanctos) {
		this.receb_lanctos = receb_lanctos;
	}

	public Conta_Corrente getConta_corrente() {
		return conta_corrente;
	}

	public void setConta_corrente(Conta_Corrente conta_corrente) {
		this.conta_corrente = conta_corrente;
	}
	
	
}