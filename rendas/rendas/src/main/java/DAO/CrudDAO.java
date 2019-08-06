package DAO;

import java.util.List;

import entity.Imovel;
import exception.ErroSistema;

public interface CrudDAO<E> {  // E de entidade
	
	public void salvar(E entidade) throws ErroSistema;
	public void deletar(E entidade) throws ErroSistema;
	public List<E> buscar() throws ErroSistema;
	public Imovel editar(E entidade) throws ErroSistema;
}
