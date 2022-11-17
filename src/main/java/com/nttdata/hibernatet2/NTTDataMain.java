package com.nttdata.hibernatet2;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernatet2.persistence.Book;
import com.nttdata.hibernatet2.persistence.Series;
import com.nttdata.hibernatet2.persistence.Store;
import com.nttdata.hibernatet2.persistence.Writer;
import com.nttdata.hibernatet2.services.BookManagementServiceI;
import com.nttdata.hibernatet2.services.BookManagementServiceImpl;
import com.nttdata.hibernatet2.services.SeriesManagementServiceI;
import com.nttdata.hibernatet2.services.SeriesManagementServiceImpl;
import com.nttdata.hibernatet2.services.StoreManagementServiceI;
import com.nttdata.hibernatet2.services.StoreManagementServiceImpl;
import com.nttdata.hibernatet2.services.WriterManagementServiceI;
import com.nttdata.hibernatet2.services.WriterManagementServiceImpl;

/**
 * Formación - Hibernate - T2
 * 
 * Clase principal
 * 
 * @author Rafael Jose Ossorio Lopez
 *
 */
public class NTTDataMain {
	private static final Logger LOG = LoggerFactory.getLogger(NTTDataMain.class);

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LOG.info("Inicio del método main");

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// String usado en varias ocasiones para un género de libro.
		final String EPIC_FANTASY_GENRE = "Epic Fantasy";

		// Inicialización de servicios.
		final WriterManagementServiceI writerService = new WriterManagementServiceImpl(session);
		final SeriesManagementServiceI seriesService = new SeriesManagementServiceImpl(session);
		final BookManagementServiceI bookService = new BookManagementServiceImpl(session);
		final StoreManagementServiceI storeService = new StoreManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTTWRITERS_SYS";
		final Date updatedDate = new Date();

		// Generación de escritores.
		final Writer writer1 = new Writer();
		final Writer writer2 = new Writer();
		final Writer writer3 = new Writer();
		final Writer writer4 = new Writer();

		createWriter(writer1, "Brandon", "Sanderson", "https://www.brandonsanderson.com", "NOVA", updatedUser,
				updatedDate);
		createWriter(writer2, "Robert", "Jordan", "https://dragonmount.com", "Minotauro", updatedUser, updatedDate);
		createWriter(writer3, "Robert", "Anthony", "http://rasalvatore.com", "Timun Mas", updatedUser, updatedDate);
		createWriter(writer4, "Ken", "Follet", "https://ken-follett.com", "PLAZA & JANES EDITORES", updatedUser,
				updatedDate);

		// Generación de sagas.
		final Series series1 = new Series();
		final Series series2 = new Series();
		final Series series3 = new Series();
		final Series series4 = new Series();
		final Series series5 = new Series();
		final Series series6 = new Series();
		final Series series7 = new Series();

		createSeries(series1, "Mistborn", "Action", 7, writer1, updatedUser, updatedDate);
		createSeries(series2, "Stormlight Archive", EPIC_FANTASY_GENRE, 5, writer1, updatedUser, updatedDate);
		createSeries(series3, "The Wheel of Time", EPIC_FANTASY_GENRE, 5, writer2, updatedUser, updatedDate);
		createSeries(series4, "The Dark Elf", EPIC_FANTASY_GENRE, 3, writer3, updatedUser, updatedDate);
		createSeries(series5, "Icewind Dale", EPIC_FANTASY_GENRE, 3, writer3, updatedUser, updatedDate);
		createSeries(series6, "Legacy of the Drow", EPIC_FANTASY_GENRE, 4, writer3, updatedUser, updatedDate);
		createSeries(series7, "Pillars of the Earth", "Historical Fiction", 4, writer4, updatedUser, updatedDate);

		// Asignación de sagas a los escritores.
		writer1.setSeriesList(Arrays.asList(series1, series2));
		writer2.setSeriesList(Arrays.asList(series3));
		writer3.setSeriesList(Arrays.asList(series4, series5, series6));
		writer4.setSeriesList(Arrays.asList(series7));

		// Generacion de libros.
		final Book book1 = new Book();
		final Book book2 = new Book();
		final Book book3 = new Book();
		final Book book4 = new Book();
		final Book book5 = new Book();
		final Book book6 = new Book();
		final Book book7 = new Book();

		final Book book8 = new Book();
		final Book book9 = new Book();
		final Book book10 = new Book();
		final Book book11 = new Book();
		final Book book12 = new Book();

		final Book book13 = new Book();
		final Book book14 = new Book();
		final Book book15 = new Book();
		final Book book16 = new Book();
		final Book book17 = new Book();

		final Book book18 = new Book();
		final Book book19 = new Book();
		final Book book20 = new Book();

		final Book book21 = new Book();
		final Book book22 = new Book();
		final Book book23 = new Book();

		final Book book24 = new Book();
		final Book book25 = new Book();
		final Book book26 = new Book();
		final Book book27 = new Book();

		final Book book28 = new Book();
		final Book book29 = new Book();
		final Book book30 = new Book();
		final Book book31 = new Book();

		createBook(book1, "The Final Empire", "2006-07-17", 12.30, series1, updatedUser, updatedDate);
		createBook(book2, "The Well of Ascension", "2007-08-21", 12.50, series1, updatedUser, updatedDate);
		createBook(book3, "The Hero of Ages", "2008-10-14", 13.50, series1, updatedUser, updatedDate);
		createBook(book4, "Alloy of Law", "2011-11-08", 12.80, series1, updatedUser, updatedDate);
		createBook(book5, "Shadows of Self", "2015-10-06", 13.90, series1, updatedUser, updatedDate);
		createBook(book6, "Bands of Mourning", "2016-01-26", 13.99, series1, updatedUser, updatedDate);
		createBook(book7, "The Lost Metal", "2022-11-15", 15.50, series1, updatedUser, updatedDate);

		createBook(book8, "The Way of Kings", "2010-08-31", 16.30, series2, updatedUser, updatedDate);
		createBook(book9, "Words of Radiance", "2014-03-04", 16.50, series2, updatedUser, updatedDate);
		createBook(book10, "Oathbringer", "2017-11-14", 16.80, series2, updatedUser, updatedDate);
		createBook(book11, "Rhythm of War", "2020-11-17", 17.00, series2, updatedUser, updatedDate);
		createBook(book12, "TBA", "2023-01-01", 19.99, series2, updatedUser, updatedDate);

		createBook(book13, "New Spring", "2004-01-06", 14.99, series3, updatedUser, updatedDate);
		createBook(book14, "The Eye of the World", "1990-01-15", 12.95, series3, updatedUser, updatedDate);
		createBook(book15, "The Great Hunt", "1990-11-15", 13.95, series3, updatedUser, updatedDate);
		createBook(book16, "The Dragon Reborn", "1991-10-15", 14.99, series3, updatedUser, updatedDate);
		createBook(book17, "The Shadow Rising", "1992-09-15", 14.90, series3, updatedUser, updatedDate);

		createBook(book18, "Homeland", "1990-12-01", 10.99, series4, updatedUser, updatedDate);
		createBook(book19, "Exile", "1991-02-03", 12.99, series4, updatedUser, updatedDate);
		createBook(book20, "Sojourn", "1991-03-14", 13.00, series4, updatedUser, updatedDate);

		createBook(book21, "The Crystal Shard", "1988-11-03", 11.99, series5, updatedUser, updatedDate);
		createBook(book22, "Streams of Silver", "1989-05-01", 11.99, series5, updatedUser, updatedDate);
		createBook(book23, "The Halfling's Gem", "1990-02-02", 12.95, series5, updatedUser, updatedDate);

		createBook(book24, "The Legacy", "1992-12-14", 11.99, series6, updatedUser, updatedDate);
		createBook(book25, "Starless Night", "1993-11-01", 11.99, series6, updatedUser, updatedDate);
		createBook(book26, "Siege of Darkness", "1994-05-10", 12.95, series6, updatedUser, updatedDate);
		createBook(book27, "Passage to Dawn", "1996-06-09", 12.95, series6, updatedUser, updatedDate);

		createBook(book28, "The Pillars of the Earth", "1989-10-05", 15.99, series7, updatedUser, updatedDate);
		createBook(book29, "World Without End", "2007-05-10", 18.95, series7, updatedUser, updatedDate);
		createBook(book30, "A Column of Fire", "2017-06-11", 16.95, series7, updatedUser, updatedDate);
		createBook(book31, "The Evening and the Morning", "2020-09-15", 19.99, series7, updatedUser, updatedDate);

		// Asignacion de los libros a las sagas.
		series1.setBooksList(Arrays.asList(book1, book2, book3, book4, book5, book6, book7));
		series2.setBooksList(Arrays.asList(book8, book9, book10, book11, book12));
		series3.setBooksList(Arrays.asList(book13, book14, book15, book16, book17));
		series4.setBooksList(Arrays.asList(book18, book19, book20));
		series5.setBooksList(Arrays.asList(book21, book22, book23));
		series6.setBooksList(Arrays.asList(book24, book25, book26, book27));
		series7.setBooksList(Arrays.asList(book28, book29, book30, book31));

		// Generación de tiendas.
		final Store store1 = new Store();
		final Store store2 = new Store();
		final Store store3 = new Store();

		// Creación de listas de libros para su asignación en las tiendas.
		List<Book> booksList1 = series1.getBooksList();
		List<Book> booksList2 = series2.getBooksList();
		List<Book> booksList3 = series3.getBooksList();
		List<Book> booksList4 = series4.getBooksList();
		List<Book> booksList5 = series5.getBooksList();
		List<Book> booksList6 = series6.getBooksList();
		List<Book> booksList7 = series7.getBooksList();

		createStore(store1, "Casa del libro", 10, Arrays.asList(booksList1, booksList2, booksList3), updatedUser,
				updatedDate);
		createStore(store2, "FNAC", 5, Arrays.asList(booksList4, booksList5, booksList6), updatedUser, updatedDate);
		createStore(store3, "Amazon", 15,
				Arrays.asList(booksList1, booksList2, booksList3, booksList4, booksList5, booksList6, booksList7),
				updatedUser, updatedDate);

		// Asignación de las tiendas a cada saga.
		for (int i = 0; i < booksList1.size(); i++) {
			booksList1.get(i).setStoresList(Arrays.asList(store1, store3));
		}
		for (int i = 0; i < booksList2.size(); i++) {
			booksList2.get(i).setStoresList(Arrays.asList(store1, store3));
		}
		for (int i = 0; i < booksList3.size(); i++) {
			booksList3.get(i).setStoresList(Arrays.asList(store1, store3));
		}
		for (int i = 0; i < booksList4.size(); i++) {
			booksList4.get(i).setStoresList(Arrays.asList(store2, store3));
		}
		for (int i = 0; i < booksList5.size(); i++) {
			booksList5.get(i).setStoresList(Arrays.asList(store2, store3));
		}
		for (int i = 0; i < booksList6.size(); i++) {
			booksList6.get(i).setStoresList(Arrays.asList(store2, store3));
		}
		for (int i = 0; i < booksList7.size(); i++) {
			booksList7.get(i).setStoresList(Arrays.asList(store3));
		}

		// Inserción en la BBDD.
		writerService.insertNewWriter(writer1);
		writerService.insertNewWriter(writer2);
		writerService.insertNewWriter(writer3);
		writerService.insertNewWriter(writer4);

		seriesService.insertNewSeries(series1);
		seriesService.insertNewSeries(series2);
		seriesService.insertNewSeries(series3);
		seriesService.insertNewSeries(series4);
		seriesService.insertNewSeries(series5);
		seriesService.insertNewSeries(series6);
		seriesService.insertNewSeries(series7);

		bookService.insertNewBook(book1);
		bookService.insertNewBook(book2);
		bookService.insertNewBook(book3);
		bookService.insertNewBook(book4);
		bookService.insertNewBook(book5);
		bookService.insertNewBook(book6);
		bookService.insertNewBook(book7);
		bookService.insertNewBook(book8);
		bookService.insertNewBook(book9);
		bookService.insertNewBook(book10);
		bookService.insertNewBook(book11);
		bookService.insertNewBook(book12);
		bookService.insertNewBook(book13);
		bookService.insertNewBook(book14);
		bookService.insertNewBook(book15);
		bookService.insertNewBook(book16);
		bookService.insertNewBook(book17);
		bookService.insertNewBook(book18);
		bookService.insertNewBook(book19);
		bookService.insertNewBook(book20);
		bookService.insertNewBook(book21);
		bookService.insertNewBook(book22);
		bookService.insertNewBook(book23);
		bookService.insertNewBook(book24);
		bookService.insertNewBook(book25);
		bookService.insertNewBook(book26);
		bookService.insertNewBook(book27);
		bookService.insertNewBook(book28);
		bookService.insertNewBook(book29);
		bookService.insertNewBook(book30);
		bookService.insertNewBook(book31);

		storeService.insertNewStore(store1);
		storeService.insertNewStore(store2);
		storeService.insertNewStore(store3);

		// Querys
		List<Writer> writersList = writerService.searchByName("ob");
		List<Series> seriesList = seriesService.searchAll();
		List<Series> seriesListMoreThan5Bbooks = seriesService.searchByMoreBooks(4);
		List<Series> seriesMist = seriesService.searchByName("Mist");
		List<Book> booksList = bookService.searchAll();
		List<Store> storesListSortedByDiscount = storeService.searchAndSortByDiscount();
		List<Writer> writersByNameAndBooks = writerService.searchByNameAndNumberOfBooks("Rob%", 4);
		List<Writer> writersWithBooksOnStore = writerService.searchByBooksOnStore("Casa del libro");

		// Consultas
		LOG.info("Comienzo de la sección de consultas");
		LOG.info("Busqueda de escritores que contienen 'ob' en su nombre:");
		for (final Writer writer : writersList) {
			getWriterInfo(writer);
		}

		LOG.info("Busqueda de todas las sagas:");
		for (final Series series : seriesList) {
			getSeriesInfo(series);
		}

		LOG.info("Busqueda de todas las sagas con más de 4 libros:");
		for (final Series series : seriesListMoreThan5Bbooks) {
			getSeriesInfo(series);
		}

		LOG.info("Busqueda de todas las sagas que contengan 'Mist' en su nombre:");
		for (final Series series : seriesMist) {
			getSeriesInfo(series);
		}

		LOG.info("Busqueda de todos los libros:");
		for (final Book book : booksList) {
			getBookInfo(book);
		}

		LOG.info("Busqueda de todas las tiendas ordenadas por su descuento:");
		for (final Store store : storesListSortedByDiscount) {
			getStoreInfo(store);
		}
		
		LOG.info("Busqueda de todos los clientes:");

		// Consultas JPA
		LOG.info(
				"Busqueda de todos los escritores cuyo nombre empiece por 'Rob' y tenga alguna saga con más de 4 libros:");
		for (final Writer writer : writersByNameAndBooks) {
			getWriterInfo(writer);
		}

		LOG.info("Busqueda de todos los escritores que tengan libros en 'Casa del libro'");
		for (final Writer writer : writersWithBooksOnStore) {
			getWriterInfo(writer);
		}

		// Cierre de sesión.
		session.close();
		LOG.info("Fin de la ejecución.");
	}

	/**
	 * 
	 * @param writer
	 * @param name
	 * @param lastName
	 * @param website
	 * @param publisher
	 * @param user
	 * @param date
	 * 
	 *                  Metodo para crear escritores.
	 */
	private static void createWriter(Writer writer, String name, String lastName, String website, String publisher,
			String user, Date date) {
		writer.setWriterName(name);
		writer.setWriterLastName(lastName);
		writer.setWebsite(website);
		writer.setPublisher(publisher);
		writer.setUpdatedUser(user);
		writer.setUpdatedDate(date);
	}

	/**
	 * 
	 * @param series
	 * @param name
	 * @param genre
	 * @param numberOfBooks
	 * @param writer
	 * @param user
	 * @param date
	 * 
	 *                      Metodo para crear sagas.
	 */
	private static void createSeries(Series series, String name, String genre, int numberOfBooks, Writer writer,
			String user, Date date) {
		series.setSeriesName(name);
		series.setSeriesGenre(genre);
		series.setNumberOfBooks(numberOfBooks);
		series.setWriter(writer);
		series.setUpdatedUser(user);
		series.setUpdatedDate(date);
	}

	/**
	 * 
	 * @param book
	 * @param name
	 * @param releaseDate
	 * @param price
	 * @param series
	 * @param user
	 * @param date
	 * 
	 *                    Metodo para crear libros.
	 */
	private static void createBook(Book book, String name, String releaseDate, double price, Series series, String user,
			Date date) {		
		book.setBookName(name);
		book.setReleaseDate(LocalDate.parse(releaseDate));
		book.setBookPrice(price);
		book.setSeries(series);
		book.setUpdatedUser(user);
		book.setUpdatedDate(date);
	}

	/**
	 * 
	 * @param store
	 * @param name
	 * @param discount
	 * @param booksList
	 * @param user
	 * @param date
	 * 
	 *                  Metodo para crear tiendas.
	 */
	private static void createStore(Store store, String name, int discount, List<List<Book>> booksList, String user,
			Date date) {
		store.setStoreName(name);
		store.setDiscount(discount);
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < booksList.size(); i++) {
			books.addAll(booksList.get(i));
		}
		store.setBooksList(books);
		store.setUpdatedUser(user);
		store.setUpdatedDate(date);
	}

	/**
	 * 
	 * @param writer
	 * 
	 *               Metodo para obtener la informacion de los escritores.
	 */
	private static void getWriterInfo(final Writer writer) {
		LOG.info("Nombre: {} {} | Página web: {} | Editorial: {} | Sagas:", writer.getWriterName(),
				writer.getWriterLastName(), writer.getWebsite(), writer.getPublisher());
		getSeriesFromWriter(writer);
	}

	/**
	 * 
	 * @param writer
	 * 
	 *               Metodo para obtener las sagas de cada escritor.
	 */
	private static void getSeriesFromWriter(final Writer writer) {
		for (int i = 0; i < writer.getSeriesList().size(); i++) {
			LOG.info(writer.getSeriesList().get(i).getSeriesName());
		}
	}

	/**
	 * 
	 * @param series
	 * 
	 *               Metodo para obtener la informacion de las sagas.
	 */
	private static void getSeriesInfo(final Series series) {
		LOG.info("Nombre: {} | Género: {} | Número de libros: {} | Escritor: {}", series.getSeriesName(),
				series.getSeriesGenre(), series.getNumberOfBooks(), series.getWriter().getWriterName());
	}

	/**
	 * 
	 * @param book
	 * 
	 *             Metodo para obtener la informacion de los libros.
	 */
	private static void getBookInfo(final Book book) {
		LOG.info("Título: {} | Fecha de lanzamiento: {} | Precio: {} | Saga: {} | Tiendas donde se vende: ",
				book.getBookName(), book.getReleaseDate(), book.getBookPrice(), book.getSeries().getSeriesName());
		getStoresWhereBooksAre(book);
	}

	/**
	 * 
	 * @param book
	 * 
	 *             Metodo para obtener las tiendas donde se vende cada libro
	 */
	private static void getStoresWhereBooksAre(final Book book) {
		if (book.getStoresList() != null) {

			// Calculo del precio de cada libro con el descuento de la tienda.
			final DecimalFormat df = new DecimalFormat("0.00");
			for (int i = 0; i < book.getStoresList().size(); i++) {
				String priceWithDiscount = df
						.format(book.getBookPrice() - book.getBookPrice() / book.getStoresList().get(i).getDiscount());
				LOG.info("{} --- Precio con el descuento de la tienda: {}€", book.getStoresList().get(i).getStoreName(),
						priceWithDiscount);
			}
		} else {
			LOG.info("No se vende en ninguna tienda.");
		}
	}

	/**
	 * 
	 * @param store
	 * 
	 *              Metodo para obtener la informacion de las tiendas.
	 */
	private static void getStoreInfo(final Store store) {
		LOG.info("Nombre de la tienda: {} | Descuento: {}% | Libros a la venta:", store.getStoreName(),
				store.getDiscount());

		getBooksFromStore(store);
	}

	/**
	 * 
	 * @param store
	 * 
	 *              Metodo para obtener la informacion de los libros de cada tienda.
	 */
	private static void getBooksFromStore(final Store store) {

		// Calculo del precio de cada libro con el descuento de la tienda.
		final DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < store.getBooksList().size(); i++) {
			String priceWithDiscount = df.format(store.getBooksList().get(i).getBookPrice()
					- (store.getBooksList().get(i).getBookPrice() / store.getDiscount()));
			LOG.info("{} --- Precio: {}", store.getBooksList().get(i).getBookName(), priceWithDiscount);
		}
	}
}