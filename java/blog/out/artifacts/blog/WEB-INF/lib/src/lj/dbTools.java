package lj;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class dbTools {
    static DataSource dataSource;
    private static final String DB_URL="jdbc:mysql://150.158.141.30:3306/MyDB";
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="root";
    private static final String PASS="root";

    private static void init() throws Exception {
//        创建Properties对象，用于加载配置文件
        Properties pro = new Properties();
        //加载配置文件
        pro.load(dbTools.class.getResourceAsStream("druid.properties"));
//        获取数据库连接池对象
//        dataSource = new DruidDataSource();
        dataSource= DruidDataSourceFactory.createDataSource(pro);
//        获取statement,使用prepareStatement，防止sql注入
//        pstmt = conn.createStatement();
//        dataSource=new DruidDataSource();
//        dataSource.setUrl("jdbc:mysql://150.158.141.30:3306/MyDB");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
    }
    private static Connection getconn() throws Exception {
        if (dataSource==null){
            init();
            return dataSource.getConnection();
        }else
            return dataSource.getConnection();
    }
    public static void excute(String sql){
        try (Connection conn=getconn()){

            try(PreparedStatement statement= conn.prepareStatement(sql)){
                statement.execute(sql);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    public static User getUser(String sql){
        User user=new User();
        System.out.println(sql);
        try (Connection conn=getconn()){
            try(PreparedStatement statement= conn.prepareStatement(sql)){
                ResultSet rs=statement.executeQuery(sql);
                if (rs.next()){
                    user.setUsername(rs.getString("username"));
                    user.setPass(rs.getString("password"));
                    user.setIdentity(rs.getString("identity"));
                }else {
                    user.setIdentity("no");
                    user.setUsername("no");
                }
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public static List<Text> getText(String sql){
        List<Text> list=new ArrayList<Text>();
        try (Connection conn=getconn()){
            try(Statement statement= conn.createStatement()){
                ResultSet resultSet=statement.executeQuery(sql);
                while (resultSet.next()){
                    Text text=new Text();
                    text.setAuthor(resultSet.getString("author"));
                    text.setContent(resultSet.getString("content"));
                    text.setTitle(resultSet.getString("title"));
                    text.setType(resultSet.getString("type"));
                    text.setPics(resultSet.getString("pics"));
                    text.setId(Integer.parseInt(resultSet.getString("id")));
                    list.add(text);
                }
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
