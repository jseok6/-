package study;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.Socket;

import javax.swing.border.*;

import net.ChatClient3;
import net.ChatProtocol3;
import talk.TalkProtocol;
public class UI1 extends JFrame
implements ActionListener{
	
	 private JButton btnLogin;
	 private JButton btnInit;
	 private JButton btnjoin;
	 private JPasswordField passText;
	 private JTextField userText;
	 private JLabel managerphone;
	 private JLabel label;
	 private JLabel label2;
	 ImageIcon img=new ImageIcon("./Button_Image/back.jpg");
	 

	 
	 
	 Socket sock;
	 String id;
	 String ip = "127.0.0.1";
	 int port = 8003;
	 BufferedReader in;
	 PrintWriter out;
	 
	 private JButton btn1;
	 private JButton btn2;
	 private JButton btn3;
	 private JButton btn4;
	 private JButton btn5;
	 private JButton btn6;
	 private JButton btn7;
	 private JButton btn8;
	 private JButton btn9;
	 private JButton btn0;
	 
	 private JButton btnq;
	 private JButton btnw;
	 private JButton btne;
	 private JButton btnr;
	 private JButton btnt;
	 private JButton btny;
	 private JButton btnu;
	 private JButton btni;
	 private JButton btno;
	 private JButton btnp;
	 
	 private JButton btna;
	 private JButton btns;
	 private JButton btnd;
	 private JButton btnf;
	 private JButton btng;
	 private JButton btnh;
	 private JButton btnj;
	 private JButton btnk;
	 private JButton btnl;
	 
	 private JButton btnz;
	 private JButton btnx;
	 private JButton btnc;
	 private JButton btnv;
	 private JButton btnb;
	 private JButton btnn;
	 private JButton btnm;
	 
	 private JButton back;
	 
	 
	 
	public UI1() {
		 // setting
        setTitle("FamilyStudyCafe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		// panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
		
		
		//initGUI
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
        //배경이미지
        label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Java\\eclipse-workspace\\myjava\\study\\family.jpg"));
        label.setBounds(0, 0, 1100, 700);
        panel.add(label);

        // add
        getContentPane().add(panel);
        
       
        // visiible
        setVisible(true);
	}
	public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);
        Font font=new Font("맑은 고딕", Font.PLAIN, 17);
        
        JLabel userLabel = new JLabel("Tell");
        userLabel.setBounds(427, 229, 80, 25);
        userLabel.setFont(font);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("PassWord");
        passLabel.setBounds(427, 259, 80, 25);
        passLabel.setFont(font);
        panel.add(passLabel);
       
        userText = new JTextField(20);
        userText.setBounds(517, 229, 160, 25);
        panel.add(userText);
       
        passText = new JPasswordField(20);
        passText.setBounds(517, 259, 160, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
            	//로그인체크
            }
        });
       
        btnInit = new JButton("Reset");
        btnInit.setBackground(Color.yellow);
        btnInit.setBounds(427, 299, 121, 25);
        panel.add(btnInit);
        
       
        btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.yellow);
        btnLogin.setBounds(680, 229, 120, 100);
        panel.add(btnLogin);
        btnLogin.addActionListener(this);
        btnInit.addActionListener(this);
        
        
        btnjoin=new JButton("회원가입");
        btnjoin.setBackground(Color.yellow);
        btnjoin.setBounds(560, 299, 117, 25);
        panel.add(btnjoin);
        btnjoin.addActionListener(this);
        
        label2=new JLabel("아이디와 비번을 입력하세요.");
        label2.setOpaque(true); 
        label2.setBackground(Color.pink);
        label2.setFont(font);
        label2.setBounds(430, 580, 220, 20);
        panel.add(label2);
        
        
        //숫자키패드
        btn0=new JButton("0");
        btn0.setBounds(310,350,50,25);
        btn0.setBackground(Color.yellow);
        panel.add(btn0);
        btn1=new JButton("1");
        btn1.setBounds(360,350,50,25);
        btn1.setBackground(Color.yellow);
        panel.add(btn1);
        btn2=new JButton("2");
        btn2.setBounds(410,350,50,25);
        btn2.setBackground(Color.yellow);
        panel.add(btn2);
        btn3=new JButton("3");
        btn3.setBounds(460,350,50,25);
        btn3.setBackground(Color.yellow);
        panel.add(btn3);
        btn4=new JButton("4");
        btn4.setBounds(510,350,50,25);
        btn4.setBackground(Color.yellow);
        panel.add(btn4);
        btn5=new JButton("5");
        btn5.setBounds(560,350,50,25);
        btn5.setBackground(Color.yellow);
        panel.add(btn5);
        btn6=new JButton("6");
        btn6.setBounds(610,350,50,25);
        btn6.setBackground(Color.yellow);
        panel.add(btn6);
        btn7=new JButton("7");
        btn7.setBounds(660,350,50,25);
        btn7.setBackground(Color.yellow);
        panel.add(btn7);
        btn8=new JButton("8");
        btn8.setBounds(710,350,50,25);
        btn8.setBackground(Color.yellow);
        panel.add(btn8);
        btn9=new JButton("9");
        btn9.setBounds(760,350,50,25);
        btn9.setBackground(Color.yellow);
        panel.add(btn9);
        
        //영문키패드
        
        btnq=new JButton("q");
        btnq.setBounds(310,375,50,25);
        btnq.setBackground(Color.yellow);
        panel.add(btnq);
        btnw=new JButton("w");
        btnw.setBounds(360,375,50,25);
        btnw.setBackground(Color.yellow);
        panel.add(btnw);
        btne=new JButton("e");
        btne.setBounds(410,375,50,25);
        btne.setBackground(Color.yellow);
        panel.add(btne);
        btnr=new JButton("r");
        btnr.setBounds(460,375,50,25);
        btnr.setBackground(Color.yellow);
        panel.add(btnr);
        btnt=new JButton("t");
        btnt.setBounds(510,375,50,25);
        btnt.setBackground(Color.yellow);
        panel.add(btnt);
        btny=new JButton("y");
        btny.setBounds(560,375,50,25);
        btny.setBackground(Color.yellow);
        panel.add(btny);
        btnu=new JButton("u");
        btnu.setBounds(610,375,50,25);
        btnu.setBackground(Color.yellow);
        panel.add(btnu);
        btni=new JButton("i");
        btni.setBounds(660,375,50,25);
        btni.setBackground(Color.yellow);
        panel.add(btni);
        btno=new JButton("o");
        btno.setBounds(710,375,50,25);
        btno.setBackground(Color.yellow);
        panel.add(btno);
        btnp=new JButton("p");
        btnp.setBounds(760,375,50,25);
        btnp.setBackground(Color.yellow);
        panel.add(btnp);
        
        btna=new JButton("a");
        btna.setBounds(335,400,50,25);
        btna.setBackground(Color.yellow);
        panel.add(btna);
        btns=new JButton("s");
        btns.setBounds(385,400,50,25);
        btns.setBackground(Color.yellow);
        panel.add(btns);
        btnd=new JButton("d");
        btnd.setBounds(435,400,50,25);
        btnd.setBackground(Color.yellow);
        panel.add(btnd);
        btnf=new JButton("f");
        btnf.setBounds(485,400,50,25);
        btnf.setBackground(Color.yellow);
        panel.add(btnf);
        btng=new JButton("g");
        btng.setBounds(535,400,50,25);
        btng.setBackground(Color.yellow);
        panel.add(btng);
        btnh=new JButton("h");
        btnh.setBounds(585,400,50,25);
        btnh.setBackground(Color.yellow);
        panel.add(btnh);
        btnj=new JButton("j");
        btnj.setBounds(635,400,50,25);
        btnj.setBackground(Color.yellow);
        panel.add(btnj);
        btnk=new JButton("k");
        btnk.setBounds(685,400,50,25);
        btnk.setBackground(Color.yellow);
        panel.add(btnk);
        btnl=new JButton("l");
        btnl.setBounds(735,400,50,25);
        btnl.setBackground(Color.yellow);
        panel.add(btnl);
        
        btnz=new JButton("z");
        btnz.setBounds(385,425,50,25);
        btnz.setBackground(Color.yellow);
        panel.add(btnz);
        btnx=new JButton("x");
        btnx.setBounds(435,425,50,25);
        btnx.setBackground(Color.yellow);
        panel.add(btnx);
        btnc=new JButton("c");
        btnc.setBounds(485,425,50,25);
        btnc.setBackground(Color.yellow);
        panel.add(btnc);
        btnv=new JButton("v");
        btnv.setBounds(535,425,50,25);
        btnv.setBackground(Color.yellow);
        panel.add(btnv);
        btnb=new JButton("b");
        btnb.setBounds(585,425,50,25);
        btnb.setBackground(Color.yellow);
        panel.add(btnb);
        btnn=new JButton("n");
        btnn.setBounds(635,425,50,25);
        btnn.setBackground(Color.yellow);
        panel.add(btnn);
        btnm=new JButton("m");
        btnm.setBounds(685,425,50,25);
        btnm.setBackground(Color.yellow);
        panel.add(btnm);
        
        
        manager_pn mgpn=new manager_pn();
        String str=mgpn.manager_pn();
        JLabel managerphone= new JLabel("관리자 연락처:"+str);
        managerphone.setFont(font);
        managerphone.setBounds(800, 620, 300, 50);
        panel.add(managerphone);
        
        back=new JButton(img);
		back.setBounds(0, 0, 150, 90);
		back.setBorderPainted(false);
		panel.add(back);
        
        
        
        
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj=e.getSource();
			if(obj==btnInit)
			{
				userText.setText("");
	            passText.setText("");
			}
			//로그인버튼
			else if (obj==btnLogin)
			{
				log_event log=new log_event();
				int i = log.sql_run(Integer.parseInt(userText.getText()), passText.getText());
				if(i == 1){
					Pay pay=new Pay();
					pay.setVisible(true);
					JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
					dispose();
					
					
				}
				else
				{

					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				
			}
			//회원가입버튼
			else if(obj==btnjoin)
			{
				join_event join=new join_event();
				join.join(Integer.parseInt(userText.getText()),passText.getText());
				userText.setText("");
				passText.setText("");
				dispose();
				
			}
			//뒤로가기버튼
			else if (obj==back)
			{
				//뒤로가기 기능
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}

	public static void main(String[] args) {
		new UI1();

	}

}

