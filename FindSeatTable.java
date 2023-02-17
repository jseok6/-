package study;

import java.awt.Color;
//의자정보(seat테이블) 가져오기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindSeatTable {
	Connection con=null;
	String fSNSql="SELECT seatNum FROM seat"; //의자번호 찾기
	//+where ...
	//String fSASql="SELECT seatAvail FROM seat";//의자 사용가능여부 찾기
	
	
	//의자번호확인
	public String findSeatNum()
	{
		DBconnect db = new DBconnect();
		Statement stmt = null;
		String str=null;
		try {
			stmt=db.con.createStatement();
			ResultSet rs = stmt.executeQuery(fSNSql);
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
	
	//의자상태확인
	public Integer seatAvail(int tempint)
	{
		DBconnect db=new DBconnect();
		Statement stmt=null;
		String stateStr="";
		Color seatColor= Color.BLACK;
		Integer stateInt=null;
		String fSASql="select seatAvail from seat where seatNum = "+ tempint;
		try {
			stmt=db.con.createStatement();
			ResultSet rs=stmt.executeQuery(fSASql);
			
			while(rs.next())
			{
				stateInt=rs.getInt("seatAvail");//괄호안에 컬럼명이 들어가야함
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return stateInt;
	}
	
}
