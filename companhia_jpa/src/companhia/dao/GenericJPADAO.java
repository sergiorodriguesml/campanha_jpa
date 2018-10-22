package companhia.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

import companhia.util.JPAUtil;

public abstract class GenericJPADAO<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;

	public EntityManager getEm() {
		return JPAUtil.getEntityManager();
	}

	public void save(T entity) {
		getEm().merge(entity);
	}
	public void delete(T entity) {
		getEm().remove(getEm().merge(entity));
	}
	public T find(Object id) {
		return getEm().find(persistentClass, id);
	}
	public List<T> find() {
		CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(persistentClass);
		cq.from(persistentClass);
		return getEm().createQuery(cq).getResultList();
	}

	public void beginTransaction() {
		getEm().getTransaction().begin();
	}

	public void commit() {
		getEm().getTransaction().commit();
	}

	public void rollback() {
		getEm().getTransaction().rollback();
	}

	public void close() {
		JPAUtil.closeEntityManager();
	}
}
