package 기능구현;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

public class FirstDisplay {

	private JFrame frmFamilyStudyCafe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstDisplay window = new FirstDisplay();
					window.frmFamilyStudyCafe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstDisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFamilyStudyCafe = new JFrame();
		frmFamilyStudyCafe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dita810\\Desktop\\D팀 프로젝트\\-001.jpg"));
		frmFamilyStudyCafe.setTitle("Family Study Cafe에 오신 것을 환영합니다.");
		frmFamilyStudyCafe.setResizable(false); //버튼 & 창 고정
		frmFamilyStudyCafe.setBounds(100, 100, 1000, 600);
		frmFamilyStudyCafe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFamilyStudyCafe.getContentPane().setLayout(null);
	
		
		Button button1 = new Button("사용자");
		button1.setBounds(0, 0, 492, 561);
		button1.setBackground(new Color(205, 133, 63));
		button1.setPreferredSize(new Dimension(216, 0));
		frmFamilyStudyCafe.getContentPane().add(button1);
		// 사용자 버튼 button1
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button1) {
					Frame fs = new Frame();
					fs.setVisible(true);
					fs.setSize(700,600);
					fs.setLocation(200, 200);
					
				}
			}
		});
		
		Button button2 = new Button("관리자");
		button2.setBounds(492, 0, 492, 561);
		button2.setBackground(new Color(102, 205, 170));
		button2.setPreferredSize(new Dimension(216, 0));
		frmFamilyStudyCafe.getContentPane().add(button2);
		// 관리자 버튼 button2
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button2) {
					Frame fs = new Frame();
					fs.setVisible(true);
					fs.setSize(700,600);
					fs.setLocation(200, 200);
					
				}
			}
		});
		
	}
}