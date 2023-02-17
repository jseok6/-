package study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

class ManagerJoinDialog extends JDialog{ //매니저 회원가입창
	public ManagerJoinDialog(String title, boolean modal,ManagerLogin mLogin)
	{
		//다이얼로그 생성자 호출
		super(mLogin, title, modal);
		
		//다이얼로그 설정
		this.setTitle("FamilyStudyCafe_ManagerJoin");
		this.setBounds(100, 100, 500, 700);
		this.setLocationRelativeTo(mLogin);
		this.setResizable(false);
		
		//패널추가
		JPanel managerJoinPanel = new JPanel();
		managerJoinPanel.setLayout(null);
		this.setContentPane(managerJoinPanel);
		
        //Id라벨
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(idLabel);
        
        //Id텍스트필드
        
        //Pw라벨
        JLabel pwLabel = new JLabel("Password");
        pwLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(pwLabel);
        //Pw텍스트필드
        
        //Name라벨
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(nameLabel);
        //Name텍스트필드
        
        //Tel라벨
        JLabel telLabel = new JLabel("Tel");
        telLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(telLabel);
        //Tel텍스트필드
		
        //Email라벨
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(emailLabel);
        //Email텍스트필드
        
		//회원가입버튼
        JButton questDeleteBtn = new JButton("삭제");
        questDeleteBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        questDeleteBtn.setBackground(Color.RED);
        questDeleteBtn.setFocusPainted(false);
        questDeleteBtn.setBounds
        (emailLabel.getX(), emailLabel.getY()-20,80, 30);
        questDeleteBtn.addMouseListener(new MouseInputAdapter() {
		//버튼을 누르면 questLabel 삭제
            @Override
            public void mouseClicked(MouseEvent e) {
            	managerJoinPanel.remove(emailLabel); //삭제
            	managerJoinPanel.repaint(); //다시그리기
            }
        });
        managerJoinPanel.add(questDeleteBtn);   
	}
}

public class ManagerJoinEvent {
	
	Connection con=null;
	Statement stmt=null;
//	LocalDateTime time=LocalDateTime.now();
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	
	public void managerJoin(String Id,String Pw,String Name, String Tel, String Email)
	{
		DBconnect db = new DBconnect();
		String test = null;
//		int password=Integer.parseInt(pass);
        String sql = "INSERT INTO manager "
        		+ "("+Id+", "+Pw+", "+Name+", "+Tel+", "+Email+") VALUES";
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
	    	JOptionPane.showMessageDialog(null, "매니저 가입 완료");
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
