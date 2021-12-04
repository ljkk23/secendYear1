package swu.lj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbUtils {
    public static void excute(String sql){
        Connection conn=null;
        Statement statement=null;
        //ResultSet rs=null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");
            statement=conn.createStatement();
            //String sql="select * from textbook";
            //rs=statement.executeQuery(sql);
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
    public static List<Book> getBooks(String sql){
        List<Book> books= new ArrayList<Book>();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                Book book=new Book();
                book.setAuthor(rs.getString("author"));
                book.setContent(rs.getString("content"));
                book.setId(rs.getInt("id"));
                book.setPrice(rs.getInt("price"));
                book.setTitle(rs.getString("title"));
                book.setType(rs.getString("type"));
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;


    }
}
