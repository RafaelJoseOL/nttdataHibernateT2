package com.nttdata.hibernatet2.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

/**
 * Formación - Hibernate - T2
 * 
 * Entidad de tabla NTTDATA_HEX_BOOK
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_BOOK")
public class Book extends AbstractEntity {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long bookId;

	/** Título del libro */
	private String bookName;

	/** Fecha de lanzamiento */
	private Date releaseDate;

	/** Precio */
	private Double price;

	/** Saga del libro */
	private Series series;

	/** Tiendas donde se vende */
	private List<Store> storesList;

	/**
	 * @return the bookId
	 */
	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_Sequence")
	@SequenceGenerator(name = "book_id_Sequence", sequenceName = "BOOK_ID_SEQ")
	public Long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId bookId to be set
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	@Column(name = "NAME", nullable = false)
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName bookName to be set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the releaseDate
	 */
	@Column(name = "RELEASE_DATE", nullable = false)
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate releaseDate to be set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the price
	 */
	@Column(name = "PRICE", nullable = false)
	@Digits(integer = 3, fraction = 2)
	public Double getBookPrice() {
		return price;
	}

	/**
	 * @param price price to be set
	 */
	public void setBookPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the series
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SERIES_ID")
	public Series getSeries() {
		return series;
	}

	/**
	 * @param series series to be set
	 */
	public void setSeries(Series series) {
		this.series = series;
	}

	/**
	 * @return the storesList
	 */
	@ManyToMany(mappedBy = "booksList")
	public List<Store> getStoresList() {
		return storesList;
	}

	/**
	 * @param storesList storesList to be set
	 */
	public void setStoresList(List<Store> storesList) {
		this.storesList = storesList;
	}

	@Transient
	public Class<?> getClase() {
		return Writer.class;
	}

	@Override
	public Long getId() {
		return this.bookId;
	}

	@Override
	public void setId(Long id) {
		this.bookId = id;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", releaseDate=" + releaseDate + ", price="
				+ price;
	}
}
