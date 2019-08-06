package ManagedBen;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Imovel;
import util.JPAUtil;

@ApplicationScoped
@ManagedBean
public class gravaimovelMB {
	
	public void teste() {
		System.out.println("estou na gravação do teste");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rendas");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Imovel im = new Imovel();
		im.setEndereco("Rua de Teste II, 00/001");
		im.setNome("tst-02");
		im.setCidade("rio de Janeiro");
		im.setCep(20000);
		im.setBairro("ninguem sabe");
		im.setArea(87);
		im.setAnoconstrucao(1960);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(im);
		et.commit();
		
		em.close();
		emf.close();
		System.out.println("....encerrada a gravação!!!!");
	}
}
