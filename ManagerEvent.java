package study;

//메니저 폰번호 가져오기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerEvent {
	Connection con=null;
	String sql="SELECT managerTel FROM manager WHERE managerId=?";
	String sql2="SELECT managerEmail FROM manager WHERE managerId=?";

	//관리자 전화번호불러주기
	public String Manager_phone()
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
	//관리자 이메일 불러주기
	public String manager_email()
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String str=null;
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql2);
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
