package study;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DBConnect2 
{
    public static Connection getConnection() {
        Connection con = null;
    	String url = "jdbc:mysql://localhost:3306/familystudycafe";
		String id = "root";
		String password = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, password);
            return con;
        } catch (Exception e) {
            System.out.println("연결오류 :" + e.toString());
        }
        return null;
    }
}
