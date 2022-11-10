package com.nttdata.hibernatet2.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - T2
 * 
 * DAO genérico
 * 
 * @author NTT Data Sevilla
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public T searchById(final Long id) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		return session.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchByName(final String name) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza escritores en función del nombre
		return session.createQuery("FROM " + this.entityClass.getName() + " WHERE name LIKE '%" + name + "%'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass 
	 * entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}