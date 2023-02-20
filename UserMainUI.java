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
	private JList list;
	String [] question= {"����:~~~~~"};
	
	

	private JButton answerButton;//�к���ư
	private JButton questButton;//������ư

	ImageIcon img=new ImageIcon("./Button_Image/addpay.jpg");
	ImageIcon imgexit=new ImageIcon("./Button_Image/exit.jpg");
	
	
	
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
        
        
        
	}
	
	public void UserMainUIPanel(JPanel panel)
	{
		panel.setLayout(null);
		
		Font font=new Font("���� ���", Font.PLAIN, 17);
		
		JLabel remaintime=new JLabel("���� �ð�:");
		remaintime.setBounds(400,0,100,50);
		remaintime.setFont(font);
		panel.add(remaintime);
		
		//������ ��ȭ��ȣ �߰��ϱ�
		Manager_pn mgpn=new Manager_pn();
        String managerphone_str=mgpn.Manager_pn();
		JLabel ManagerPhone = new JLabel("������ ����ó:"+managerphone_str);
		ManagerPhone.setBounds(400, 20, 300, 50);
		ManagerPhone.setFont(font);
		panel.add(ManagerPhone);
		
		
		//�������̸��� �߰��ϱ�
		Manager_pn mgem=new Manager_pn();
		String managerEmail_str=mgem.manager_email();
		JLabel managerEmail=new JLabel("�������̸���:"+managerEmail_str);
		managerEmail.setBounds(400,40,300,50);
		managerEmail.setFont(font);
		panel.add(managerEmail);
		
		picture = new JLabel();
        picture.setIcon(new ImageIcon("./Button_Image/book.jpg"));
        picture.setBounds(0, 100, 700,365);
        panel.add(picture);
        
        JButton addpay=new JButton(img);
        addpay.setBounds(0,465,350,200);
        panel.add(addpay);
        
        JButton exit=new JButton(imgexit);
        exit.setBounds(350,465,350,200);
        panel.add(exit);
        
        
        
        panel.setBackground(Color.pink);
        
        //�߰����� ���
        addpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Pay pay=new Pay();
				pay.setVisible(true);
				dispose();
				
			}
		});
        
        //��� ���
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
		
	}
	
	public void QuestionPanel(JPanel panel)
	{
		panel.setLayout(null);
		Font font=new Font("���� ���", Font.PLAIN, 17);
		
		//��������Ʈ��
		list=new JList(question);
		list.setFont(font);		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		list.setBounds(730, 100, 320, 500);
		panel.add(list);
		
		JLabel quest=new JLabel("����");
		quest.setBounds(880,50,100,50);
		quest.setBackground(Color.cyan);
		quest.setFont(font);
		panel.add(quest);
		
		
		JButton questButton=new JButton("�����ϱ�");
		questButton.setBounds(700,615,192,50);
		questButton.setBackground(Color.yellow);
		questButton.setFont(font);
		panel.add(questButton);
		
		JButton answerButton=new JButton("�亯�ϱ�");
		answerButton.setBounds(892,615,192,50);
		answerButton.setBackground(Color.yellow);
		answerButton.setFont(font);
		panel.add(answerButton);
		panel.setBackground(Color.green);
		
		
		//�����ϱ��ư
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
