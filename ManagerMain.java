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
	//ȸ������
	private String memberTel;
	
	public MemberInfoDTO(String memberTel) {
		this.memberTel=memberTel;
	}

	public String getMemberTel() {
		return memberTel;
	}
}
class ManagerInfoDTO{
	//�Ŵ��� ����
	private String managerId;
	
	public ManagerInfoDTO(String managerId) {
		this.managerId=managerId;
	}

	public String getManagerId() {
		return managerId;
	}
}
class QuestInfoDTO{
	//���� ����
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
		//���̾�α� ������ ȣ��
		super(mMain, title, modal);
		
		//���̾�α� ����
		this.setTitle(managerInfo.getManagerId()+"�� ȯ���մϴ�."); //�Ŵ��� ID �о�ͼ� â ���� ����
		this.setBounds(100, 100, 500, 700);
		this.setLocationRelativeTo(mMain);
		this.setResizable(false);
		
		//�г��߰�
		JPanel questListPanel = new JPanel();
		questListPanel.setLayout(null);
		this.setContentPane(questListPanel);
		
		//--TODO ��, ������ư ������ DB���� �޾ƿͼ� ����������ŭ �ݺ��ʿ�--
		//���߰�
        //QuestInfo�� ������ �޾ƿͼ� �󺧿� ǥ��-DB���� �ʿ�
        JLabel questLabel = new JLabel("����:"+questInfo.getQuestion());
        questLabel.setBounds(0, 100, 100, 50);
        questListPanel.add(questLabel);
		
		//������ư �߰�
        JButton questDeleteBtn = new JButton("����");
        questDeleteBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        questDeleteBtn.setBackground(Color.RED);
        questDeleteBtn.setFocusPainted(false);
        questDeleteBtn.setBounds
        (questLabel.getX(), questLabel.getY()-20,80, 30);
        questDeleteBtn.addMouseListener(new MouseInputAdapter() {
		//��ư�� ������ questLabel ����
            @Override
            public void mouseClicked(MouseEvent e) {
            	questListPanel.remove(questLabel); //����
            	questListPanel.repaint(); //�ٽñ׸���
            }
        });
        questListPanel.add(questDeleteBtn);   
	}
}

public class ManagerMain extends JFrame {

	private JPanel contentPane;
	
	 //��ư ������(�ձ� �𼭸� ��ư ���� ���)
//	   public class RoundedButton extends JButton {
//	      public RoundedButton() { super(); decorate(); } 
//	      public RoundedButton(String text) { super(text); decorate(); } 
//	      public RoundedButton(Action action) { super(action); decorate(); } 
//	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
//	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
//	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
//	      @Override 
//	      protected void paintComponent(Graphics g) {
//	         Color c=new Color(255,247,242); //���� ����
//	         Color o=new Color(247,99,12); //���ڻ� ����
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
		//���� �ּ�ó���ϸ� ��������ü�� ����ȵ�, �α���â���� �Ѿ���� ������ �״�� ����
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain Jframe = new ManagerMain("ȫ�浿");
					Jframe.setVisible(true);
					Jframe.setResizable(false);
					Jframe.setTitle("FamilyStudyCafe_ManagerMain");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//������ ����
	public ManagerMain(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1114, 736);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 228, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		  //��Ʈ(������� ���� 16)
		Font logoutBtnFont = new Font("������� ����", Font.BOLD, 16);
		 //�׵θ��� ����
		 LineBorder lb = new LineBorder(Color.BLACK,2);
		setVisible(true);
		
		ImageIcon logoIcon= new ImageIcon
				("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\src\\img\\family.jpg");
        Image logoImg = logoIcon.getImage(); // ImageIcon ��ü���� Image ����
    	Image updateLogoImg = logoImg.getScaledInstance(70, 69, Image.SCALE_SMOOTH);         // ����� Image�� ũ�� �����Ͽ� ���ο� Image ��ü ����
        ImageIcon updateLogoIcon = new ImageIcon(updateLogoImg);  // ���ο� Image ��ü�� ImageIcon ��ü ����
        
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
			
			//�¼����� �г�- ������ �ٸ� �¼� ��ư���� �� �������� �ؾ���(ó���� Ȱ��ȭ�ȵǰ� �Ⱥ��̴� ����)
			//TODO DB�����ؼ� seatNum, seatAvail �޾ƿ;���
			JPanel seatInfoPanel = new JPanel();
			seatInfoPanel.setOpaque(true);
			seatInfoPanel.setBorder(lb);
			seatInfoPanel.setBounds(420, 150, 165, 251);
			seatInfoPanel.setBackground(new Color(128, 255, 128));
			seatInfoPanel.setLayout(null);
			seatInfoPanel.setEnabled(false);
			seatInfoPanel.setVisible(false);
			
			//------------------------------------------------------------------------------------------------------------
			//ȸ������ �г�
			JPanel memberInfoPanel = new JPanel();
			memberInfoPanel.setLayout(null);
			memberInfoPanel.setOpaque(true);
			memberInfoPanel.setBackground(new Color(128, 255, 128));
			memberInfoPanel.setBounds(420, 150, 165, 251);
			memberInfoPanel.setEnabled(false);
			memberInfoPanel.setVisible(false);	
			
			//"ȸ�� ����" ���� ��
			JLabel seatInfoStrLabel_1 = new JLabel("ȸ������");
			seatInfoStrLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			seatInfoStrLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			seatInfoStrLabel_1.setBackground(new Color(128, 0, 0));
			seatInfoStrLabel_1.setBounds(37, 10, 77, 23);
			memberInfoPanel.add(seatInfoStrLabel_1);
			
			//"���� �ð�" ���� ��
			JLabel seatNumStrLabel_1 = new JLabel("\uB0A8\uC740\uC2DC\uAC04");
			seatNumStrLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			seatNumStrLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumStrLabel_1.setBackground(new Color(128, 0, 0));
			seatNumStrLabel_1.setBounds(12, 79, 66, 23);
			memberInfoPanel.add(seatNumStrLabel_1);
			
			//TODO DB�� Member���̺� remainTime �����ʿ�
			//�����ð� ���� ��
			JLabel seatNumLabel_1 = new JLabel("10�� 11�ð�12��13��");
			seatNumLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			seatNumLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
			seatNumLabel_1.setBackground(new Color(128, 0, 0));
			seatNumLabel_1.setBounds(12, 99, 141, 23);
			memberInfoPanel.add(seatNumLabel_1);
			
			//"�� �¼�"���� ��
			JLabel memberStrLabel_1 = new JLabel("�� �¼�");
			memberStrLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			memberStrLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			memberStrLabel_1.setBackground(new Color(128, 0, 0));
			memberStrLabel_1.setBounds(52, 191, 62, 23);
			memberInfoPanel.add(memberStrLabel_1);
			
			//TODO DB�� SEAT���̺� seatNum �����ʿ�
	     	//�¼���ȣ ���� ��
			JLabel seatNumLabel_memberInfoPanel = new JLabel("105");
			seatNumLabel_memberInfoPanel.setHorizontalAlignment(JLabel.CENTER);
			seatNumLabel_memberInfoPanel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumLabel_memberInfoPanel.setBackground(new Color(128, 0, 0));
			seatNumLabel_memberInfoPanel.setBounds(12, 191, 39, 23);
			memberInfoPanel.add(seatNumLabel_memberInfoPanel);
			
			//TODO DB�� SEAT���̺� seatAvail �����ʿ�
			//�¼����� ���� ��(�̿���/�Ͻ�����?)
			JLabel memberTelLabel_1 = new JLabel("�̿���");
			memberTelLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			memberTelLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
			memberTelLabel_1.setBackground(new Color(128, 0, 0));
			memberTelLabel_1.setBounds(12, 218, 55, 23);
			memberInfoPanel.add(memberTelLabel_1);
			
			//�ݱ��ư
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
			
			//"�¼�����" ���� ��
			JLabel seatInfoStrLabel = new JLabel("�¼�����");
			//seatInfoStrLabel.setOpaque(true);
			seatInfoStrLabel.setHorizontalAlignment(JLabel.CENTER);
			seatInfoStrLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatInfoStrLabel.setBackground(new Color(128, 0, 0));
			seatInfoStrLabel.setBounds(48, 10, 66, 23);
			seatInfoPanel.add(seatInfoStrLabel);
			
			//"�¼���ȣ" ���� ��
			JLabel seatNumStrLabel = new JLabel("�¼���ȣ");
			//seatNumStrLabel.setOpaque(true);
			seatNumStrLabel.setHorizontalAlignment(JLabel.CENTER);
			seatNumStrLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumStrLabel.setBackground(new Color(128, 0, 0));
			seatNumStrLabel.setBounds(12, 79, 66, 23);
			seatInfoPanel.add(seatNumStrLabel);
			
			//TODO DB�� SEAT���̺� seatNum �����ʿ�
			//�¼���ȣ ���� ��-DB����? Ŭ���� �¼���ȣ ������ �о�ͼ� ���
			JLabel seatNumLabel_seatInfoPanel = new JLabel("105");
			seatNumLabel_seatInfoPanel.setHorizontalAlignment(JLabel.CENTER);
			seatNumLabel_seatInfoPanel.setFont(new Font("Dialog", Font.BOLD, 16));
			seatNumLabel_seatInfoPanel.setBackground(new Color(128, 0, 0));
			seatNumLabel_seatInfoPanel.setBounds(22, 99, 27, 23);
			seatInfoPanel.add(seatNumLabel_seatInfoPanel);
			
			//"ȸ��"���� ��
			JLabel memberStrLabel = new JLabel("ȸ��");
			//memberStrLabel.setOpaque(true);
			memberStrLabel.setHorizontalAlignment(JLabel.CENTER);
			memberStrLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			memberStrLabel.setBackground(new Color(128, 0, 0));
			memberStrLabel.setBounds(16, 185, 33, 23);
			seatInfoPanel.add(memberStrLabel);
			
	    //ȸ������ ��ư(Ŭ���� memberInfo �г� ����)
			JButton memberInfoBtn = new JButton("����");
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
			
			//TODO DB�� MEMBER���̺� memberTEL �����ʿ�
			//ȸ�� ��ȭ��ȣ ��
			JLabel memberTelLabel = new JLabel("010-1234-1234");
			//memberTelLabel.setOpaque(true);
			memberTelLabel.setHorizontalAlignment(JLabel.CENTER);
			memberTelLabel.setFont(new Font("Dialog", Font.BOLD, 16));
			memberTelLabel.setBackground(new Color(128, 0, 0));
			memberTelLabel.setBounds(12, 212, 141, 23);
			seatInfoPanel.add(memberTelLabel);
					
		//-----------------------------------------------------------------------------------------------------------
			//1�� ��ġ�� �ǳ�
			JPanel panel1F = new JPanel();
			panel1F.setBounds(71, 37, 945, 599);
			panel1F.setLayout(null);
			//panel1F.setEnabled(false); //�г� ��Ȱ��ȭ
			//panel1F.setVisible(false); //�г� ���߱�
			contentPane.add(panel1F);
			
			//TODO DB���� �¼����� �޾ƿͼ� �̸�(seatNum), ����(seatAvail)������ �� �� �����ʿ�
			//1�� �¼� ��ư ����, ��ġ����
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
					{//��밡��
						seat1FBtn[i].setBackground(Color.CYAN);
					} else
						try {
							if(findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i]))==1)
							{//�����
								seat1FBtn[i].setBackground(Color.ORANGE);
							} else
								try {
									if(findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i]))==2)
									{//���Ұ�
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
	    	
	    	//�ε���(i)�� ���� seatNum���� ������ seatAvail �˻�
	    	Integer.parseInt(seat1Farr[0]);
	    	
			seat1FBtn[0].setBounds(114, 0, 72, 60); //100�� �¼�
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
			
		//ȭ���
		JLabel toiletLabel1_1 = new JLabel("<html><body><center>ȭ<br>��<br>��</center></body></html>");
		toiletLabel1_1.setOpaque(true);
		toiletLabel1_1.setHorizontalAlignment(JLabel.CENTER);
		toiletLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel1_1.setBackground(new Color(255, 210, 0));
		toiletLabel1_1.setBounds(0, 60, 72, 160);
		panel1F.add(toiletLabel1_1);
		
		
		//��
		JLabel doorLabel1_1 = new JLabel("��");
		doorLabel1_1.setOpaque(true);
		doorLabel1_1.setHorizontalAlignment(JLabel.CENTER);
		doorLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel1_1.setBackground(new Color(128, 0, 0));
		doorLabel1_1.setBounds(882, 74, 61, 69);
		panel1F.add(doorLabel1_1);
		
		//1�� ���� ����, ��ġ����
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
		
		//�������� �̹���
		JLabel trashcanLabel1_1 = new JLabel(); //ȭ��ǿ�
		trashcanLabel1_1.setBounds(70, 53, 57, 54);
		trashcanLabel1_1.setIcon(updatetrashcanIcon);
		panel1F.add(trashcanLabel1_1);
		
		JLabel trashcanLabel1_2 = new JLabel(); //����
		trashcanLabel1_2.setBounds(814, 0, 57, 54);
		trashcanLabel1_2.setIcon(updatetrashcanIcon);
		panel1F.add(trashcanLabel1_2);
		
		//������ �̹���
		JLabel waterPFLabel1_1 = new JLabel(); // ȭ��ǿ�
		waterPFLabel1_1.setBounds(70, 166, 35, 54);
		waterPFLabel1_1.setIcon(updateWaterPFIcon);
		panel1F.add(waterPFLabel1_1);
		
		JLabel waterPFLabel1_2 = new JLabel(); // ����
		waterPFLabel1_2.setBounds(876, 6, 57, 54);
		waterPFLabel1_2.setIcon(updateWaterPFIcon);
		panel1F.add(waterPFLabel1_2);
					
		//-------------------------------------------------------------------------------------------------------------
		//2�� ��ġ�� �ǳ�
		JPanel panel2F = new JPanel();
		panel2F.setBounds(71, 37, 945, 599);
		//panel2F.setBackground(Color.WHITE);
	    panel2F.setEnabled(false); //�г� ��Ȱ��ȭ
		panel2F.setVisible(false); //�г� ���߱�
		panel2F.setLayout(null);
		contentPane.add(panel2F);

		//TODO DB���� �¼����� �޾ƿͼ� �̸�(seatNum), ����(seatAvail)������ �� �� �����ʿ�
		// 2�� �¼� ��ư ����, ��ġ����
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
			//seat2FBtn[i].setBackground(new Color(0, 128, 255)); //seatAvail������ ����
	    	try {
				if (findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i]))==0) 
				{//��밡��
					seat2FBtn[i].setBackground(Color.CYAN);
				} else
					try {
						if(findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i]))==1)
						{//�����
							seat2FBtn[i].setBackground(Color.ORANGE);
						}
						else if(findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i]))==2)
						{//���Ұ�
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

		seat2FBtn[0].setBounds(190, 0, 72, 60); //200�� ����
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

		JLabel doorLabel2_1 = new JLabel("��");
		doorLabel2_1.setOpaque(true);
		doorLabel2_1.setHorizontalAlignment(JLabel.CENTER);
		doorLabel2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel2_1.setBackground(new Color(128, 0, 0));
		doorLabel2_1.setBounds(882, 72, 61, 69);
		panel2F.add(doorLabel2_1);

		// ȭ���
		JLabel toiletLabel2_1 = new JLabel("<html><body><center>ȭ<br>��<br>��</center></body></html>");
		toiletLabel2_1.setOpaque(true);
		toiletLabel2_1.setHorizontalAlignment(JLabel.CENTER);
		toiletLabel2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel2_1.setBackground(new Color(255, 210, 0));
		toiletLabel2_1.setBounds(0, 60, 72, 180);
		panel2F.add(toiletLabel2_1);
		
		//�������� �̹���
		JLabel trashcanLabel2_1 = new JLabel(); //ȭ��ǿ�
		trashcanLabel2_1.setBounds(76, 184, 57, 54);   
		trashcanLabel2_1.setIcon(updatetrashcanIcon);
		panel2F.add(trashcanLabel2_1);
		
		JLabel trashcanLabel2_2 = new JLabel(); //����
		trashcanLabel2_2.setBounds(871, 6, 57, 54);
		trashcanLabel2_2.setIcon(updatetrashcanIcon);
		panel2F.add(trashcanLabel2_2);
		
		//������ �̹���
		JLabel waterPFLabel2_1 = new JLabel(); //ȭ��ǿ�
		waterPFLabel2_1.setBounds(152, 0, 35, 70);   
		waterPFLabel2_1.setIcon(updateWaterPFIcon);
		panel2F.add(waterPFLabel2_1);
		
		JLabel waterPFLabel2_2 = new JLabel(); //����
		waterPFLabel2_2.setBounds(839, 6, 35, 54);
		waterPFLabel2_2.setIcon(updateWaterPFIcon);
		panel2F.add(waterPFLabel2_2);
		
		// 2�� ���� ����, ��ġ����
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

			//�α׾ƿ� ��ư--������ �����ڷα���â����
		JButton logoutBtn = new JButton("�α׾ƿ�");
		logoutBtn.setBounds(982, 0, 116, 31);
		logoutBtn.setBackground(new Color(255, 0, 0));
		logoutBtn.setFont(logoutBtnFont);
        logoutBtn.setFocusPainted(false);// hide focus rectangle
    	logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0); //�Ŵ��� ����ȭ�� �ݱ�(0 == ��������)  <=�̰ž��� ��â�� �ȳ���
				dispose(); //�̰ɾ���
				new ManagerLogin();//������ �α��� â ���- �����ڷα���â ��ġ�� �����ʿ�
			}
		});
		contentPane.add(logoutBtn);
		
		
		//TODO �ӽ÷� �ص�, ���� DB�� �޾ƿ��� �����
		//managerInfo, quest�� ������ �Ű������� ���� ��ü ����
		ManagerInfoDTO manager1 = new ManagerInfoDTO("corlwn");
		QuestInfoDTO quest1 = new QuestInfoDTO("�����Դϴ�");
		
		//TODO DB, ä��������ϱ�� �����ؾ���
		//����Ȯ�� ��ư
		JButton searchQuestionBtn = new JButton("<html><body><center>��"
        		+ "<br>��</center><br>Ȯ<br>��</body></html>");
		searchQuestionBtn.setBounds(1036, 140, 62, 395);
		searchQuestionBtn.setBackground(new Color(0, 255, 64));
		searchQuestionBtn.setFont(logoutBtnFont);
		searchQuestionBtn.setFocusPainted(false);// hide focus rectangle
		searchQuestionBtn.addActionListener(new ActionListener() {//������ �Ʒ� ��� ����
			public void actionPerformed(ActionEvent e) {
	              // QuestDialog����
                QuestDialog questDialog = new QuestDialog //������ �����س��� QuestDialog Ŭ���� ��ü ����
                		("", true, manager1,quest1, ManagerMain.this); //�Ű�����(������ ���Ѹ�ŭ)
                questDialog.setVisible(true);
			}
		});
		contentPane.add(searchQuestionBtn);
		
		//����(1��) ���� ��ư
		JButton firstFloorBtn = new JButton("1��");
		firstFloorBtn.setBounds(0, 659, 116, 38);
		firstFloorBtn.setBackground(new Color(245, 134, 52));
		firstFloorBtn.setFont(logoutBtnFont);
		firstFloorBtn.setFocusPainted(false);// hide focus rectangle
		firstFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2F.setEnabled(false); //2�� ��ġ�� ��Ȱ��ȭ
				panel2F.setVisible(false); //2�� ��ġ�� ���߱�
				panel1F.setEnabled(true); //1�� ��ġ�� ��Ȱ��ȭ
				panel1F.setVisible(true); //1�� ��ġ�� ���߱�
			}
		});
		contentPane.add(firstFloorBtn);
		
		//����(2��) ���� ��ư
		JButton secondFloorBtn = new JButton("2��");
		secondFloorBtn.setBounds(0, 625, 116, 38);
		secondFloorBtn.setBackground(new Color(248, 211, 129));
		secondFloorBtn.setFont(logoutBtnFont);
		secondFloorBtn.setFocusPainted(false);// hide focus rectangle
		secondFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1F.setEnabled(false); //1�� ��ġ�� ��Ȱ��ȭ
				panel1F.setVisible(false); //1�� ��ġ�� ���߱�
				panel2F.setEnabled(true); //2�� ��ġ�� ��Ȱ��ȭ
				panel2F.setVisible(true); //2�� ��ġ�� ���߱�
			}
		});
		contentPane.add(secondFloorBtn);
		
		//TODO DB���� managerID �о�ͼ� ����
		//�Ű������� ���� �α����� ������ID�ֱ�
		JLabel idLabel = new JLabel("������:"+name+" ��"); 
		idLabel.setBounds(71, 0, 197, 38);
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setFont(logoutBtnFont);
		contentPane.add(idLabel);
		
		//������� �ΰ��̹���
		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(0, 0, 70, 69);       
        logoLabel.setIcon(updateLogoIcon);
        getContentPane().add(logoLabel);
        //--------------------------------------------------------------------------------------------------
    	class SeatBtnListener implements ActionListener {
    		//���ڹ�ư �������� ���� 		seat2FBtn[0] //200�� ����
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			JButton seatSource = (JButton)e.getSource(); //Ŭ���� ��ư�� �󺧰� �о��
    			FindUseTable findUseTable = new FindUseTable();
    			String usestat = null; //seatInfoPanel�� memberTelLabel�� �� 
    			
    			//���� ���� �� �о�ͼ� �������� �г��� ���ڹ�ȣ �󺧿� ����
    			seatNumLabel_seatInfoPanel.setText(seatSource.getText());//
    			if(memberInfoPanel.isEnabled()==false||seatInfoPanel.isEnabled()==false)
    			{
    				//Ŭ���� ���ڶ󺧰� �о�ͼ� findUse ����(��������� �˻�)
    				try {
						usestat = findUseTable.findUse(Integer.parseInt(seatSource.getText()));
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
    				if(usestat=="0")//���Ϲ������� 0�̸� ȸ����ȭ��ȣ �󺧿��� �����(������·� ��)
    				{
    					memberTelLabel.setText("");
    				}
    				else
    				{
    					//��� ���̺��� ���� ��ȭ��ȣ �˻��ؿͼ� ����ֱ�
    					memberTelLabel.setText(usestat);
    				}
    				
    				seatInfoPanel.setVisible(true);
    				seatInfoPanel.setEnabled(true);
    				
    				//�г� �Ʒ��� 1���¼� ��ư ��Ȱ��ȭ
    				seat1FBtn[10].setEnabled(false);
    				seat1FBtn[10].setVisible(false);
    				seat1FBtn[11].setEnabled(false);
    				seat1FBtn[11].setVisible(false);
    				seat1FBtn[12].setEnabled(false);
    				seat1FBtn[12].setVisible(false);
    				seat1FBtn[13].setEnabled(false);
    				seat1FBtn[13].setVisible(false);

    				//�г� �Ʒ��� 2���¼� ��ư ��Ȱ��ȭ
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
    	
    	//�¼���ư�� �׼Ǹ����� ��� �߰�
    	SeatBtnListener seatBtnListener = new SeatBtnListener();
    	for (int i = 0; i < seat1Farr.length; i++) {
    		seat1FBtn[i].addActionListener(seatBtnListener);
		}
    	for (int i = 0; i < seat2Farr.length; i++) {
			seat2FBtn[i].addActionListener(seatBtnListener);
		}
    	
    	//�ݱ��ưx
		JButton closeBtn_seatInfoPanel = new JButton("X");
		closeBtn_seatInfoPanel.setOpaque(true);
		closeBtn_seatInfoPanel.setBounds(116, 0, 49, 38);
		closeBtn_seatInfoPanel.setFont(new Font("Dialog", Font.BOLD, 13));
		closeBtn_seatInfoPanel.setHorizontalAlignment(JLabel.CENTER);
		closeBtn_seatInfoPanel.setBackground(new Color(128, 255, 128));//�г��̶� ����ѻ�����?
		closeBtn_seatInfoPanel.setForeground(Color.RED);
		closeBtn_seatInfoPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatInfoPanel.setEnabled(false);
				seatInfoPanel.setVisible(false);
				
				//�г� �Ʒ��� 1���¼� ��ư Ȱ��ȭ
				seat1FBtn[10].setEnabled(true);
				seat1FBtn[10].setVisible(true);
				seat1FBtn[11].setEnabled(true);
				seat1FBtn[11].setVisible(true);
				seat1FBtn[12].setEnabled(true);
				seat1FBtn[12].setVisible(true);
				seat1FBtn[13].setEnabled(true);
				seat1FBtn[13].setVisible(true);

				//�г� �Ʒ��� 2���¼� ��ư Ȱ��ȭ
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