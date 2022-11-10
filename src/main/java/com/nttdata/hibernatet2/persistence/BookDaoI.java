package com.nttdata.hibernatet2.persistence;

import java.util.Date;
import java.util.List;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_BOOK
 * 
 * @author NTT Data Sevilla
 *
 */
public interface BookDaoI extends CommonDaoI<Book> {

	/**
	 * Obtiene los libros por su fecha de lanzamiento
	 * 
	 * @param releaseDate
	 * @return List<Book>
	 */
	public List<Book> searchByDate(final Date releaseDate);
	
	/**
	 * Obtiene los libros anteriores a una fecha
	 * 
	 * @param releaseDate
	 * @return List<Book>
	 */
	public List<Book> searchByDatePreviousTo(final Date releaseDate);
	
	/**
	 * Obtiene los libros posteriores a una fecha
	 * 
	 * @param releaseDate
	 * @return List<Book>
	 */
	public List<Book> searchByDatePosteriorTo(final Date releaseDate);
	
	/**
	 * Obtiene los libros mas baratos que la cantidad introducida
	 * 
	 * @param price
	 * @return List<Book>
	 */
	public List<Book> searchByPriceLowerThan(final float price);
	
	/**
	 * Obtiene los libros mas caros que la cantidad introducida
	 * 
	 * @param price
	 * @return List<Book>
	 */
	public List<Book> searchByPriceHigherThan(final float price);
}
