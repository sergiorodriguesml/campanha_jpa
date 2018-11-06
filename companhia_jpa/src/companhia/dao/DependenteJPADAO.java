package companhia.dao;

import java.util.List;

import companhia.model.Dependente;
import companhia.util.JPAUtil;

public class DependenteJPADAO extends GenericJPADAO<Dependente> implements DependenteDAO{
	public DependenteJPADAO() {
		this.persistentClass = Dependente.class;
	}

	@Override
	public List<Dependente> findByFun(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Dependente.findByFun", Dependente.class)
				.setParameter("id",id)
				.getResultList();
	}
}
