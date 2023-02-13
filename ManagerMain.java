package study;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain Jframe = new ManagerMain();
					Jframe.setVisible(true);
					Jframe.setResizable(false);
					Jframe.setTitle("FamilyStudyCafe_ManagerMain");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 228, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 37, 945, 599);
		contentPane.add(panel);
		
		//�α׾ƿ� ��ư
		JButton logoutBtn = new JButton("�α׾ƿ�");
		logoutBtn.setBackground(new Color(255, 0, 0));
		logoutBtn.setBounds(954, 0, 128, 38);
		Font logoutBtnFont = new Font("������� ����", Font.BOLD, 16);
		logoutBtn.setFont(logoutBtnFont);
        logoutBtn.setFocusPainted(false);// hide focus rectangle
		contentPane.add(logoutBtn);
		
		//����Ȯ�� ��ư
		JButton searchQuestionBtn = new JButton("<html><body><center>��"
        		+ "<br>��</center><br>Ȯ<br>��</body></html>");
		searchQuestionBtn.setBackground(new Color(0, 255, 64));
		searchQuestionBtn.setBounds(1020, 141, 62, 395);
		searchQuestionBtn.setFont(logoutBtnFont);
		searchQuestionBtn.setFocusPainted(false);// hide focus rectangle
		searchQuestionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(searchQuestionBtn);
		
		//����(1��) ���� ��ư
		JButton firstFloorBtn = new JButton("1��");
		firstFloorBtn.setBackground(new Color(255, 128, 0));
		firstFloorBtn.setBounds(0, 646, 116, 38);
		firstFloorBtn.setFont(logoutBtnFont);
		searchQuestionBtn.setFocusPainted(false);// hide focus rectangle
		searchQuestionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(firstFloorBtn);
	}
}
