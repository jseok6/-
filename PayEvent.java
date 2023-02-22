package study;

import java.text.SimpleDateFormat;
import java.sql.*;



public class PayEvent {
	
	Connection con=null;
	PreparedStatement pstmt=null;
	String num1_1="0010000";
	String num1_2="0020000";
	String num1_3="0040000";
	String num1_4="0060000";
	String num1_5="0080000";
	String num1_6="0120000";
	
	String num2_1="0240000";
	String num2_2="0720000";
	String num2_3="1680000";
	String num2_4="2400000";
	String num2_5="3600000";
	String num2_6="7200000";
	
	String sql="SELECT payment FROM charge WHERE chargeTime=?";
	String str=null;
	
	//시간권가격
	public String payCharge1()
	{
		try 
		{
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_1);
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
	
	
	
	
	
	public String payCharge2()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge3()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_3);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge4()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge5()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_5);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge6()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_6);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
		
		}
		
		return str;
	}
	//기간권 가격
	public String payCharge2_1()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_1);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge2_2()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{

		}
		
		return str;
	}
	
	public String payCharge2_3()
	{	
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_3);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}	
		return str;
	}
	
	public String payCharge2_4()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge2_5()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_5);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}
		} 
		catch (Exception e)
		{
			
		}
		
		return str;
	}
	
	public String payCharge2_6()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_6);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}
			pstmt.close();
		} 
		catch (Exception e)
		{
			
		}
		return str;
	}
}