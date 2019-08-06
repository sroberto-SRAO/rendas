package entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.crypto.Data;

@Entity
@SequenceGenerator(name="contrato_seq", sequenceName="contrato_seq", initialValue=1, allocationSize=10)
public class Contrato {
	
	@Id @GeneratedValue(generator="contrato_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length=8)
	private Integer 	nu_contrato;
	@Column
	private BigDecimal 	va_contrato;
	@Column
	private Data		data_fim;
	@Column
	private Data		da_inic;
	@Column(length=2)
	private Integer		duracao;
	@Column
	private boolean		ind_ativo;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="contrato")
	@JoinColumn(name="Contrato_id")
	private List<Imovel_Contrato> imoveis_contratos;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="contrato")
	private Inquilino inquilino;

	@OneToOne(cascade=CascadeType.ALL)
	private Recebedor recebedor;
	
	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNu_contrato() {
		return nu_contrato;
	}

	public void setNu_contrato(Integer nu_contrato) {
		this.nu_contrato = nu_contrato;
	}

	public BigDecimal getVa_contrato() {
		return va_contrato;
	}

	public void setVa_contrato(BigDecimal va_contrato) {
		this.va_contrato = va_contrato;
	}

	public Data getData_fim() {
		return data_fim;
	}

	public void setData_fim(Data data_fim) {
		this.data_fim = data_fim;
	}

	public Data getDa_inic() {
		return da_inic;
	}

	public void setDa_inic(Data da_inic) {
		this.da_inic = da_inic;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public boolean isInd_ativo() {
		return ind_ativo;
	}

	public void setInd_ativo(boolean ind_ativo) {
		this.ind_ativo = ind_ativo;
	}

	public List<Imovel_Contrato> getImoveis_contratos() {
		return imoveis_contratos;
	}

	public void setImoveis_contratos(List<Imovel_Contrato> imoveis_contratos) {
		this.imoveis_contratos = imoveis_contratos;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
	
}
