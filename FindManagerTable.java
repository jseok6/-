package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Manager(관리자) 테이블 검색
public class FindManagerTable {
	public String managerName(String mid) throws SQLException //매니저 이름 찾기
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
		finally 
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		return str;
	}
}
