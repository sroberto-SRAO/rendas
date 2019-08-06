package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="imovel_seq", sequenceName="imovel_seq", initialValue=1, allocationSize=10)
public class Imovel {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imovel_seq")
	private Integer id;
	
	@Column
	private String  nome;
	@Column
	private String  endereco;
	@Column
	private String  bairro;
	@Column
	private Integer cep;
	@Column
	private String  cidade;
	@Column
	private Integer	area;
	@Column
	private Integer anoconstrucao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="imovel")
	@JoinColumn(name="id_imov")
	private List<Taxa_Imovel> taxas_imovel;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="imovel")
	@JoinColumn(name="Imovel_id")
	private List<Imovel_Contrato> imoveis_contratos;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getAnoconstrucao() {
		return anoconstrucao;
	}
	public void setAnoconstrucao(Integer anoconstrucao) {
		this.anoconstrucao = anoconstrucao;
	}
	
	public List<Taxa_Imovel> getTaxas_imovel() {
		return taxas_imovel;
	}

	public void setTaxas_imovel(List<Taxa_Imovel> taxas_imovel) {
		this.taxas_imovel = taxas_imovel;
	}
	
	public List<Imovel_Contrato> getImoveis_contratos() {
		return imoveis_contratos;
	}

	public void setImoveis_contratos(List<Imovel_Contrato> imoveis_contratos) {
		this.imoveis_contratos = imoveis_contratos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
