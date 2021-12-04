package cn.edu.swu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String DB_URL    = "jdbc:mysql://172.18.5.74:3306/books";
	private static String DB_USER   = "root";
	private static String DB_PASS   = "qwer1234";
	
	public static void insert(String sql) throws SQLException {
		excute(sql);
	}
	
	public static void delete(String sql) throws SQLException {
		excute(sql);
	}
	
	public static void update(String sql) throws SQLException {
		excute(sql);
	}
		
	private static void excute(String sql) throws SQLException {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			try (Statement statement = connection.createStatement()) {
				statement.execute(sql);
			}
		}
	}
	
	public static List<Book> getBooks(String sql) throws SQLException {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Book> books = new ArrayList<Book>();
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			try (Statement statement = connection.createStatement()) {
				ResultSet rs = statement.executeQuery(sql);				
				while (rs.next()) {
					Book book = new Book();
					book.setId(rs.getInt("id"));
					book.setName(rs.getString("name"));
					book.setAuthor(rs.getString("author"));
					book.setType(rs.getString("type"));
					book.setPrice(rs.getInt("price"));
					book.setDescribe(rs.getString("describe"));
					book.setPics(rs.getString("pics"));
					books.add(book);
				}
			}
		}
		
		return books;
	}

}
