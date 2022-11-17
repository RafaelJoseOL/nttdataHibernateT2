package com.nttdata.hibernatet2.services;

import java.util.List;

import com.nttdata.hibernatet2.persistence.Writer;

/**
 * Formación - Hibernate - T2
 * 
 * Interfaz del servicio de escritores
 * 
 * @author NTT Data Sevilla
 *
 */
public interface WriterManagementServiceI {

	/**
	 * Inserta un nuevo escritor.
	 * 
	 * @param newWriter
	 */
	public void insertNewWriter(final Writer newWriter);

	/**
	 * Actualiza un escritor ya existente.
	 * 
	 * @param writerToDelete
	 */
	public void updateWriter(final Writer writerToUpdate);

	/**
	 * Elimina un escritor ya existente.
	 * 
	 * @param writerToDelete
	 */
	public void deleteWriter(final Writer writerToDelete);

	/**
	 * Obtiene un escritor por su ID.
	 * 
	 * @param writerId
	 */
	public Writer searchById(final Long writerId);

	/**
	 * Obtiene un escritor por su nombre.
	 * 
	 * @param name
	 * @return List<Writer>
	 */
	public List<Writer> searchByName(final String name);
	
	/**
	 * Obtiene un escritor por su nombre completo.
	 * 
	 * @param name
	 * @return List<Writer>
	 */
	public List<Writer> searchByFullName(final String name, final String lastName);
	
	/**
	 * Obtiene un escritor por la saga.
	 * 
	 * @param name
	 * @return List<Writer>
	 */
	public List<Writer> searchBySeries(final String series);
	
	/**
	 * Obtiene un escritor por su editorial en España.
	 * 
	 * @param name
	 * @return List<Writer>
	 */
	public List<Writer> searchByPublisher(final String publisher);
	
	/**
	 * Obtiene un escritor por su editorial en España.
	 * 
	 * @param name
	 * @return List<Writer>
	 */
	public List<Writer> searchByNameAndNumberOfBooks(String writerName, Integer numberOfBooks);
	
	/**
	 * Obtiene los escritores que tienen libros en la tienda indicada.
	 * 
	 * @param storeName
	 * @return
	 */
	List<Writer> searchByBooksOnStore(String storeName);

	/**
	 * Obtiene todos los escritores existentes.
	 * 
	 * @return List<Writer>
	 */
	public List<Writer> searchAll();
}