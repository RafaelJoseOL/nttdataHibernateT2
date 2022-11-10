package com.nttdata.hibernatet2.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Book extends AbstractEntity implements Serializable{
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long bookId;
	
	/** Identificador (PK) */
	private String bookName;
	
	/** Identificador (PK) */
	private Date releaseDate;
	
	/** Identificador (PK) */
	private Double price;
	
	/** Saga del libro */
	//private Series series;
	
	/**
	 * @return the bookId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	public Long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId 
	 * bookId to be set
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
	 * @param bookName 
	 * bookName to be set
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
	 * @param releaseDate 
	 * releaseDate to be set
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
	 * @param price 
	 * price to be set
	 */
	public void setBookPrice(Double price) {
		this.price = price;
	}
	
//	/**
//	 * @return the team
//	 */
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "SERIES_ID")
//	public Series getSeries() {
//		return series;
//	}
//
//	/**
//	 * @param series
//	 * series to be set
//	 */
//	public void setSeries(Series series) {
//		this.series = series;
//	}

	@Override
	@Transient
	public Long getId() {
		return this.bookId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.bookId = id;		
	}	
}
