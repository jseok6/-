package study;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
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
		
		//1�� ��ġ�� �ǳ�
		JPanel panel1F = new JPanel();
		panel1F.setBounds(71, 37, 945, 599);
		contentPane.add(panel1F);
		
		//2�� ��ġ�� �ǳ�
		JPanel panel2F = new JPanel();
		panel2F.setBackground(new Color(0, 255, 255)); //���߿� �ӽ� ���߰�, 1�� �ǳ� ������ �����ؾ���
		panel2F.setBounds(71, 37, 945, 599);
		panel2F.setEnabled(false); //��ư ��Ȱ��ȭ
		panel2F.setVisible(false); //��ư ���߱�
		contentPane.add(panel2F);
		
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
		firstFloorBtn.setBackground(new Color(245, 134, 52)); //�� ���� �ʿ�?
		firstFloorBtn.setBounds(0, 646, 116, 38);
		firstFloorBtn.setFont(logoutBtnFont);
		firstFloorBtn.setFocusPainted(false);// hide focus rectangle
		firstFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2F.setEnabled(false); //2�� ��ġ�� ��Ȱ��ȭ
				panel2F.setVisible(false); //2�� ��ġ�� ���߱�
				panel1F.setEnabled(true); //1�� ��ġ�� ��Ȱ��ȭ
				panel1F.setVisible(true); //1�� ��ġ�� ���߱�
			}
		});
		contentPane.add(firstFloorBtn);
		
		//����(2��) ���� ��ư
		JButton secondFloorBtn = new JButton("2��");
		secondFloorBtn.setBackground(new Color(248, 211, 129)); //�� ���� �ʿ�
		secondFloorBtn.setBounds(0, 609, 116, 38);
		secondFloorBtn.setFont(logoutBtnFont);
		secondFloorBtn.setFocusPainted(false);// hide focus rectangle
		secondFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1F.setEnabled(false); //1�� ��ġ�� ��Ȱ��ȭ
				panel1F.setVisible(false); //1�� ��ġ�� ���߱�
				panel2F.setEnabled(true); //2�� ��ġ�� ��Ȱ��ȭ
				panel2F.setVisible(true); //2�� ��ġ�� ���߱�
			}
		});
		contentPane.add(secondFloorBtn);
		
		//�������� ������ ID(�̸�?)
		JLabel idLabel = new JLabel("������:"); // + ������ ID + " ��" �߰��ʿ�
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setBounds(71, 0, 197, 38);
		idLabel.setFont(logoutBtnFont);
		contentPane.add(idLabel);
		
		//�ΰ��̹���
		JLabel logoLabel = new JLabel();
		ImageIcon logoIcon= new ImageIcon
				("C:\\Users\\dita810\\Desktop\\JAVA_TeamProject\\ProjectFolder02.13\\-\\src\\img\\family.jpg");
        Image logoImg = logoIcon.getImage(); // ImageIcon ��ü���� Image ����
        
        // ����� Image�� ũ�� �����Ͽ� ���ο� Image ��ü ����
    	Image updateLogoImg = logoImg.getScaledInstance(70, 69, Image.SCALE_SMOOTH);
        
        // ���ο� Image ��ü�� ImageIcon ��ü ����
        ImageIcon updateLogoIcon = new ImageIcon(updateLogoImg);
        
        logoLabel.setIcon(updateLogoIcon);
		logoLabel.setBounds(0, 0, 70, 69);
        getContentPane().add(logoLabel);
		//logoLabel.setIcon(logoIcon);
		//contentPane.add(logoLabel);
		setVisible(true);
		
	}
}
