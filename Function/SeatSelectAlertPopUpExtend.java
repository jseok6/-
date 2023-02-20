package Function;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class SeatSelectAlertPopUpExtend {

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
					SeatSelectAlertPopUpExtend window = new SeatSelectAlertPopUpExtend();
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
	public SeatSelectAlertPopUpExtend() {
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
	
		seat1FBtn = new JButton[31];
		for (int i = 0; i < seat1Farr.length; i++) {
			seat1FBtn[i] = new JButton(seat1Farr[i]);
			seat1FBtn[i].setBounds(871, 184, 72, 60);
			seat1FBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
			seat1FBtn[i].setBorder(lb);
			seat1FBtn[i].setFocusPainted(false);
			seat1FBtn[i].setBackground(new Color(0, 128, 255));
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
		
		for (int j = 0; j < seat1FBtn.length; j++) {
			seat1FBtn[j].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					
					
				}
			});
		}
		
//		 예시 : 자리 101번 버튼 눌렀을 시 팝업 생성 ("101번 자리를 선택 하시겠습니까?" 내용 출력)
//		 맞을시 확인, 아닐시 다시 선택
//		JButton seat101Btn = new JButton("101");
//		seat101Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat101Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat101Btn.setFocusPainted(false);
//		seat101Btn.setBackground(new Color(0, 128, 255));
//		seat101Btn.setBounds(113, 0, 72, 60);
//		panel1F.add(seat101Btn);
//
//		seat101Btn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JInternalFrame internalFrame = new JInternalFrame("자리 선택 여부");
//				internalFrame.setBounds(200, 150, 465, 260);
//				panel1F.add(internalFrame);
//				internalFrame.getContentPane().setLayout(null);
//
//				JLabel lblNewLabel = new JLabel("101번 자리를 선택 하시겠습니까?");
//				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//				lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
//				lblNewLabel.setBounds(75, 40, 317, 78);
//				internalFrame.getContentPane().add(lblNewLabel);
//
//				JButton btnNewButton1 = new JButton("확인");
//				btnNewButton1.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// System.exit(0); -> 이 메소드를 쓰면 화면이 전부 닫힘.
//						// dispose(); -> JInternalFrame에선 완전 종료가 아닌 부분 종료 메서드인 dispose도 적용이 안됨.
//					}
//				});
//				btnNewButton1.setDefaultCapable(false);
//				btnNewButton1.setSelected(true);
//				btnNewButton1.setFont(new Font("굴림", Font.PLAIN, 15));
//				btnNewButton1.setBounds(99, 139, 109, 50);
//				internalFrame.getContentPane().add(btnNewButton1);
//				internalFrame.setVisible(true);
//
//				JButton btnNewButton2 = new JButton("다시 선택");
//				btnNewButton2.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// System.exit(0);
//						// dispose();
//					}
//				});
//				btnNewButton2.setDefaultCapable(false);
//				btnNewButton2.setSelected(true);
//				btnNewButton2.setFont(new Font("굴림", Font.PLAIN, 15));
//				btnNewButton2.setBounds(258, 139, 109, 50);
//				internalFrame.getContentPane().add(btnNewButton2);
//				internalFrame.setVisible(true);
//			}
//		});
//		JButton seat102Btn = new JButton("102");
//		seat102Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat102Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat102Btn.setFocusPainted(false);
//		seat102Btn.setBackground(new Color(0, 128, 255));
//		seat102Btn.setBounds(186, 0, 72, 60);
//		panel1F.add(seat102Btn);
//
//		JButton seat103Btn = new JButton("103");
//		seat103Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat103Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat103Btn.setFocusPainted(false);
//		seat103Btn.setBackground(new Color(0, 128, 255));
//		seat103Btn.setBounds(259, 0, 72, 60);
//		panel1F.add(seat103Btn);
//
//		JButton seat104Btn = new JButton("104");
//		seat104Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat104Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat104Btn.setFocusPainted(false);
//		seat104Btn.setBackground(new Color(0, 128, 255));
//		seat104Btn.setBounds(402, 0, 72, 60);
//		panel1F.add(seat104Btn);
//
//		JButton seat105Btn = new JButton("105");
//		seat105Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat105Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat105Btn.setFocusPainted(false);
//		seat105Btn.setBackground(new Color(0, 128, 255));
//		seat105Btn.setBounds(475, 0, 72, 60);
//		panel1F.add(seat105Btn);
//
//		JButton seat106Btn = new JButton("106");
//		seat106Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat106Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat106Btn.setFocusPainted(false);
//		seat106Btn.setBackground(new Color(0, 128, 255));
//		seat106Btn.setBounds(548, 0, 72, 60);
//		panel1F.add(seat106Btn);
//
//		JButton seat107Btn = new JButton("107");
//		seat107Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat107Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat107Btn.setFocusPainted(false);
//		seat107Btn.setBackground(new Color(0, 128, 255));
//		seat107Btn.setBounds(621, 0, 72, 60);
//		panel1F.add(seat107Btn);
//
//		JButton seat108Btn = new JButton("108");
//		seat108Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat108Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat108Btn.setFocusPainted(false);
//		seat108Btn.setBackground(new Color(0, 128, 255));
//		seat108Btn.setBounds(694, 0, 72, 60);
//		panel1F.add(seat108Btn);
//
//		JButton seat109Btn = new JButton("109");
//		seat109Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat109Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat109Btn.setFocusPainted(false);
//		seat109Btn.setBackground(new Color(0, 128, 255));
//		seat109Btn.setBounds(147, 241, 72, 60);
//		panel1F.add(seat109Btn);
//
//		JButton seat110Btn = new JButton("110");
//		seat110Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat110Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat110Btn.setFocusPainted(false);
//		seat110Btn.setBackground(new Color(0, 128, 255));
//		seat110Btn.setBounds(147, 303, 72, 60);
//		panel1F.add(seat110Btn);
//
//		JButton seat111Btn = new JButton("111");
//		seat111Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat111Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat111Btn.setFocusPainted(false);
//		seat111Btn.setBackground(new Color(0, 128, 255));
//		seat111Btn.setBounds(329, 241, 72, 60);
//		panel1F.add(seat111Btn);
//
//		JButton seat112Btn = new JButton("112");
//		seat112Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat112Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat112Btn.setFocusPainted(false);
//		seat112Btn.setBackground(new Color(0, 128, 255));
//		seat112Btn.setBounds(402, 241, 72, 60);
//		panel1F.add(seat112Btn);
//
//		JButton seat113Btn = new JButton("113");
//		seat113Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat113Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat113Btn.setFocusPainted(false);
//		seat113Btn.setBackground(new Color(0, 128, 255));
//		seat113Btn.setBounds(329, 303, 72, 60);
//		panel1F.add(seat113Btn);
//
//		JButton seat114Btn = new JButton("114");
//		seat114Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat114Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat114Btn.setFocusPainted(false);
//		seat114Btn.setBackground(new Color(0, 128, 255));
//		seat114Btn.setBounds(402, 303, 72, 60);
//		panel1F.add(seat114Btn);
//
//		JButton seat115Btn = new JButton("115");
//		seat115Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat115Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat115Btn.setFocusPainted(false);
//		seat115Btn.setBackground(new Color(0, 128, 255));
//		seat115Btn.setBounds(576, 241, 72, 60);
//		panel1F.add(seat115Btn);
//
//		JButton seat116Btn = new JButton("116");
//		seat116Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat116Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat116Btn.setFocusPainted(false);
//		seat116Btn.setBackground(new Color(0, 128, 255));
//		seat116Btn.setBounds(576, 303, 72, 60);
//		panel1F.add(seat116Btn);
//
//		JButton seat117Btn = new JButton("117");
//		seat117Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat117Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat117Btn.setFocusPainted(false);
//		seat117Btn.setBackground(new Color(0, 128, 255));
//		seat117Btn.setBounds(0, 253, 72, 60);
//		panel1F.add(seat117Btn);
//
//		JButton seat118Btn = new JButton("118");
//		seat118Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat118Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat118Btn.setFocusPainted(false);
//		seat118Btn.setBackground(new Color(0, 128, 255));
//		seat118Btn.setBounds(0, 314, 72, 60);
//		panel1F.add(seat118Btn);
//
//		JButton seat119Btn = new JButton("119");
//		seat119Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat119Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat119Btn.setFocusPainted(false);
//		seat119Btn.setBackground(new Color(0, 128, 255));
//		seat119Btn.setBounds(0, 375, 72, 60);
//		panel1F.add(seat119Btn);
//
//		JButton seat120Btn = new JButton("120");
//		seat120Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat120Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat120Btn.setFocusPainted(false);
//		seat120Btn.setBackground(new Color(0, 128, 255));
//		seat120Btn.setBounds(0, 437, 72, 60);
//		panel1F.add(seat120Btn);
//
//		JButton seat121Btn = new JButton("121");
//		seat121Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat121Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat121Btn.setFocusPainted(false);
//		seat121Btn.setBackground(new Color(0, 128, 255));
//		seat121Btn.setBounds(98, 539, 72, 60);
//		panel1F.add(seat121Btn);
//
//		JButton seat122Btn = new JButton("122");
//		seat122Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat122Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat122Btn.setFocusPainted(false);
//		seat122Btn.setBackground(new Color(0, 128, 255));
//		seat122Btn.setBounds(171, 539, 72, 60);
//		panel1F.add(seat122Btn);
//
//		JButton seat123Btn = new JButton("123");
//		seat123Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat123Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat123Btn.setFocusPainted(false);
//		seat123Btn.setBackground(new Color(0, 128, 255));
//		seat123Btn.setBounds(329, 539, 72, 60);
//		panel1F.add(seat123Btn);
//
//		JButton seat124Btn = new JButton("124");
//		seat124Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat124Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat124Btn.setFocusPainted(false);
//		seat124Btn.setBackground(new Color(0, 128, 255));
//		seat124Btn.setBounds(402, 539, 72, 60);
//		panel1F.add(seat124Btn);
//
//		JButton seat125Btn = new JButton("125");
//		seat125Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat125Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat125Btn.setFocusPainted(false);
//		seat125Btn.setBackground(new Color(0, 128, 255));
//		seat125Btn.setBounds(475, 539, 72, 60);
//		panel1F.add(seat125Btn);
//
//		JButton seat126Btn = new JButton("126");
//		seat126Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat126Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat126Btn.setFocusPainted(false);
//		seat126Btn.setBackground(new Color(0, 128, 255));
//		seat126Btn.setBounds(648, 539, 72, 60);
//		panel1F.add(seat126Btn);
//
//		JButton seat127Btn = new JButton("127");
//		seat127Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat127Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat127Btn.setFocusPainted(false);
//		seat127Btn.setBackground(new Color(0, 128, 255));
//		seat127Btn.setBounds(721, 539, 72, 60);
//		panel1F.add(seat127Btn);
//
//		JButton seat128Btn = new JButton("128");
//		seat128Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat128Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat128Btn.setFocusPainted(false);
//		seat128Btn.setBackground(new Color(0, 128, 255));
//		seat128Btn.setBounds(871, 480, 72, 60);
//		panel1F.add(seat128Btn);
//
//		JButton seat129Btn = new JButton("129");
//		seat129Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat129Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat129Btn.setFocusPainted(false);
//		seat129Btn.setBackground(new Color(0, 128, 255));
//		seat129Btn.setBounds(871, 419, 72, 60);
//		panel1F.add(seat129Btn);
//
//		JButton seat130Btn = new JButton("130");
//		seat130Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat130Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat130Btn.setFocusPainted(false);
//		seat130Btn.setBackground(new Color(0, 128, 255));
//		seat130Btn.setBounds(871, 358, 72, 60);
//		panel1F.add(seat130Btn);
//
//		JButton seat131Btn = new JButton("131");
//		seat131Btn.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		seat131Btn.setFont(new Font("Dialog", Font.BOLD, 16));
//		seat131Btn.setFocusPainted(false);
//		seat131Btn.setBackground(new Color(0, 128, 255));
//		seat131Btn.setBounds(871, 241, 72, 60);
//		panel1F.add(seat131Btn);
//
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