package com.nttdata.hibernatet2.persistence;

import java.util.List;

/**
 * Formación - Hibernate - T2
 * 
 * DAO genérico
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);

	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);

	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public T searchById(final Long id);
	
	/**
	 * Localiza un registro por nombre en BBDD.
	 * 
	 * @param paramT
	 */
	public List<T> searchByName(final String name);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();
}