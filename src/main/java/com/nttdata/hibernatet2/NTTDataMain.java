package com.nttdata.hibernatet2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernatet2.persistence.Book;
import com.nttdata.hibernatet2.persistence.Series;
import com.nttdata.hibernatet2.persistence.Writer;
import com.nttdata.hibernatet2.services.BookManagementServiceI;
import com.nttdata.hibernatet2.services.BookManagementServiceImpl;
import com.nttdata.hibernatet2.services.SeriesManagementServiceI;
import com.nttdata.hibernatet2.services.SeriesManagementServiceImpl;
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

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final WriterManagementServiceI writerService = new WriterManagementServiceImpl(session);
		final SeriesManagementServiceI seriesService = new SeriesManagementServiceImpl(session);
		final BookManagementServiceI bookService = new BookManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTTWRITERS_SYS";
		final Date updatedDate = new Date();

		// Generación de escritores.
		final Writer writer1 = new Writer();
		writer1.setWriterName("Brandon");
		writer1.setWriterLastName("Sanderson");
		writer1.setWebsite("https://www.brandonsanderson.com");
		writer1.setPublisher("NOVA");
		writer1.setUpdatedUser(updatedUser);
		writer1.setUpdatedDate(updatedDate);

		final Writer writer2 = new Writer();
		writer2.setWriterName("Robert");
		writer2.setWriterLastName("Jordan");
		writer2.setWebsite("https://dragonmount.com");
		writer2.setPublisher("Minotauro");
		writer2.setUpdatedUser(updatedUser);
		writer2.setUpdatedDate(updatedDate);

		final Writer writer3 = new Writer();
		writer3.setWriterName("Robert");
		writer3.setWriterLastName("Anthony");
		writer3.setWebsite("http://rasalvatore.com");
		writer3.setPublisher("Timun Mas");
		writer3.setUpdatedUser(updatedUser);
		writer3.setUpdatedDate(updatedDate);

		final Writer writer4 = new Writer();
		writer4.setWriterName("Ken");
		writer4.setWriterLastName("Follet");
		writer4.setWebsite("https://ken-follett.com");
		writer4.setPublisher("PLAZA & JANES EDITORES");
		writer4.setUpdatedUser(updatedUser);
		writer4.setUpdatedDate(updatedDate);

		// Generación de sagas.
		final Series series1 = new Series();
		series1.setSeriesName("Mistborn");
		series1.setSeriesGenre("Action");
		series1.setNumberOfBooks(7);
		series1.setWriter(writer1);
		series1.setUpdatedUser(updatedUser);
		series1.setUpdatedDate(updatedDate);

		final Series series2 = new Series();
		series2.setSeriesName("Stormlight Archive");
		series2.setSeriesGenre("Epic Fantasy");
		series2.setNumberOfBooks(5);
		series2.setWriter(writer1);
		series2.setUpdatedUser(updatedUser);
		series2.setUpdatedDate(updatedDate);

		// Creacion de formato para las fechas
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		// Generacion de libros.
		final Book book1 = new Book();
		book1.setBookName("The Final Empire");
		String date1 = "2006-07-17";
		try {
			book1.setReleaseDate(formatDate(formatter, date1));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		book1.setBookPrice(12.30);
		book1.setSeries(series1);
		book1.setUpdatedUser(updatedUser);
		book1.setUpdatedDate(updatedDate);

		final Book book2 = new Book();
		book2.setBookName("The Well of Ascension");
		String date2 = "2007-08-21";
		try {
			book2.setReleaseDate(formatDate(formatter, date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book2.setBookPrice(12.50);
		book2.setSeries(series1);
		book2.setUpdatedUser(updatedUser);
		book2.setUpdatedDate(updatedDate);

		final Book book3 = new Book();
		book3.setBookName("The Hero of Ages");
		String date3 = "2008-10-14";
		try {
			book3.setReleaseDate(formatDate(formatter, date3));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book3.setBookPrice(13.50);
		book3.setSeries(series1);
		book3.setUpdatedUser(updatedUser);
		book3.setUpdatedDate(updatedDate);

		final Book book4 = new Book();
		book4.setBookName("Alloy of Law");
		String date4 = "2011-11-08";
		try {
			book4.setReleaseDate(formatDate(formatter, date4));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book4.setBookPrice(12.80);
		book4.setSeries(series1);
		book4.setUpdatedUser(updatedUser);
		book4.setUpdatedDate(updatedDate);

		final Book book5 = new Book();
		book5.setBookName("Shadows of Self");
		String date5 = "2015-10-06";
		try {
			book5.setReleaseDate(formatDate(formatter, date5));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book5.setBookPrice(13.90);
		book5.setSeries(series1);
		book5.setUpdatedUser(updatedUser);
		book5.setUpdatedDate(updatedDate);

		final Book book6 = new Book();
		book6.setBookName("Bands of Mourning");
		String date6 = "2016-01-26";
		try {
			book6.setReleaseDate(formatDate(formatter, date6));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book6.setBookPrice(13.90);
		book6.setSeries(series1);
		book6.setUpdatedUser(updatedUser);
		book6.setUpdatedDate(updatedDate);

		final Book book7 = new Book();
		book7.setBookName("The Lost Metal");
		String date7 = "2022-11-15";
		try {
			book7.setReleaseDate(formatDate(formatter, date7));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		book7.setBookPrice(15.50);
		book7.setSeries(series1);
		book7.setUpdatedUser(updatedUser);
		book7.setUpdatedDate(updatedDate);

		writerService.insertNewWriter(writer1);
		writerService.insertNewWriter(writer2);
		writerService.insertNewWriter(writer3);
		writerService.insertNewWriter(writer4);
		seriesService.insertNewSeries(series1);
		seriesService.insertNewSeries(series2);
		bookService.insertNewBook(book1);
		bookService.insertNewBook(book2);
		bookService.insertNewBook(book3);
		bookService.insertNewBook(book4);
		bookService.insertNewBook(book5);
		bookService.insertNewBook(book6);
		bookService.insertNewBook(book7);

		// Consultas
//		List<Writer> writersList = writerService.searchByName("ob");
//		for (final Writer writer : writersList) {
//			writerInfo(writer);
//		}
//
//		List<Series> seriesList = seriesService.searchAll();
//		for (final Series series : seriesList) {
//			seriesInfo(series);
//		}
//
//		List<Series> seriesListMoreThan5Bbooks = seriesService.searchByMoreBooks(5);
//		for (final Series series : seriesListMoreThan5Bbooks) {
//			seriesInfo(series);
//		}

		List<Series> seriesMist = seriesService.searchByName("Mist");
		for (final Series series : seriesMist) {
			seriesInfo(series);
		}

//		List<Book> bookList = bookService.searchAll();
//		for (final Book book : bookList) {
//			bookInfo(book);
//		}

		// Cierre de sesión.
		session.close();
	}

	private static Date formatDate(SimpleDateFormat formatter, String dateString) throws ParseException {
		return formatter.parse(dateString);
	}

	private static void writerInfo(final Writer writer) {
		System.out.println("Nombre: " + writer.getWriterName() + " " + writer.getWriterLastName() + "\nPágina Web: "
				+ writer.getWebsite() + "\nEditorial: " + writer.getPublisher());
	}

	private static void seriesInfo(final Series series) {
		System.out.println("Nombre: " + series.getSeriesName() + "\nGénero: " + series.getSeriesGenre()
				+ "\nNúmero de libros: " + series.getNumberOfBooks() + "\nEscritor: "
				+ series.getWriter().getWriterName() + " " + series.getWriter().getWriterLastName());
	}

	private static void bookInfo(final Book book) {
		System.out.println("Titulo: " + book.getBookName() + "\nFecha: " + book.getReleaseDate() + "\nPrecio: "
				+ book.getBookPrice() + "\nSaga: " + book.getSeries().getSeriesName());
	}
}