package companhia.dao;

import java.util.List;

import companhia.model.Funcionario;
import companhia.model.Projeto;
import companhia.util.JPAUtil;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> implements ProjetoDAO{
	
	public ProjetoJPADAO() {
		this.persistentClass = Projeto.class;
	}

	@Override
	public List<Projeto> findByDpt(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Projeto.findByDpt", Projeto.class)
				.setParameter("id",id)
				.getResultList();
	}
}
