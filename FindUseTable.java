package study;

//의자정보(seat테이블) 가져오기
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//USE(사용)테이블 검색
public class FindUseTable {	
	
	//사용정보 Insert
	public void insertUse(String checkintime
			, String membertel, int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String queryinsertUse="insert into `Use` "
				+ "VALUES(null, ?, null, ?, ?, null)";
		try 
		{
			con = DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryinsertUse);
			
			pstmt.setString(1, checkintime);
			pstmt.setString(2, membertel);
			pstmt.setInt(3, seatnum);
			
			pstmt.executeUpdate();
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
		return;
	}
	
	//사용번호 확인- 의자번호로 찾기
	public String findUse(int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null, rs2 = null;
		String queryFindUse="select useNum from `use` "
				+ "where seatNum = ?"; //사용번호 확인
		String usenumReturn=null;
		
		String queryFindmemberTel="select memberTel from `use` "
				+ "where seatNum = ?"; //멤버전화번호 확인
		String memberTel = null;
		
		try
		{
			con = DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindUse);
			pstmt.setInt(1, seatnum);
			rs = pstmt.executeQuery();
			if(rs.next()) //사용번호가 있으면
			{
				pstmt=con.prepareStatement(queryFindmemberTel);
				pstmt.setInt(1, seatnum);
				rs2 = pstmt.executeQuery();
				//회원전화번호 찾아와서 리턴
				if(rs2.next()) {					
					usenumReturn=rs2.getString(1);
				}
			}
			else //사용번호가 없으면
			{
				usenumReturn="0"; //0 리턴
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
