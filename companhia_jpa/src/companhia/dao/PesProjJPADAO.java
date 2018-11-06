package companhia.dao;

import java.util.List;

import companhia.model.PesProj;
import companhia.util.JPAUtil;

public class PesProjJPADAO extends GenericJPADAO<PesProj> implements PesProjDAO {
	public PesProjJPADAO() {
		this.persistentClass = PesProj.class;
	}

	@Override
	public List<PesProj> findByProj(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("PesProj.findByProj", PesProj.class)
				.setParameter("id",id)
				.getResultList();
	}

	@Override
	public List<PesProj> findByFun(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("PesProj.findByFun", PesProj.class)
				.setParameter("id",id)
				.getResultList();
	}
}
