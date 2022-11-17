package com.nttdata.hibernatet2.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	@Override
	public List<Writer> searchByNameAndNumberOfBooks(String writerName, Integer numberOfBooks) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Writer> cquery = cb.createQuery(Writer.class);
		final Root<Writer> rootWriter = cquery.from(Writer.class);
		final Join<Writer, Series> writerJoinSeries = rootWriter.join("seriesList");

		// Where.
		final Predicate pr1 = cb.like(rootWriter.<String>get("writerName"), writerName);
		final Predicate pr2 = cb.gt(writerJoinSeries.<Integer>get("numberOfBooks"), numberOfBooks);

		// Consulta.
		cquery.select(rootWriter).where(cb.and(pr1, pr2));

		// Ejecución.
		return session.createQuery(cquery).getResultList();
	}

	@Override
	public List<Writer> searchByBooksOnStore(String storeName) {
		
		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Writer> cquery = cb.createQuery(Writer.class);
		final Root<Writer> rootWriter = cquery.from(Writer.class);
		final Join<Writer, Series> writerJoinSeries = rootWriter.join("seriesList");
		final Join<Series, Book> seriesJoinBook = writerJoinSeries.join("booksList");
		final Join<Book, Store> bookJoinStore = seriesJoinBook.join("storesList");

		// Where.
		final Predicate pr = cb.like(bookJoinStore.<String> get("storeName"), storeName);

		// Consulta.
		cquery.distinct(true).select(rootWriter).where(cb.and(pr));

		// Ejecución.
		return session.createQuery(cquery).getResultList();
	}
}