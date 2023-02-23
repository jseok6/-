package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;


//로그인이벤트
public class UserLoginEvent {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	//로그인
	public int userLogin(String memberTel, String memberPw) {
		String test = null;
		
		String queryLogin = "select memberPw from member where memberTel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
//			String str=Integer.toString(memberTel);
			pstmt.setString(1, memberTel);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				test = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("잘못입력");
			e.printStackTrace();	
		}
		if(memberPw.equals(test)){
			return 1;
		}else{
			return 0;
		}
	
	}
	
	

	//가입
	public void userJoin(String num,String pass)
	{	
        String sql = "INSERT INTO member VALUES (?,?,?,?)";
		try {
 
            con=DBconnect.getConnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, num);
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
	    	JOptionPane.showMessageDialog(null, "회원 가입 완료");
	    	Pay pay=new Pay(num);
        	pay.setVisible(true);
        	JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
	    }
	    else {
	    	JOptionPane.showMessageDialog(null, "회원 가입 실패");
	    }
            
        } 

		catch(SQLException e) 
		
		{
		e.printStackTrace();
		}
		
	}
	
	public Time userRemain(String id) {
		Time test=new Time(0);
		//시간
		String queryLogin = "select remainTime  from member where memberTel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				test = rs.getTime(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("잘못입력");
			e.printStackTrace();	
		}
		return test;
	
	}
	
	public void remainTimeplus(String id)
	{
		//날짜형식 String으로 변환하기위한 포맷
		DateFormat format = new SimpleDateFormat("HHH:MM:SS");
		Time test=new Time(0);

		String remaintime2 = "Update member SET remainTime='";
		String remaintime3="'WHERE memberTel=?";
		String remaintime1 = "select remainTime  from member where memberTel = ?";
		try {
			//연결및 남은시간가져오기
			con=DBconnect.getConnection();
			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				test=rs.getTime(1);
			}
			System.out.println("time:"+test);
			//추가
			System.out.println("시간추가1");
			System.out.println(test);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(test); 
			cal1.add(Calendar.HOUR_OF_DAY, 3); // 시간 연산
			
			String qwe=format.format(cal1.getTime());
			System.out.println(cal1);
			remaintime2=remaintime2+qwe;
			System.out.println(remaintime2);
			remaintime2=remaintime2+remaintime3;
			
			pstmt=con.prepareStatement(remaintime2);
			System.out.println("시간추가2");
			pstmt.setString(1, id);
			
			System.out.println(remaintime2);
			int result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
	}

}