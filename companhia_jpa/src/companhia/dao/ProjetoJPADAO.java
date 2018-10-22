package companhia.dao;

import companhia.model.Projeto;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> implements ProjetoDAO{
	
	public ProjetoJPADAO() {
		this.persistentClass = Projeto.class;
	}
}
