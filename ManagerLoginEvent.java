package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//로그인이벤트
public class ManagerLoginEvent {

	public int managerLogin(String id, String pw) {
		DBconnect db = new DBconnect();
		Connection con = null;
		Statement stmt = null;
		String test = null;

		String queryManagerLogin = "select managerPw  from manager "
				+ "where managerId = '"+id+"'";
		try {
			
			//로그인
			stmt=db.con.createStatement();
			ResultSet rs = stmt.executeQuery(queryManagerLogin);
			while(rs.next()){
				test = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		if(pw.equals(test)){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		new ManagerLoginEvent();
	}

}
