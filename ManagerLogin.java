package study;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;
public class ManagerLogin extends JFrame{
	 private JButton btnLogin;
	 private JButton btnInit;
	 private JPasswordField managerPassWordText;
	 private JTextField managerIDText;
	 private JLabel managerphone;
	 private JLabel label;
	
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
		
        // add
        getContentPane().add(panel);
       
        // visible
        setVisible(true);
	}
	public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);
        
        //안내메세지 라벨
        JLabel notificationLabel = new JLabel("<html><body><center>아이디와 비밀번호를 입력하세요"
        		+ "<br>Enter ID and Password</center></body></html>");
        notificationLabel.setOpaque(true);
        notificationLabel.setBackground(Color.WHITE); //배경색상 변경
        notificationLabel.setBounds(360, 125, 400, 60); //위치, 크기 조정
        Font notificationFont = new Font("맑은고딕 굵게", Font.BOLD, 18); //폰트 설정
        notificationLabel.setFont(notificationFont); 
        notificationLabel.setHorizontalAlignment(JLabel.CENTER); //중앙정렬
        panel.add(notificationLabel);
        //안내메세지 텍스트필드
//        passText = new JPasswordField(20);
//        passText.setBounds(425, 125, 255, 40);
//        panel.add(passText);
        
        //계정(ID) 라벨
        JLabel managerIdLabel = new JLabel("계정(ID)");
        managerIdLabel.setBounds(427, 229, 80, 25);
        panel.add(managerIdLabel);
       //ID 텍스트필드
        managerIDText = new JTextField(20);
        managerIDText.setBounds(517, 229, 160, 25);
        panel.add(managerIDText);
        
        //비밀번호(PW) 라벨
        JLabel managerPassWordLabel = new JLabel("비밀번호(PW)");
        managerPassWordLabel.setBounds(427, 259, 80, 25);
        panel.add(managerPassWordLabel);
       //비밀번호 텍스트필드
        managerPassWordText = new JPasswordField(20);
        managerPassWordText.setBounds(517, 259, 160, 25);
        panel.add(managerPassWordText);
    
        managerPassWordText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
            	//�α���üũ
            }
        });
       
        //정정버튼
        btnInit = new JButton("정정");
        btnInit.setBackground(Color.yellow);
        btnInit.setBounds(400, 300, 140, 40);
        Font ILBtnFont = new Font("맑은고딕 굵게", Font.BOLD, 16); //폰트 설정
        btnInit.setFont(ILBtnFont); 
        panel.add(btnInit);
        btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerIDText.setText(""); //ID 텍스트필드 초기화
                managerPassWordText.setText(""); //비밀번호 텍스트필드 초기화
            }
        });
       
        //로그인버튼
        btnLogin = new JButton("로그인");
        btnLogin.setBackground(Color.yellow);
        btnLogin.setBounds(560, 300, 140, 40);
        btnLogin.setFont(ILBtnFont); 
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//�α���üũ
            }
        });
        //숫자키 패널
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
        
        //영어 키패널
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
    }

	public static void main(String[] args) {
		new ManagerLogin();
	}
}