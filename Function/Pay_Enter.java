package Function;

import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import study.Pay;
import study.Pay2;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pay_Enter {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay_Enter window = new Pay_Enter();
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
	public Pay_Enter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dita810\\Desktop\\D팀 프로젝트\\-001.jpg"));
		frame.setTitle("결제, 입실");
		frame.setResizable(false); // 버튼 & 창 고정
		frame.setBounds(100, 100, 1056, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Button button1 = new Button("시간제 결제하기");
		button1.setBounds(0, 20, 346, 510);
		button1.setBackground(new Color(143, 188, 143));
		button1.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button1);
		// 시간제 결제하기 버튼 button1
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button1) {
//					Frame fs = new Frame();
//					fs.setVisible(true);
//					fs.setSize(700, 600);
//					fs.setLocation(200, 200);
					new Pay();
				}
			}
		});
		Button button2 = new Button("기간제 결제하기");
		button2.setBounds(346, 20, 347, 510);
		button2.setBackground(new Color(143, 188, 143));
		button2.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button2);
		// 기간제 결제하기 버튼 button2
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button2) {
//					Frame fs = new Frame();
//					fs.setVisible(true);
//					fs.setSize(700, 600);
//					fs.setLocation(200, 200);
					new Pay2();
				}
			}
		});

		Button button3 = new Button("입실하기");
		button3.setBounds(693, 20, 347, 510);
		button3.setBackground(new Color(112, 128, 144));
		button3.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button3);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button2) {
					Frame fs = new Frame();
					fs.setVisible(true);
					fs.setSize(700, 600);
					fs.setLocation(200, 200);
					
				}
			}
		});

		// 입실하기 버튼 button3

		textField = new JTextField();
		textField.setBounds(0, 0, 1040, 20);
		textField.setBackground(new Color(135, 206, 250));
		textField.setText("결제하기, 입실하기 중에서 선택해주세요");
		textField.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField);
		textField.setColumns(20);

	}

}