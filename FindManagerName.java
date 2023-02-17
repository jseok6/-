package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindManagerName {//관리자 이름 가져오기
	public String managerName(String mid)
	{
		DBconnect db = new DBconnect();
		Connection con=null;
		Statement stmt = null;
		String str=null;
		String sql = "select managerName from manager where managerId = '"+ mid +"'";
		try {
			stmt=db.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				str = rs.getString("managerName");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
}
