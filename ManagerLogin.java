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

import network.ChatClient3;
import network.ChatProtocol3;
import Talk.TalkProtocol;
public class ManagerLogin extends JFrame
implements ActionListener{
	
	 private JButton btnLogin;
	 private JButton btnInit;
	 private JButton btnjoin;
	 private JPasswordField managerPwText;
	 private JTextField managerIdText;
	 private JLabel managerphone;
	 private JLabel label;
	 private JLabel infoMsgLabel;
	 
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
	 
	 
	 
	public ManagerLogin() {
		 // setting
        setTitle("FamilyStudyCafe_ManagerLogin");
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
        
        JLabel userLabel = new JLabel("ID");
        userLabel.setBounds(427, 229, 80, 25);
        userLabel.setFont(font);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("PassWord");
        passLabel.setBounds(427, 259, 80, 25);
        passLabel.setFont(font);
        panel.add(passLabel);
       
        managerIdText = new JTextField(20);
        managerIdText.setBounds(517, 229, 160, 25);
        panel.add(managerIdText);
       
        managerPwText = new JPasswordField(20);
        managerPwText.setBounds(517, 259, 160, 25);
        panel.add(managerPwText);
        managerPwText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
            	//로그인체크
            }
        });
       
        btnInit = new JButton("Reset");
        btnInit.setFocusPainted(false);
        btnInit.setBackground(Color.yellow);
        btnInit.setBounds(480, 300, 140, 25);
        panel.add(btnInit);
        
       
        btnLogin = new JButton("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(Color.yellow);
        btnLogin.setBounds(680, 229, 120, 100);
        panel.add(btnLogin);
        btnLogin.addActionListener(this);
        btnInit.addActionListener(this);
        
        
//        btnjoin=new JButton("회원가입");
//        btnjoin.setBackground(Color.yellow);
//        btnjoin.setBounds(560, 299, 117, 25);
//        panel.add(btnjoin);
//        btnjoin.addActionListener(this);
        
        infoMsgLabel=new JLabel("아이디와 비밀번호를 입력하세요.");
        infoMsgLabel.setOpaque(true); 
        infoMsgLabel.setBackground(Color.pink);
        infoMsgLabel.setHorizontalAlignment(JLabel.CENTER);
        infoMsgLabel.setFont(font);
        infoMsgLabel.setBounds(400, 180, 300, 20);
        panel.add(infoMsgLabel);
        
        //숫자키패드
        btn0=new JButton("0");
        btn0.setBounds(310,350,50,25);
        btn0.setBackground(Color.yellow);
        btn0.setFocusPainted(false);
        panel.add(btn0);
        
        btn1=new JButton("1");
        btn1.setBounds(360,350,50,25);
        btn1.setBackground(Color.yellow);
        btn1.setFocusPainted(false);
        panel.add(btn1);
        
        btn2=new JButton("2");
        btn2.setBounds(410,350,50,25);
        btn2.setBackground(Color.yellow);
        btn2.setFocusPainted(false);
        panel.add(btn2);
        
        btn3=new JButton("3");
        btn3.setBounds(460,350,50,25);
        btn3.setBackground(Color.yellow);
        btn3.setFocusPainted(false);
        panel.add(btn3);
        
        btn4=new JButton("4");
        btn4.setBounds(510,350,50,25);
        btn4.setBackground(Color.yellow);
        btn4.setFocusPainted(false);
        panel.add(btn4);
        
        btn5=new JButton("5");
        btn5.setBounds(560,350,50,25);
        btn5.setBackground(Color.yellow);
        btn5.setFocusPainted(false);
        panel.add(btn5);
        
        btn6=new JButton("6");
        btn6.setBounds(610,350,50,25);
        btn6.setBackground(Color.yellow);
        btn6.setFocusPainted(false);
        panel.add(btn6);
        
        btn7=new JButton("7");
        btn7.setBounds(660,350,50,25);
        btn7.setBackground(Color.yellow);
        btn7.setFocusPainted(false);
        panel.add(btn7);
        
        btn8=new JButton("8");
        btn8.setBounds(710,350,50,25);
        btn8.setBackground(Color.yellow);
        btn8.setFocusPainted(false);
        panel.add(btn8);
        
        btn9=new JButton("9");
        btn9.setBounds(760,350,50,25);
        btn9.setBackground(Color.yellow);
        btn9.setFocusPainted(false);
        panel.add(btn9);
        
        //영문키패드
        
        btnq=new JButton("q");
        btnq.setBounds(310,375,50,25);
        btnq.setBackground(Color.yellow);
        btnq.setFocusPainted(false);
        panel.add(btnq);
        
        btnw=new JButton("w");
        btnw.setBounds(360,375,50,25);
        btnw.setBackground(Color.yellow);
        btnw.setFocusPainted(false);
        panel.add(btnw);
        
        btne=new JButton("e");
        btne.setBounds(410,375,50,25);
        btne.setBackground(Color.yellow);
        btne.setFocusPainted(false);
        panel.add(btne);
        
        btnr=new JButton("r");
        btnr.setBounds(460,375,50,25);
        btnr.setBackground(Color.yellow);
        btnr.setFocusPainted(false);
        panel.add(btnr);
        
        btnt=new JButton("t");
        btnt.setBounds(510,375,50,25);
        btnt.setBackground(Color.yellow);
        btnt.setFocusPainted(false);
        panel.add(btnt);
        
        btny=new JButton("y");
        btny.setBounds(560,375,50,25);
        btny.setBackground(Color.yellow);
        btny.setFocusPainted(false);
        panel.add(btny);
        
        btnu=new JButton("u");
        btnu.setBounds(610,375,50,25);
        btnu.setBackground(Color.yellow);
        btnu.setFocusPainted(false);
        panel.add(btnu);
        
        btni=new JButton("i");
        btni.setBounds(660,375,50,25);
        btni.setBackground(Color.yellow);
        btni.setFocusPainted(false);
        panel.add(btni);
        
        btno=new JButton("o");
        btno.setBounds(710,375,50,25);
        btno.setBackground(Color.yellow);
        btno.setFocusPainted(false);
        panel.add(btno);
        
        btnp=new JButton("p");
        btnp.setBounds(760,375,50,25);
        btnp.setBackground(Color.yellow);
        btnp.setFocusPainted(false);
        panel.add(btnp);
        
        btna=new JButton("a");
        btna.setBounds(335,400,50,25);
        btna.setBackground(Color.yellow);
        btna.setFocusPainted(false);
        panel.add(btna);
        
        btns=new JButton("s");
        btns.setBounds(385,400,50,25);
        btns.setBackground(Color.yellow);
        btns.setFocusPainted(false);
        panel.add(btns);
        
        btnd=new JButton("d");
        btnd.setBounds(435,400,50,25);
        btnd.setBackground(Color.yellow);
        btnd.setFocusPainted(false);
        panel.add(btnd);
        
        btnf=new JButton("f");
        btnf.setBounds(485,400,50,25);
        btnf.setBackground(Color.yellow);
        btnf.setFocusPainted(false);
        panel.add(btnf);
        
        btng=new JButton("g");
        btng.setBounds(535,400,50,25);
        btng.setBackground(Color.yellow);
        btng.setFocusPainted(false);
        panel.add(btng);
        
        btnh=new JButton("h");
        btnh.setBounds(585,400,50,25);
        btnh.setBackground(Color.yellow);
        btnh.setFocusPainted(false);
        panel.add(btnh);
        
        btnj=new JButton("j");
        btnj.setBounds(635,400,50,25);
        btnj.setBackground(Color.yellow);
        btnj.setFocusPainted(false);
        panel.add(btnj);
        
        btnk=new JButton("k");
        btnk.setBounds(685,400,50,25);
        btnk.setBackground(Color.yellow);
        btnk.setFocusPainted(false);
        panel.add(btnk);
        
        btnl=new JButton("l");
        btnl.setBounds(735,400,50,25);
        btnl.setBackground(Color.yellow);
        btnl.setFocusPainted(false);
        panel.add(btnl);
        
        btnz=new JButton("z");
        btnz.setBounds(385,425,50,25);
        btnz.setBackground(Color.yellow);
        btnz.setFocusPainted(false);
        panel.add(btnz);
        
        btnx=new JButton("x");
        btnx.setBounds(435,425,50,25);
        btnx.setBackground(Color.yellow);
        btnx.setFocusPainted(false);
        panel.add(btnx);
        
        btnc=new JButton("c");
        btnc.setBounds(485,425,50,25);
        btnc.setBackground(Color.yellow);
        btnc.setFocusPainted(false);
        panel.add(btnc);
        
        btnv=new JButton("v");
        btnv.setBounds(535,425,50,25);
        btnv.setBackground(Color.yellow);
        btnv.setFocusPainted(false);
        panel.add(btnv);
        
        btnb=new JButton("b");
        btnb.setBounds(585,425,50,25);
        btnb.setBackground(Color.yellow);
        btnb.setFocusPainted(false);
        panel.add(btnb);
        
        btnn=new JButton("n");
        btnn.setBounds(635,425,50,25);
        btnn.setBackground(Color.yellow);
        btnn.setFocusPainted(false);
        panel.add(btnn);
        
        btnm=new JButton("m");
        btnm.setBounds(685,425,50,25);
        btnm.setBackground(Color.yellow);
        btnm.setFocusPainted(false);
        panel.add(btnm);
        
//        manager_pn mgpn=new manager_pn();
//        String str=mgpn.manager_pn();
//        JLabel managerphone= new JLabel("관리자 연락처:"+str);
//        managerphone.setFont(font);
//        managerphone.setBounds(800, 620, 300, 50);
//        panel.add(managerphone);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj=e.getSource();
			if(obj==btnInit)
			{
				managerIdText.setText("");
	            managerPwText.setText("");
			}
			else if (obj==btnLogin)
			{
				ManagerLoginEvent2 mLE2=new ManagerLoginEvent2();
				int i = mLE2.managerLogin2((managerIdText.getText()), managerPwText.getText());
				if(i == 1){
					FindManagerName mgr = new FindManagerName();
					String name = mgr.managerName(managerIdText.getText());//managerName읽어옴
					ManagerMain managerMain = new ManagerMain(name);
					managerMain.setTitle("FamilyStudyCafe_ManagerMain");
					managerMain.setResizable(false);
					managerMain.setVisible(true);
					JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 확인하세요");
				}
				
			}
//			else if(obj==btnjoin)
//			{
//				ManagerJoinEvent mJ=new ManagerJoinEvent();
//				//mJ.managerJoin((managerIdText.getText()),managerPwText.getText());
//				managerIdText.setText("");
//				managerPwText.setText("");
//				dispose();
//				
//			}
		}
		catch (Exception e2)
		{
			// TODO: handle exception
		}
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) 
//	{
//		try 
//		{
//			Object obj = e.getSource();
//			if(obj==btnLogin)//로그인 버튼 누르면
//			{
//				if(sock==null)
//				{
//					connect(); //처음 시도
//				}
//				id = managerIdText.getText().trim();
//				out.println(ChatProtocol3.ID+ChatProtocol3.MODE+id+";"
//				+managerPwText.getText().trim());
//				String line = in.readLine();
//				int idx = line.indexOf(ChatProtocol3.MODE);
//				String cmd = line.substring(0, idx);
//				String data = line.substring(idx+1);
//				
//				//cmd는 ID, data는 T,F,C값중 하나가 들어옴
//				if(cmd.equals(ChatProtocol3.ID))
//				{
//					if(data.equals("T"))
//					{
//						dispose();
//						new ManagerMain(id);
//					}//if data.equals
//				}//if cmd.equals
//			}//if obj==btnlogin
//		}//try
//		catch (Exception e2)
//		{
//		e2.printStackTrace();
//		}
//	}
//
//	public void connect() 
//	{
//		try
//		{
//			sock = new Socket(ip, port);
//			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//			out = new PrintWriter(sock.getOutputStream(), true/* auto flush */);
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}// --connect
	
	public static void main(String[] args) {
		new ManagerLogin();
	}
}
