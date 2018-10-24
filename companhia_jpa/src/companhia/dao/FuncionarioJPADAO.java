package companhia.dao;

import java.util.List;

import companhia.model.Funcionario;
import companhia.util.JPAUtil;

public class FuncionarioJPADAO extends GenericJPADAO<Funcionario> implements FuncionarioDAO{
	
	public FuncionarioJPADAO() {
		this.persistentClass = Funcionario.class;
	}

	@Override
	public List<Funcionario> findByDpt(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Funcionario.findByDpt", Funcionario.class)
				.setParameter("id",id)
				.getResultList();
	}

	@Override
	public List<Funcionario> findByProj(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Funcionario.findByProj", Funcionario.class)
				.setParameter("id",id)
				.getResultList();
	}
}

