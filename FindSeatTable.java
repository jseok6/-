package study;

import java.awt.Color;
//��������(seat���̺�) ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindSeatTable {	
	//���ڹ�ȣȮ��
	public String findSeatNum()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryFindSeatNum="SELECT seatNum FROM seat"; //���ڹ�ȣ ã��
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

		return str;
	}
	
	//���ڻ���Ȯ��
	public Integer seatAvail(int seatnum)
	{
		Connection con = null;
		PreparedStatement pstmt=null;
		Integer stateInt=null;
		String queryFindSeatAvail="select seatAvail from seat "
				+ "where seatNum = ?";
		
		try {
			con = DBConnect2.getConnection();
			pstmt=con.prepareStatement(queryFindSeatAvail);
			pstmt.setInt(1, seatnum);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				stateInt=rs.getInt("seatAvail");//��ȣ�ȿ� �÷����� ������
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return stateInt;
	}
	
}
