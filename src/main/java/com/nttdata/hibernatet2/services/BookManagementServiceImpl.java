package com.nttdata.hibernatet2.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernatet2.persistence.Book;
import com.nttdata.hibernatet2.persistence.BookDaoI;
import com.nttdata.hibernatet2.persistence.BookDaoImpl;

/**
 * Formación - Hibernate - T2
 * 
 * Implementacion del servicio de libros
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class BookManagementServiceImpl implements BookManagementServiceI {

	/** DAO: NTTDATA_HEX_BOOK */
	private BookDaoI bookDao;

	/**
	 * Método constructor.
	 */
	public BookManagementServiceImpl(final Session session) {
		this.bookDao = new BookDaoImpl(session);
	}

	@Override
	public void insertNewBook(final Book newBook) {

		// Verificación de nulidad e inexistencia.
		if (newBook != null && newBook.getBookId() == null) {

			// Insercción del nuevo libro
			bookDao.insert(newBook);
		}
	}

	@Override
	public void updateBook(Book bookToUpdate) {

		// Verificación de nulidad y existencia.
		if (bookToUpdate != null && bookToUpdate.getBookId() != null) {

			// Actualización del libro
			bookDao.update(bookToUpdate);
		}
	}

	@Override
	public void deleteBook(Book bookToDelete) {

		// Verificación de nulidad y existencia.
		if (bookToDelete != null && bookToDelete.getBookId() != null) {

			// Borrado del libro
			bookDao.delete(bookToDelete);
		}
	}

	@Override
	public Book searchById(Long bookId) {

		// Resultado.
		Book book = null;

		// Verificación de nulidad.
		if (bookId != null) {

			// Obtencion del libro por ID
			book = bookDao.searchById(bookId);
		}
		return book;
	}

	@Override
	public List<Book> searchByName(String name) {

		// Resultado.
		List<Book> bookList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención de los libros por nombre.
			bookList = bookDao.searchByName(name);
		}
		return bookList;
	}

	@Override
	public List<Book> searchByDate(Date releaseDate) {

		// Obtención de los libros por fecha
		return bookDao.searchByDate(releaseDate);
	}

	@Override
	public List<Book> searchByDatePreviousTo(Date releaseDate) {

		// Obtención de los libros por fecha previa
		return bookDao.searchByDatePreviousTo(releaseDate);
	}

	@Override
	public List<Book> searchByDatePosteriorTo(Date releaseDate) {

		// Obtención de los libros por fecha posterior
		return bookDao.searchByDatePosteriorTo(releaseDate);
	}

	@Override
	public List<Book> searchByPriceLowerThan(float price) {

		// Obtención de los libros por precio inferior
		return bookDao.searchByPriceLowerThan(price);
	}

	@Override
	public List<Book> searchByPriceHigherThan(float price) {

		// Obtención de los libros por precio superior
		return bookDao.searchByPriceHigherThan(price);
	}

	@Override
	public List<Book> searchAll() {

		// Obtención y devolución de libros
		return bookDao.searchAll();
	}
}