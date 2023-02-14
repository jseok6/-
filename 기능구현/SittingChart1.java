package 기능구현;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;

public class SittingChart1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SittingChart1 window = new SittingChart1();
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
	public SittingChart1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		Button button101 = new Button("New button");
		panel.add(button101);

		Button button102 = new Button("New button");
		panel.add(button102);

		Button button103 = new Button("New button");
		panel.add(button103);

		Button button104 = new Button("New button");
		panel.add(button104);

		Button button105 = new Button("New button");
		panel.add(button105);

		Button button106 = new Button("New button");
		panel.add(button106);

		Button button107 = new Button("New button");
		panel.add(button107);

		Button button108 = new Button("New button");
		panel.add(button108);

		Button button109 = new Button("New button");
		panel.add(button109);

		Button button110 = new Button("New button");
		panel.add(button110);

		Button button111 = new Button("New button");
		panel.add(button111);

		Button button112 = new Button("New button");
		panel.add(button112);

		Button button113 = new Button("New button");
		panel.add(button113);

		Button button114 = new Button("New button");
		panel.add(button114);

		Button button115 = new Button("New button");
		panel.add(button115);

		Button button116 = new Button("New button");
		panel.add(button116);

		Button button117 = new Button("New button");
		panel.add(button117);

		Button button118 = new Button("New button");
		panel.add(button118);

		Button button119 = new Button("New button");
		panel.add(button119);

		Button button120 = new Button("New button");
		panel.add(button120);

		Button button121 = new Button("New button");
		panel.add(button121);

		Button button122 = new Button("New button");
		panel.add(button122);

		Button button123 = new Button("New button");
		panel.add(button123);

		Button button124 = new Button("New button");
		panel.add(button124);

		Button button125 = new Button("New button");
		panel.add(button125);

		Button button126 = new Button("New button");
		panel.add(button126);

		Button button127 = new Button("New button");
		panel.add(button127);

		Button button128 = new Button("New button");
		panel.add(button128);

		Button button129 = new Button("New button");
		panel.add(button129);

		Button button130 = new Button("New button");
		panel.add(button130);

		Button button131 = new Button("New button");
		panel.add(button131);
	}

}
