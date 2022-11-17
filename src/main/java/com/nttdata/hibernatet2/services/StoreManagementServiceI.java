package com.nttdata.hibernatet2.services;

import java.util.List;

import com.nttdata.hibernatet2.persistence.Store;

/**
 * Formación - Hibernate - T2
 * 
 * Interfaz del servicio de tiendas
 * 
 * @author NTT Data Sevilla
 *
 */
public interface StoreManagementServiceI {

	/**
	 * Inserta una nueva tienda
	 * 
	 * @param newStore
	 */
	public void insertNewStore(final Store newStore);

	/**
	 * Actualiza una tienda ya existente
	 * 
	 * @param storeToUpdate
	 */
	public void updateStore(final Store storeToUpdate);

	/**
	 * Elimina una tienda ya existente
	 * 
	 * @param storeToDelete
	 */
	public void deleteStore(final Store storeToDelete);

	/**
	 * Obtiene una tienda por su ID
	 * 
	 * @param storeId
	 */
	public Store searchById(final Long storeId);

	/**
	 * Obtiene tiendas por su nombre
	 * 
	 * @param name
	 * @return List<Store>
	 */
	public List<Store> searchByName(final String name);
	
	/**
	 * Obtiene las tiendas con un descuento concreto
	 * 
	 * @param discount
	 * @return List<Store>
	 */
	public List<Store> searchByDiscount(int discount);
	
	/**
	 * Ordena las tiendas por su descuento
	 * 
	 * @return List<Store>
	 */
	public List<Store> searchAndSortByDiscount();

	/**
	 * Obtiene todas las tiendas existentes
	 * 
	 * @return List<Store>
	 */
	public List<Store> searchAll();
}