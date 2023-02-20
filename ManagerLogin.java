package study;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class ManagerLogin extends JFrame
implements ActionListener{
	
	 private JButton btnLogin;
	 private JButton btnInit;
	 private JButton btnjoin;
	 private JButton btnBack;
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
	 
	 
	 String arr[]= {"btnq","btnw","btne","btnr","btnt","btny","btnu","btni","btno","btnp"};
	 
	 
	 
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
		
        //����̹���
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
        Font font=new Font("���� ����", Font.PLAIN, 17);
        
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
            	//�α���üũ
            }
        });
        
        //�ڷΰ��� ��ư
        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\"
        		+ "src\\img\\Button_image\\back.jpg"));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new ActionListener()
        		{
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		FirstDisplay fDisplay = new FirstDisplay();
        		fDisplay.setTitle("FamilyStudyCafe_FirstDisplay");
        		fDisplay.setVisible(true);
             	dispose(); //��â �ݱ�
        	}
        		});
        btnBack.setBounds(0,0,100,50);
        panel.add(btnBack);
        
       
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
        
        infoMsgLabel=new JLabel("���̵�� ��й�ȣ�� �Է��ϼ���.");
        infoMsgLabel.setOpaque(true); 
        infoMsgLabel.setBackground(Color.pink);
        infoMsgLabel.setHorizontalAlignment(JLabel.CENTER);
        infoMsgLabel.setFont(font);
        infoMsgLabel.setBounds(400, 180, 300, 20);
        panel.add(infoMsgLabel);
        
        //����Ű�е�
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
        
        //����Ű�е�
        
        btnq=new JButton("q");
        btnq.setBounds(310,375,50,25);
        btnq.setBackground(Color.yellow);
        btnq.setFocusPainted(false);
        btnq.addActionListener(this);
        panel.add(btnq);
        
        btnw=new JButton("w");
        btnw.setBounds(360,375,50,25);
        btnw.setBackground(Color.yellow);
        btnw.setFocusPainted(false);
        btnw.addActionListener(this);
        panel.add(btnw);
        
        btne=new JButton("e");
        btne.setBounds(410,375,50,25);
        btne.setBackground(Color.yellow);
        btne.setFocusPainted(false);
        btne.addActionListener(this);
        panel.add(btne);
        
        btnr=new JButton("r");
        btnr.setBounds(460,375,50,25);
        btnr.setBackground(Color.yellow);
        btnr.setFocusPainted(false);
        btnr.addActionListener(this);
        panel.add(btnr);
        
        btnt=new JButton("t");
        btnt.setBounds(510,375,50,25);
        btnt.setBackground(Color.yellow);
        btnt.setFocusPainted(false);
        btnt.addActionListener(this);
        panel.add(btnt);
        
        btny=new JButton("y");
        btny.setBounds(560,375,50,25);
        btny.setBackground(Color.yellow);
        btny.setFocusPainted(false);
        btny.addActionListener(this);
        panel.add(btny);
        
        btnu=new JButton("u");
        btnu.setBounds(610,375,50,25);
        btnu.setBackground(Color.yellow);
        btnu.setFocusPainted(false);
        btnu.addActionListener(this);
        panel.add(btnu);
        
        btni=new JButton("i");
        btni.setBounds(660,375,50,25);
        btni.setBackground(Color.yellow);
        btni.setFocusPainted(false);
        btni.addActionListener(this);
        panel.add(btni);
        
        btno=new JButton("o");
        btno.setBounds(710,375,50,25);
        btno.setBackground(Color.yellow);
        btno.setFocusPainted(false);
        btno.addActionListener(this);
        panel.add(btno);
        
        btnp=new JButton("p");
        btnp.setBounds(760,375,50,25);
        btnp.setBackground(Color.yellow);
        btnp.setFocusPainted(false);
        btnp.addActionListener(this);
        panel.add(btnp);
        
        btna=new JButton("a");
        btna.setBounds(335,400,50,25);
        btna.setBackground(Color.yellow);
        btna.setFocusPainted(false);
        btna.addActionListener(this);
        panel.add(btna);
        
        btns=new JButton("s");
        btns.setBounds(385,400,50,25);
        btns.setBackground(Color.yellow);
        btns.setFocusPainted(false);
        btns.addActionListener(this);
        panel.add(btns);
        
        btnd=new JButton("d");
        btnd.setBounds(435,400,50,25);
        btnd.setBackground(Color.yellow);
        btnd.setFocusPainted(false);
        btnd.addActionListener(this);
        panel.add(btnd);
        
        btnf=new JButton("f");
        btnf.setBounds(485,400,50,25);
        btnf.setBackground(Color.yellow);
        btnf.setFocusPainted(false);
        btnf.addActionListener(this);
        panel.add(btnf);
        
        btng=new JButton("g");
        btng.setBounds(535,400,50,25);
        btng.setBackground(Color.yellow);
        btng.setFocusPainted(false);
        btng.addActionListener(this);
        panel.add(btng);
        
        btnh=new JButton("h");
        btnh.setBounds(585,400,50,25);
        btnh.setBackground(Color.yellow);
        btnh.setFocusPainted(false);
        btnh.addActionListener(this);
        panel.add(btnh);
        
        btnj=new JButton("j");
        btnj.setBounds(635,400,50,25);
        btnj.setBackground(Color.yellow);
        btnj.setFocusPainted(false);
        btnj.addActionListener(this);
        panel.add(btnj);
        
        btnk=new JButton("k");
        btnk.setBounds(685,400,50,25);
        btnk.setBackground(Color.yellow);
        btnk.setFocusPainted(false);
        btnk.addActionListener(this);
        panel.add(btnk);
        
        btnl=new JButton("l");
        btnl.setBounds(735,400,50,25);
        btnl.setBackground(Color.yellow);
        btnl.setFocusPainted(false);
        btnl.addActionListener(this);
        panel.add(btnl);
        
        btnz=new JButton("z");
        btnz.setBounds(385,425,50,25);
        btnz.setBackground(Color.yellow);
        btnz.setFocusPainted(false);
        btnz.addActionListener(this);
        panel.add(btnz);
        
        btnx=new JButton("x");
        btnx.setBounds(435,425,50,25);
        btnx.setBackground(Color.yellow);
        btnx.setFocusPainted(false);
        btnx.addActionListener(this);
        panel.add(btnx);
        
        btnc=new JButton("c");
        btnc.setBounds(485,425,50,25);
        btnc.setBackground(Color.yellow);
        btnc.setFocusPainted(false);
        btnc.addActionListener(this);
        panel.add(btnc);
        
        btnv=new JButton("v");
        btnv.setBounds(535,425,50,25);
        btnv.setBackground(Color.yellow);
        btnv.setFocusPainted(false);
        btnv.addActionListener(this);
        panel.add(btnv);
        
        btnb=new JButton("b");
        btnb.setBounds(585,425,50,25);
        btnb.setBackground(Color.yellow);
        btnb.setFocusPainted(false);
        btnb.addActionListener(this);
        panel.add(btnb);
        
        btnn=new JButton("n");
        btnn.setBounds(635,425,50,25);
        btnn.setBackground(Color.yellow);
        btnn.setFocusPainted(false);
        btnn.addActionListener(this);
        panel.add(btnn);
        
        btnm=new JButton("m");
        btnm.setBounds(685,425,50,25);
        btnm.setBackground(Color.yellow);
        btnm.setFocusPainted(false);
        btnm.addActionListener(this);
        panel.add(btnm);
        
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
					String name = mgr.managerName(managerIdText.getText());//managerName�о��
					ManagerMain managerMain = new ManagerMain(name);
					managerMain.setTitle("FamilyStudyCafe_ManagerMain");
					managerMain.setResizable(false);
					//managerMain.setVisible(true);
					JOptionPane.showMessageDialog(null, "�α����� ȯ���մϴ�.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� Ȯ���ϼ���");
				}
			}
		}
		catch (Exception e2)
		{

		}
	}
	
	public static void main(String[] args) {
		new ManagerLogin();
	}
}