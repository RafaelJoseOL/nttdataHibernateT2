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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Series extends AbstractEntity implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long seriesId;

	/** Nombre de la saga */
	private String seriesName;
	
	/** Genero de la saga */
	private String seriesGenre;

	/** Numero de libros */
	private int seriesNumberOfBooks;
	
	/** Escritor de la saga */
	//private Writer writer;
	
	/** Libros de la saga */
	//private List<Book> books;

	/**
	 * @return the seriesId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SERIES_ID")
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
	public int getNumberOfBooks() {
		return seriesNumberOfBooks;
	}

	/**
	 * @param seriesNumberOfBooks 
	 * seriesNumberOfBooks to be set
	 */
	public void setNumberOfBooks(int seriesNumberOfBooks) {
		this.seriesNumberOfBooks = seriesNumberOfBooks;
	}
	
//	/**
//	 * @return the writer
//	 */
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "WRITER_ID")
//	public Writer getWriter() {
//		return writer;
//	}
//
//	/**
//	 * @param writer
//	 * writer to be set
//	 */
//	public void setSeriesWriter(Writer writer) {
//		this.writer = writer;
//	}
	
//	/**
//	 * @return the booksList
//	 */
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "series")
//	public List<Book> getBooksList() {
//		return books;
//	}
//
//	/**
//	 * @param books
//	 * books to be set
//	 */
//	public void setPlayersList(List<Book> books) {
//		this.books = books;
//	}

	@Transient
	public Class<?> getClase() {
		return Writer.class;
	}

	@Override
	@Transient
	public Long getId() {
		return this.seriesId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.seriesId = id;
	}
}