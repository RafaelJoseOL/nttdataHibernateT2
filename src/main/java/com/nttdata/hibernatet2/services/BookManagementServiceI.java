package com.nttdata.hibernatet2.services;

import java.util.Date;
import java.util.List;

import com.nttdata.hibernatet2.persistence.Book;

/**
 * Formación - Hibernate - T2
 * 
 * Interfaz del servicio de libros
 * 
 * @author NTT Data Sevilla
 *
 */
public interface BookManagementServiceI {

	/**
	 * Inserta una nueva saga
	 * 
	 * @param newBook
	 */
	public void insertNewBook(final Book newBook);

	/**
	 * Actualiza un libro ya existente
	 * 
	 * @param bookToUpdate
	 */
	public void updateBook(final Book bookToUpdate);

	/**
	 * Elimina un libro ya existente
	 * 
	 * @param bookToDelete
	 */
	public void deleteBook(final Book bookToDelete);

	/**
	 * Obtiene un libro por su ID
	 * 
	 * @param bookId
	 */
	public Book searchById(final Long bookId);

	/**
	 * Obtiene libros por su nombre
	 * 
	 * @param name
	 * @return List<Book>
	 */
	public List<Book> searchByName(final String name);
	
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

	/**
	 * Obtiene todos los libros existentes
	 * 
	 * @return List<Book>
	 */
	public List<Book> searchAll();
}