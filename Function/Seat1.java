package Function;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;

public class Seat1 {

	private JFrame frame;
	private Button seat101btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat1 window = new Seat1();
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
	public Seat1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dita810\\Desktop\\D팀 프로젝트\\-001.jpg"));
		frame.setSize(new Dimension(1100, 728));
		frame.setTitle("1층 좌석 배치도");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // 버튼 & 창 고정
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1084, 689);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		seat101btn = new Button("101");
		seat101btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat101btn.setBounds(285, 146, 53, 53);
		panel.add(seat101btn);

		Button seat102btn = new Button("102");
		seat102btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat102btn.setBounds(338, 146, 53, 53);
		panel.add(seat102btn);

		Button seat103btn = new Button("103");
		seat103btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat103btn.setBounds(391, 146, 53, 53);
		panel.add(seat103btn);

		Button seat104btn = new Button("104");
		seat104btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat104btn.setBounds(497, 146, 53, 53);
		panel.add(seat104btn);

		Button seat105btn = new Button("105");
		seat105btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat105btn.setBounds(550, 146, 53, 53);
		panel.add(seat105btn);

		Button seat106btn = new Button("106");
		seat106btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat106btn.setBounds(603, 146, 53, 53);
		panel.add(seat106btn);

		Button seat107btn = new Button("107");
		seat107btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat107btn.setBounds(656, 146, 53, 53);
		panel.add(seat107btn);

		Button seat108btn = new Button("108");
		seat108btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat108btn.setBounds(709, 146, 53, 53);
		panel.add(seat108btn);

		Button seat109btn = new Button("109");
		seat109btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat109btn.setBounds(335, 306, 53, 53);
		panel.add(seat109btn);

		Button seat110btn = new Button("110");
		seat110btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat110btn.setBounds(335, 359, 53, 53);
		panel.add(seat110btn);

		Button seat111btn = new Button("111");
		seat111btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat111btn.setBounds(441, 306, 53, 53);
		panel.add(seat111btn);

		Button seat112btn = new Button("112");
		seat112btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat112btn.setBounds(494, 306, 53, 53);
		panel.add(seat112btn);

		Button seat113btn = new Button("113");
		seat113btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat113btn.setBounds(441, 359, 53, 53);
		panel.add(seat113btn);

		Button seat114btn = new Button("114");
		seat114btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat114btn.setBounds(494, 359, 53, 53);
		panel.add(seat114btn);

		Button seat115btn = new Button("115");
		seat115btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat115btn.setBounds(634, 306, 53, 53);
		panel.add(seat115btn);

		Button seat116btn = new Button("116");
		seat116btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat116btn.setBounds(634, 359, 53, 53);
		panel.add(seat116btn);

		Button seat117btn = new Button("117");
		seat117btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat117btn.setBounds(189, 315, 53, 53);
		panel.add(seat117btn);

		Button seat118btn = new Button("118");
		seat118btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat118btn.setBounds(189, 368, 53, 53);
		panel.add(seat118btn);

		Button seat119btn = new Button("119");
		seat119btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat119btn.setBounds(189, 421, 53, 53);
		panel.add(seat119btn);

		Button seat120btn = new Button("120");
		seat120btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat120btn.setBounds(189, 474, 53, 53);
		panel.add(seat120btn);

		Button seat121btn = new Button("121");
		seat121btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat121btn.setBounds(285, 527, 53, 53);
		panel.add(seat121btn);

		Button seat122btn = new Button("122");
		seat122btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat122btn.setBounds(338, 527, 53, 53);
		panel.add(seat122btn);

		Button seat123btn = new Button("123");
		seat123btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat123btn.setBounds(444, 527, 53, 53);
		panel.add(seat123btn);

		Button seat124btn = new Button("124");
		seat124btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat124btn.setBounds(497, 527, 53, 53);
		panel.add(seat124btn);

		Button seat125btn = new Button("125");
		seat125btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat125btn.setBounds(550, 527, 53, 53);
		panel.add(seat125btn);

		Button seat126btn = new Button("126");
		seat126btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat126btn.setBounds(674, 527, 53, 53);
		panel.add(seat126btn);

		Button seat127btn = new Button("127");
		seat127btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat127btn.setBounds(727, 527, 53, 53);
		panel.add(seat127btn);
		
		Button seat128btn = new Button("128");
		seat128btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat128btn.setBounds(812, 474, 53, 53);
		panel.add(seat128btn);

		Button seat129btn = new Button("129");
		seat129btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat129btn.setBounds(812, 421, 53, 53);
		panel.add(seat129btn);

		Button seat130btn = new Button("130");
		seat130btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat130btn.setBounds(812, 368, 53, 53);
		panel.add(seat130btn);

		Button seat131btn = new Button("131");
		seat131btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		seat131btn.setBounds(812, 289, 53, 53);
		panel.add(seat131btn);
	}

}