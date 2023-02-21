package Function;


import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Seat2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat2 window = new Seat2();
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
	public Seat2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dita810\\Desktop\\D팀 프로젝트\\-001.jpg"));
		frame.setSize(new Dimension(1100, 728));
		frame.setTitle("2층 좌석 배치도");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(-7, 2, 1084, 689);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		Button seat201btn = new Button("201");
		seat201btn.setForeground(Color.BLACK);
		seat201btn.setBounds(285, 131, 53, 53);
		panel.add(seat201btn);

		Button seat202btn = new Button("202");
		seat202btn.setBounds(338, 131, 53, 53);
		panel.add(seat202btn);

		Button seat203btn = new Button("203");
		seat203btn.setBounds(391, 131, 53, 53);
		panel.add(seat203btn);

		Button seat204btn = new Button("204");
		seat204btn.setBounds(444, 131, 53, 53);
		panel.add(seat204btn);

		Button seat205btn = new Button("205");
		seat205btn.setBounds(497, 131, 53, 53);
		panel.add(seat205btn);

		Button seat206btn = new Button("206");
		seat206btn.setBounds(550, 131, 53, 53);
		panel.add(seat206btn);

		Button seat207btn = new Button("207");
		seat207btn.setBounds(603, 131, 53, 53);
		panel.add(seat207btn);

		Button seat208btn = new Button("208");
		seat208btn.setBounds(292, 331, 53, 53);
		panel.add(seat208btn);

		Button seat209btn = new Button("209");
		seat209btn.setBounds(365, 331, 53, 53);
		panel.add(seat209btn);

		Button seat210btn = new Button("210");
		seat210btn.setBounds(438, 331, 53, 53);
		panel.add(seat210btn);

		Button seat211btn = new Button("211");
		seat211btn.setBounds(292, 404, 53, 53);
		panel.add(seat211btn);

		Button seat212btn = new Button("212");
		seat212btn.setBounds(365, 404, 53, 53);
		panel.add(seat212btn);

		Button seat213btn = new Button("213");
		seat213btn.setBounds(438, 404, 55, 53);
		panel.add(seat213btn);

		Button seat214btn = new Button("214");
		seat214btn.setBounds(535, 331, 53, 53);
		panel.add(seat214btn);

		Button seat215btn = new Button("215");
		seat215btn.setBounds(608, 331, 53, 53);
		panel.add(seat215btn);

		Button seat216btn = new Button("216");
		seat216btn.setBounds(535, 404, 53, 53);
		panel.add(seat216btn);

		Button seat217btn = new Button("217");
		seat217btn.setBounds(608, 404, 53, 53);
		panel.add(seat217btn);

		Button seat218btn = new Button("218");
		seat218btn.setBounds(146, 346, 53, 53);
		panel.add(seat218btn);

		Button seat219btn = new Button("219");
		seat219btn.setBounds(146, 399, 53, 53);
		panel.add(seat219btn);

		Button seat220btn = new Button("220");
		seat220btn.setBounds(146, 452, 53, 53);
		panel.add(seat220btn);

		Button seat221btn = new Button("221");
		seat221btn.setBounds(146, 505, 53, 53);
		panel.add(seat221btn);

		Button seat222btn = new Button("222");
		seat222btn.setBounds(146, 558, 53, 53);
		panel.add(seat222btn);

		Button seat223btn = new Button("223");
		seat223btn.setBounds(199, 558, 53, 53);
		panel.add(seat223btn);

		Button seat224btn = new Button("224");
		seat224btn.setBounds(306, 558, 53, 53);
		panel.add(seat224btn);

		Button seat225btn = new Button("225");
		seat225btn.setBounds(359, 558, 53, 53);
		panel.add(seat225btn);

		Button seat226btn = new Button("226");
		seat226btn.setBounds(412, 558, 53, 53);
		panel.add(seat226btn);

		Button seat227btn = new Button("227");
		seat227btn.setBounds(539, 558, 53, 53);
		panel.add(seat227btn);

		Button seat228btn = new Button("228");
		seat228btn.setBounds(592, 558, 53, 53);
		panel.add(seat228btn);

		Button seat229btn = new Button("229");
		seat229btn.setBounds(645, 558, 53, 53);
		panel.add(seat229btn);

		Button seat230btn = new Button("230");
		seat230btn.setBounds(698, 558, 53, 53);
		panel.add(seat230btn);

		Button seat231btn = new Button("231");
		seat231btn.setBounds(698, 337, 53, 53);
		panel.add(seat231btn);

		Button seat232btn = new Button("232");
		seat232btn.setBounds(698, 452, 53, 53);
		panel.add(seat232btn);

		Button seat233btn = new Button("233");
		seat233btn.setBounds(698, 505, 53, 53);
		panel.add(seat233btn);
	}

}
