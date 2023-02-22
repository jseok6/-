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
	
<<<<<<< HEAD
	//½Ã°£±Ç°¡°Ý
	public String pay1()
=======
	//ì‹œê°„ê¶Œê°€ê²©
	public String Pay_charge1()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
	
	
	
	
	
<<<<<<< HEAD
	public String pay2()
=======
	public String Pay_charge2()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String pay3()
=======
	public String Pay_charge3()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String pay4()
=======
	public String Pay_charge4()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String pay5()
=======
	public String Pay_charge5()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String pay6()
=======
	public String Pay_charge6()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
<<<<<<< HEAD
	//±â°£±Ç °¡°Ý
	public String payPeriod1()
=======
	//ê¸°ê°„ê¶Œ ê°€ê²©
	public String Pay_charge2_1()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String payPeriod2()
=======
	public String Pay_charge2_2()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String payPeriod3()
=======
	public String Pay_charge2_3()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String payPeriod4()
=======
	public String Pay_charge2_4()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String payPeriod5()
=======
	public String Pay_charge2_5()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
<<<<<<< HEAD
	public String payPeriod6()
=======
	public String Pay_charge2_6()
>>>>>>> cb5399a3cbe245dcec10526c45c239495a213359
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
			// TODO: handle exception
		}
		
		return str;
	}
	
	
}
