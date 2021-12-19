package lj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbTools {
    private static final String DB_URL="jdbc:mysql://150.158.141.30:3306/forum";
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="root";
    private static final String PASS="root";

    public static void excute(String sql){
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection conn=DriverManager.getConnection(DB_URL,USER,PASS)){
                try(Statement statement= conn.createStatement()){
                    statement.execute(sql);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static User getUser(String sql){
        User user=new User();
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection conn=DriverManager.getConnection(DB_URL,USER,PASS)){
                try(Statement statement= conn.createStatement()){
                    ResultSet rs=statement.executeQuery(sql);
                    //System.out.println(rs.getString("identity"));
                    if (rs.next()){
                        user.setUsername(rs.getString("username"));
                        user.setPass(rs.getString("password"));
                        user.setIdentity(rs.getString("identity"));
                    }else {
                        user.setIdentity("no");
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static List<Text> getText(String sql){
        List<Text> list=new ArrayList<Text>();
        try {
            Class.forName(JDBC_DRIVER);
            try (Connection conn=DriverManager.getConnection(DB_URL,USER,PASS)){
                try(Statement statement= conn.createStatement()){
                    ResultSet resultSet=statement.executeQuery(sql);
                    while (resultSet.next()){
                        Text text=new Text();
                        text.setAuthor(resultSet.getString("author"));
                        text.setContent(resultSet.getString("content"));
                        text.setTitle(resultSet.getString("title"));
                        text.setType(resultSet.getString("type"));
                        text.setPics(resultSet.getString("pics"));
                        list.add(text);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
