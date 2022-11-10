package com.nttdata.hibernatet2.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - T2
 * 	
 * DAO de tabla NTTDATA_HEX_WRITER
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class WriterDaoImpl extends CommonDaoImpl<Writer> implements WriterDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public WriterDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Writer> searchByFullName(String name, String lastName) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza escritores en función del nombre completo.
		return session.createQuery("FROM Writer WHERE name=" + name + " AND last_Name=" + lastName).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Writer> searchBySeries(String series) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza escritores en función del nombre de la saga
		return session.createQuery("FROM Writer WHERE series=" + series).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Writer> searchByPublisher(String publisher) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza escritores en función de la editorial
		return session.createQuery("FROM Writer WHERE publisher=" + publisher).list();
	}
}