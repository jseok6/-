package study;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DBconnect 
{
    public static Connection getConnection() {
        Connection con = null;
        int db_portnumber = 3306;
        String db_hostname = "localhost";
        String urlFormat = "jdbc:mysql://localhost/study";
        String id = "root";
        String pw = "whdtjrsq124!";
//        String url=String.format(urlFormat, db_hostname,db_portn)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(urlFormat, id, pw);
            return con;
        } catch (Exception e) {
        	 System.out.println("연결오류 : " + e.toString());
        }
        return null;	
    }
}
