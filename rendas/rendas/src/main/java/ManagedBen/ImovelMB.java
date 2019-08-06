package ManagedBen;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.ImovelDAO;
import entity.Imovel;

@ApplicationScoped
@ManagedBean
public class ImovelMB extends CrudMB<Imovel, ImovelDAO> implements Serializable {

	private ImovelDAO imovelDAO;
	private Imovel imv = new Imovel();
	
	@Override
	public ImovelDAO getDAO() {
		System.out.println("Atenção...estou executando o getDAO.....");
		if (imovelDAO == null) {
			System.out.println("estou retornando null no DAO......");
			imovelDAO = new ImovelDAO();
		}
		return imovelDAO;
	}
	@Override
	public Imovel criarNovaEntidade() {
		return new Imovel();
	}

	public Imovel getIm() {
		return imv;
	}

	public void setIm(Imovel imv) {
		this.imv = imv;
	}

	
}
