package com.nttdata.hibernatet2.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - T2
 * 
 * Entidad de tabla NTTDATA_HEX_STORE
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
@Entity
@Table(name = "NTTDATA_HEX_STORE")
public class Store extends AbstractEntity {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long storeId;

	/** Nombre de la tienda */
	private String storeName;

	/** Descuento a aplicar */
	private int discount;

	/** Libros a la venta */
	private List<Book> booksList;

	/**
	 * @return the storeId
	 */
	@Id
	@Column(name = "STORE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "store_id_Sequence")
	@SequenceGenerator(name = "store_id_Sequence", sequenceName = "STORE_ID_SEQ")
	public Long getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId storeId to be set
	 */
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the storeName
	 */
	@Column(name = "NAME", nullable = false)
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName storeName to be set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * @return the discount
	 */
	@Column(name = "DISCOUNT")
	public int getDiscount() {
		return discount;
	}

	/**
	 * @param discount discount to be set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * @return the booksList
	 */
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "NTTDATA_HEX_STORE_BOOK", joinColumns = { @JoinColumn(name = "STORE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "BOOK_ID") })
	public List<Book> getBooksList() {
		return booksList;
	}

	/**
	 * @param booksList booksList to be set
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
		return this.storeId;
	}

	@Override
	public void setId(Long id) {
		this.storeId = id;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", discount=" + discount;
	}
}