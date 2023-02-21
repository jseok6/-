package study;

import java.awt.Color;
//의자정보(seat테이블) 가져오기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindSeatTable {	
	//의자번호확인
	public String findSeatNum() throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryFindSeatNum="SELECT seatNum FROM seat"; //의자번호 찾기
		String str=null;
		try {
			con = DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindSeatNum);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	//의자상태확인
	public Integer seatAvail(int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Integer stateInt=null;
		String queryFindSeatAvail="select seatAvail from seat "
				+ "where seatNum = ?";
		
		try {
			con = DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindSeatAvail);
			pstmt.setInt(1, seatnum);
			 rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				stateInt=rs.getInt("seatAvail");//괄호안에 컬럼명이 들어가야함
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		return stateInt;
	}
	
}
