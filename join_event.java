package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.Date;

import javax.swing.JOptionPane;


public class join_event {
	
	Connection con=null;
	Statement stmt=null;
//	LocalDateTime time=LocalDateTime.now();
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	
	public void join(int num,String pass)
	{
		DBconnect db = new DBconnect();
		String test = null;
//		int password=Integer.parseInt(pass);
		
        String sql = "INSERT INTO member";
 	   sql += " VALUES (";
 	   sql +=num;
 	   sql +=","; 
 	   sql +="'";
 	   sql +=pass;
 	   sql +="'";
 	   sql +=",";
 	   sql +="'";
 	   sql +=time1;
 	   sql +="'";
 	   sql +=",";
 	   sql += "'000:00:00'";
 	   sql += ")";
		try {
            int count=0;
      	    Statement stmt=db.con.createStatement();	  
            stmt.execute(sql);
	    if(stmt != null) 
	    	stmt.close();
	    if(con != null) 
	    	con.close();
	    
	    count++;
	    if (count!=0)
	    {
	    	JOptionPane.showMessageDialog(null, "회원 가입 완료");
	    	Pay pay=new Pay();
        	pay.setVisible(true);
        	JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
	    }
            
        } 

		catch(SQLException e) 
		
		{
		e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		 
            
    }
	
}
