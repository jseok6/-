package study;

//��������(seat���̺�) ��������
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//USE(���)���̺� �˻�
public class FindUseTable {	
	
	//������� Insert
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
	
	//����ȣ Ȯ��- ���ڹ�ȣ�� ã��
	public String findUse(int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null, rs2 = null;
		String queryFindUse="select useNum from `use` "
				+ "where seatNum = ?"; //����ȣ Ȯ��
		String usenumReturn=null;
		
		String queryFindmemberTel="select memberTel from `use` "
				+ "where seatNum = ?"; //�����ȭ��ȣ Ȯ��
		String memberTel = null;
		
		try
		{
			con = DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindUse);
			pstmt.setInt(1, seatnum);
			rs = pstmt.executeQuery();
			if(rs.next()) //����ȣ�� ������
			{
				pstmt=con.prepareStatement(queryFindmemberTel);
				pstmt.setInt(1, seatnum);
				rs2 = pstmt.executeQuery();
				//ȸ����ȭ��ȣ ã�ƿͼ� ����
				if(rs2.next()) {					
					usenumReturn=rs2.getString(1);
				}
			}
			else //����ȣ�� ������
			{
				usenumReturn="0"; //0 ����
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