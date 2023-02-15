package 기능구현;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Seat1_1 extends JFrame {

	private JPanel contentPane;

	 //버튼 디자인
	   public class RoundedButton extends JButton {
	      public RoundedButton() { super(); decorate(); } 
	      public RoundedButton(String text) { super(text); decorate(); } 
	      public RoundedButton(Action action) { super(action); decorate(); } 
	      public RoundedButton(Icon icon) { super(icon); decorate(); } 
	      public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
	      protected void decorate() { setBorderPainted(false); setOpaque(false); }
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color c=new Color(255,247,242); //배경색 결정
	         Color o=new Color(247,99,12); //글자색 결정
	         int width = getWidth(); 
	         int height = getHeight(); 
	         Graphics2D graphics = (Graphics2D) g; 
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	         if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
	         else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
	         else { graphics.setColor(c); } 
	         graphics.fillRoundRect(0, 0, width, height, 10, 10); 
	         FontMetrics fontMetrics = graphics.getFontMetrics(); 
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
	         int textX = (width - stringBounds.width) / 2; 
	         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
	         graphics.setColor(o); 
	         graphics.setFont(getFont()); 
	         graphics.drawString(getText(), textX, textY); 
	         graphics.dispose(); 
	         super.paintComponent(g); 
	         }
	      }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat1_1 Jframe = new Seat1_1();
					Jframe.setVisible(true);
					Jframe.setResizable(false);
					Jframe.setTitle("Seat1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Seat1_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 228, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		  //폰트(맑은고딕 굵게 16)
		Font logoutBtnFont = new Font("맑은고딕 굵게", Font.BOLD, 16);
		 //테두리선 굵게
		 LineBorder lb = new LineBorder(Color.BLACK,2);
	
		//1층 배치도 판넬
		JPanel panel1F = new JPanel();
		panel1F.setBounds(70, 67, 945, 599);
		
		//1층 좌석 버튼
		JButton seat101Btn = new JButton("101");
		seat101Btn.setBounds(113, 0, 72, 60);
		seat101Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel1F.setLayout(null);
		seat101Btn.setBackground(new Color(0, 128, 255));
		seat101Btn.setFont(logoutBtnFont);
		seat101Btn.setBorder(lb);
		seat101Btn.setFocusPainted(false);// hide focus rectangle
		panel1F.add(seat101Btn);
		
		JButton seat102Btn = new JButton("102");
		seat102Btn.setBounds(186, 0, 72, 60);
		seat102Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		seat102Btn.setBackground(new Color(0, 128, 255));
		seat102Btn.setFont(logoutBtnFont);
		seat102Btn.setBorder(lb);
		seat102Btn.setFocusPainted(false);// hide focus rectangle
		panel1F.add(seat102Btn);
		
		JButton seat103Btn = new JButton("103");
		seat103Btn.setBounds(259, 0, 72, 60);
		seat103Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat103Btn.setBorder(lb);
		seat103Btn.setFocusPainted(false);
		seat103Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat103Btn);
		
		JButton seat104Btn = new JButton("104");
		seat104Btn.setBounds(402, 0, 72, 60);
		seat104Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat104Btn.setBorder(lb);
		seat104Btn.setFocusPainted(false);
		seat104Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat104Btn);
		
		JButton seat105Btn = new JButton("105");
		seat105Btn.setBounds(475, 0, 72, 60);
		seat105Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat105Btn.setBorder(lb);
		seat105Btn.setFocusPainted(false);
		seat105Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat105Btn);
		
		JButton seat106Btn = new JButton("106");
		seat106Btn.setBounds(548, 0, 72, 60);
		seat106Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat106Btn.setBorder(lb);
		seat106Btn.setFocusPainted(false);
		seat106Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat106Btn);
		
		JButton seat107Btn = new JButton("107");
		seat107Btn.setBounds(621, 0, 72, 60);
		seat107Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat107Btn.setBorder(lb);
		seat107Btn.setFocusPainted(false);
		seat107Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat107Btn);
		
		JButton seat108Btn = new JButton("108");
		seat108Btn.setBounds(694, 0, 72, 60);
		seat108Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat108Btn.setBorder(lb);
		seat108Btn.setFocusPainted(false);
		seat108Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat108Btn);
		
		JButton seat109Btn = new JButton("109");
		seat109Btn.setBounds(147, 241, 72, 60);
		seat109Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat109Btn.setBorder(lb);
		seat109Btn.setFocusPainted(false);
		seat109Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat109Btn);
		
		JButton seat110Btn = new JButton("110");
		seat110Btn.setBounds(147, 303, 72, 60);
		seat110Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat110Btn.setBorder(lb);
		seat110Btn.setFocusPainted(false);
		seat110Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat110Btn);
		
		JButton seat111Btn = new JButton("111");
		seat111Btn.setBounds(329, 241, 72, 60);
		seat111Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat111Btn.setBorder(lb);
		seat111Btn.setFocusPainted(false);
		seat111Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat111Btn);
		
		JButton seat112Btn = new JButton("112");
		seat112Btn.setBounds(402, 241, 72, 60);
		seat112Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat112Btn.setBorder(lb);
		seat112Btn.setFocusPainted(false);
		seat112Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat112Btn);
		
		JButton seat113Btn = new JButton("113");
		seat113Btn.setBounds(329, 303, 72, 60);
		seat113Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat113Btn.setBorder(lb);
		seat113Btn.setFocusPainted(false);
		seat113Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat113Btn);
		
		JButton seat114Btn = new JButton("114");
		seat114Btn.setBounds(402, 303, 72, 60);
		seat114Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat114Btn.setBorder(lb);
		seat114Btn.setFocusPainted(false);
		seat114Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat114Btn);
		
		JButton seat115Btn = new JButton("115");
		seat115Btn.setBounds(576, 241, 72, 60);
		seat115Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat115Btn.setBorder(lb);
		seat115Btn.setFocusPainted(false);
		seat115Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat115Btn);
		
		JButton seat116Btn = new JButton("116");
		seat116Btn.setBounds(576, 303, 72, 60);
		seat116Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat116Btn.setBorder(lb);
		seat116Btn.setFocusPainted(false);
		seat116Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat116Btn);
		
		JButton seat117Btn = new JButton("117");
		seat117Btn.setBounds(0, 253, 72, 60);
		seat117Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat117Btn.setBorder(lb);
		seat117Btn.setFocusPainted(false);
		seat117Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat117Btn);
		
		JButton seat118Btn = new JButton("118");
		seat118Btn.setBounds(0, 314, 72, 60);
		seat118Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat118Btn.setBorder(lb);
		seat118Btn.setFocusPainted(false);
		seat118Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat118Btn);
		
		JButton seat119Btn = new JButton("119");
		seat119Btn.setBounds(0, 375, 72, 60);
		seat119Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat119Btn.setBorder(lb);
		seat119Btn.setFocusPainted(false);
		seat119Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat119Btn);
		
		JButton seat120Btn = new JButton("120");
		seat120Btn.setBounds(0, 437, 72, 60);
		seat120Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat120Btn.setBorder(lb);
		seat120Btn.setFocusPainted(false);
		seat120Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat120Btn);
		
		JButton seat121Btn = new JButton("121");
		seat121Btn.setBounds(98, 539, 72, 60);
		seat121Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat121Btn.setBorder(lb);
		seat121Btn.setFocusPainted(false);
		seat121Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat121Btn);
		
		JButton seat122Btn = new JButton("122");
		seat122Btn.setBounds(171, 539, 72, 60);
		seat122Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat122Btn.setBorder(lb);
		seat122Btn.setFocusPainted(false);
		seat122Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat122Btn);
		
		JButton seat123Btn = new JButton("123");
		seat123Btn.setBounds(329, 539, 72, 60);
		seat123Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat123Btn.setBorder(lb);
		seat123Btn.setFocusPainted(false);
		seat123Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat123Btn);
		
		JButton seat124Btn = new JButton("124");
		seat124Btn.setBounds(402, 539, 72, 60);
		seat124Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat124Btn.setBorder(lb);
		seat124Btn.setFocusPainted(false);
		seat124Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat124Btn);
		
		JButton seat125Btn = new JButton("125");
		seat125Btn.setBounds(475, 539, 72, 60);
		seat125Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat125Btn.setBorder(lb);
		seat125Btn.setFocusPainted(false);
		seat125Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat125Btn);
		
		JButton seat126Btn = new JButton("126");
		seat126Btn.setBounds(648, 539, 72, 60);
		seat126Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat126Btn.setBorder(lb);
		seat126Btn.setFocusPainted(false);
		seat126Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat126Btn);
		
		JButton seat127Btn = new JButton("127");
		seat127Btn.setBounds(721, 539, 72, 60);
		seat127Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat127Btn.setBorder(lb);
		seat127Btn.setFocusPainted(false);
		seat127Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat127Btn);
		
		JButton seat128Btn = new JButton("128");
		seat128Btn.setBounds(871, 480, 72, 60);
		seat128Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat128Btn.setBorder(lb);
		seat128Btn.setFocusPainted(false);
		seat128Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat128Btn);
		
		JButton seat129Btn = new JButton("129");
		seat129Btn.setBounds(871, 419, 72, 60);
		seat129Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat129Btn.setBorder(lb);
		seat129Btn.setFocusPainted(false);
		seat129Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat129Btn);
		
		JButton seat130Btn = new JButton("130");
		seat130Btn.setBounds(871, 358, 72, 60);
		seat130Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat130Btn.setBorder(lb);
		seat130Btn.setFocusPainted(false);
		seat130Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat130Btn);
		
		JButton seat131Btn = new JButton("131");
		seat131Btn.setBounds(871, 241, 72, 60);
		seat131Btn.setFont(new Font("Dialog", Font.BOLD, 16));
		seat131Btn.setBorder(lb);
		seat131Btn.setFocusPainted(false);
		seat131Btn.setBackground(new Color(0, 128, 255));
		panel1F.add(seat131Btn);
		
		contentPane.add(panel1F);
		
		
		//화장실
		JButton seat101Btn_1 = new JButton("<html><body><center>화<br>장<br>실</center></body></html>");
		seat101Btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		seat101Btn_1.setFont(new Font("Dialog", Font.BOLD, 16));
		seat101Btn_1.setFocusPainted(false);
		seat101Btn_1.setBackground(new Color(0, 128, 255));
		seat101Btn_1.setBounds(0, 58, 72, 167);
		panel1F.add(seat101Btn_1);
		
		JLabel lblNewLabel = new JLabel("자리 선택 완료");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel.setBounds(192, 36, 90, 29);
		contentPane.add(lblNewLabel);
		
	
		//-------------------------------------------------------------------------------------------------------------
	}
	
}