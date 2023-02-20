package ��ɱ���;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dita810\\Desktop\\D�� ������Ʈ\\-001.jpg"));
		frame.setTitle("����, �Խ�");
		frame.setResizable(false); // ��ư & â ����
		frame.setBounds(100, 100, 1056, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Button button1 = new Button("�����ϱ�");
		button1.setBounds(0, 20, 520, 510);
		button1.setBackground(new Color(143, 188, 143));
		button1.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button1);
		// �����ϱ� ��ư button1
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button1) {
					Frame fs = new Frame();
					fs.setVisible(true);
					fs.setSize(700, 600);
					fs.setLocation(200, 200);
				}
			}
		});

		Button button2 = new Button("�Խ��ϱ�");
		button2.setBounds(520, 20, 520, 510);
		button2.setBackground(new Color(112, 128, 144));
		button2.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button2);
		button2.addActionListener(new ActionListener() {

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

		// �Խ��ϱ� ��ư button2

		textField = new JTextField();
		textField.setBounds(0, 0, 1040, 20);
		textField.setBackground(new Color(135, 206, 250));
		textField.setText("�����ϱ�, �Խ��ϱ� �߿��� �������ּ���");
		textField.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField);
		textField.setColumns(20);

	}

}
