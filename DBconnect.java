package study;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class DBconnect 
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
    
    public void conAccept() throws SQLException { //박유진 컴퓨터 연결수락
    Connection con =null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String str = null;
    String queryConnect1 = "create user 'root'@'113.198.238.94'identified by'1234';\r\n"
    		+ "grant all privileges on *.* to 'root'@'113.198.238.94';\r\n"
			+ "flush privileges;";
	try {
		con = DBconnect.getConnection();
		pstmt= con.prepareStatement(queryConnect1);
		rs = pstmt.executeQuery();
	} catch (Exception e) {

	}
	finally {
		if(rs!=null)
		{
			rs.close();
		}
		pstmt.close();
		con.close();
	}
}
    
    public void conAccept2() throws SQLException { //김종석 컴퓨터 연결수락
    Connection con =null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String str = null;
    String queryConnect2 = "create user 'root'@'113.198.238.109'identified by'1234';\r\n"
    		+ "grant all privileges on *.* to 'root'@'113.198.238.109';\r\n"
			+ "flush privileges;";
	try {
		con = DBconnect.getConnection();
		pstmt= con.prepareStatement(queryConnect2);
		rs = pstmt.executeQuery();
	} catch (Exception e) {

	}
	finally {
		if(rs!=null)
		{
			rs.close();
		}
		pstmt.close();
		con.close();
	}
}
    
    public void conAccept3() throws SQLException {//신기한 컴퓨터 연결수락
    Connection con =null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String str = null;
    String queryConnect3 = "create user 'root'@'113.198.238.111'identified by'1234';\r\n"
    		+ "grant all privileges on *.* to 'root'@'113.198.238.111';\r\n"
			+ "flush privileges;";
	try {
		con = DBconnect.getConnection();
		pstmt= con.prepareStatement(queryConnect3);
		rs = pstmt.executeQuery();
	} catch (Exception e) {

	}
	finally {
		if(rs!=null)
		{
			rs.close();
		}
		pstmt.close();
		con.close();
	}
}
}