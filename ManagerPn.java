package study;

//�޴��� ����ȣ ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerPn {
	Connection con=null;
	String sql="SELECT manager_tel FROM manager WHERE manager_id=?";
	String sql2="SELECT manager_email FROM manager WHERE manager_id=?";

	//������ ��ȭ��ȣ�ҷ��ֱ�
	public String Manager_pn()
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String str=null;
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
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
	public String manager_email()
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String str=null;
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
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