package study;

import java.awt.Color;
//��������(seat���̺�) ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//USE(���)���̺� �˻�
public class FindUseTable {	
	
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
			con = DBConnect2.getConnection();
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
