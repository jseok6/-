package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class log_event {

	Connection con = null;
	Statement stmt = null;
		
	public int sql_run(int num, String name) {
		DBconnect db = new DBconnect();
		String test = null;

		String queryIdCheck="SELECT count(*) cnt FROM member WHERE id=?";
		String queryLogin = "select member_pw  from member where member_tel = '"+num+"'";
		try {
			
			
			//·Î±×ÀÎ
			stmt=db.con.createStatement();
			ResultSet rs = stmt.executeQuery(queryLogin);
			while(rs.next()){
				test = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();	
		}
		if(name.equals(test)){
			return 1;
		}else{
			return 0;
		}
	
	}
	public static void main(String[] args) {
		new log_event();
	}

}
