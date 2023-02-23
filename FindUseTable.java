package study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//USE(사용)테이블 검색
public class FindUseTable {	
	
	//새로운 USE데이터 Insert
	public void insertUse(String checkintime
			, String membertel, int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String queryinsertUse="insert into `Use` "
				+ "VALUES(null, ?, null, ?, ?, null)";
		FindSeatTable fst = new FindSeatTable();
		try 
		{
			con = DBconnect.getConnection();
			pstmt=con.prepareStatement(queryinsertUse);
			
			pstmt.setString(1, checkintime);
			pstmt.setString(2, membertel);
			pstmt.setInt(3, seatnum);
			
			pstmt.executeUpdate();
			fst.seatUpdate(seatnum, 1);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			pstmt.close();
			con.close();
		}
		//return;
	}
	
	//의자번호로 사용번호 찾기
	public String findUse(int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null, rs2 = null;
		String queryFindUse="select useNum from `use` "
				+ "where seatNum = ?";
		String usenumReturn=null;
		
		String queryFindmemberTel="select memberTel from `use` "
				+ "where seatNum = ?";
		String memberTel = null;
		
		try
		{
			con = DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindUse);
			pstmt.setInt(1, seatnum);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				pstmt=con.prepareStatement(queryFindmemberTel);
				pstmt.setInt(1, seatnum);
				rs2 = pstmt.executeQuery();
				if(rs2.next()) {					
					usenumReturn=rs2.getString(1);
				}
			}
			else
			{
				usenumReturn="0";
			}
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace();
		} 
		finally 
		{
			rs.close();
			if(rs2!=null)
			{
				rs2.close();
			}
			pstmt.close();
			con.close();
		}
		return usenumReturn;
	}
}