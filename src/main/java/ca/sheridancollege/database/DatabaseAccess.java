package ca.sheridancollege.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Book;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void addBook(Book book) {

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO BOOK (title, author, price, invQuant, courses, store)"
				+ " VALUES (:title, :author, :price, :invQuant, :courses, :store)";
		parameters.addValue("title", book.getTitle());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("price", book.getPrice());
		parameters.addValue("invQuant", book.getInvQuant());
		parameters.addValue("courses", book.getCourses());
		parameters.addValue("store", book.getStore());
		jdbc.update(query, parameters);

	}

	public  ArrayList<Book> getBook(){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK";
		List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String, Object>());
		for(Map<String, Object> row: rows) {
			Book book = new Book();
			book.setId((Integer)row.get("id"));
			book.setTitle((String)row.get("title")); 
			book.setAuthor((String)row.get("author"));
			book.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			book.setInvQuant((Integer)row.get("invQuant"));
			book.setCourses((String)row.get("courses"));
			book.setStore((String)row.get("store"));
			books.add(book);
		}
		return books;
	}

	public  Book getBookById(int id){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK WHERE id=:id";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);

		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) {
			Book b = new Book();
			b.setId((Integer)row.get("id"));
			b.setTitle((String)row.get("title")); 
			b.setAuthor((String)row.get("author"));
			b.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			b.setInvQuant((Integer)(row.get("invQuant")));
			b.setCourses((String)row.get("courses"));
			b.setStore((String)row.get("store"));
			books.add(b);
		}
		if (books.size()>0)
			return books.get(0);
		return null;
	}

	public void editBook(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE BOOK SET title=:title, author=:author, price=:price,"
				+ " invQuant=:invQuant, courses=:courses, store=:store  WHERE id=:id";
		parameters.addValue("id", book.getId());
		parameters.addValue("title", book.getTitle());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("price", book.getPrice());
		parameters.addValue("invQuant", book.getInvQuant());
		parameters.addValue("courses", book.getCourses());
		parameters.addValue("store", book.getStore());
		jdbc.update(query, parameters);
	}

	public  ArrayList<Book> searchBookByTitle(String title){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK WHERE title=:title"; 
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("title", title);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) {
			Book b = new Book();
			b.setId((Integer)row.get("id"));
			b.setTitle((String)row.get("title")); 
			b.setAuthor((String)row.get("author"));
			b.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			b.setInvQuant((Integer)(row.get("invQuant")));
			b.setCourses((String)row.get("courses"));
			b.setStore((String)row.get("store"));
			books.add(b);
		}
		return books;
	}

	public  ArrayList<Book> searchBookByAuthor(String author){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK WHERE author=:author"; 
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("author", author);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) {
			Book b = new Book();
			b.setId((Integer)row.get("id"));
			b.setTitle((String)row.get("title")); 
			b.setAuthor((String)row.get("author"));
			b.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			b.setInvQuant((Integer)(row.get("invQuant")));
			b.setCourses((String)row.get("courses"));
			b.setStore((String)row.get("store"));
			books.add(b);
		}
		return books;
	}

	public  ArrayList<Book> searchBookById(int id){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK WHERE id=:id"; 
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) {
			Book b = new Book();
			b.setId((Integer)row.get("id"));
			b.setTitle((String)row.get("title")); 
			b.setAuthor((String)row.get("author"));
			b.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			b.setInvQuant((Integer)(row.get("invQuant")));
			b.setCourses((String)row.get("courses"));
			b.setStore((String)row.get("store"));
			books.add(b);
		}
		return books;
	}
	public  ArrayList<Book> searchBookByQ(double invQuant){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK WHERE invQuan BETWEEN :invQuant1 AND :invQuant2"; 
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) {
			Book b = new Book();
			b.setId((Integer)row.get("id"));
			b.setTitle((String)row.get("title")); 
			b.setAuthor((String)row.get("author"));
			b.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			b.setInvQuant((Integer)(row.get("invQuant")));
			b.setCourses((String)row.get("courses"));
			b.setStore((String)row.get("store"));
			books.add(b);
		}
		return books;
	}
	public  ArrayList<Book> searchBookByCourses(String courses){
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK WHERE courses=:courses"; 
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("courses", courses);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) {
			Book b = new Book();
			b.setId((Integer)row.get("id"));
			b.setTitle((String)row.get("title")); 
			b.setAuthor((String)row.get("author"));
			b.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			b.setInvQuant((Integer)(row.get("invQuant")));
			b.setCourses((String)row.get("courses"));
			b.setStore((String)row.get("store"));
			books.add(b);
		}
		return books;
	}
	public void deleteBook(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM BOOK WHERE id=:id";
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}

	public void purchaseBook(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		String query = "UPDATE BOOK SET invQuant=:invQuant-1  WHERE id=:id";
		parameters.addValue("id", book.getId());
		parameters.addValue("title", book.getTitle());
		parameters.addValue("author", book.getAuthor());
		parameters.addValue("price", book.getPrice());
		parameters.addValue("invQuant", book.getInvQuant());
		parameters.addValue("courses", book.getCourses());
		parameters.addValue("store", book.getStore());
			
		jdbc.update(query, parameters);
	}
	
	

}













































































