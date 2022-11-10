package com.nttdata.hibernatet2.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernatet2.persistence.Series;
import com.nttdata.hibernatet2.persistence.SeriesDaoI;
import com.nttdata.hibernatet2.persistence.SeriesDaoImpl;

/**
 * Formación - Hibernate - T2
 * 
 * Implementacion del servicio de sagas
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class SeriesManagementServiceImpl implements SeriesManagementServiceI {

	/** DAO: NTTDATA_HEX_SERIES */
	private SeriesDaoI seriesDao;

	/**
	 * Método constructor.
	 */
	public SeriesManagementServiceImpl(final Session session) {
		this.seriesDao = new SeriesDaoImpl(session);
	}

	@Override
	public void insertNewSeries(final Series newSeries) {

		// Verificación de nulidad e inexistencia.
		if (newSeries != null && newSeries.getSeriesId() == null) {

			// Insercción de la nueva saga
			seriesDao.insert(newSeries);
		}
	}

	@Override
	public void updateSeries(final Series updatedSeries) {

		// Verificación de nulidad y existencia.
		if (updatedSeries != null && updatedSeries.getSeriesId() != null) {

			// Actualización de la saga
			seriesDao.update(updatedSeries);
		}
	}

	@Override
	public void deleteSeries(final Series seriesToDelete) {

		// Verificación de nulidad y existencia.
		if (seriesToDelete != null && seriesToDelete.getSeriesId() != null) {

			// Eliminación de la saga
			seriesDao.delete(seriesToDelete);
		}
	}

	@Override
	public Series searchById(final Long seriesId) {

		// Resultado.
		Series series = null;

		// Verificación de nulidad.
		if (seriesId != null) {

			// Obtención del libro por ID.
			series = seriesDao.searchById(seriesId);
		}
		return series;
	}

	@Override
	public List<Series> searchByName(final String name) {

		// Resultado.
		List<Series> seriesList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención de las sagas por nombre.
			seriesList = seriesDao.searchByName(name);
		}
		return seriesList;
	}

	@Override
	public List<Series> searchAll() {

		// Obtención y devolución de sagas
		return seriesDao.searchAll();
	}

	@Override
	public List<Series> searchByGenre(String name) {

		// Resultado.
		List<Series> seriesList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención de las sagas por nombre.
			seriesList = seriesDao.searchByGenre(name);
		}
		return seriesList;
	}

	@Override
	public List<Series> searchByNumberOfBooks(int numberOfBooks) {
		
		// Obtención de las sagas por nombre.
		return seriesDao.searchByNumberOfBooks(numberOfBooks);
	}

	@Override
	public List<Series> searchByMoreBooks(int numberOfBooks) {

		// Obtención de las sagas por nombre.
		return seriesDao.searchByMoreBooks(numberOfBooks);
	}
}