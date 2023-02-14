package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestUI extends JFrame{
	
	private JTextField title;
	private JTextField detail;
	private JButton check;
	
	public QuestUI() {
		setTitle("질문창");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
        QuestPanel(panel);
        
        panel.setBounds(0,0,1100,700);
        getContentPane().add(panel);
        
        setVisible(true);
       
	}
	public void QuestPanel(JPanel panel)
	{
		panel.setLayout(null);
		Font font=new Font("맑은 고딕", Font.PLAIN, 17);
		
		
		JTextField title=new JTextField(20);
		title.setBounds(170, 50, 700, 100);
		title.setText("                                         질문 내용을 입력해주세요.");
		title.setFont(font);
		panel.add(title);
		
		JTextField detail=new JTextField(20);
		detail.setBounds(170,200,700,300);
		detail.setText("질문내용:");
		detail.setFont(font);
		panel.add(detail);
		
		JButton check=new JButton("확인");
		check.setBounds(430, 550, 200, 100);
		check.setFont(font);
		check.setBackground(Color.yellow);
		panel.add(check);
		
		check.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				UserMainUI Userui=new UserMainUI();
				Userui.setVisible(true);
				dispose();
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		new QuestUI();
		

	}

}
