package study;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.*;



public class Pay_charge {
	
	Connection con=null;
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
//	SimpleDateFormat newDtFormat = new SimpleDateFormat("HHH-MM-SS");
	String sql="SELECT payment FROM charge WHERE charge_time='";
	
	//첫번째가격
	public String Pay_charge1()
	{
		
		DBconnect db = new DBconnect();
//		String strNewDtFormat = newDtFormat.format(num1_1);
		
		sql+=num1_1;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try 
		{
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	
	
	
	
	public String Pay_charge2()
	{
		DBconnect db = new DBconnect();
		sql+=num1_2;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge3()
	{
		DBconnect db = new DBconnect();
		sql+=num1_3;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge4()
	{
		DBconnect db = new DBconnect();
		sql+=num1_4;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge5()
	{
		DBconnect db = new DBconnect();
		sql+=num1_5;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge6()
	{
		DBconnect db = new DBconnect();
		sql+=num1_6;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge2_1()
	{
		DBconnect db = new DBconnect();
		sql+=num2_1;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge2_2()
	{
		DBconnect db = new DBconnect();
		sql+=num2_2;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge2_3()
	{
		DBconnect db = new DBconnect();
		sql+=num2_3;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge2_4()
	{
		DBconnect db = new DBconnect();
		sql+=num2_4;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge2_5()
	{
		DBconnect db = new DBconnect();
		sql+=num2_5;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	public String Pay_charge2_6()
	{
		DBconnect db = new DBconnect();
		sql+=num2_6;
		sql+="'";
		Statement stmt = null;
		String str=null;
		
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
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
	
	
}
