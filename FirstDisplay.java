package study;

import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Button;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstDisplay extends JFrame{

	private JPanel frmFamilyStudyCafe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstDisplay window = new FirstDisplay();
					window.setVisible(true);
					window.setResizable(false);
					window.setTitle("FamilyStudyCafe_FirstDisplay");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		frmFamilyStudyCafe = new JPanel();
		frmFamilyStudyCafe.setBorder(new EmptyBorder(5, 5, 5, 5));
//		frmFamilyStudyCafe.setBounds(100, 100, 1000, 600);
		//frmFamilyStudyCafe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFamilyStudyCafe.setLayout(null);
		setContentPane(frmFamilyStudyCafe);
		
		Button button1 = new Button("�����");
		button1.setBounds(0, 0, 492, 561);
		button1.setBackground(new Color(205, 133, 63));
		button1.setPreferredSize(new Dimension(216, 0));
		frmFamilyStudyCafe.add(button1);
		// ����� button1
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new User_LoginUI();
				dispose();
			}
		});
		
		Button button2 = new Button("������");
		button2.setBounds(492, 0, 492, 561);
		button2.setBackground(new Color(102, 205, 170));
		button2.setPreferredSize(new Dimension(216, 0));
		frmFamilyStudyCafe.add(button2);
		// ������ button2
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
					new ManagerLogin();
					dispose();				
			}
	});
	}	
}