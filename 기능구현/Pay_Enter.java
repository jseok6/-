package ��ɱ���;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Toolkit;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		Button button1 = new Button("�����ϱ�");
		button1.setBackground(new Color(143, 188, 143));
		button1.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button1, BorderLayout.WEST);
		button1.setSize(216, 0);
		// �����ϱ� ��ư button1

		Button button2 = new Button("�Խ��ϱ�");
		button2.setBackground(new Color(112, 128, 144));
		button2.setPreferredSize(new Dimension(216, 0));
		frame.getContentPane().add(button2, BorderLayout.EAST);
		button2.setSize(216, 0);
		// �Խ��ϱ� ��ư button2
		
		textField = new JTextField();
		textField.setBackground(new Color(135, 206, 250));
		textField.setText("�����ϱ� �Խ��ϱ� �߿��� �������ּ���");
		textField.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(20);
		
	}


}
