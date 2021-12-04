package swu.lj.jdbc;

import java.sql.*;

public class jdbcText01 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");
            statement=conn.createStatement();
            String sql="select * from textbook";
            rs=statement.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String author=rs.getString("author");
                System.out.println(id+","+title+","+author);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
}
