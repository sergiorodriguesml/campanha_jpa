package companhia.dao;

import java.util.List;

import companhia.model.Funcionario;

public interface FuncionarioDAO extends GenericDAO<Funcionario>{
	public List<Funcionario> findByDpt(int id);
}
