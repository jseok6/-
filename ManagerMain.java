package study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.Box;
import javax.swing.SwingConstants;

public class ManagerMain extends JFrame {

	private JPanel contentPane;
	
	 //버튼 디자인
	   public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(255,247,242); //배경색 결정
	         Color o=new Color(247,99,12); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain Jframe = new ManagerMain();
					Jframe.setVisible(true);
					Jframe.setResizable(false);
					Jframe.setTitle("FamilyStudyCafe_ManagerMain");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1114, 736);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 228, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		  //폰트(맑은고딕 굵게 16)
		Font logoutBtnFont = new Font("맑은고딕 굵게", Font.BOLD, 16);
		 //테두리선 굵게
		 LineBorder lb = new LineBorder(Color.BLACK,2);
		setVisible(true);
		
		ImageIcon logoIcon= new ImageIcon
				("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\src\\img\\family.jpg");
        Image logoImg = logoIcon.getImage(); // ImageIcon 객체에서 Image 추출
    	Image updateLogoImg = logoImg.getScaledInstance(70, 69, Image.SCALE_SMOOTH);         // 추출된 Image의 크기 조절하여 새로운 Image 객체 생성
        ImageIcon updateLogoIcon = new ImageIcon(updateLogoImg);  // 새로운 Image 객체로 ImageIcon 객체 생성
        
		ImageIcon trashcanIcon= new ImageIcon
				("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\src\\img\\trashcan.png");
		Image trashcanImg = trashcanIcon.getImage();
		Image updateTrashcanImg = trashcanImg.getScaledInstance(57, 54, Image.SCALE_SMOOTH);
        ImageIcon updatetrashcanIcon = new ImageIcon(updateTrashcanImg);        
        
		ImageIcon waterPFIcon = new ImageIcon
				("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\src\\img\\water.png");
		Image waterPFImg = waterPFIcon.getImage();
		Image updateWaterPFImg = waterPFImg.getScaledInstance(35, 54, Image.SCALE_SMOOTH);
		ImageIcon updateWaterPFIcon = new ImageIcon(updateWaterPFImg);
		
		setVisible(true);
			
			
			//------------------------------------------------------------------------------------------------------------
			//회원정보 패널
			JPanel memberInfoPanel = new JPanel();
			memberInfoPanel.setLayout(null);
			memberInfoPanel.setOpaque(true);
			memberInfoPanel.setBackground(new Color(128, 255, 128));
			memberInfoPanel.setBounds(420, 150, 165, 251);
			memberInfoPanel.setEnabled(false);
			memberInfoPanel.setVisible(false);
			//----------------------------------------------------------------------------	
			
			//좌석정보 패널- 켜지면 다른 좌석 버튼등은 다 못누르게 해야함(처음에 활성화안되고 안보이는 상태)
			JPanel seatInfoPanel = new JPanel();
			seatInfoPanel.setOpaque(true);
			seatInfoPanel.setBorder(lb);
			seatInfoPanel.setBounds(420, 150, 165, 251);
			seatInfoPanel.setBackground(new Color(128, 255, 128));
			seatInfoPanel.setLayout(null);
			seatInfoPanel.setEnabled(false);
			seatInfoPanel.setVisible(false);
			contentPane.add(seatInfoPanel);
			
			//"좌석정보" 글자 라벨
			JLabel seatInfoStrLabel = new JLabel("좌석정보");
			//seatInfoStrLabel.setOpaque(true);
			seatInfoStrLabel.setHorizontalAlignment(JLabel.CENTER);
			seatInfoStrLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatInfoStrLabel.setBackground(new Color(128, 0, 0));
			seatInfoStrLabel.setBounds(48, 10, 66, 23);
			seatInfoPanel.add(seatInfoStrLabel);
			
			//"좌석번호" 글자 라벨
			JLabel seatNumStrLabel = new JLabel("좌석번호");
			//seatNumStrLabel.setOpaque(true);
			seatNumStrLabel.setHorizontalAlignment(JLabel.CENTER);
			seatNumStrLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumStrLabel.setBackground(new Color(128, 0, 0));
			seatNumStrLabel.setBounds(12, 79, 66, 23);
			seatInfoPanel.add(seatNumStrLabel);
			
			//좌석번호 숫자 라벨-DB에서? 클릭한 좌석번호 정보를 읽어와서 출력
			JLabel seatNumLabel_seatInfoPanel = new JLabel("105");
			seatNumLabel_seatInfoPanel.setHorizontalAlignment(JLabel.CENTER);
			seatNumLabel_seatInfoPanel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumLabel_seatInfoPanel.setBackground(new Color(128, 0, 0));
			seatNumLabel_seatInfoPanel.setBounds(22, 99, 27, 23);
			seatInfoPanel.add(seatNumLabel_seatInfoPanel);
			
			//"회원"글자 라벨
			JLabel memberStrLabel = new JLabel("회원");
			//memberStrLabel.setOpaque(true);
			memberStrLabel.setHorizontalAlignment(JLabel.CENTER);
			memberStrLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			memberStrLabel.setBackground(new Color(128, 0, 0));
			memberStrLabel.setBounds(16, 185, 33, 23);
			seatInfoPanel.add(memberStrLabel);
			
	    //회원정보 버튼(클릭시 memberInfo 패널 켜짐)
			JButton memberInfoBtn = new JButton("정보");
			memberInfoBtn.setBounds(57, 183, 78, 27);
			memberInfoBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seatInfoPanel.setEnabled(false);
					seatInfoPanel.setVisible(false);					
					memberInfoPanel.setVisible(true);
					memberInfoPanel.setEnabled(true);
				}
			});
			memberInfoBtn.setBackground(new Color(0, 128, 255));
			memberInfoBtn.setFont(logoutBtnFont);
			memberInfoBtn.setBorder(lb);
			memberInfoBtn.setFocusPainted(false);// hide focus rectangle
			seatInfoPanel.add(memberInfoBtn);
			
			//회원 전화번호 라벨
			JLabel memberTelLabel = new JLabel("010-1234-1234");
			//memberTelLabel.setOpaque(true);
			memberTelLabel.setHorizontalAlignment(JLabel.CENTER);
			memberTelLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			memberTelLabel.setBackground(new Color(128, 0, 0));
			memberTelLabel.setBounds(12, 212, 141, 23);
			seatInfoPanel.add(memberTelLabel);
			
			//닫기버튼x
			JButton closeBtn_seatInfoPanel = new JButton("X");
			closeBtn_seatInfoPanel.setOpaque(true);
			closeBtn_seatInfoPanel.setBounds(116, 0, 49, 38);
			closeBtn_seatInfoPanel.setFont(new Font("Dialog", Font.BOLD, 13));
			closeBtn_seatInfoPanel.setHorizontalAlignment(JLabel.CENTER);
			closeBtn_seatInfoPanel.setBackground(new Color(128, 255, 128));//패널이랑 비슷한색으로?
			closeBtn_seatInfoPanel.setForeground(Color.RED);
			closeBtn_seatInfoPanel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seatInfoPanel.setEnabled(false);
					seatInfoPanel.setVisible(false);
				}
			});
			closeBtn_seatInfoPanel.setBorder(lb);
			closeBtn_seatInfoPanel.setFocusPainted(false);
			seatInfoPanel.add(closeBtn_seatInfoPanel);
			memberInfoPanel.setBorder(lb);
			contentPane.add(memberInfoPanel);
			
			//"회원 정보" 글자 라벨
			JLabel seatInfoStrLabel_1 = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
			seatInfoStrLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			seatInfoStrLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			seatInfoStrLabel_1.setBackground(new Color(128, 0, 0));
			seatInfoStrLabel_1.setBounds(37, 10, 77, 23);
			memberInfoPanel.add(seatInfoStrLabel_1);
			
			//"남은 시간" 글자 라벨
			JLabel seatNumStrLabel_1 = new JLabel("\uB0A8\uC740\uC2DC\uAC04");
			seatNumStrLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			seatNumStrLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumStrLabel_1.setBackground(new Color(128, 0, 0));
			seatNumStrLabel_1.setBounds(12, 79, 66, 23);
			memberInfoPanel.add(seatNumStrLabel_1);
			
			//남은시간 글자 라벨-DB에서 남은시간 읽어와서 표시
			JLabel seatNumLabel_1 = new JLabel("10일 11시간12분13초");
			seatNumLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			seatNumLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
			seatNumLabel_1.setBackground(new Color(128, 0, 0));
			seatNumLabel_1.setBounds(12, 99, 141, 23);
			memberInfoPanel.add(seatNumLabel_1);
			
			//"번 좌석"글자 라벨
			JLabel memberStrLabel_1 = new JLabel("번 좌석");
			memberStrLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			memberStrLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			memberStrLabel_1.setBackground(new Color(128, 0, 0));
			memberStrLabel_1.setBounds(52, 191, 62, 23);
			memberInfoPanel.add(memberStrLabel_1);
			
	     	//좌석번호 숫자 라벨-DB에서? 클릭한 좌석번호 정보를 읽어와서 출력
			JLabel seatNumLabel_memberInfoPanel = new JLabel("105");
			seatNumLabel_memberInfoPanel.setHorizontalAlignment(JLabel.CENTER);
			seatNumLabel_memberInfoPanel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumLabel_memberInfoPanel.setBackground(new Color(128, 0, 0));
			seatNumLabel_memberInfoPanel.setBounds(12, 191, 39, 23);
			memberInfoPanel.add(seatNumLabel_memberInfoPanel);
			
			//좌석상태 글자 라벨(이용중/일시정지?)
			JLabel memberTelLabel_1 = new JLabel("이용중");
			memberTelLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			memberTelLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			memberTelLabel_1.setBackground(new Color(128, 0, 0));
			memberTelLabel_1.setBounds(12, 218, 55, 23);
			memberInfoPanel.add(memberTelLabel_1);
			
			//닫기버튼
			JButton closeBtn_MemberInfoPanel = new JButton("X");
			closeBtn_MemberInfoPanel.setOpaque(true);
			closeBtn_MemberInfoPanel.setHorizontalAlignment(SwingConstants.CENTER);
			closeBtn_MemberInfoPanel.setForeground(Color.RED);
			closeBtn_MemberInfoPanel.setFont(new Font("Dialog", Font.BOLD, 13));
			closeBtn_MemberInfoPanel.setFocusPainted(false);
			closeBtn_MemberInfoPanel.setBackground(new Color(128, 255, 128));
			closeBtn_MemberInfoPanel.setBounds(116, 0, 49, 38);
			closeBtn_MemberInfoPanel.setBorder(lb);
			closeBtn_MemberInfoPanel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					memberInfoPanel.setEnabled(false);
					memberInfoPanel.setVisible(false);
					seatInfoPanel.setEnabled(true);
					seatInfoPanel.setVisible(true);		
				}
			});
			memberInfoPanel.add(closeBtn_MemberInfoPanel);
					
		//-----------------------------------------------------------------------------------------------------------
			//1층 배치도 판넬
			JPanel panel1F = new JPanel();
			panel1F.setBounds(71, 37, 945, 599);
			panel1F.setLayout(null);
			//panel1F.setEnabled(false); //패널 비활성화
			//panel1F.setVisible(false); //패널 감추기
			contentPane.add(panel1F);
			
			//1층 좌석 버튼
			JButton seat101Btn = new JButton("101");
			seat101Btn.setBounds(114, 0, 72, 60);
			seat101Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			seat101Btn.setBackground(new Color(0, 128, 255));
			seat101Btn.setFont(logoutBtnFont);
			seat101Btn.setBorder(lb);
			seat101Btn.setFocusPainted(false);// hide focus rectangle
			panel1F.add(seat101Btn);
			
			JButton seat102Btn = new JButton("102");
			seat102Btn.setBounds(186, 0, 72, 60);
			seat102Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			seat102Btn.setBackground(new Color(0, 128, 255));
			seat102Btn.setFont(logoutBtnFont);
			seat102Btn.setBorder(lb);
			seat102Btn.setFocusPainted(false);// hide focus rectangle
			panel1F.add(seat102Btn);
			
			JButton seat103Btn = new JButton("103");
			seat103Btn.setBounds(259, 0, 72, 60);
			seat103Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat103Btn.setBorder(lb);
			seat103Btn.setFocusPainted(false);
			seat103Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat103Btn);
			
			JButton seat104Btn = new JButton("104");
			seat104Btn.setBounds(402, 0, 72, 60);
			seat104Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat104Btn.setBorder(lb);
			seat104Btn.setFocusPainted(false);
			seat104Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat104Btn);
			
			JButton seat105Btn = new JButton("105");
			seat105Btn.setBounds(475, 0, 72, 60);
			seat105Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat105Btn.setBorder(lb);
			seat105Btn.setFocusPainted(false);
			seat105Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat105Btn);
			
			JButton seat106Btn = new JButton("106");
			seat106Btn.setBounds(548, 0, 72, 60);
			seat106Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat106Btn.setBorder(lb);
			seat106Btn.setFocusPainted(false);
			seat106Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat106Btn);
			
			JButton seat107Btn = new JButton("107");
			seat107Btn.setBounds(621, 0, 72, 60);
			seat107Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat107Btn.setBorder(lb);
			seat107Btn.setFocusPainted(false);
			seat107Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat107Btn);
			
			JButton seat108Btn = new JButton("108");
			seat108Btn.setBounds(694, 0, 72, 60);
			seat108Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat108Btn.setBorder(lb);
			seat108Btn.setFocusPainted(false);
			seat108Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat108Btn);
			
			JButton seat109Btn = new JButton("109");
			seat109Btn.setBounds(147, 241, 72, 60);
			seat109Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat109Btn.setBorder(lb);
			seat109Btn.setFocusPainted(false);
			seat109Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat109Btn);
			
			JButton seat110Btn = new JButton("110");
			seat110Btn.setBounds(147, 303, 72, 60);

			seat110Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat110Btn.setBorder(lb);
			seat110Btn.setFocusPainted(false);
			seat110Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat110Btn);
			
			JButton seat111Btn = new JButton("111");
			seat111Btn.setBounds(329, 241, 72, 60);
			seat111Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat111Btn.setBorder(lb);
			seat111Btn.setFocusPainted(false);
			seat111Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat111Btn);
			
			JButton seat112Btn = new JButton("112");
			seat112Btn.setBounds(402, 241, 72, 60);
			seat112Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat112Btn.setBorder(lb);
			seat112Btn.setFocusPainted(false);
			seat112Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat112Btn);
			
			JButton seat113Btn = new JButton("113");
			seat113Btn.setBounds(329, 303, 72, 60);
			seat113Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat113Btn.setBorder(lb);
			seat113Btn.setFocusPainted(false);
			seat113Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat113Btn);
			
			JButton seat114Btn = new JButton("114");
			seat114Btn.setBounds(402, 303, 72, 60);
			seat114Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel1F.setEnabled(false);//1층 배치도 패널 안의 버튼들 클릭 불가능
//					seat111Btn.setEnabled(false);
//					seat112Btn.setEnabled(false);
//					seat113Btn.setEnabled(false);
//					seat114Btn.setEnabled(false);
//					seat114Btn.setVisible(false);
//					seatInfoPanel.setVisible(true);
					seatInfoPanel.setEnabled(true);
					seatInfoPanel.setVisible(true);
					//seatInfoPanel.requestFocus();
					seatInfoPanel.setFocusable(true);
				}
			});
			seat114Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat114Btn.setBorder(lb);
			seat114Btn.setFocusPainted(false);
			seat114Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat114Btn);
			
			JButton seat115Btn = new JButton("115");
			seat115Btn.setBounds(576, 241, 72, 60);
			seat115Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat115Btn.setBorder(lb);
			seat115Btn.setFocusPainted(false);
			seat115Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat115Btn);
			
			JButton seat116Btn = new JButton("116");
			seat116Btn.setBounds(576, 303, 72, 60);
			seat116Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat116Btn.setBorder(lb);
			seat116Btn.setFocusPainted(false);
			seat116Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat116Btn);
			
			JButton seat117Btn = new JButton("117");
			seat117Btn.setBounds(0, 253, 72, 60);
			seat117Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat117Btn.setBorder(lb);
			seat117Btn.setFocusPainted(false);
			seat117Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat117Btn);
			
			JButton seat118Btn = new JButton("118");
			seat118Btn.setBounds(0, 314, 72, 60);
			seat118Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat118Btn.setBorder(lb);
			seat118Btn.setFocusPainted(false);
			seat118Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat118Btn);
			
			JButton seat119Btn = new JButton("119");
			seat119Btn.setBounds(0, 375, 72, 60);
			seat119Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat119Btn.setBorder(lb);
			seat119Btn.setFocusPainted(false);
			seat119Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat119Btn);
			
			JButton seat120Btn = new JButton("120");
			seat120Btn.setBounds(0, 437, 72, 60);
			seat120Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat120Btn.setBorder(lb);
			seat120Btn.setFocusPainted(false);
			seat120Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat120Btn);
			
			JButton seat121Btn = new JButton("121");
			seat121Btn.setBounds(98, 539, 72, 60);
			seat121Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat121Btn.setBorder(lb);
			seat121Btn.setFocusPainted(false);
			seat121Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat121Btn);
			
			JButton seat122Btn = new JButton("122");
			seat122Btn.setBounds(171, 539, 72, 60);
			seat122Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat122Btn.setBorder(lb);
			seat122Btn.setFocusPainted(false);
			seat122Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat122Btn);
			
			JButton seat123Btn = new JButton("123");
			seat123Btn.setBounds(329, 539, 72, 60);
			seat123Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat123Btn.setBorder(lb);
			seat123Btn.setFocusPainted(false);
			seat123Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat123Btn);
			
			JButton seat124Btn = new JButton("124");
			seat124Btn.setBounds(402, 539, 72, 60);
			seat124Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat124Btn.setBorder(lb);
			seat124Btn.setFocusPainted(false);
			seat124Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat124Btn);
			
			JButton seat125Btn = new JButton("125");
			seat125Btn.setBounds(475, 539, 72, 60);
			seat125Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat125Btn.setBorder(lb);
			seat125Btn.setFocusPainted(false);
			seat125Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat125Btn);
			
			JButton seat126Btn = new JButton("126");
			seat126Btn.setBounds(648, 539, 72, 60);
			seat126Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat126Btn.setBorder(lb);
			seat126Btn.setFocusPainted(false);
			seat126Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat126Btn);
			
			JButton seat127Btn = new JButton("127");
			seat127Btn.setBounds(721, 539, 72, 60);
			seat127Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat127Btn.setBorder(lb);
			seat127Btn.setFocusPainted(false);
			seat127Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat127Btn);
			
			JButton seat128Btn = new JButton("128");
			seat128Btn.setBounds(871, 480, 72, 60);
			seat128Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat128Btn.setBorder(lb);
			seat128Btn.setFocusPainted(false);
			seat128Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat128Btn);
			
			JButton seat129Btn = new JButton("129");
			seat129Btn.setBounds(871, 419, 72, 60);
			seat129Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat129Btn.setBorder(lb);
			seat129Btn.setFocusPainted(false);
			seat129Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat129Btn);
			
			JButton seat130Btn = new JButton("130");
			seat130Btn.setBounds(871, 358, 72, 60);
			seat130Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat130Btn.setBorder(lb);
			seat130Btn.setFocusPainted(false);
			seat130Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat130Btn);
			
			JButton seat131Btn = new JButton("131");
			seat131Btn.setBounds(871, 241, 72, 60);
			seat131Btn.setFont(new Font("Dialog", Font.BOLD, 16));
			seat131Btn.setBorder(lb);
			seat131Btn.setFocusPainted(false);
			seat131Btn.setBackground(new Color(0, 128, 255));
			panel1F.add(seat131Btn);
			
		//화장실
		JLabel toiletLabel1_1 = new JLabel("<html><body><center>화<br>장<br>실</center></body></html>");
		toiletLabel1_1.setOpaque(true);
		toiletLabel1_1.setHorizontalAlignment(JLabel.CENTER);
		toiletLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel1_1.setBackground(new Color(255, 210, 0));
		toiletLabel1_1.setBounds(0, 60, 72, 160);
		panel1F.add(toiletLabel1_1);
		
		
		//문
		JLabel doorLabel1_1 = new JLabel("문");
		doorLabel1_1.setOpaque(true);
		doorLabel1_1.setHorizontalAlignment(JLabel.CENTER);
		doorLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel1_1.setBackground(new Color(128, 0, 0));
		doorLabel1_1.setBounds(882, 74, 61, 69);
		panel1F.add(doorLabel1_1);
		
		//벽라벨들
		JLabel wallLabel1_1 = new JLabel();
		wallLabel1_1.setOpaque(true);
		wallLabel1_1.setBackground(Color.GRAY);
		wallLabel1_1.setBounds(0, 496, 72, 103);
		panel1F.add(wallLabel1_1);
		
		JLabel wallLabel1_2 = new JLabel();
		wallLabel1_2.setOpaque(true);
		wallLabel1_2.setBackground(Color.GRAY);
		wallLabel1_2.setBounds(26, 539, 72, 60);
		panel1F.add(wallLabel1_2);
		
		JLabel wallLabel1_3 = new JLabel();
		wallLabel1_3.setOpaque(true);
		wallLabel1_3.setBackground(Color.GRAY);
		wallLabel1_3.setBounds(241, 539, 90, 60);
		panel1F.add(wallLabel1_3);
		
		JLabel wallLabel1_4 = new JLabel();
		wallLabel1_4.setOpaque(true);
		wallLabel1_4.setBackground(Color.GRAY);
		wallLabel1_4.setBounds(536, 539, 112, 60);
		panel1F.add(wallLabel1_4);
		
		JLabel wallLabel1_5 = new JLabel();
		wallLabel1_5.setOpaque(true);
		wallLabel1_5.setBackground(Color.GRAY);
		wallLabel1_5.setBounds(787, 539, 156, 60);
		panel1F.add(wallLabel1_5);
		
		JLabel wallLabel1_6 = new JLabel();
		wallLabel1_6.setOpaque(true);
		wallLabel1_6.setBackground(Color.GRAY);
		wallLabel1_6.setBounds(871, 294, 72, 69);
		panel1F.add(wallLabel1_6);
		
		JLabel wallLabel1_7 = new JLabel();
		wallLabel1_7.setOpaque(true);
		wallLabel1_7.setBackground(Color.GRAY);
		wallLabel1_7.setBounds(871, 143, 72, 103);
		panel1F.add(wallLabel1_7);
		
		JLabel wallLabel1_8 = new JLabel();
		wallLabel1_8.setOpaque(true);
		wallLabel1_8.setBackground(Color.GRAY);
		wallLabel1_8.setBounds(0, 209, 72, 60);
		panel1F.add(wallLabel1_8);
		
		JLabel wallLabel1_9 = new JLabel();
		wallLabel1_9.setOpaque(true);
		wallLabel1_9.setBackground(Color.GRAY);
		wallLabel1_9.setBounds(0, 0, 117, 60);
		panel1F.add(wallLabel1_9);
		
		JLabel wallLabel1_10 = new JLabel();
		wallLabel1_10.setOpaque(true);
		wallLabel1_10.setBackground(Color.GRAY);
		wallLabel1_10.setBounds(329, 0, 79, 60);
		panel1F.add(wallLabel1_10);
		
		JLabel wallLabel1_11 = new JLabel();
		wallLabel1_11.setOpaque(true);
		wallLabel1_11.setBackground(Color.GRAY);
		wallLabel1_11.setBounds(126, 241, 21, 122);
		panel1F.add(wallLabel1_11);
		
		JLabel wallLabel1_12 = new JLabel();
		wallLabel1_12.setOpaque(true);
		wallLabel1_12.setBackground(Color.GRAY);
		wallLabel1_12.setBounds(126, 358, 93, 18);
		panel1F.add(wallLabel1_12);
		
		JLabel wallLabel1_13 = new JLabel();
		wallLabel1_13.setOpaque(true);
		wallLabel1_13.setBackground(Color.GRAY);
		wallLabel1_13.setBounds(126, 228, 93, 18);
		panel1F.add(wallLabel1_13);
		
		JLabel wallLabel1_14 = new JLabel();
		wallLabel1_14.setOpaque(true);
		wallLabel1_14.setBackground(Color.GRAY);
		wallLabel1_14.setBounds(648, 241, 21, 122);
		panel1F.add(wallLabel1_14);
		
		JLabel wallLabel1_15 = new JLabel();
		wallLabel1_15.setOpaque(true);
		wallLabel1_15.setBackground(Color.GRAY);
		wallLabel1_15.setBounds(576, 358, 93, 18);
		panel1F.add(wallLabel1_15);
		
		JLabel wallLabel1_16 = new JLabel();
		wallLabel1_16.setOpaque(true);
		wallLabel1_16.setBackground(Color.GRAY);
		wallLabel1_16.setBounds(576, 228, 93, 18);
		panel1F.add(wallLabel1_16);
		
		JLabel wallLabel1_17 = new JLabel();
		wallLabel1_17.setOpaque(true);
		wallLabel1_17.setBackground(Color.GRAY);
		wallLabel1_17.setBounds(765, 0, 50, 60);
		panel1F.add(wallLabel1_17);
		
		//쓰레기통 이미지
		JLabel trashcanLabel1_1 = new JLabel(); //화장실옆
		trashcanLabel1_1.setBounds(70, 53, 57, 54);
		trashcanLabel1_1.setIcon(updatetrashcanIcon);
		panel1F.add(trashcanLabel1_1);
		
		JLabel trashcanLabel1_2 = new JLabel(); //문옆
		trashcanLabel1_2.setBounds(814, 0, 57, 54);
		trashcanLabel1_2.setIcon(updatetrashcanIcon);
		panel1F.add(trashcanLabel1_2);
		
		//정수기 이미지
		JLabel waterPFLabel1_1 = new JLabel(); // 화장실옆
		waterPFLabel1_1.setBounds(70, 166, 35, 54);
		waterPFLabel1_1.setIcon(updateWaterPFIcon);
		panel1F.add(waterPFLabel1_1);
		
		JLabel waterPFLabel1_2 = new JLabel(); // 문옆
		waterPFLabel1_2.setBounds(876, 6, 57, 54);
		waterPFLabel1_2.setIcon(updateWaterPFIcon);
		panel1F.add(waterPFLabel1_2);
					
		//-------------------------------------------------------------------------------------------------------------
		//2층 배치도 판넬
		JPanel panel2F = new JPanel();
		panel2F.setBounds(71, 37, 945, 599);
		//panel2F.setBackground(Color.WHITE);
	    panel2F.setEnabled(false); //패널 비활성화
		panel2F.setVisible(false); //패널 감추기
		panel2F.setLayout(null);
		contentPane.add(panel2F);

		// 2층 좌석 버튼
		JButton seat201Btn = new JButton("201");
		seat201Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat201Btn.setFocusPainted(false);
		seat201Btn.setBorder(lb);
		seat201Btn.setBackground(new Color(0, 128, 255));
		seat201Btn.setBounds(190, 0, 72, 60);
		panel2F.add(seat201Btn);

		JButton seat202Btn = new JButton("202");
		seat202Btn.setBounds(264, 0, 72, 60);
		seat202Btn.setBackground(new Color(0, 128, 255));
		seat202Btn.setFont(logoutBtnFont);
		seat202Btn.setBorder(lb);
		seat202Btn.setFocusPainted(false);// hide focus rectangle
		panel2F.add(seat202Btn);

		JButton seat203Btn = new JButton("203");
		seat203Btn.setBounds(338, 0, 72, 60);
		seat203Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat203Btn.setBorder(lb);
		seat203Btn.setFocusPainted(false);
		seat203Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat203Btn);

		JButton seat204Btn = new JButton("204");
		seat204Btn.setBounds(414, 0, 72, 60);
		seat204Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat204Btn.setBorder(lb);
		seat204Btn.setFocusPainted(false);
		seat204Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat204Btn);

		JButton seat205Btn = new JButton("205");
		seat205Btn.setBounds(489, 0, 72, 60);
		seat205Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat205Btn.setBorder(lb);
		seat205Btn.setFocusPainted(false);
		seat205Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat205Btn);

		JButton seat206Btn = new JButton("206");
		seat206Btn.setBounds(563, 0, 72, 60);
		seat206Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat206Btn.setBorder(lb);
		seat206Btn.setFocusPainted(false);
		seat206Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat206Btn);

		JButton seat207Btn = new JButton("207");
		seat207Btn.setBounds(636, 0, 72, 60);
		seat207Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat207Btn.setBorder(lb);
		seat207Btn.setFocusPainted(false);
		seat207Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat207Btn);

		JButton seat208Btn = new JButton("208");
		seat208Btn.setBounds(215, 184, 72, 60);
		seat208Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat208Btn.setBorder(lb);
		seat208Btn.setFocusPainted(false);
		seat208Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat208Btn);

		JButton seat209Btn = new JButton("209");
		seat209Btn.setBounds(310, 184, 72, 60);
		seat209Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat209Btn.setBorder(lb);
		seat209Btn.setFocusPainted(false);
		seat209Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat209Btn);

		JButton seat210Btn = new JButton("210");
		seat210Btn.setBounds(402, 184, 72, 60);
		seat210Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat210Btn.setBorder(lb);
		seat210Btn.setFocusPainted(false);
		seat210Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat210Btn);

		JButton seat211Btn = new JButton("211");
		seat211Btn.setBounds(215, 264, 72, 60);
		seat211Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat211Btn.setBorder(lb);
		seat211Btn.setFocusPainted(false);
		seat211Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat211Btn);

		JButton seat212Btn = new JButton("212");
		seat212Btn.setBounds(310, 264, 72, 60);
		seat212Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat212Btn.setBorder(lb);
		seat212Btn.setFocusPainted(false);
		seat212Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat212Btn);

		JButton seat213Btn = new JButton("213");
		seat213Btn.setBounds(402, 264, 72, 60);
		seat213Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat213Btn.setBorder(lb);
		seat213Btn.setFocusPainted(false);
		seat213Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat213Btn);

		JButton seat214Btn = new JButton("214");
		seat214Btn.setBounds(600, 184, 72, 60);
		seat214Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat214Btn.setBorder(lb);
		seat214Btn.setFocusPainted(false);
		seat214Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat214Btn);

		JButton seat215Btn = new JButton("215");
		seat215Btn.setBounds(690, 184, 72, 60);
		seat215Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat215Btn.setBorder(lb);
		seat215Btn.setFocusPainted(false);
		seat215Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat215Btn);

		JButton seat216Btn = new JButton("216");
		seat216Btn.setBounds(600, 264, 72, 60);
		seat216Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat216Btn.setBorder(lb);
		seat216Btn.setFocusPainted(false);
		seat216Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat216Btn);

		JButton seat217Btn = new JButton("217");
		seat217Btn.setBounds(690, 264, 72, 60);
		seat217Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat217Btn.setBorder(lb);
		seat217Btn.setFocusPainted(false);
		seat217Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat217Btn);

		JButton seat218Btn = new JButton("218");
		seat218Btn.setBounds(0, 294, 72, 60);
		seat218Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat218Btn.setBorder(lb);
		seat218Btn.setFocusPainted(false);
		seat218Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat218Btn);

		JButton seat219Btn = new JButton("219");
		seat219Btn.setBounds(0, 355, 72, 60);
		seat219Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat219Btn.setBorder(lb);
		seat219Btn.setFocusPainted(false);
		seat219Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat219Btn);

		JButton seat220Btn = new JButton("220");
		seat220Btn.setBounds(0, 416, 72, 60);
		seat220Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat220Btn.setBorder(lb);
		seat220Btn.setFocusPainted(false);
		seat220Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat220Btn);

		JButton seat221Btn = new JButton("221");
		seat221Btn.setBounds(0, 478, 72, 60);
		seat221Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat221Btn.setBorder(lb);
		seat221Btn.setFocusPainted(false);
		seat221Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat221Btn);

		JButton seat222Btn = new JButton("222");
		seat222Btn.setBounds(0, 539, 72, 60);
		seat222Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat222Btn.setBorder(lb);
		seat222Btn.setFocusPainted(false);
		seat222Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat222Btn);

		JButton seat223Btn = new JButton("223");
		seat223Btn.setBounds(74, 539, 72, 60);
		seat223Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat223Btn.setBorder(lb);
		seat223Btn.setFocusPainted(false);
		seat223Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat223Btn);

		JButton seat224Btn = new JButton("224");
		seat224Btn.setBounds(258, 539, 72, 60);
		seat224Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat224Btn.setBorder(lb);
		seat224Btn.setFocusPainted(false);
		seat224Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat224Btn);

		JButton seat225Btn = new JButton("225");
		seat225Btn.setBounds(332, 539, 72, 60);
		seat225Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat225Btn.setBorder(lb);
		seat225Btn.setFocusPainted(false);
		seat225Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat225Btn);

		JButton seat226Btn = new JButton("226");
		seat226Btn.setBounds(406, 539, 72, 60);
		seat226Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat226Btn.setBorder(lb);
		seat226Btn.setFocusPainted(false);
		seat226Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat226Btn);

		JButton seat227Btn = new JButton("227");
		seat227Btn.setBounds(583, 539, 72, 60);
		seat227Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat227Btn.setBorder(lb);
		seat227Btn.setFocusPainted(false);
		seat227Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat227Btn);

		JButton seat228Btn = new JButton("228");
		seat228Btn.setBounds(656, 539, 72, 60);
		seat228Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat228Btn.setBorder(lb);
		seat228Btn.setFocusPainted(false);
		seat228Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat228Btn);

		JButton seat229Btn = new JButton("229");
		seat229Btn.setBounds(797, 539, 72, 60);
		seat229Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat229Btn.setBorder(lb);
		seat229Btn.setFocusPainted(false);
		seat229Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat229Btn);

		JButton seat230Btn = new JButton("230");
		seat230Btn.setBounds(871, 539, 72, 60);
		seat230Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat230Btn.setBorder(lb);
		seat230Btn.setFocusPainted(false);
		seat230Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat230Btn);

		JButton seat231Btn = new JButton("231");
		seat231Btn.setBounds(871, 478, 72, 60);
		seat231Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat231Btn.setBorder(lb);
		seat231Btn.setFocusPainted(false);
		seat231Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat231Btn);

		JButton seat232Btn = new JButton("232");
		seat232Btn.setBounds(871, 416, 72, 60);
		seat232Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat232Btn.setBorder(lb);
		seat232Btn.setFocusPainted(false);
		seat232Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat232Btn);

		JButton seat233Btn = new JButton("233");
		seat233Btn.setBounds(871, 184, 72, 60);
		seat233Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat233Btn.setBorder(lb);
		seat233Btn.setFocusPainted(false);
		seat233Btn.setBackground(new Color(0, 128, 255));
		panel2F.add(seat233Btn);

		// 2층 문
		JLabel doorLabel2_1 = new JLabel("문");
		doorLabel2_1.setOpaque(true);
		doorLabel2_1.setHorizontalAlignment(JLabel.CENTER);
		doorLabel2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel2_1.setBackground(new Color(128, 0, 0));
		doorLabel2_1.setBounds(882, 72, 61, 69);
		panel2F.add(doorLabel2_1);

		// 화장실
		JLabel toiletLabel2_1 = new JLabel("<html><body><center>화<br>장<br>실</center></body></html>");
		toiletLabel2_1.setOpaque(true);
		toiletLabel2_1.setHorizontalAlignment(JLabel.CENTER);
		toiletLabel2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel2_1.setBackground(new Color(255, 210, 0));
		toiletLabel2_1.setBounds(0, 60, 72, 180);
		panel2F.add(toiletLabel2_1);
		
		//쓰레기통 이미지
		JLabel trashcanLabel2_1 = new JLabel(); //화장실옆
		trashcanLabel2_1.setBounds(76, 184, 57, 54);   
		trashcanLabel2_1.setIcon(updatetrashcanIcon);
		panel2F.add(trashcanLabel2_1);
		
		JLabel trashcanLabel2_2 = new JLabel(); //문옆
		trashcanLabel2_2.setBounds(871, 6, 57, 54);
		trashcanLabel2_2.setIcon(updatetrashcanIcon);
		panel2F.add(trashcanLabel2_2);
		
		//정수기 이미지
		JLabel waterPFLabel2_1 = new JLabel(); //화장실옆
		waterPFLabel2_1.setBounds(152, 0, 35, 70);   
		waterPFLabel2_1.setIcon(updateWaterPFIcon);
		panel2F.add(waterPFLabel2_1);
		
		JLabel waterPFLabel2_2 = new JLabel(); //문옆
		waterPFLabel2_2.setBounds(839, 6, 35, 54);
		waterPFLabel2_2.setIcon(updateWaterPFIcon);
		panel2F.add(waterPFLabel2_2);
		
		//벽라벨들
		JLabel wallLabel2_1 = new JLabel();
		wallLabel2_1.setOpaque(true);
		wallLabel2_1.setBackground(Color.GRAY);
		wallLabel2_1.setBounds(148, 539, 108, 60);
		panel2F.add(wallLabel2_1);
		
		JLabel wallLabel2_2 = new JLabel();
		wallLabel2_2.setOpaque(true);
		wallLabel2_2.setBackground(Color.GRAY);
		wallLabel2_2.setBounds(0, 0, 148, 60);
		panel2F.add(wallLabel2_2);
		
		JLabel wallLabel2_3 = new JLabel();
		wallLabel2_3.setOpaque(true);
		wallLabel2_3.setBackground(Color.GRAY);
		wallLabel2_3.setBounds(0, 241, 122, 54);
		panel2F.add(wallLabel2_3);
		
		JLabel wallLabel2_4 = new JLabel();
		wallLabel2_4.setOpaque(true);
		wallLabel2_4.setBackground(Color.GRAY);
		wallLabel2_4.setBounds(477, 539, 108, 60);
		panel2F.add(wallLabel2_4);
		
		JLabel wallLabel2_5 = new JLabel();
		wallLabel2_5.setOpaque(true);
		wallLabel2_5.setBackground(Color.GRAY);
		wallLabel2_5.setBounds(728, 539, 72, 60);
		panel2F.add(wallLabel2_5);
		
		JLabel wallLabel2_6 = new JLabel();
		wallLabel2_6.setOpaque(true);
		wallLabel2_6.setBackground(Color.GRAY);
		wallLabel2_6.setBounds(871, 241, 72, 176);
		panel2F.add(wallLabel2_6);
		
		JLabel wallLabel2_7 = new JLabel();
		wallLabel2_7.setOpaque(true);
		wallLabel2_7.setBackground(Color.GRAY);
		wallLabel2_7.setBounds(871, 141, 72, 47);
		panel2F.add(wallLabel2_7);
		
		JLabel wallLabel2_8 = new JLabel();
		wallLabel2_8.setOpaque(true);
		wallLabel2_8.setBackground(Color.GRAY);
		wallLabel2_8.setBounds(709, 0, 57, 60);
		panel2F.add(wallLabel2_8);
		
		JLabel wallLabel2_9 = new JLabel();
		wallLabel2_9.setOpaque(true);
		wallLabel2_9.setBackground(Color.GRAY);
		wallLabel2_9.setBounds(215, 241, 259, 23);
		panel2F.add(wallLabel2_9);
		
		JLabel wallLabel2_10 = new JLabel();
		wallLabel2_10.setOpaque(true);
		wallLabel2_10.setBackground(Color.GRAY);
		wallLabel2_10.setBounds(600, 244, 162, 23);
		panel2F.add(wallLabel2_10);
		
		JLabel wallLabel2_11 = new JLabel();
		wallLabel2_11.setOpaque(true);
		wallLabel2_11.setBackground(Color.GRAY);
		wallLabel2_11.setBounds(670, 184, 23, 140);
		panel2F.add(wallLabel2_11);
		
		JLabel wallLabel2_12 = new JLabel();
		wallLabel2_12.setOpaque(true);
		wallLabel2_12.setBackground(Color.GRAY);
		wallLabel2_12.setBounds(380, 184, 23, 140);
		panel2F.add(wallLabel2_12);
		
		JLabel wallLabel2_13 = new JLabel();
		wallLabel2_13.setOpaque(true);
		wallLabel2_13.setBackground(Color.GRAY);
		wallLabel2_13.setBounds(285, 184, 27, 140);
		panel2F.add(wallLabel2_13);
		setVisible(true);	
		//-----------------------------------------------------------------------------------------
		//로그아웃 버튼
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(982, 0, 116, 31);
		logoutBtn.setBackground(new Color(255, 0, 0));
		logoutBtn.setFont(logoutBtnFont);
        logoutBtn.setFocusPainted(false);// hide focus rectangle
		contentPane.add(logoutBtn);
		
		//질문확인 버튼
		JButton searchQuestionBtn = new JButton("<html><body><center>질"
        		+ "<br>문</center><br>확<br>인</body></html>");
		searchQuestionBtn.setBounds(1036, 140, 62, 395);
		searchQuestionBtn.setBackground(new Color(0, 255, 64));
		searchQuestionBtn.setFont(logoutBtnFont);
		searchQuestionBtn.setFocusPainted(false);// hide focus rectangle
		searchQuestionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(searchQuestionBtn);
		
		//구역(1층) 선택 버튼
		JButton firstFloorBtn = new JButton("1층");
		firstFloorBtn.setBounds(0, 659, 116, 38);
		firstFloorBtn.setBackground(new Color(245, 134, 52));
		firstFloorBtn.setFont(logoutBtnFont);
		firstFloorBtn.setFocusPainted(false);// hide focus rectangle
		firstFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2F.setEnabled(false); //2층 배치도 비활성화
				panel2F.setVisible(false); //2층 배치도 감추기
				panel1F.setEnabled(true); //1층 배치도 비활성화
				panel1F.setVisible(true); //1층 배치도 감추기
			}
		});
		contentPane.add(firstFloorBtn);
		
		//구역(2층) 선택 버튼
		JButton secondFloorBtn = new JButton("2층");
		secondFloorBtn.setBounds(0, 625, 116, 38);
		secondFloorBtn.setBackground(new Color(248, 211, 129));
		secondFloorBtn.setFont(logoutBtnFont);
		secondFloorBtn.setFocusPainted(false);// hide focus rectangle
		secondFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1F.setEnabled(false); //1층 배치도 비활성화
				panel1F.setVisible(false); //1층 배치도 감추기
				panel2F.setEnabled(true); //2층 배치도 비활성화
				panel2F.setVisible(true); //2층 배치도 감추기
			}
		});
		contentPane.add(secondFloorBtn);
		
		//접속중인 관리자 ID(이름?)
		JLabel idLabel = new JLabel("관리자:"); // + 관리자 ID + " 님" 추가필요
		idLabel.setBounds(71, 0, 197, 38);
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setFont(logoutBtnFont);
		contentPane.add(idLabel);
		
		//로고이미지
		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(0, 0, 70, 69);       
        logoLabel.setIcon(updateLogoIcon);
        getContentPane().add(logoLabel);
        //--------------------------------------------------------------------------------------------------
    	class SeatBtnListener implements ActionListener {
    		//의자버튼 눌렀을때 동작
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if(memberInfoPanel.isEnabled()==false||seatInfoPanel.isEnabled()==false)
    			{
    				seatInfoPanel.setVisible(true);
    				seatInfoPanel.setEnabled(true);
    				
    			}
    		}
    	}
	}
	
	
}
