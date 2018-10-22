package companhia.dao;

import companhia.model.Departamento;

public class DepartamentoJPADAO extends GenericJPADAO<Departamento> implements DepartamentoDAO{
	
	public DepartamentoJPADAO() {
		this.persistentClass = Departamento.class;
	}
}
