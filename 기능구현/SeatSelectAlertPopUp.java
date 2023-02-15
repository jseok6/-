package 기능구현;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SeatSelectAlertPopUp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatSelectAlertPopUp window = new SeatSelectAlertPopUp();
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
	public SeatSelectAlertPopUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dita810\\Desktop\\D팀 프로젝트 자료\\FamilyStudycafe\\src\\img\\family.jpg"));
		frame.getContentPane().setFont(new Font("굴림", Font.PLAIN, 12));
		frame.setResizable(false);
		frame.setBounds(100, 100, 465, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("oo번 자리를 선택 하시겠습니까?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		lblNewLabel.setBounds(75, 40, 317, 78);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton1 = new JButton("확인");
		btnNewButton1.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton1.setDefaultCapable(false);
		btnNewButton1.setSelected(true);
		btnNewButton1.setFont(new Font("굴림", Font.PLAIN, 15));
		btnNewButton1.setPreferredSize(new Dimension(0, 0));
		btnNewButton1.setMinimumSize(new Dimension(0, 0));
		btnNewButton1.setMaximumSize(new Dimension(0, 0));
		btnNewButton1.setBounds(99, 139, 109, 50);
		frame.getContentPane().add(btnNewButton1);

		JButton btnNewButton2 = new JButton("다시 선택");
		btnNewButton2.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton2.setDefaultCapable(false);
		btnNewButton2.setSelected(true);
		btnNewButton2.setFont(new Font("굴림", Font.PLAIN, 15));
		btnNewButton2.setPreferredSize(new Dimension(0, 0));
		btnNewButton2.setMinimumSize(new Dimension(0, 0));
		btnNewButton2.setMaximumSize(new Dimension(0, 0));
		btnNewButton2.setBounds(258, 139, 109, 50);
		frame.getContentPane().add(btnNewButton2);
	}
}
