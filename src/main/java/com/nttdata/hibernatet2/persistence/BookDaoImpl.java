package com.nttdata.hibernatet2.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_BOOK
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class BookDaoImpl extends CommonDaoImpl<Book> implements BookDaoI {

	/** Sesión de conexión a BD */
	private Session session;
	
	/** Constante String repetido para query de fecha*/
	private static final String DATEFORMAT = ",'dd-MON-yy'";

	/**
	 * Método constructor
	 */
	public BookDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchByDate(Date releaseDate) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza libros de una fecha concreta
		return session.createQuery("FROM Book WHERE trunc(release_date)=(TO_DATE" + releaseDate + DATEFORMAT)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchByDatePreviousTo(Date releaseDate) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza libros de una fecha anterior a la introducida
		return session.createQuery("FROM Book WHERE trunc(release_date)<(TO_DATE" + releaseDate + DATEFORMAT)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchByDatePosteriorTo(Date releaseDate) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza libros de una fecha posterior a la introducida
		return session.createQuery("FROM Book WHERE trunc(release_date)>(TO_DATE" + releaseDate + DATEFORMAT)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchByPriceLowerThan(float price) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza libros mas baratos que la cantidad introducida
		return session.createQuery("FROM Book WHERE price <" + price).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchByPriceHigherThan(float price) {

		// Verificacion: sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza libros mas caros que la cantidad introducida
		return session.createQuery("FROM Book WHERE price >" + price).list();
	}
}