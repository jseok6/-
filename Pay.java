package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pay extends JFrame{
	private JButton btntime;//�ð��ǹ�ư
	private JButton btnperiod;//�Ⱓ�� ��ư
	private JLabel label;
	

	private JButton btntime1;
	private JButton btntime2;
	private JButton btntime4;
	private JButton btntime6;
	private JButton btntime9;
	private JButton btntime12;
	
	private JButton btnpay;
	
	
	
	public Pay() {
		setTitle("�ð���");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		// panel
        JPanel panel = new JPanel();
        PayUI(panel);
		
		
		//initGUI
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
        //����̹���
        label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Java\\eclipse-workspace\\myjava\\study\\family.jpg"));
        label.setBounds(0, 0, 1100, 700);
        panel.add(label);

        // add
        getContentPane().add(panel);
       
        // visible
        setVisible(true);
        
        btnperiod.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Pay2 pay2=new Pay2();
				pay2.setVisible(true);
				dispose();
				
			}
		});
		
	}
	public void PayUI(JPanel panel){
		panel.setLayout(null);
		btntime=new JButton("�ð���");
		btntime.setBounds(67, 50, 420, 100);
		btntime.setBackground(Color.yellow);
		panel.add(btntime);
		
		btnperiod=new JButton("�Ⱓ��");
		btnperiod.setBounds(567, 50, 420, 100);
		btnperiod.setBackground(Color.yellow);
		panel.add(btnperiod);
		
		btntime1=new JButton("1�ð���");
		btntime1.setBounds(67,167,200,100);
		btntime1.setBackground(Color.yellow);
		panel.add(btntime1);
		
		
		btntime2=new JButton("2�ð���");
		btntime2.setBounds(427,167,200,100);
		btntime2.setBackground(Color.yellow);
		panel.add(btntime2);
		
		btntime4=new JButton("4�ð���");
		btntime4.setBounds(787,167,200,100);
		btntime4.setBackground(Color.yellow);
		panel.add(btntime4);
		
		
		btntime6=new JButton("6�ð���");
		btntime6.setBounds(67,367,200,100);
		btntime6.setBackground(Color.yellow);
		panel.add(btntime6);
		btntime9=new JButton("8�ð���");
		btntime9.setBounds(427,367,200,100);
		btntime9.setBackground(Color.yellow);
		panel.add(btntime9);
		btntime12=new JButton("12�ð���");
		btntime12.setBounds(787,367,200,100);
		btntime12.setBackground(Color.yellow);
		panel.add(btntime12);
		
		btnpay=new JButton("����");
		btnpay.setBounds(375,500,300,100);
		btnpay.setBackground(Color.yellow);
		panel.add(btnpay);
		
		

	
	}
	public void PayUI2(JPanel panel){
		panel.setLayout(null);
		btntime=new JButton("�ð���");
		btntime.setBounds(67, 50, 420, 100);
		btntime.setBackground(Color.yellow);
		panel.add(btntime);
		
		btnperiod=new JButton("�Ⱓ��");
		btnperiod.setBounds(567, 50, 420, 100);
		btnperiod.setBackground(Color.yellow);
		panel.add(btnperiod);
		
		btntime1=new JButton("1�ϱ�");
		btntime1.setBounds(67,167,200,100);
		btntime1.setBackground(Color.yellow);
		panel.add(btntime1);
		
		
		btntime2=new JButton("2�ϱ�");
		btntime2.setBounds(427,167,200,100);
		btntime2.setBackground(Color.yellow);
		panel.add(btntime2);
		
		btntime4=new JButton("4�ϱ�");
		btntime4.setBounds(787,167,200,100);
		btntime4.setBackground(Color.yellow);
		panel.add(btntime4);
		
		
		btntime6=new JButton("6�ϱ�");
		btntime6.setBounds(67,367,200,100);
		btntime6.setBackground(Color.yellow);
		panel.add(btntime6);
		btntime9=new JButton("9�ϱ�");
		btntime9.setBounds(427,367,200,100);
		btntime9.setBackground(Color.yellow);
		panel.add(btntime9);
		btntime12=new JButton("12�ϱ�");
		btntime12.setBounds(787,367,200,100);
		btntime12.setBackground(Color.yellow);
		panel.add(btntime12);
		
		btnpay=new JButton("����");
		btnpay.setBounds(375,500,300,100);
		btnpay.setBackground(Color.yellow);
		panel.add(btnpay);
		
		

	
	}
	
	
	public static void main(String[] args) {
		new Pay();
	}

}
