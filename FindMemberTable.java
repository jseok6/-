package study;

import java.awt.Color;
//��������(seat���̺�) ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Member(ȸ��)���̺� �˻�
public class FindMemberTable {	
	
	//ȸ�� ��ȭ��ȣ Ȯ��- ���ڹ�ȣ�� ã��
	public String findMemberTel(int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryFindUse="select memberTel from `member`"
				+ "where member = ?";
		String usenumReturn=null;
		
		try
		{
			con = DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindUse);
			pstmt.setInt(1, seatnum);
			rs = pstmt.executeQuery();
			if(rs.next()) //����ȣ�� ������
			{
				//ȸ����ȭ��ȣ ã�ƿͼ� usenumReturn������ �־��ֱ�
				usenumReturn=rs.getString(1);
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
			pstmt.close();
			con.close();
		}
		return usenumReturn;
	}
}
