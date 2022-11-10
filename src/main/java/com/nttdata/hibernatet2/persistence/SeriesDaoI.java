package com.nttdata.hibernatet2.persistence;

import java.util.List;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_SERIES
 * 
 * @author NTT Data Sevilla
 *
 */
public interface SeriesDaoI extends CommonDaoI<Series> {

	/**
	 * Obtiene las sagas por su genero
	 * 
	 * @param genre
	 * @return List<Series>
	 */
	public List<Series> searchByGenre(final String genre);
	
	/**
	 * Obtiene las sagas por su numero de libros
	 * 
	 * @param numberOfBooks
	 * @return List<Series>
	 */
	public List<Series> searchByNumberOfBooks(final int numberOfBooks);
	
	/**
	 * Obtiene las sagas con mas de X libros
	 * 
	 * @param numberOfBooks
	 * @return List<Series>
	 */
	public List<Series> searchByMoreBooks(final int numberOfBooks);
}
