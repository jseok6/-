package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pay extends JFrame{
	private JButton btntime;//시간권버튼
	private JButton btnperiod;//기간권 버튼
	private JLabel label;//배경이미지
	private JLabel label2;
	

	private JButton btntime1;
	private JButton btntime2;
	private JButton btntime4;
	private JButton btntime6;
	private JButton btntime9;
	private JButton btntime12;
	
	private JButton btncardpay;
	private JButton btncashpay;
	private JButton back;
	
	ImageIcon img=new ImageIcon("./Button_Image/image_exitButton.jpg");
	ImageIcon img2=new ImageIcon("./Button_Image/image_exitButton2.jpg");
	ImageIcon imgtime=new ImageIcon("./Button_Image/time.jpg");
	ImageIcon imageperiod=new ImageIcon("./Button_Image/time2.jpg");
	
	Font font=new Font("맑은 고딕", Font.PLAIN, 17);
	
	
	
	public Pay() {
		setTitle("시간제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		// panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        PayUI(panel);
		
		
		//initGUI
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
        //배경이미지
        label = new JLabel();
//        label.setIcon(new ImageIcon("C:\\Java\\eclipse-workspace\\myjava\\study\\family.jpg"));
        label.setBounds(0, 0, 1100, 700);
        panel.add(label);
        
        label2=new JLabel();
        label2.setBounds(450,0,250,100);
        label2.setBackground(Color.pink);
        label2.setText("원하는 메뉴를 선택하세요.");
        label2.setFont(font);
        panel.add(label2);

        // add
        getContentPane().add(panel);
       
        // visible
        setVisible(true);
        
        //기간권버튼
        btnperiod.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Pay2 pay2=new Pay2();
				pay2.setVisible(true);
				dispose();
				
			}
		});
        
        //뒤로가기버튼
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UI1 ui1=new UI1();
				ui1.setVisible(true);
				dispose();
			}
		});
        
        //현금결제
        btncashpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        //카드결제
        btncardpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	public void PayUI(JPanel panel){
		panel.setLayout(null);
		
		
		
//		btntime=new JButton(imgtime);
//		btntime.setBounds(0,100, 550,67);
//		btntime.setBorderPainted(false);
//		btntime.setPreferredSize(new Dimension(300,50));
//
//		btntime.setBackground(Color.yellow);
//		panel.add(btntime);
		
//		btnperiod=new JButton("기간권");
//		btnperiod.setBounds(550, 100, 550, 67);
//		btnperiod.setBackground(Color.yellow);
//		btnperiod.setFont(font);
//		panel.add(btnperiod);
		
		btntime1=new JButton("1시간권");
		btntime1.setBounds(67,167,200,100);
		btntime1.setBackground(Color.yellow);
		btntime1.setFont(font);
		panel.add(btntime1);
		
		
		btntime2=new JButton("2시간권");
		btntime2.setBounds(427,167,200,100);
		btntime2.setBackground(Color.yellow);
		btntime2.setFont(font);
		panel.add(btntime2);
		
		btntime4=new JButton("4시간권");
		btntime4.setBounds(787,167,200,100);
		btntime4.setBackground(Color.yellow);
		btntime4.setFont(font);
		panel.add(btntime4);
		
		
		btntime6=new JButton("6시간권");
		btntime6.setBounds(67,367,200,100);
		btntime6.setBackground(Color.yellow);
		btntime6.setFont(font);
		panel.add(btntime6);
		btntime9=new JButton("8시간권");
		btntime9.setBounds(427,367,200,100);
		btntime9.setBackground(Color.yellow);
		btntime9.setFont(font);
		panel.add(btntime9);
		btntime12=new JButton("12시간권");
		btntime12.setBounds(787,367,200,100);
		btntime12.setBackground(Color.yellow);
		btntime12.setFont(font);
		panel.add(btntime12);
		
		btncardpay=new JButton("카드결제");
		btncardpay.setBounds(800,560,300,100);
		btncardpay.setBackground(Color.red);
		btncardpay.setFont(font);
		panel.add(btncardpay);
		
		btncashpay=new JButton("현금결제");
		btncashpay.setBounds(500,560,300,100);
		btncashpay.setBackground(Color.cyan);
		btncashpay.setFont(font);
		panel.add(btncashpay);
		
		back = new JButton(img);
		back.setBounds(0, 610, 300, 50);
		back.setRolloverIcon(img2);
		back.setBorderPainted(false);

		panel.add(back);
		
		btntime=new JButton(imgtime);
		btntime.setBounds(0,70, 550,98);
		panel.add(btntime);
		
		btnperiod=new JButton(imageperiod);
		btnperiod.setBounds(550, 70, 550, 98);
		panel.add(btnperiod);
		

	
	}
	public static void main(String[] args) {
		new Pay();
	}
	
	

}
