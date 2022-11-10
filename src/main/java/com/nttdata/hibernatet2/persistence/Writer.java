package com.nttdata.hibernatet2.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - T2
 * 
 * Entidad de tabla NTTDATA_HEX_WRITER
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_WRITER")
public class Writer extends AbstractEntity implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long writerId;

	/** Nombre del escritor */
	private String writerName;
	
	/** Apellido del escritor */
	private String writerLastName;

	/** Enlace de la pagina web */
	private String website;

	/** Editorial en España */
	private String publisher;
	
	/** Sagas del escritor */
	//private List<Series> seriesList;

	/**
	 * @return the writerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WRITER_ID")
	public Long getWriterId() {
		return writerId;
	}

	/**
	 * @param writerId 
	 * writerId to be set
	 */
	public void setWriterId(Long writerId) {
		this.writerId = writerId;
	}

	/**
	 * @return the writerName
	 */
	@Column(name = "NAME", nullable = false)
	public String getWriterName() {
		return writerName;
	}

	/**
	 * @param writerName 
	 * writerName to be set
	 */
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
	/**
	 * @return the writerLastName
	 */
	@Column(name = "LAST_NAME", nullable = false)
	public String getWriterLastName() {
		return writerLastName;
	}

	/**
	 * @param writerLastName 
	 * writerLastName to be set
	 */
	public void setWriterLastName(String writerLastName) {
		this.writerLastName = writerLastName;
	}

	/**
	 * @return the website
	 */
	@Column(name = "WEBSITE", nullable = false)
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website 
	 * website to be set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the publisher
	 */
	@Column(name = "SPANISH_PUBLISHER", nullable = false)
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher 
	 * publisher to be set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
//	/**
//	 * @return the seriesList
//	 */
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity=Series.class, mappedBy = "writer")
//	public List<Series> getSeriesList() {
//		return seriesList;
//	}
//
//	/**
//	 * @param seriesList 
//	 * seriesList to set
//	 */
//	public void setSeriesList(List<Series> seriesList) {
//		this.seriesList = seriesList;
//	}

	@Transient
	public Class<?> getClase() {
		return Writer.class;
	}

	@Override
	@Transient
	public Long getId() {
		return this.writerId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.writerId = id;
	}
}