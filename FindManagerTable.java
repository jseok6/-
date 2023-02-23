package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Manager(������) ���̺� �˻�
public class FindManagerTable {
	
	public String managerName(String mid) throws SQLException //�Ŵ��� �̸� ã��
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
	
	//������ ��ȭ��ȣ�ҷ��ֱ�
		public String managerPn()
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			String queryFindmanagerPn="SELECT managerTel FROM manager WHERE managerId=?";
			String str=null;
			try {
				con=DBconnect.getConnection();
				pstmt = con.prepareStatement(queryFindmanagerPn);
				pstmt.setString(1,"jseok1");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					str=rs.getString(1);
				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return str;
		}
		
		//������ �̸��� �ҷ��ֱ�
		public String managerEmail()
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			String queryFindmanagerEmail="SELECT managerEmail "
					+ "FROM manager WHERE managerId=?";
			String str=null;
			
			try {
				con=DBconnect.getConnection();
				pstmt = con.prepareStatement(queryFindmanagerEmail);
				pstmt.setString(1,"jseok1");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					str=rs.getString(1);
				}

			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
}