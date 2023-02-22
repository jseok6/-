package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


//�α����̺�Ʈ
public class UserLoginEvent {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	//�α���
	public int userLogin(int memberTel, String memberPw) {
		String test = null;
		
		String queryLogin = "select memberPw from member where memberTel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
			String str=Integer.toString(memberTel);
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
		if(memberPw.equals(test)){
			return 1;
		}else{
			return 0;
		}
	
	}
	
	

	//����
	public void userJoin(int num,String pass)
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
	
	public Time userRemain() {
		Time test=new Time(1);
		//�α���
		String queryLogin = "select remainTime  from member where memberTel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
			String str=Integer.toString(1234);
			pstmt.setString(1, str);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				test = rs.getTime(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("�߸��Է�");
			e.printStackTrace();	
		}
		return test;
	
	}
	
	public static void main(String[] args) {
		new UserLoginEvent();
	}

}
