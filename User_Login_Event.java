package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


//�α����̺�Ʈ
public class User_Login_Event {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	
	public int sql_run(int member_tel, String member_pw) {
		String test = null;
		//�α���
		String queryLogin = "select member_pw  from member where member_tel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
			String str=Integer.toString(member_tel);
			pstmt.setString(1, str);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				test = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("�߸��Է�");
			e.printStackTrace();	
		}
		if(member_pw.equals(test)){
			return 1;
		}else{
			return 0;
		}
	
	}
	public static void main(String[] args) {
		new User_Login_Event();
	}
	

	//����
	public void join(int num,String pass)
	{	
        String sql = "INSERT INTO member VALUES (?,?,?,?)";
		try {
 
            con=DBconnect.getConnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setString(2, pass);
            pstmt.setString(3, time1);
            pstmt.setString(4, "000:00:00");
            int rs = pstmt.executeUpdate();

	    if(pstmt != null) 
	    	pstmt.close();
	    if(con != null) 
	    	con.close();
	    
	    if (rs==1)
	    {
	    	JOptionPane.showMessageDialog(null, "ȸ�� ���� �Ϸ�");
	    	Pay pay=new Pay();
        	pay.setVisible(true);
        	JOptionPane.showMessageDialog(null, "�α����� ȯ���մϴ�.");
	    }
	    else {
	    	JOptionPane.showMessageDialog(null, "ȸ�� ���� ����");
	    }
            
        } 

		catch(SQLException e) 
		
		{
		e.printStackTrace();
		}
		
	}

}
