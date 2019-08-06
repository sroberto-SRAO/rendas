package Conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import entity.Imovel;
import util.JPAUtil;

@FacesConverter(forClass=Imovel.class)
public class ImovelConverter implements Converter{

	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Imovel imovel = (Imovel) object;
		if(imovel == null || imovel.getId() == null) {
			return null;
		}
		return String.valueOf(imovel.getId());
	}
	
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if(string == null || string.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(string);
		EntityManager em = JPAUtil.getEntityManager();
		Imovel imovel = em.find(Imovel.class, id);
		return imovel;
		
	}
}
