package com.nttdata.hibernatet2.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernatet2.persistence.Writer;
import com.nttdata.hibernatet2.persistence.WriterDaoI;
import com.nttdata.hibernatet2.persistence.WriterDaoImpl;

/**
 * Formación - Hibernate - T2
 * 
 * Implementacion del servicio de escritores
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class WriterManagementServiceImpl implements WriterManagementServiceI {

	/** DAO: NTTDATA_HEX_WRITER */
	private WriterDaoI writerDao;

	/**
	 * Método constructor.
	 */
	public WriterManagementServiceImpl(final Session session) {
		this.writerDao = new WriterDaoImpl(session);
	}

	@Override
	public void insertNewWriter(final Writer newWriter) {

		// Verificación de nulidad e inexistencia.
		if (newWriter != null && newWriter.getWriterId() == null) {

			// Insercción del nuevo escritor.
			writerDao.insert(newWriter);
		}
	}

	@Override
	public void updateWriter(final Writer updatedWriter) {

		// Verificación de nulidad y existencia.
		if (updatedWriter != null && updatedWriter.getWriterId() != null) {

			// Actualización del escritor.
			writerDao.update(updatedWriter);
		}
	}

	@Override
	public void deleteWriter(final Writer writerToDelete) {

		// Verificación de nulidad y existencia.
		if (writerToDelete != null && writerToDelete.getWriterId() != null) {

			// Eliminación del escritor.
			writerDao.delete(writerToDelete);
		}
	}

	@Override
	public Writer searchById(final Long writerId) {

		// Resultado.
		Writer writer = null;

		// Verificación de nulidad.
		if (writerId != null) {

			// Obtención del escritor por ID.
			writer = writerDao.searchById(writerId);
		}
		return writer;
	}

	@Override
	public List<Writer> searchByName(final String name) {

		// Resultado.
		List<Writer> writersList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención del escritor por nombre.
			writersList = writerDao.searchByName(name);
		}
		return writersList;
	}

	@Override
	public List<Writer> searchAll() {

		// Obtención y devolución de escritores.
		return writerDao.searchAll();
	}

	@Override
	public List<Writer> searchByFullName(String name, String lastName) {

		// Resultado.
		List<Writer> writersList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(lastName)) {

			// Obtención del escritor por nombre completo.
			writersList = writerDao.searchByFullName(name, lastName);
		}
		return writersList;
	}

	@Override
	public List<Writer> searchBySeries(String series) {

		// Resultado.
		List<Writer> writersList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(series)) {

			// Obtención del escritor por nombre completo.
			writersList = writerDao.searchBySeries(series);
		}
		return writersList;
	}

	@Override
	public List<Writer> searchByPublisher(String publisher) {

		// Resultado.
		List<Writer> writersList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(publisher)) {

			// Obtención del escritor por nombre completo.
			writersList = writerDao.searchByPublisher(publisher);
		}
		return writersList;
	}
}