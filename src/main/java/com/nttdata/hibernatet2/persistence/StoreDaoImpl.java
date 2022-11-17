package com.nttdata.hibernatet2.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_STORE
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class StoreDaoImpl extends CommonDaoImpl<Store> implements StoreDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public StoreDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> searchByDiscount(int discount) {
		return session.createQuery("FROM Store WHERE discount=" + discount).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> searchAndSortByDiscount() {
		return session.createQuery("FROM Store ORDER BY discount DESC").list();
	}
}
