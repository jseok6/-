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
//			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
//			System.out.println("�����ͺ��̽� ���� ����:");
		} 
		catch (SQLException e) 
		{
			// TODO: handle exception
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("���̵� ����?");		
		} 
		
	}
	public static void main(String[] args) {
		new DBconnect();
	}

}