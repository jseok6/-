package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.*;

import javax.swing.JOptionPane;


public class join_event {
	
	Connection con=null;
	Statement stmt=null;
	LocalDateTime time=LocalDateTime.now();
	
	public void join(int num,String pass)
	{
		DBconnect db = new DBconnect();
		String test = null;
		int password=Integer.parseInt(pass);
		
        String sql = "INSERT INTO member";
 	   sql += " VALUES (";
 	   sql +=num;
 	   sql +=","; 
 	   sql +=password;
 	   sql +=",";
 	   sql +="'1234'";
 	   sql +=",";
 	   sql += "'0000-12-12'";
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
