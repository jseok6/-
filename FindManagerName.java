package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//관리자 이름 가져오기
public class FindManagerName {
	public String managerName(String mid)
	{
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str=null;
		String queryFindManagerName = "select managerName from manager "
				+ "where managerId = ?";
		
		try {
			con=DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindManagerName);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
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
