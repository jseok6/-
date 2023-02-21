package study;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DBconnect 
{
    public static Connection getConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/projec";
        String id = "root";
        String pw = "whdtjrsq124!";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, pw);
            return con;
        } catch (Exception e) {
            System.out.println("오류 : " + e.toString());
        }
        return null;	
    }
}
