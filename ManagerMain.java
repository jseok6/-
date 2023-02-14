package study;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMain extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 1098, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 228, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//1층 배치도 판넬
		JPanel panel1F = new JPanel();
		panel1F.setBounds(71, 37, 945, 599);
		contentPane.add(panel1F);
		
		//2층 배치도 판넬
		JPanel panel2F = new JPanel();
		panel2F.setBackground(new Color(0, 255, 255)); //개발용 임시 색추가, 1층 판넬 색으로 변경해야함
		panel2F.setBounds(71, 37, 945, 599);
		panel2F.setEnabled(false); //버튼 비활성화
		panel2F.setVisible(false); //버튼 감추기
		contentPane.add(panel2F);
		
		//로그아웃 버튼
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setBackground(new Color(255, 0, 0));
		logoutBtn.setBounds(954, 0, 128, 38);
		Font logoutBtnFont = new Font("맑은고딕 굵게", Font.BOLD, 16);
		logoutBtn.setFont(logoutBtnFont);
        logoutBtn.setFocusPainted(false);// hide focus rectangle
		contentPane.add(logoutBtn);
		
		//질문확인 버튼
		JButton searchQuestionBtn = new JButton("<html><body><center>질"
        		+ "<br>문</center><br>확<br>인</body></html>");
		searchQuestionBtn.setBackground(new Color(0, 255, 64));
		searchQuestionBtn.setBounds(1020, 141, 62, 395);
		searchQuestionBtn.setFont(logoutBtnFont);
		searchQuestionBtn.setFocusPainted(false);// hide focus rectangle
		searchQuestionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(searchQuestionBtn);
		
		//구역(1층) 선택 버튼
		JButton firstFloorBtn = new JButton("1층");
		firstFloorBtn.setBackground(new Color(245, 134, 52)); //색 조정 필요?
		firstFloorBtn.setBounds(0, 646, 116, 38);
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
		secondFloorBtn.setBackground(new Color(248, 211, 129)); //색 조정 필요
		secondFloorBtn.setBounds(0, 609, 116, 38);
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
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setBounds(71, 0, 197, 38);
		idLabel.setFont(logoutBtnFont);
		contentPane.add(idLabel);
		
		//로고이미지
		JLabel logoLabel = new JLabel();
		ImageIcon logoIcon= new ImageIcon
				("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\src\\img\\family.jpg");
        Image logoImg = logoIcon.getImage(); // ImageIcon 객체에서 Image 추출
        
        // 추출된 Image의 크기 조절하여 새로운 Image 객체 생성
    	Image updateLogoImg = logoImg.getScaledInstance(70, 69, Image.SCALE_SMOOTH);
        
        // 새로운 Image 객체로 ImageIcon 객체 생성
        ImageIcon updateLogoIcon = new ImageIcon(updateLogoImg);
        
        logoLabel.setIcon(updateLogoIcon);
		logoLabel.setBounds(0, 0, 70, 69);
        getContentPane().add(logoLabel);
		//logoLabel.setIcon(logoIcon);
		//contentPane.add(logoLabel);
		setVisible(true);
		
	}
}
