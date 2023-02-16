package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;


public class UserMainUI extends JFrame {
	
	private JLabel RemainTime;
	private JLabel notification;
	private JLabel ManagerPhone;
	private JLabel ManagerNumber;
	private JLabel ManagerEmail;
	private JLabel picture;
	private JLabel quest;
	private JButton addpay;
	private JButton exit;

	private JButton answerButton;//댭변버튼
	private JButton questButton;//질문버튼

	
	
	
	public UserMainUI() {
        setTitle("UserMain");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
        UserMainUIPanel(panel1);
        
        panel1.setBounds(0,0,700,700);
        getContentPane().add(panel1);
        
		JPanel panel2 = new JPanel();
		QuestionPanel(panel2);
        
        panel2.setBounds(800,0,300,700);
        getContentPane().add(panel2);
        

        setVisible(true);
        
        questButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				QuestUI questui=new QuestUI();
				questui.setVisible(true);
				dispose();
			}
		});
        
	}
	
	public void UserMainUIPanel(JPanel panel)
	{
		panel.setLayout(null);
		
		Font font=new Font("맑은 고딕", Font.PLAIN, 17);
		
		JLabel remaintime=new JLabel("남은 시간:");
		remaintime.setBounds(400,50,100,50);
		remaintime.setFont(font);
		panel.add(remaintime);
		
		JLabel ManagerPhone = new JLabel("관리자 연락처");
		ManagerPhone.setBounds(300, 100, 150, 50);
		ManagerPhone.setFont(font);
		panel.add(ManagerPhone);
		
		JLabel ManagerNumber=new JLabel("010-1234-1234");
		ManagerNumber.setBounds(295,120,150,50);
		ManagerNumber.setFont(font);
		panel.add(ManagerNumber);
		
		JLabel managerEmail=new JLabel("Family@naver.com");
		managerEmail.setBounds(293,140,150,50);
		managerEmail.setFont(font);
		panel.add(managerEmail);
		
		picture = new JLabel();
        picture.setIcon(new ImageIcon("C:\\Java\\eclipse-workspace\\myjava\\study\\hanbok.jpg"));
        picture.setBounds(140, 200, 500,300);
        panel.add(picture);
        
        JButton addpay=new JButton("추가결제");
        addpay.setBounds(50,500,250,100);
        addpay.setBackground(Color.yellow);
        addpay.setFont(font);
        panel.add(addpay);
        
        JButton exit=new JButton("퇴실");
        exit.setBounds(350,500,250,100);
        exit.setBackground(Color.yellow);
        exit.setFont(font);
        panel.add(exit);
        
        
        
        panel.setBackground(Color.pink);
        
		
	}
	
	public void QuestionPanel(JPanel panel)
	{
		panel.setLayout(null);
		Font font=new Font("맑은 고딕", Font.PLAIN, 17);
		
		JLabel quest=new JLabel("질문");
		quest.setBounds(880,50,300,50);
		quest.setBackground(Color.cyan);
		quest.setFont(font);
		panel.add(quest);
		
		
		JButton questButton=new JButton("질문");
		questButton.setBounds(700,550,180,50);
		questButton.setBackground(Color.yellow);
		questButton.setFont(font);
		panel.add(questButton);
		
		JButton answerButton=new JButton("답변");
		answerButton.setBounds(910,550,180,50);
		answerButton.setBackground(Color.yellow);
		answerButton.setFont(font);
		panel.add(answerButton);
		
		panel.setBackground(Color.green);
		
		questButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QuestUI qui=new QuestUI();
				qui.setVisible(true);
				dispose();
				
			}
		});
       
	}
	public static void main(String[] args) {
		new UserMainUI();
	}



}
