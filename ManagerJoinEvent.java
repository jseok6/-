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

class ManagerJoinDialog extends JDialog{ //�Ŵ��� ȸ������â
	public ManagerJoinDialog(String title, boolean modal,ManagerLogin mLogin)
	{
		//���̾�α� ������ ȣ��
		super(mLogin, title, modal);
		
		//���̾�α� ����
		this.setTitle("FamilyStudyCafe_ManagerJoin");
		this.setBounds(100, 100, 500, 700);
		this.setLocationRelativeTo(mLogin);
		this.setResizable(false);
		
		//�г��߰�
		JPanel managerJoinPanel = new JPanel();
		managerJoinPanel.setLayout(null);
		this.setContentPane(managerJoinPanel);
		
        //Id��
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(idLabel);
        
        //Id�ؽ�Ʈ�ʵ�
        
        //Pw��
        JLabel pwLabel = new JLabel("Password");
        pwLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(pwLabel);
        //Pw�ؽ�Ʈ�ʵ�
        
        //Name��
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(nameLabel);
        //Name�ؽ�Ʈ�ʵ�
        
        //Tel��
        JLabel telLabel = new JLabel("Tel");
        telLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(telLabel);
        //Tel�ؽ�Ʈ�ʵ�
		
        //Email��
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(0, 100, 100, 50);
        managerJoinPanel.add(emailLabel);
        //Email�ؽ�Ʈ�ʵ�
        
		//ȸ�����Թ�ư
        JButton questDeleteBtn = new JButton("����");
        questDeleteBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        questDeleteBtn.setBackground(Color.RED);
        questDeleteBtn.setFocusPainted(false);
        questDeleteBtn.setBounds
        (emailLabel.getX(), emailLabel.getY()-20,80, 30);
        questDeleteBtn.addMouseListener(new MouseInputAdapter() {
		//��ư�� ������ questLabel ����
            @Override
            public void mouseClicked(MouseEvent e) {
            	managerJoinPanel.remove(emailLabel); //����
            	managerJoinPanel.repaint(); //�ٽñ׸���
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
	    	JOptionPane.showMessageDialog(null, "�Ŵ��� ���� �Ϸ�");
	    	Pay pay=new Pay();
        	pay.setVisible(true);
        	JOptionPane.showMessageDialog(null, "�α����� ȯ���մϴ�.");
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
