package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//로그인이벤트
public class log_event {

	Connection con = null;
	Statement stmt = null;
		
	public int sql_run(int member_tel, String member_pw) {
		DBconnect db = new DBconnect();
		String test = null;

		//로그인
		String queryLogin = "select member_pw  from member where member_tel = '"+member_tel+"'";
		try {
			
			

			stmt=db.con.createStatement();
			ResultSet rs = stmt.executeQuery(queryLogin);
			while(rs.next()){
				test = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();	
		}
		if(member_pw.equals(test)){
			return 1;
		}else{
			return 0;
		}
	
	}
	public static void main(String[] args) {
		new log_event();
	}

}
