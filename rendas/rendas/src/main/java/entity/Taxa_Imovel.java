package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="taxa_imovel_seq", sequenceName="taxa_imovel_seq", initialValue=1, allocationSize=10)
public class Taxa_Imovel {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="taxa_imovel_seq")
	private Integer id;
	
	@Column
	private String  descricao;
	@Column
	private double  va_taxa;
	@Column
	private String  taxas_imovel;
	@Column
	private String	tx_proprietario;
	
	@ManyToOne
	private Imovel imovel;

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getVa_taxa() {
		return va_taxa;
	}

	public void setVa_taxa(double va_taxa) {
		this.va_taxa = va_taxa;
	}

	public String getTaxas_imovel() {
		return taxas_imovel;
	}

	public void setTaxas_imovel(String taxas_imovel) {
		this.taxas_imovel = taxas_imovel;
	}

	public String getTx_proprietario() {
		return tx_proprietario;
	}

	public void setTx_proprietario(String tx_proprietario) {
		this.tx_proprietario = tx_proprietario;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	
}
