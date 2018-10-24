package companhia.dao;

import java.util.List;

import companhia.model.PesProj;

public interface PesProjDAO extends GenericDAO<PesProj> {
	public List<PesProj> findByProj(int id);
	public List<PesProj> findByFun(int id);
}
