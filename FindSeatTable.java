package study;

import java.awt.Color;
//��������(seat���̺�) ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindSeatTable {
	Connection con=null;
	String fSNSql="SELECT seatNum FROM seat"; //���ڹ�ȣ ã��
	//+where ...
	//String fSASql="SELECT seatAvail FROM seat";//���� ��밡�ɿ��� ã��
	
	
	//���ڹ�ȣȮ��
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
	
	//���ڻ���Ȯ��
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
				stateInt=rs.getInt("seatAvail");//��ȣ�ȿ� �÷����� ������
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return stateInt;
	}
	
}
