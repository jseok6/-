package study.function;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import study.FirstDisplay;
import study.Pay;
import study.function.SeatSelect;

public class PayEnter extends JFrame{

	private JPanel pePanel;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayEnter window = new PayEnter();
					window.setVisible(true);
					window.setResizable(false);
					window.setTitle("PayEnter");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PayEnter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 570);
		pePanel = new JPanel();
		pePanel.setLayout(null);
		setContentPane(pePanel);

		//화면 위쪽 안내 텍스트
		textField = new JTextField();
		textField.setBounds(0, 0, 1040, 20);
		textField.setBackground(new Color(135, 206, 250));
		textField.setText("결제하기, 입실하기 중에서 선택해주세요");
		textField.setHorizontalAlignment(JTextField.CENTER);
		pePanel.add(textField);
		textField.setColumns(20);
		
		// 시간제 결제하기 버튼 button1
		Button paymentBtn = new Button("시간제 & 기간제 결제하기");
		paymentBtn.setBounds(0, 20, 528, 510);
		paymentBtn.setBackground(new Color(143, 188, 143));		
		pePanel.add(paymentBtn);
		paymentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == paymentBtn) {
					Pay pay = new Pay();
					pay.setTitle("FamilyStudyCafe_Pay");
					dispose();
				}
			}
		});// 시간제 & 기간제 결제창 실행
		
		// 입실하기 버튼 button2
		Button button2 = new Button("입실하기");
		button2.setBounds(528, 20, 528, 510);
		button2.setBackground(new Color(112, 128, 144));
		pePanel.add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button2) {
				SeatSelect seatSelect = new SeatSelect();
				seatSelect.setTitle("FamilyStudyCafe_SeatSelect");
				seatSelect.setVisible(true);
				seatSelect.setResizable(false);
				seatSelect.setTitle("SeatSelect");
				dispose();
				}
			}
		});
	}
}