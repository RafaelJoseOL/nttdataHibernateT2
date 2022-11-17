package com.nttdata.hibernatet2.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernatet2.persistence.Store;
import com.nttdata.hibernatet2.persistence.StoreDaoI;
import com.nttdata.hibernatet2.persistence.StoreDaoImpl;

/**
 * Formación - Hibernate - T2
 * 
 * Implementacion del servicio de tiendas
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class StoreManagementServiceImpl implements StoreManagementServiceI {

	/** DAO: NTTDATA_HEX_BOOK */
	private StoreDaoI storeDao;

	/**
	 * Método constructor.
	 */
	public StoreManagementServiceImpl(final Session session) {
		this.storeDao = new StoreDaoImpl(session);
	}

	@Override
	public void insertNewStore(Store newStore) {

		// Verificación de nulidad e inexistencia.
		if (newStore != null && newStore.getStoreId() == null) {

			// Insercción de la nueva tienda
			storeDao.insert(newStore);
		}
	}

	@Override
	public void updateStore(Store storeToUpdate) {

		// Verificación de nulidad y existencia.
		if (storeToUpdate != null && storeToUpdate.getStoreId() != null) {

			// Actualización de la tienda
			storeDao.update(storeToUpdate);
		}
	}

	@Override
	public void deleteStore(Store storeToDelete) {

		// Verificación de nulidad y existencia.
		if (storeToDelete != null && storeToDelete.getStoreId() != null) {

			// Borrado del tienda
			storeDao.delete(storeToDelete);
		}
	}

	@Override
	public Store searchById(Long storeId) {

		// Resultado.
		Store store = null;

		// Verificación de nulidad.
		if (storeId != null) {

			// Obtencion de la tienda por ID
			store = storeDao.searchById(storeId);
		}
		return store;
	}

	@Override
	public List<Store> searchByName(String name) {

		// Resultado.
		List<Store> storeList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención de las tiendas por nombre.
			storeList = storeDao.searchByName(name);
		}
		return storeList;
	}

	@Override
	public List<Store> searchByDiscount(int discount) {

		// Obtención y devolución de las tiendas con el descuento indicado.
		return storeDao.searchByDiscount(discount);
	}

	@Override
	public List<Store> searchAndSortByDiscount() {

		// Obtención y devolución de todas las tiendas para su ordenación por descuento
		return storeDao.searchAndSortByDiscount();
	}

	@Override
	public List<Store> searchAll() {

		// Obtención y devolución de todas las tiendas.
		return storeDao.searchAll();
	}
}
