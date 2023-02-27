package study;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayEnter  extends JFrame{

	private JPanel payenterPanel;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayEnter window = new PayEnter("-test-");
					window.setTitle("FSC_PayEnter");
					window.setVisible(true);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PayEnter(String membertel) {
		setTitle("FamilyStudyCafe_PayEnter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1056,570);
		this.setResizable(false);
		this.setVisible(true);
		System.out.println("PayEnter:"+membertel);
		
		payenterPanel = new JPanel();
		payenterPanel.setBounds(100, 100, 1056, 570);
		payenterPanel.setLayout(null);
		setContentPane(payenterPanel);
		
		Button button1 = new Button("시간제 & 기간제 결제하기");
		button1.setBounds(0, 20, 528, 510);
		button1.setBackground(new Color(143, 188, 143));
		button1.setPreferredSize(new Dimension(216, 0));
		payenterPanel.add(button1);
		// 시간제 결제하기 버튼 button1
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button1) {
//					Frame fs = new Frame();
//					fs.setVisible(true);
//					fs.setSize(700, 600);
//					fs.setLocation(200, 200);
//					fs.dispose();
					new Pay(membertel);
					dispose();
				}
			}
		});// 시간제 & 기간제 결제창 실행
		
		Button button2 = new Button("입실하기");
		button2.setBounds(528, 20, 528, 510);
		button2.setBackground(new Color(112, 128, 144));
		button2.setPreferredSize(new Dimension(216, 0));
		payenterPanel.add(button2);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				//조건에 회원의 남은시간 가져와서 남은시간이 0시간0분0초보다 많은지 확인
				FindMemberTable fmt = new FindMemberTable();
				try 
				{
					String remaintime = fmt.findRemainTime(membertel);
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					// 문자열 -> Time
					LocalTime remaintimedate = LocalTime.parse(remaintime);		
					System.out.println("PayEnter_remtime:"+remaintimedate);
					// Time -> Sec(초) 추출
					long remaintimeSec = remaintimedate.getSecond();
					System.out.println("PayEnter_Member is:"+membertel+ " RemainSec:"+ remaintimeSec);
					if (remaintimeSec > 0) {
						try {
							SeatSelect ss = new SeatSelect(membertel);
							ss.setTitle("FSC_SeatSelect");
							dispose();
						} catch (NumberFormatException | SQLException e1) {
							e1.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "시간 결제 후 이용해주세요");
					}
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}			
			}
		});

		// 입실하기 버튼 button2

		textField = new JTextField();
		textField.setBounds(0, 0, 1040, 20);
		textField.setBackground(new Color(135, 206, 250));
		textField.setText("결제하기, 입실하기 중에서 선택해주세요");
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		payenterPanel.add(textField);
		textField.setColumns(20);
	}
}