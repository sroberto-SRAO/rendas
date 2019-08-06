package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Receb_Lanc {
	@EmbeddedId
	private Receb_LancPk id;
	
	@ManyToOne
	private Lancamento lancamento;
	@ManyToOne
	private Recebedor recebedor;

	// getters e setters
	public Receb_LancPk getId() {
		return id;
	}
	public void setId(Receb_LancPk id) {
		this.id = id;
	}
	public Lancamento getLancamento() {
		return lancamento;
	}
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	public Recebedor getRecebedor() {
		return recebedor;
	}
	public void setRecebedor(Recebedor recebedor) {
		this.recebedor = recebedor;
	}
	
	
}
