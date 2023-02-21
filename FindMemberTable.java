package study;

import java.awt.Color;
//의자정보(seat테이블) 가져오기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Member(회원)테이블 검색
public class FindMemberTable {	
	
//	//회원 전화번호 확인- 의자번호로 찾기
//	public String findMemberTel(int seatnum) throws SQLException
//	{
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String queryFindUse="select memberTel from `member`"
//				+ "where member = ?";
//		String usenumReturn=null;
//		
//		try
//		{
//			con = DBConnect2.getConnection();
//			pstmt=con.prepareStatement(queryFindUse);
//			pstmt.setInt(1, seatnum);
//			rs = pstmt.executeQuery();
//			if(rs.next()) //사용번호가 있으면
//			{
//				//회원전화번호 찾아와서 usenumReturn값으로 넣어주기
//				usenumReturn=rs.getString(1);
//			}
//			else
//			{
//				usenumReturn="0";
//			}
//		}
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		finally 
//		{
//			rs.close();
//			pstmt.close();
//			con.close();
//		}
//		return usenumReturn;
//	}
	
	//회원 남은시간 확인- 회원 전화번호로 찾기
	public String findRemainTime(String membertel) throws SQLException //매니저 이름 찾기
	{
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String remtime=null;
		String queryFindremTime = "select remainTime from member "
				+ "where memberTel = ?";

		try {
			con=DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindremTime);
			pstmt.setString(1, membertel);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				remtime = rs.getString("remainTime");
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
		return remtime;
	}
}
