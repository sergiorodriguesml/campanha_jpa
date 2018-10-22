package companhia.dao;

import companhia.model.Dependente;

public class DependenteJPADAO extends GenericJPADAO<Dependente> implements DependenteDAO{
	public DependenteJPADAO() {
		this.persistentClass = Dependente.class;
	}
}
