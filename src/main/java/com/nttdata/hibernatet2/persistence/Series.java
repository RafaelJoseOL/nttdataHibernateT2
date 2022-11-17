package com.nttdata.hibernatet2.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - T2
 * 
 * Entidad de tabla NTTDATA_HEX_SERIES
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_SERIES")
public class Series extends AbstractEntity {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long seriesId;

	/** Nombre de la saga */
	private String seriesName;
	
	/** Genero de la saga */
	private String seriesGenre;

	/** Numero de libros */
	private Integer seriesNumberOfBooks;
	
	/** Escritor de la saga */
	private Writer writer;
	
	/** Libros de la saga */
	private List<Book> booksList;

	/**
	 * @return the seriesId
	 */
	@Id
	@Column(name = "SERIES_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "series_id_Sequence")
	@SequenceGenerator(name = "series_id_Sequence", sequenceName = "SERIES_ID_SEQ")
	public Long getSeriesId() {
		return seriesId;
	}

	/**
	 * @param seriesId 
	 * seriesId to be set
	 */
	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * @return the seriesName
	 */
	@Column(name = "NAME", nullable = false)
	public String getSeriesName() {
		return seriesName;
	}

	/**
	 * @param seriesName 
	 * seriesName to be set
	 */
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	
	/**
	 * @return the seriesGenre
	 */
	@Column(name = "GENRE", nullable = false)
	public String getSeriesGenre() {
		return seriesGenre;
	}

	/**
	 * @param seriesGenre 
	 * seriesGenre to be set
	 */
	public void setSeriesGenre(String seriesGenre) {
		this.seriesGenre = seriesGenre;
	}

	/**
	 * @return the seriesNumberOfBooks
	 */
	@Column(name = "NUMBER_OF_BOOKS", nullable = false)
	public Integer getNumberOfBooks() {
		return seriesNumberOfBooks;
	}

	/**
	 * @param seriesNumberOfBooks 
	 * seriesNumberOfBooks to be set
	 */
	public void setNumberOfBooks(Integer seriesNumberOfBooks) {
		this.seriesNumberOfBooks = seriesNumberOfBooks;
	}
	
	/**
	 * @return the writer
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "WRITER_ID")
	public Writer getWriter() {
		return writer;
	}

	/**
	 * @param writer
	 * writer to be set
	 */
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
	/**
	 * @return the booksList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "series")
	@Column(name = "BOOKS_LIST")
	public List<Book> getBooksList() {
		return booksList;
	}

	/**
	 * @param books
	 * books to be set
	 */
	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	@Transient
	public Class<?> getClase() {
		return Writer.class;
	}

	@Override
	public Long getId() {
		return this.seriesId;
	}

	@Override
	public void setId(Long id) {
		this.seriesId = id;
	}

	@Override
	public String toString() {
		return "Series [seriesId=" + seriesId + ", seriesName=" + seriesName + ", seriesGenre=" + seriesGenre
				+ ", seriesNumberOfBooks=" + seriesNumberOfBooks;
	}
}