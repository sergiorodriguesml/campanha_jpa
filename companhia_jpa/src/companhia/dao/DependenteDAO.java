package companhia.dao;

import java.util.List;

import companhia.model.Dependente;

public interface DependenteDAO extends GenericDAO<Dependente>{
	public List<Dependente> findByFun(int id);
}
