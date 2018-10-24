package companhia.dao;

import java.util.List;

import companhia.model.Projeto;

public interface ProjetoDAO extends GenericDAO<Projeto> {
	public List<Projeto> findByDpt(int id);
}
