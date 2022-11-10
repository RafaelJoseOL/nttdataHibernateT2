package com.nttdata.hibernatet2.persistence;

import java.util.List;

/**
 * Formación - Hibernate - T2
 * 
 * DAO de tabla NTTDATA_HEX_WRITER
 * 
 * @author NTT Data Sevilla
 *
 */
public interface WriterDaoI extends CommonDaoI<Writer> {
	
	/**
	 * Obtiene los escritores por nombre completo
	 * 
	 * @param name
	 * @param lastName
	 * @return List<Writer>
	 */
	public List<Writer> searchByFullName(final String name, final String lastName);

	/**
	 * Obtiene los escritores por nombre de saga
	 * 
	 * @param series
	 * @return List<Writer>
	 */
	public List<Writer> searchBySeries(final String series);
	
	/**
	 * Obtiene los escritores por nombre de editorial
	 * 
	 * @param publisher
	 * @return List<Writer>
	 */
	public List<Writer> searchByPublisher(final String publisher);
}
