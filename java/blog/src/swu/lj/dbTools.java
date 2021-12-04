package swu.lj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

}
