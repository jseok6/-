package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.*;


public class join_event {
	
	Connection con=null;
	Statement stmt=null;
	LocalDateTime time=LocalDateTime.now();
	
	public void join(int num,String pass)
	{
		try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loading Success!!");
            
            
            String url = "jdbc:mysql://localhost/projec";
            String user = "root", pwd = "whdtjrsq124!"; 
            int password=Integer.parseInt(pass);
            Connection con = DriverManager.getConnection(url, user, pwd);
            System.out.println("DB 연결 성공!!");
            
            
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
            
            
      	    Statement stmt=con.createStatement();	  
            
         
            stmt.execute(sql);
            System.out.println("데이터 insert 성공!!");
           
	    if(stmt != null) 
	    	stmt.close();
	    if(con != null) 
	    	con.close();
            
        } 
		catch(ClassNotFoundException e) 
		{
			System.out.println("드라이버 로딩 실패!!");
			} 
		catch(SQLException e) 
		
		{
		e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		 
            
    }
	
}
