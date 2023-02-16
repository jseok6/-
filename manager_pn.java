package study;

//메니저 폰번호 가져오기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class manager_pn {
	Connection con=null;
	String sql="SELECT manager_tel FROM manager";

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

}
