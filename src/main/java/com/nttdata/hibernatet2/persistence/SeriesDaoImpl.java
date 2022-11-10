package com.nttdata.hibernatet2.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_SERIES
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class SeriesDaoImpl extends CommonDaoImpl<Series> implements SeriesDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public SeriesDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Series> searchByGenre(String name) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza sagas de un genero concreto
		return session.createQuery("FROM Series WHERE genre=" + name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Series> searchByNumberOfBooks(int numberOfBooks) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza sagas con una cantidad concreta de libros
		return session.createQuery("FROM Series WHERE number_of_books=" + numberOfBooks).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Series> searchByMoreBooks(int numberOfBooks) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza sagas con mas de X libros
		return session.createQuery("FROM Series WHERE number_of_books >" + numberOfBooks).list();
	}
}