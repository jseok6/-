package study;

import java.text.SimpleDateFormat;
import java.sql.*;



public class PayEvent {
	
	Connection con=null;
	PreparedStatement pstmt=null;
	
	String sql="SELECT payment FROM charge WHERE chargeNum=?";
	String sql2="SELECT payName FROM charge WHERE chargeNum=?";
	String str=null;
	String str1="'";
	
	public String pay(String num)
	{
		try 
		{
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return str;
	}
	public String payName(String num)
	{
		try 
		{
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return str;
	}
	
}
	
	
	
	
	
	