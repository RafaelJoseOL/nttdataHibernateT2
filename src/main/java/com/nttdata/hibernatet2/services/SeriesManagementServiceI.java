package com.nttdata.hibernatet2.services;

import java.util.List;

import com.nttdata.hibernatet2.persistence.Series;

/**
 * Formación - Hibernate - T2
 * 
 * Interfaz del servicio de sagas
 * 
 * @author NTT Data Sevilla
 *
 */
public interface SeriesManagementServiceI {

	/**
	 * Inserta una nueva saga
	 * 
	 * @param newSeries
	 */
	public void insertNewSeries(final Series newSeries);

	/**
	 * Actualiza una saga ya existente
	 * 
	 * @param seriesToUpdate
	 */
	public void updateSeries(final Series seriesToUpdate);

	/**
	 * Elimina una saga ya existente
	 * 
	 * @param seriesToDelete
	 */
	public void deleteSeries(final Series seriesToDelete);

	/**
	 * Obtiene una saga por su ID
	 * 
	 * @param seriesId
	 */
	public Series searchById(final Long seriesId);

	/**
	 * Obtiene sagas por su nombre
	 * 
	 * @param name
	 * @return List<Series>
	 */
	public List<Series> searchByName(final String name);
	
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

	/**
	 * Obtiene todas las sagas existentes
	 * 
	 * @return List<Series>
	 */
	public List<Series> searchAll();
}