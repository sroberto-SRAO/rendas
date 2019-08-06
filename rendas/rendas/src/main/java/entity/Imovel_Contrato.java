package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Imovel_Contrato {
	@EmbeddedId
	private Imovel_ContratoPk id;
	
	@ManyToOne
	private Imovel imovel;
	@ManyToOne
	private Contrato contrato;
	
	public Imovel_ContratoPk getId() {
		return id;
	}
	public void setId(Imovel_ContratoPk id) {
		this.id = id;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
}
