package study;

import java.awt.Color;
import study.UI1;
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
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

import ch06.ThisEx1;

import javax.swing.Box;
import javax.swing.SwingConstants;

class MemberInfoDTO{
	//회원정보
	private String memberTel;
	
	public MemberInfoDTO(String memberTel) {
		this.memberTel=memberTel;
	}

	public String getMemberTel() {
		return memberTel;
	}
}
class ManagerInfoDTO{
	//매니저 정보
	private String managerId;
	
	public ManagerInfoDTO(String managerId) {
		this.managerId=managerId;
	}

	public String getManagerId() {
		return managerId;
	}
}
class QuestInfoDTO{
	//질문 정보
	private String question;
	
	public QuestInfoDTO(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}
}

class QuestDialog extends JDialog{
	public QuestDialog(String title, boolean modal, ManagerInfoDTO managerInfo, QuestInfoDTO questInfo,ManagerMain mMain)
	{
		//다이얼로그 생성자 호출
		super(mMain, title, modal);
		
		//다이얼로그 설정
		this.setTitle(managerInfo.getManagerId()+"님 환영합니다."); //매니저 ID 읽어와서 창 제목 변경
		this.setBounds(100, 100, 500, 700);
		this.setLocationRelativeTo(mMain);
		this.setResizable(false);
		
		//패널추가
		JPanel questListPanel = new JPanel();
		questListPanel.setLayout(null);
		this.setContentPane(questListPanel);
		
		//--TODO 라벨, 삭제버튼 생성은 DB에서 받아와서 질문개수만큼 반복필요--
		//라벨추가
        //QuestInfo의 정보를 받아와서 라벨에 표시-DB연동 필요
        JLabel questLabel = new JLabel("질문:"+questInfo.getQuestion());
        questLabel.setBounds(0, 100, 100, 50);
        questListPanel.add(questLabel);
		
		//삭제버튼 추가
        JButton questDeleteBtn = new JButton("삭제");
        questDeleteBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        questDeleteBtn.setBackground(Color.RED);
        questDeleteBtn.setFocusPainted(false);
        questDeleteBtn.setBounds
        (questLabel.getX(), questLabel.getY()-20,80, 30);
        questDeleteBtn.addMouseListener(new MouseInputAdapter() {
		//버튼을 누르면 questLabel 삭제
            @Override
            public void mouseClicked(MouseEvent e) {
            	questListPanel.remove(questLabel); //삭제
            	questListPanel.repaint(); //다시그리기
            }
        });
        questListPanel.add(questDeleteBtn);   
	}
}

public class ManagerMain extends JFrame {

	private JPanel contentPane;
	
	 //버튼 디자인(둥근 모서리 버튼 쓸때 사용)
//	   public class RoundedButton extends JButton {
//	      public RoundedButton() { super(); decorate(); } 
//	      public RoundedButton(String text) { super(text); decorate(); } 
//	      public RoundedButton(Action action) { super(action); decorate(); } 
//	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
//	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
//	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
//	      @Override 
//	      protected void paintComponent(Graphics g) {
//	         Color c=new Color(255,247,242); //배경색 결정
//	         Color o=new Color(247,99,12); //글자색 결정
//	         int width = getWidth(); 
//	         int height = getHeight(); 
//	         Graphics2D graphics = (Graphics2D) g; 
//	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
//	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
//	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
//	         else { graphics.setColor(c); } 
//	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
//	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
//	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
//	         int textX = (width - stringBounds.width) / 2; 
//	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
//	         graphics.setColor(o); 
//	         graphics.setFont(getFont()); 
//	         graphics.drawString(getText(), textX, textY); 
//	         graphics.dispose(); 
//	         super.paintComponent(g); 
//	         }
//	      }
	
	public static void main(String[] args) {
		//전부 주석처리하면 이파일자체로 실행안됨, 로그인창에서 넘어오는 실행은 그대로 가능
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain Jframe = new ManagerMain("홍길동");
					Jframe.setVisible(true);
					Jframe.setResizable(false);
					Jframe.setTitle("FamilyStudyCafe_ManagerMain");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//프레임 생성
	public ManagerMain(String name) {
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
			//----------------------------------------------------------------------------	
			
			//좌석정보 패널- 켜지면 다른 좌석 버튼등은 다 못누르게 해야함(처음에 활성화안되고 안보이는 상태)
			//TODO DB연동해서 seatNum, seatAvail 받아와야함
			JPanel seatInfoPanel = new JPanel();
			seatInfoPanel.setOpaque(true);
			seatInfoPanel.setBorder(lb);
			seatInfoPanel.setBounds(420, 150, 165, 251);
			seatInfoPanel.setBackground(new Color(128, 255, 128));
			seatInfoPanel.setLayout(null);
			seatInfoPanel.setEnabled(false);
			seatInfoPanel.setVisible(false);
			
			//------------------------------------------------------------------------------------------------------------
			//회원정보 패널
			JPanel memberInfoPanel = new JPanel();
			memberInfoPanel.setLayout(null);
			memberInfoPanel.setOpaque(true);
			memberInfoPanel.setBackground(new Color(128, 255, 128));
			memberInfoPanel.setBounds(420, 150, 165, 251);
			memberInfoPanel.setEnabled(false);
			memberInfoPanel.setVisible(false);	
			
			//"회원 정보" 글자 라벨
			JLabel seatInfoStrLabel_1 = new JLabel("회원정보");
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
			
			//TODO DB의 Member테이블 remainTime 연동필요
			//남은시간 글자 라벨
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
			
			//TODO DB의 SEAT테이블 seatNum 연동필요
	     	//좌석번호 숫자 라벨
			JLabel seatNumLabel_memberInfoPanel = new JLabel("105");
			seatNumLabel_memberInfoPanel.setHorizontalAlignment(JLabel.CENTER);
			seatNumLabel_memberInfoPanel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumLabel_memberInfoPanel.setBackground(new Color(128, 0, 0));
			seatNumLabel_memberInfoPanel.setBounds(12, 191, 39, 23);
			memberInfoPanel.add(seatNumLabel_memberInfoPanel);
			
			//TODO DB의 SEAT테이블 seatAvail 연동필요
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
			memberInfoPanel.setBorder(lb);
			contentPane.add(memberInfoPanel);
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
			
			//TODO DB의 SEAT테이블 seatNum 연동필요
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
			
			//TODO DB의 MEMBER테이블 memberTEL 연동필요
			//회원 전화번호 라벨
			JLabel memberTelLabel = new JLabel("010-1234-1234");
			//memberTelLabel.setOpaque(true);
			memberTelLabel.setHorizontalAlignment(JLabel.CENTER);
			memberTelLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			memberTelLabel.setBackground(new Color(128, 0, 0));
			memberTelLabel.setBounds(12, 212, 141, 23);
			seatInfoPanel.add(memberTelLabel);
					
		//-----------------------------------------------------------------------------------------------------------
			//1층 배치도 판넬
			JPanel panel1F = new JPanel();
			panel1F.setBounds(71, 37, 945, 599);
			panel1F.setLayout(null);
			//panel1F.setEnabled(false); //패널 비활성화
			//panel1F.setVisible(false); //패널 감추기
			contentPane.add(panel1F);
			
			//TODO DB에서 좌석정보 받아와서 이름(seatNum), 상태(seatAvail)에따라 색 등 지정필요
			//1층 좌석 버튼 생성, 위치지정
	    	String[] seat1Farr = {"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"
	    			, "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124"
	    			,"125", "126","127", "128", "129", "130"};
	    	JButton[] seat1FBtn = new JButton[31];
	    	
	    	
	    	FindSeatTable findSeatTable = new FindSeatTable();
	    	
	    	for (int i = 0; i < seat1Farr.length; i++) {
				seat1FBtn[i] = new JButton(seat1Farr[i]);
				seat1FBtn[i].setBounds(871, 184, 72, 60);
				seat1FBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
				seat1FBtn[i].setBorder(lb);
				seat1FBtn[i].setFocusPainted(false);
				//seat1FBtn[i].setBackground(new Color(0, 128, 255));
		    	try {
					if (findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i]))==0) 
					{//사용가능
						seat1FBtn[i].setBackground(Color.CYAN);
					} else
						try {
							if(findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i]))==1)
							{//사용중
								seat1FBtn[i].setBackground(Color.ORANGE);
							} else
								try {
									if(findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i]))==2)
									{//사용불가
										seat1FBtn[i].setBackground(Color.RED);
									}
								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel1F.add(seat1FBtn[i]);
			}
	    	
	    	//인덱스(i)의 값을 seatNum으로 가지는 seatAvail 검색
	    	Integer.parseInt(seat1Farr[0]);
	    	
			seat1FBtn[0].setBounds(114, 0, 72, 60); //100번 좌석
			seat1FBtn[1].setBounds(186, 0, 72, 60);
			seat1FBtn[2].setBounds(259, 0, 72, 60);
			seat1FBtn[3].setBounds(402, 0, 72, 60);
			seat1FBtn[4].setBounds(475, 0, 72, 60);
			seat1FBtn[5].setBounds(548, 0, 72, 60);
			seat1FBtn[6].setBounds(621, 0, 72, 60);
			seat1FBtn[7].setBounds(694, 0, 72, 60);
			seat1FBtn[8].setBounds(147, 241, 72, 60);
			seat1FBtn[9].setBounds(147, 303, 72, 60);
			seat1FBtn[10].setBounds(329, 241, 72, 60);
			seat1FBtn[11].setBounds(402, 241, 72, 60);
			seat1FBtn[12].setBounds(329, 303, 72, 60);
			seat1FBtn[13].setBounds(402, 303, 72, 60);
			seat1FBtn[14].setBounds(576, 241, 72, 60);
			seat1FBtn[15].setBounds(576, 303, 72, 60);
			seat1FBtn[16].setBounds(0, 253, 72, 60);
			seat1FBtn[17].setBounds(0, 314, 72, 60);
			seat1FBtn[18].setBounds(0, 375, 72, 60);
			seat1FBtn[19].setBounds(0, 437, 72, 60);
			seat1FBtn[20].setBounds(98, 539, 72, 60);
			seat1FBtn[21].setBounds(171, 539, 72, 60);
			seat1FBtn[22].setBounds(329, 539, 72, 60);
			seat1FBtn[23].setBounds(402, 539, 72, 60);
			seat1FBtn[24].setBounds(475, 539, 72, 60);
			seat1FBtn[25].setBounds(648, 539, 72, 60);
			seat1FBtn[26].setBounds(721, 539, 72, 60);
			seat1FBtn[27].setBounds(871, 480, 72, 60);
			seat1FBtn[28].setBounds(871, 419, 72, 60);
			seat1FBtn[29].setBounds(871, 358, 72, 60);
			seat1FBtn[30].setBounds(871, 241, 72, 60);
			
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
		
		//1층 벽라벨 생성, 위치지정
    	JLabel[] wall1FLabel = new JLabel[17];
    	
    	for (int i = 0; i < wall1FLabel.length; i++) {
			wall1FLabel[i] = new JLabel();
			wall1FLabel[i].setBounds(871, 184, 72, 60);
			wall1FLabel[i].setOpaque(true);
			wall1FLabel[i].setBackground(Color.GRAY);
			panel1F.add(wall1FLabel[i]);
		}
    	
    	wall1FLabel[0].setBounds(0, 496, 72, 103);
    	wall1FLabel[1].setBounds(26, 539, 72, 60);
    	wall1FLabel[2].setBounds(241, 539, 90, 60);
    	wall1FLabel[3].setBounds(536, 539, 112, 60);
    	wall1FLabel[4].setBounds(787, 539, 156, 60);
    	wall1FLabel[5].setBounds(871, 294, 72, 69);
    	wall1FLabel[6].setBounds(871, 143, 72, 103);
    	wall1FLabel[7].setBounds(0, 209, 72, 60);
    	wall1FLabel[8].setBounds(0, 0, 117, 60);
    	wall1FLabel[9].setBounds(329, 0, 79, 60);
    	wall1FLabel[10].setBounds(126, 241, 21, 122);
    	wall1FLabel[11].setBounds(126, 358, 93, 18);
    	wall1FLabel[12].setBounds(126, 228, 93, 18);
    	wall1FLabel[13].setBounds(648, 241, 21, 122);
    	wall1FLabel[14].setBounds(576, 358, 93, 18);
    	wall1FLabel[15].setBounds(576, 228, 93, 18);
    	wall1FLabel[16].setBounds(765, 0, 50, 60);
		
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

		//TODO DB에서 좌석정보 받아와서 이름(seatNum), 상태(seatAvail)에따라 색 등 지정필요
		// 2층 좌석 버튼 생성, 위치지정
    	String[] seat2Farr = {"200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210"
    			, "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224"
    			,"225", "226","227", "228", "229", "230", "231", "232"};
    	JButton[] seat2FBtn = new JButton[33];
    	
    	for (int i = 0; i < seat2Farr.length; i++) {
			seat2FBtn[i] = new JButton(seat2Farr[i]);
			seat2FBtn[i].setBounds(871, 184, 72, 60);
			seat2FBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
			seat2FBtn[i].setBorder(lb);
			seat2FBtn[i].setFocusPainted(false);
			//seat2FBtn[i].setBackground(new Color(0, 128, 255)); //seatAvail에따라 변경
	    	try {
				if (findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i]))==0) 
				{//사용가능
					seat2FBtn[i].setBackground(Color.CYAN);
				} else
					try {
						if(findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i]))==1)
						{//사용중
							seat2FBtn[i].setBackground(Color.ORANGE);
						}
						else if(findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i]))==2)
						{//사용불가
							seat2FBtn[i].setBackground(Color.RED);
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			panel2F.add(seat2FBtn[i]);
		}

		seat2FBtn[0].setBounds(190, 0, 72, 60); //200번 의자
		seat2FBtn[1].setBounds(264, 0, 72, 60);
		seat2FBtn[2].setBounds(338, 0, 72, 60);
		seat2FBtn[3].setBounds(414, 0, 72, 60);
		seat2FBtn[4].setBounds(489, 0, 72, 60);
		seat2FBtn[5].setBounds(563, 0, 72, 60);
		seat2FBtn[6].setBounds(636, 0, 72, 60);
		seat2FBtn[7].setBounds(215, 184, 72, 60);
		seat2FBtn[8].setBounds(310, 184, 72, 60);
		seat2FBtn[9].setBounds(402, 184, 72, 60);
		seat2FBtn[10].setBounds(215, 264, 72, 60);
		seat2FBtn[11].setBounds(310, 264, 72, 60);
		seat2FBtn[12].setBounds(402, 264, 72, 60);
		seat2FBtn[13].setBounds(600, 184, 72, 60);
		seat2FBtn[14].setBounds(690, 184, 72, 60);
		seat2FBtn[15].setBounds(600, 264, 72, 60);
		seat2FBtn[16].setBounds(690, 264, 72, 60);
		seat2FBtn[17].setBounds(0, 294, 72, 60);
		seat2FBtn[18].setBounds(0, 355, 72, 60);
		seat2FBtn[19].setBounds(0, 416, 72, 60);
		seat2FBtn[20].setBounds(0, 478, 72, 60);
		seat2FBtn[21].setBounds(0, 539, 72, 60);
		seat2FBtn[22].setBounds(74, 539, 72, 60);
		seat2FBtn[23].setBounds(258, 539, 72, 60);
		seat2FBtn[24].setBounds(332, 539, 72, 60);
		seat2FBtn[25].setBounds(406, 539, 72, 60);
		seat2FBtn[26].setBounds(583, 539, 72, 60);
		seat2FBtn[27].setBounds(656, 539, 72, 60);
		seat2FBtn[28].setBounds(797, 539, 72, 60);
		seat2FBtn[29].setBounds(871, 539, 72, 60);
		seat2FBtn[30].setBounds(871, 478, 72, 60);
		seat2FBtn[31].setBounds(871, 416, 72, 60);
		seat2FBtn[32].setBounds(871, 184, 72, 60);

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
		
		// 2층 벽라벨 생성, 위치지정
    	//String[] wall2Farr = {};
    	JLabel[] wall2FLabel = new JLabel[13];
    	
    	for (int i = 0; i < wall2FLabel.length; i++) {
			wall2FLabel[i] = new JLabel();
			wall2FLabel[i].setBounds(871, 184, 72, 60);
			wall2FLabel[i].setOpaque(true);
			wall2FLabel[i].setBackground(Color.GRAY);
			panel2F.add(wall2FLabel[i]);
		}
    	
			wall2FLabel[0].setBounds(148, 539, 108, 60);
			wall2FLabel[1].setBounds(0, 0, 148, 60);
			wall2FLabel[2].setBounds(0, 241, 122, 54);
			wall2FLabel[3].setBounds(477, 539, 108, 60);
			wall2FLabel[4].setBounds(728, 539, 72, 60);
			wall2FLabel[5].setBounds(871, 241, 72, 176);
			wall2FLabel[6].setBounds(871, 141, 72, 47);
			wall2FLabel[7].setBounds(709, 0, 57, 60);
			wall2FLabel[8].setBounds(215, 241, 259, 23);
			wall2FLabel[9].setBounds(600, 244, 162, 23);
			wall2FLabel[10].setBounds(670, 184, 23, 140);
			wall2FLabel[11].setBounds(380, 184, 23, 140);
			wall2FLabel[12].setBounds(285, 184, 27, 140);

//		setVisible(true);	
		//-----------------------------------------------------------------------------------------

			//로그아웃 버튼--누르면 관리자로그인창으로
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(982, 0, 116, 31);
		logoutBtn.setBackground(new Color(255, 0, 0));
		logoutBtn.setFont(logoutBtnFont);
        logoutBtn.setFocusPainted(false);// hide focus rectangle
    	logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0); //매니저 메인화면 닫기(0 == 정상종료)  <=이거쓰면 새창도 안나옴
				dispose(); //이걸쓰자
				new ManagerLogin();//관리자 로그인 창 띄움- 관리자로그인창 고치고 수정필요
			}
		});
		contentPane.add(logoutBtn);
		
		
		//TODO 임시로 해둠, 실제 DB값 받아오고 지우기
		//managerInfo, quest값 데이터 매개변수로 가진 객체 생성
		ManagerInfoDTO manager1 = new ManagerInfoDTO("corlwn");
		QuestInfoDTO quest1 = new QuestInfoDTO("질문입니다");
		
		//TODO DB, 채팅질문목록기능 연동해야함
		//질문확인 버튼
		JButton searchQuestionBtn = new JButton("<html><body><center>질"
        		+ "<br>문</center><br>확<br>인</body></html>");
		searchQuestionBtn.setBounds(1036, 140, 62, 395);
		searchQuestionBtn.setBackground(new Color(0, 255, 64));
		searchQuestionBtn.setFont(logoutBtnFont);
		searchQuestionBtn.setFocusPainted(false);// hide focus rectangle
		searchQuestionBtn.addActionListener(new ActionListener() {//누르면 아래 기능 동작
			public void actionPerformed(ActionEvent e) {
	              // QuestDialog생성
                QuestDialog questDialog = new QuestDialog //위에서 정의해놓은 QuestDialog 클래스 객체 생성
                		("", true, manager1,quest1, ManagerMain.this); //매개변수(위에서 정한만큼)
                questDialog.setVisible(true);
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
		
		//TODO DB에서 managerID 읽어와서 연동
		//매개변수로 지금 로그인한 관리자ID넣기
		JLabel idLabel = new JLabel("관리자:"+name+" 님"); 
		idLabel.setBounds(71, 0, 197, 38);
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setFont(logoutBtnFont);
		contentPane.add(idLabel);
		
		//좌측상단 로고이미지
		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(0, 0, 70, 69);       
        logoLabel.setIcon(updateLogoIcon);
        getContentPane().add(logoLabel);
        //--------------------------------------------------------------------------------------------------
    	class SeatBtnListener implements ActionListener {
    		//의자버튼 눌렀을때 동작 		seat2FBtn[0] //200번 의자
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			JButton seatSource = (JButton)e.getSource(); //클릭한 버튼의 라벨값 읽어옴
    			FindUseTable findUseTable = new FindUseTable();
    			String usestat = null; //seatInfoPanel의 memberTelLabel에 들어갈 
    			
    			//의자 라벨의 값 읽어와서 의자정보 패널의 의자번호 라벨에 붙임
    			seatNumLabel_seatInfoPanel.setText(seatSource.getText());//
    			if(memberInfoPanel.isEnabled()==false||seatInfoPanel.isEnabled()==false)
    			{
    				//클릭한 의자라벨값 읽어와서 findUse 실행(사용중인지 검사)
    				try {
						usestat = findUseTable.findUse(Integer.parseInt(seatSource.getText()));
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
    				if(usestat=="0")//리턴받은값이 0이면 회원전화번호 라벨에서 지우기(공백상태로 둠)
    				{
    					memberTelLabel.setText("");
    				}
    				else
    				{
    					//사용 테이블에서 유저 전화번호 검색해와서 집어넣기
    					memberTelLabel.setText(usestat);
    				}
    				
    				seatInfoPanel.setVisible(true);
    				seatInfoPanel.setEnabled(true);
    				
    				//패널 아래의 1층좌석 버튼 비활성화
    				seat1FBtn[10].setEnabled(false);
    				seat1FBtn[10].setVisible(false);
    				seat1FBtn[11].setEnabled(false);
    				seat1FBtn[11].setVisible(false);
    				seat1FBtn[12].setEnabled(false);
    				seat1FBtn[12].setVisible(false);
    				seat1FBtn[13].setEnabled(false);
    				seat1FBtn[13].setVisible(false);

    				//패널 아래의 2층좌석 버튼 비활성화
    				seat2FBtn[8].setEnabled(false);
    				seat2FBtn[8].setVisible(false);
    				seat2FBtn[9].setEnabled(false);
    				seat2FBtn[9].setVisible(false);
    				seat2FBtn[11].setEnabled(false);
    				seat2FBtn[11].setVisible(false);
    				seat2FBtn[12].setEnabled(false);
    				seat2FBtn[12].setVisible(false);
    			}
    		}
    	}
    	
    	//좌석버튼에 액션리스너 기능 추가
    	SeatBtnListener seatBtnListener = new SeatBtnListener();
    	for (int i = 0; i < seat1Farr.length; i++) {
    		seat1FBtn[i].addActionListener(seatBtnListener);
		}
    	for (int i = 0; i < seat2Farr.length; i++) {
			seat2FBtn[i].addActionListener(seatBtnListener);
		}
    	
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
				
				//패널 아래의 1층좌석 버튼 활성화
				seat1FBtn[10].setEnabled(true);
				seat1FBtn[10].setVisible(true);
				seat1FBtn[11].setEnabled(true);
				seat1FBtn[11].setVisible(true);
				seat1FBtn[12].setEnabled(true);
				seat1FBtn[12].setVisible(true);
				seat1FBtn[13].setEnabled(true);
				seat1FBtn[13].setVisible(true);

				//패널 아래의 2층좌석 버튼 활성화
				seat2FBtn[8].setEnabled(true);
				seat2FBtn[8].setVisible(true);
				seat2FBtn[9].setEnabled(true);
				seat2FBtn[9].setVisible(true);
				seat2FBtn[11].setEnabled(true);
				seat2FBtn[11].setVisible(true);
				seat2FBtn[12].setEnabled(true);
				seat2FBtn[12].setVisible(true);
			}
		});
		closeBtn_seatInfoPanel.setBorder(lb);
		closeBtn_seatInfoPanel.setFocusPainted(false);
		seatInfoPanel.add(closeBtn_seatInfoPanel);
	}	
	
}