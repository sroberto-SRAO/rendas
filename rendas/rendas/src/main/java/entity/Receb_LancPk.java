package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Receb_LancPk implements Serializable{
	private Integer Recebedor_id;
	private Integer lancamentos_id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Recebedor_id == null) ? 0 : Recebedor_id.hashCode());
		result = prime * result + ((lancamentos_id == null) ? 0 : lancamentos_id.hashCode());
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
		Receb_LancPk other = (Receb_LancPk) obj;
		if (Recebedor_id == null) {
			if (other.Recebedor_id != null)
				return false;
		} else if (!Recebedor_id.equals(other.Recebedor_id))
			return false;
		if (lancamentos_id == null) {
			if (other.lancamentos_id != null)
				return false;
		} else if (!lancamentos_id.equals(other.lancamentos_id))
			return false;
		return true;
	}
	
	
}
