package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBconnect {

	Connection con = null;
	public DBconnect() {
		String url = "jdbc:mysql://localhost/projec";
		String id = "root";
		String password = "whdtjrsq124!";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
//			System.out.println("데이터베이스 연결 성공:");
		} 
		catch (SQLException e) 
		{
			// TODO: handle exception
			System.out.println("연결에 실패하였습니다.");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("아이디 뭐지?");		
		} 
		
	}
	public static void main(String[] args) {
		new DBconnect();
	}

}