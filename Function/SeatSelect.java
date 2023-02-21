package function;

// TODO 뒤로가기 버튼, 확인 버튼 누를시 회원 메인 화면 창 이동
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import function.InsertUseTable;
import oracle.net.ano.SupervisorService;

import javax.swing.ImageIcon;

public class SeatSelect extends JFrame {

	private JFrame frame;
	String[] seat1Farr = { "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112",
			"113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127",
			"128", "129", "130" };
	JButton[] seat1FBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatSelect window = new SeatSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeatSelect() {
		initialize(); // 초기화
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 자리 배치도 1층 생성
		frame = new JFrame();
		frame.setBounds(100, 100, 963, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel1F = new JPanel();
		panel1F.setBounds(0, 0, 945, 600);
		panel1F.setLayout(null);
		frame.getContentPane().add(panel1F);
		LineBorder lb = new LineBorder(Color.BLACK, 2);
		
		Panel panel1 = new Panel();
		panel1.setBackground(Color.CYAN);
		panel1.setBounds(267, 66, 61, 69);
		panel1F.add(panel1);

		Panel panel2 = new Panel();
		panel2.setBackground(Color.ORANGE);
		panel2.setBounds(386, 66, 61, 69);
		panel1F.add(panel2);

		Panel panel3 = new Panel();
		panel3.setBackground(Color.RED);
		panel3.setBounds(507, 66, 61, 69);
		panel1F.add(panel3);

		Label label1 = new Label("사용 가능");
		label1.setAlignment(Label.CENTER);
		label1.setBounds(259, 149, 79, 23);
		panel1F.add(label1);

		Label label2 = new Label("사용 중");
		label2.setAlignment(Label.CENTER);
		label2.setBounds(376, 149, 79, 23);
		panel1F.add(label2);

		Label label3 = new Label("사용 불가능");
		label3.setAlignment(Label.CENTER);
		label3.setBounds(497, 149, 79, 23);
		panel1F.add(label3);
		
		 //뒤로가기 버튼
        JButton btnBack = new JButton();
        btnBack.setIcon(new ImageIcon("C:\\Users\\dita810\\Desktop\\D팀 프로젝트 자료\\FamilyStudycafe\\src\\img\\Button_image\\back.jpg"));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new ActionListener()
        		{
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        		});
        btnBack.setBounds(3,3,105,54);
        panel1F.add(btnBack);

//		JButton backBtn = new JButton();
//		backBtn.setFocusPainted(false);
//		backBtn.setIcon(new ImageIcon("C:\\Users\\dita810\\Desktop\\D팀 프로젝트 자료\\FamilyStudycafe\\src\\img\\Button_image\\back.jpg"));
//		backBtn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		backBtn.setBounds(12, 6, 72, 50);
//		panel1F.add(backBtn);

		seat1FBtn = new JButton[31];
		for (int i = 0; i < seat1Farr.length; i++) {
			seat1FBtn[i] = new JButton(seat1Farr[i]);
			seat1FBtn[i].setBounds(871, 184, 72, 60);
			seat1FBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
			seat1FBtn[i].setBorder(lb);
			seat1FBtn[i].setFocusPainted(false);
			seat1FBtn[i].setBackground(Color.CYAN);
			// btn[i].addActionListener(seatBtnListener); 아래쪽에 따로
			panel1F.add(seat1FBtn[i]);
		}

		seat1FBtn[0].setBounds(114, 0, 72, 60); // 100번 좌석
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

		
		for (int i = 0; i < seat1FBtn.length; i++) {
			seat1FBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame fs = new JFrame();
					fs.setTitle("자리 선택 여부");
					fs.setVisible(true);
					fs.setIconImage(Toolkit.getDefaultToolkit().getImage(
							"C:\\Users\\dita810\\Desktop\\D팀 프로젝트 자료\\FamilyStudycafe\\src\\img\\family.jpg"));
					fs.setFont(new Font("굴림", Font.PLAIN, 12));
					fs.setResizable(false);
					fs.setBounds(370, 289, 465, 260);
					fs.getContentPane().setLayout(null);
					JButton seatSource = (JButton) e.getSource();
					JLabel lblNewLabel = new JLabel(seatSource.getText() + "번 자리를 선택 하시겠습니까?"); // 좌석 번호의 정보를 읽어와야 함.
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
					lblNewLabel.setBounds(75, 40, 317, 78);
					fs.getContentPane().add(lblNewLabel);
					JButton btnNewButton1 = new JButton("확인");
					btnNewButton1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton btnNewButton1 = (JButton)e.getSource();
							if ((JButton)e.getSource() == btnNewButton1) {
								fs.setVisible(false);
								fs.dispose(); // 버튼 누를때 그 창만 종료하게 하는 메소드
								new InsertUseTable();
							}
						}
					});
					
					btnNewButton1.setDefaultCapable(false);
					btnNewButton1.setSelected(true);
					btnNewButton1.setFont(new Font("굴림", Font.PLAIN, 15));
					btnNewButton1.setBounds(99, 139, 109, 50);
					fs.getContentPane().add(btnNewButton1);

					JButton btnNewButton2 = new JButton("다시 선택");
					btnNewButton2.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							fs.setVisible(false);
							fs.dispose();
						}
					});
					btnNewButton2.setDefaultCapable(false);
					btnNewButton2.setSelected(true);
					btnNewButton2.setFont(new Font("굴림", Font.PLAIN, 15));
					btnNewButton2.setBounds(258, 139, 109, 50);
					fs.getContentPane().add(btnNewButton2);
				}
			});
		}

		JLabel toiletLabel1_1 = new JLabel("<html><body><center>화<br>장<br>실</center></body></html>");
		toiletLabel1_1.setOpaque(true);
		toiletLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		toiletLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel1_1.setBackground(new Color(255, 210, 0));
		toiletLabel1_1.setBounds(0, 60, 72, 160);
		panel1F.add(toiletLabel1_1);

		JLabel doorLabel1_1 = new JLabel("문");
		doorLabel1_1.setOpaque(true);
		doorLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		doorLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel1_1.setBackground(new Color(128, 0, 0));
		doorLabel1_1.setBounds(884, 70, 61, 69);
		panel1F.add(doorLabel1_1);

		// 1층 벽라벨 생성, 위치지정
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
	}

}