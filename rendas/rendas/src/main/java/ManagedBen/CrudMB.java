package ManagedBen;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.CrudDAO;
import entity.Imovel;
import exception.ErroSistema;
import util.JPAUtil;

@ViewScoped
@ManagedBean
// public abstract class CrudMB<E, D extends CrudDAO<E>> implements Serializable {
public abstract class CrudMB<E, D extends CrudDAO<E>>{
	
	private String estadoTela;
	
	private E entidade;
	private Imovel im = new Imovel();
	private Imovel imt = new Imovel();
	private List<E> entidades;
	private boolean eParaEditar = false;
	private boolean eParaInserir = false;
	
	public void novo(){
		entidade = criarNovaEntidade();
		mudarParaInsere();
		eParaEditar = true;
		System.out.println("consegui chegar no novo !!!!!!"+estadoTela);
		if (IsInsere()) {
			System.out.println("isInsere está retornando true !!!!");
		}
		
	}
	public void salvar(E entidade) {
		try {
			System.out.println("estou no salvar do crudMB......");
			getDAO().salvar(entidade);
			entidade = criarNovaEntidade();
			mudarParaBusca();
			adicionarMensagem("Registro salvo com sucesso !!!", FacesMessage.SEVERITY_INFO);
		} catch (ErroSistema e) {
			Logger.getLogger(CrudMB.class.getName()).log(Level.SEVERE, null, e);
			adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
		
		
	}
	
	public void editar(E entidade){
		try {
			System.out.println("endereço no inicio de tudo ====>>>>"+im.getEndereco());
			mudarParaEdita();
			eParaEditar = true;
			System.out.println("estou editando MB........"+estadoTela);
			imt = getDAO().editar(entidade);
			entidade.getClass().cast(entidade); //nao sei se é necessário !!!
			System.out.println("endereco ==>> "+im.getEndereco());
			adicionarMensagem("Registro Editado!!!!", FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			Logger.getLogger(CrudMB.class.getName()).log(Level.SEVERE, null, e);
			adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
		
	}
	
	public void deletar(E entidade) {
		try {
			getDAO().deletar(entidade);
			entidades.remove(entidade);
			imt = new Imovel();
			adicionarMensagem("Registro deletado com sucesso!!!", FacesMessage.SEVERITY_INFO);
		} catch (ErroSistema e) {
			Logger.getLogger(CrudMB.class.getName()).log(Level.SEVERE, null, e);
			adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void buscar() {
//		if (IsBusca() == false){
//			mudarParaBusca();
//			return;
//		} 
		try {
			System.out.println("agora sim.....vou chamar o buscar......");
			mudarParaBusca();
			eParaEditar = false;
			entidades = getDAO().buscar();
			if (entidades == null || entidades.size() < 1) {
				adicionarMensagem("Nenhum registro retornado!!!!", FacesMessage.SEVERITY_WARN);
			}
			
		} catch (ErroSistema e) {
			Logger.getLogger(CrudMB.class.getName()).log(Level.SEVERE, null, e);
			adicionarMensagem(e.getMessage(), FacesMessage.SEVERITY_ERROR);
		} 
	}
	
	public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro) {
		FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public void listener(ActionEvent ev) {
		UIComponent source = ev.getComponent();
	}
	// getters e setters
	public E getEntidade() {
		return entidade;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}

	public List<E> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<E> entidades) {
		this.entidades = entidades;
	}
	
	public boolean iseParaEditar() {
		return eParaEditar;
	}
	public void seteParaEditar(boolean eParaEditar) {
		this.eParaEditar = eParaEditar;
	}
	
	// responsável por criar os métodos classe MB
	public abstract D getDAO();
	public abstract E criarNovaEntidade();  // limpa a entidade
	public abstract Imovel getIm();
	
	// controle de estado da tela
	public boolean IsInsere() {
		return "inserir".equals(estadoTela);
	}
	
	public boolean IsBusca() {
		return "buscar".equals(estadoTela);
	}
	
	public boolean IsEdita() {
		return "editar".equals(estadoTela);
	}
	
	public void mudarParaInsere() {
		estadoTela = "inserir";
	}
	
	public void mudarParaBusca() {
		estadoTela = "buscar";
	}
	
	public void mudarParaEdita() {
		estadoTela = "editar";
	}
	
	
}
