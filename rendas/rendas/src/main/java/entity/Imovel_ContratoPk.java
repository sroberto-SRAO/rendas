package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Imovel_ContratoPk implements Serializable{
	private Integer Imovel_id;
	private Integer Contrato_id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Contrato_id == null) ? 0 : Contrato_id.hashCode());
		result = prime * result + ((Imovel_id == null) ? 0 : Imovel_id.hashCode());
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
		Imovel_ContratoPk other = (Imovel_ContratoPk) obj;
		if (Contrato_id == null) {
			if (other.Contrato_id != null)
				return false;
		} else if (!Contrato_id.equals(other.Contrato_id))
			return false;
		if (Imovel_id == null) {
			if (other.Imovel_id != null)
				return false;
		} else if (!Imovel_id.equals(other.Imovel_id))
			return false;
		return true;
	}
	
	
}
