package com.nttdata.hibernatet2.persistence;

import java.util.List;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_STORE
 * 
 * @author NTT Data Sevilla
 *
 */
public interface StoreDaoI extends CommonDaoI<Store> {

	/**
	 * Obtiene las tiendas con un descuento concreto
	 * 
	 * @param discount
	 * @return List<Store>
	 */
	public List<Store> searchByDiscount(final int discount);
	
	/**
	 * Ordena las tiendas por su descuento
	 * 
	 * @return List<Store>
	 */
	public List<Store> searchAndSortByDiscount();
}
