package study;

//�޴��� ����ȣ ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class manager_pn {
	Connection con=null;
	String sql="SELECT manager_tel FROM manager";
	String sql2="SELECT manager_email FROM manager";

	//������ ��ȭ��ȣ�ҷ��ֱ�
	public String manager_pn()
	{
		DBconnect db = new DBconnect();
		Statement stmt = null;
		String str=null;
		try {
			stmt=db.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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
		DBconnect db=new DBconnect();
		Statement stmt=null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql2);
			
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
