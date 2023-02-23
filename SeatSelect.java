package study;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.text.StyledEditorKit.FontFamilyAction;

import study.FindSeatTable;
import study.FindUseTable;
import study.ManagerMain;
import study.Pay;
import javax.swing.SwingConstants;

public class SeatSelect extends JFrame {
	private static SeatSelect ssinstance;
	private JPanel contentPane;

	public static void main(String[] args) {
		// ÀüºÎ ÁÖ¼®Ã³¸®ÇÏ¸é ÀÌÆÄÀÏÀÚÃ¼·Î ½ÇÇà¾ÈµÊ, ·Î±×ÀÎÃ¢¿¡¼­ ³Ñ¾î¿À´Â ½ÇÇàÀº ±×´ë·Î °¡´É
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(ssinstance==null)
					{
						synchronized (SeatSelect.class) {
							SeatSelect Jframe = new SeatSelect("-test-");
							Jframe.setVisible(true);
							Jframe.setResizable(false);
							Jframe.setTitle("FSC_SeatSelect");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ÇÁ·¹ÀÓ »ý¼º
	public SeatSelect(String membertel) throws NumberFormatException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1214, 836);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 228, 166));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		System.out.println("SeatSelect:"+membertel);

		// ÆùÆ®(¸¼Àº°íµñ ±½°Ô 16)
		Font logoutBtnFont = new Font("¸¼Àº°íµñ ±½°Ô", Font.BOLD, 16);
		// Å×µÎ¸®¼± ±½°Ô
		LineBorder lb = new LineBorder(Color.BLACK, 2);
		setVisible(true);

		ImageIcon logoIcon = new ImageIcon(
				"C:\\Users\\dita810\\Desktop\\DÆÀ ÇÁ·ÎÁ§Æ® ÀÚ·á\\FamilyStudycafe\\src\\img\\Button_image\\family.jpg");
		Image logoImg = logoIcon.getImage(); // ImageIcon °´Ã¼¿¡¼­ Image ÃßÃâ
		Image updateLogoImg = logoImg.getScaledInstance(70, 69, Image.SCALE_SMOOTH); // ÃßÃâµÈ ImageÀÇ Å©±â Á¶ÀýÇÏ¿© »õ·Î¿î Image °´Ã¼
																						// »ý¼º
		ImageIcon updateLogoIcon = new ImageIcon(updateLogoImg); // »õ·Î¿î Image °´Ã¼·Î ImageIcon °´Ã¼ »ý¼º

		ImageIcon trashcanIcon = new ImageIcon(
				"C:\\Users\\dita810\\Desktop\\DÆÀ ÇÁ·ÎÁ§Æ® ÀÚ·á\\FamilyStudycafe\\src\\img\\Button_image\\trashcan.png");
		Image trashcanImg = trashcanIcon.getImage();
		Image updateTrashcanImg = trashcanImg.getScaledInstance(57, 54, Image.SCALE_SMOOTH);
		ImageIcon updatetrashcanIcon = new ImageIcon(updateTrashcanImg);

		ImageIcon waterPFIcon = new ImageIcon(
				"C:\\Users\\dita810\\Desktop\\DÆÀ ÇÁ·ÎÁ§Æ® ÀÚ·á\\FamilyStudycafe\\src\\img\\Button_image\\water.png");
		Image waterPFImg = waterPFIcon.getImage();
		Image updateWaterPFImg = waterPFImg.getScaledInstance(35, 54, Image.SCALE_SMOOTH);
		ImageIcon updateWaterPFIcon = new ImageIcon(updateWaterPFImg);

		setVisible(true);

		// -----------------------------------------------------------------------------------------------------------
		// 1Ãþ ¹èÄ¡µµ ÆÇ³Ú
		JPanel panel1F = new JPanel();
		panel1F.setBounds(121, 87, 945, 599);
		panel1F.setLayout(null);
//			panel1F.setEnabled(false); //ÆÐ³Î ºñÈ°¼ºÈ­
//			panel1F.setVisible(false); //ÆÐ³Î °¨Ãß±â
		contentPane.add(panel1F);

		// 1Ãþ ÁÂ¼® ¹öÆ° »ý¼º, À§Ä¡ÁöÁ¤
		String[] seat1Farr = { "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111",
				"112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126",
				"127", "128", "129", "130" };
		JButton[] seat1FBtn = new JButton[31];

		FindSeatTable findSeatTable = new FindSeatTable();

		for (int i = 0; i < seat1Farr.length; i++) {
			seat1FBtn[i] = new JButton(seat1Farr[i]);
			seat1FBtn[i].setBounds(871, 184, 72, 60);
			seat1FBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
			seat1FBtn[i].setBorder(lb);
			seat1FBtn[i].setFocusPainted(false);
//				seat1FBtn[i].setBackground(new Color(0, 128, 255));
			try {
				if (findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i])) == 0) {// »ç¿ë°¡´É
					seat1FBtn[i].setBackground(Color.CYAN);
				} else
					try {
						if (findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i])) == 1) {// »ç¿ëÁß
							seat1FBtn[i].setBackground(Color.ORANGE);
						} else
							try {
								if (findSeatTable.seatAvail(Integer.parseInt(seat1Farr[i])) == 2) {// »ç¿ëºÒ°¡
									seat1FBtn[i].setBackground(Color.RED);
								}
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			panel1F.add(seat1FBtn[i]);
		}

		// ÀÎµ¦½º(i)ÀÇ °ªÀ» seatNumÀ¸·Î °¡Áö´Â seatAvail °Ë»ö
		Integer.parseInt(seat1Farr[0]);

		seat1FBtn[0].setBounds(114, 0, 72, 60); // 100¹ø ÁÂ¼®
		seat1FBtn[1].setBounds(186, 0, 72, 60);
		seat1FBtn[2].setBounds(259, 0, 72, 60);
		seat1FBtn[3].setBounds(402, 0, 72, 60);
		seat1FBtn[4].setBounds(475, 0, 72, 60);
		seat1FBtn[5].setBounds(548, 0, 72, 60);
		seat1FBtn[6].setBounds(621, 0, 72, 60);
		seat1FBtn[7].setBounds(694, 0, 72, 60);
		seat1FBtn[8].setBounds(147, 241, 72, 60);
		seat1FBtn[9].setBounds(147, 303, 72, 60);
		seat1FBtn[10].setBounds(329, 241, 72, 60);
		seat1FBtn[11].setBounds(402, 241, 72, 60);
		seat1FBtn[12].setBounds(329, 303, 72, 60);
		seat1FBtn[13].setBounds(402, 303, 72, 60);
		seat1FBtn[14].setBounds(576, 241, 72, 60);
		seat1FBtn[15].setBounds(576, 303, 72, 60);
		seat1FBtn[16].setBounds(0, 253, 72, 60);
		seat1FBtn[17].setBounds(0, 314, 72, 60);
		seat1FBtn[18].setBounds(0, 375, 72, 60);
		seat1FBtn[19].setBounds(0, 437, 72, 60);
		seat1FBtn[20].setBounds(98, 539, 72, 60);
		seat1FBtn[21].setBounds(171, 539, 72, 60);
		seat1FBtn[22].setBounds(329, 539, 72, 60);
		seat1FBtn[23].setBounds(402, 539, 72, 60);
		seat1FBtn[24].setBounds(475, 539, 72, 60);
		seat1FBtn[25].setBounds(648, 539, 72, 60);
		seat1FBtn[26].setBounds(721, 539, 72, 60);
		seat1FBtn[27].setBounds(871, 480, 72, 60);
		seat1FBtn[28].setBounds(871, 419, 72, 60);
		seat1FBtn[29].setBounds(871, 358, 72, 60);
		seat1FBtn[30].setBounds(871, 241, 72, 60);

		for (int i = 0; i < seat1FBtn.length; i++) {
			seat1FBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame fs = new JFrame();
					fs.setTitle("ÀÚ¸® ¼±ÅÃ ¿©ºÎ");
					fs.setVisible(true);
					fs.setIconImage(Toolkit.getDefaultToolkit().getImage(
							"C:\\Users\\dita810\\Desktop\\DÆÀ ÇÁ·ÎÁ§Æ® ÀÚ·á\\FamilyStudycafe\\src\\img\\family.jpg"));
					fs.setFont(new Font("±¼¸²", Font.PLAIN, 12));
					fs.setResizable(false);
					fs.setBounds(370, 289, 465, 260);
					fs.getContentPane().setLayout(null);

					JButton seatSource = (JButton) e.getSource();
					JLabel guideLabel = new JLabel(seatSource.getText() + "¹ø ÀÚ¸®¸¦ ¼±ÅÃ ÇÏ½Ã°Ú½À´Ï±î?");
					guideLabel.setHorizontalAlignment(SwingConstants.CENTER);
					guideLabel.setFont(new Font("ÇÔÃÊ·Ò¹ÙÅÁ", Font.PLAIN, 18));
					guideLabel.setBounds(75, 40, 317, 78);
					fs.getContentPane().add(guideLabel);

					// È®ÀÎ¹öÆ°
					JButton checkBtn = new JButton("È®ÀÎ");
					checkBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
							String checkStat;
							// Object obj = new Object();
							fs.setVisible(false);
							fs.dispose(); // ¹öÆ° ´©¸¦¶§ ±× Ã¢¸¸ Á¾·áÇÏ°Ô ÇÏ´Â ¸Þ¼Òµå
							new Pay(membertel);
=======
							String checkStat;	
>>>>>>> ed36a6e9c86348c546f9488b8f8a5cf27dc16997

							// use Å×ÀÌºí¿¡¼­ »ç¿ëÁßÀÎÁö °Ë»ç
							FindUseTable fut = new FindUseTable();
							LocalDateTime nowDateTime = LocalDateTime.now();
							DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							String formatNow = nowDateTime.format(dfm);
							try 
							{
								checkStat = fut.findUse(Integer.parseInt(seatSource.getText()));
								if (checkStat == "0")// »ç¿ëÁßÀÎ ÁÂ¼®ÀÌ ¾Æ´Ï¸é
								{
									// »ç¿ë¹øÈ£ ,Ã¼Å©ÀÎ½Ã°£, ÀüÈ­¹øÈ£, ÀÇÀÚ¹øÈ£
									// TODO Ã¼Å©ÀÎ½Ã°£ ÇöÀç½Ã°£ÀÌ¶û µ¿±âÈ­/ÀüÈ­¹øÈ£ Áßº¹¹æÁö Àû¿ëÇÊ¿ä
									fut.insertUse(formatNow, "010-1234-1234", Integer.parseInt(seatSource.getText()));
									fs.setVisible(false);
									fs.dispose(); // ë²„íŠ¼ ëˆ„ë¥¼ë•Œ ê·¸ ì°½ë§Œ ì¢…ë£Œí•˜ê²Œ í•˜ëŠ” ë©”ì†Œë“œ
									new UserMainUI(null, null, membertel);
								}
								else 
								{
									System.out.println("Already using seat");
								}
							} 
							catch (NumberFormatException e1) 
							{
								e1.printStackTrace();
							} 
							catch (SQLException e1) 
							{
								e1.printStackTrace();
							}
						}
					});
					checkBtn.setSelected(true);
					checkBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
					checkBtn.setBounds(99, 139, 109, 50);
					fs.getContentPane().add(checkBtn);

					// ´Ù½Ã¼±ÅÃ¹öÆ°
					JButton reChoiceBtn = new JButton("´Ù½Ã ¼±ÅÃ");
					reChoiceBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							fs.setVisible(false);
							fs.dispose();
						}
					});
					reChoiceBtn.setSelected(true);
					reChoiceBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
					reChoiceBtn.setBounds(258, 139, 109, 50);
					fs.getContentPane().add(reChoiceBtn);
				}
			});
		}

		// È­Àå½Ç
		JLabel toiletLabel1_1 = new JLabel("<html><body><center>È­<br>Àå<br>½Ç</center></body></html>");
		toiletLabel1_1.setOpaque(true);
		toiletLabel1_1.setHorizontalAlignment(JLabel.CENTER);
		toiletLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel1_1.setBackground(new Color(255, 210, 0));
		toiletLabel1_1.setBounds(0, 60, 72, 160);
		panel1F.add(toiletLabel1_1);

		// ¹®
		JLabel doorLabel1_1 = new JLabel("¹®");
		doorLabel1_1.setOpaque(true);
		doorLabel1_1.setHorizontalAlignment(JLabel.CENTER);
		doorLabel1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel1_1.setBackground(new Color(128, 0, 0));
		doorLabel1_1.setBounds(882, 74, 61, 69);
		panel1F.add(doorLabel1_1);

		// 1Ãþ º®¶óº§ »ý¼º, À§Ä¡ÁöÁ¤
		JLabel[] wall1FLabel = new JLabel[17];

		for (int i = 0; i < wall1FLabel.length; i++) {
			wall1FLabel[i] = new JLabel();
			wall1FLabel[i].setBounds(871, 184, 72, 60);
			wall1FLabel[i].setOpaque(true);
			wall1FLabel[i].setBackground(Color.GRAY);
			panel1F.add(wall1FLabel[i]);
		}

		wall1FLabel[0].setBounds(0, 496, 72, 103);
		wall1FLabel[1].setBounds(26, 539, 72, 60);
		wall1FLabel[2].setBounds(241, 539, 90, 60);
		wall1FLabel[3].setBounds(536, 539, 112, 60);
		wall1FLabel[4].setBounds(787, 539, 156, 60);
		wall1FLabel[5].setBounds(871, 294, 72, 69);
		wall1FLabel[6].setBounds(871, 143, 72, 103);
		wall1FLabel[7].setBounds(0, 209, 72, 60);
		wall1FLabel[8].setBounds(0, 0, 117, 60);
		wall1FLabel[9].setBounds(329, 0, 79, 60);
		wall1FLabel[10].setBounds(126, 241, 21, 122);
		wall1FLabel[11].setBounds(126, 358, 93, 18);
		wall1FLabel[12].setBounds(126, 228, 93, 18);
		wall1FLabel[13].setBounds(648, 241, 21, 122);
		wall1FLabel[14].setBounds(576, 358, 93, 18);
		wall1FLabel[15].setBounds(576, 228, 93, 18);
		wall1FLabel[16].setBounds(765, 0, 50, 60);

		// ¾²·¹±âÅë ÀÌ¹ÌÁö
		JLabel trashcanLabel1_1 = new JLabel(); // È­Àå½Ç¿·
		trashcanLabel1_1.setBounds(70, 53, 57, 54);
		trashcanLabel1_1.setIcon(updatetrashcanIcon);
		panel1F.add(trashcanLabel1_1);

		JLabel trashcanLabel1_2 = new JLabel(); // ¹®¿·
		trashcanLabel1_2.setBounds(814, 0, 57, 54);
		trashcanLabel1_2.setIcon(updatetrashcanIcon);
		panel1F.add(trashcanLabel1_2);

		// Á¤¼ö±â ÀÌ¹ÌÁö
		JLabel waterPFLabel1_1 = new JLabel(); // È­Àå½Ç¿·
		waterPFLabel1_1.setBounds(70, 166, 35, 54);
		waterPFLabel1_1.setIcon(updateWaterPFIcon);
		panel1F.add(waterPFLabel1_1);

		JLabel waterPFLabel1_2 = new JLabel(); // ¹®¿·
		waterPFLabel1_2.setBounds(876, 6, 57, 54);
		waterPFLabel1_2.setIcon(updateWaterPFIcon);
		panel1F.add(waterPFLabel1_2);

		// -------------------------------------------------------------------------------------------------------------
		// 2Ãþ ¹èÄ¡µµ ÆÇ³Ú
		JPanel panel2F = new JPanel();
		panel2F.setBounds(121, 87, 945, 599);
		// panel2F.setBackground(Color.WHITE);
		panel2F.setEnabled(false); // ÆÐ³Î ºñÈ°¼ºÈ­
		panel2F.setVisible(false); // ÆÐ³Î °¨Ãß±â
		panel2F.setLayout(null);
		contentPane.add(panel2F);

		// 2Ãþ ÁÂ¼® ¹öÆ° »ý¼º, À§Ä¡ÁöÁ¤
		String[] seat2Farr = { "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211",
				"212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226",
				"227", "228", "229", "230", "231", "232" };
		JButton[] seat2FBtn = new JButton[33];

		for (int i = 0; i < seat2Farr.length; i++) {
			seat2FBtn[i] = new JButton(seat2Farr[i]);
			seat2FBtn[i].setBounds(871, 184, 72, 60);
			seat2FBtn[i].setFont(new Font("Dialog", Font.BOLD, 16));
			seat2FBtn[i].setBorder(lb);
			seat2FBtn[i].setFocusPainted(false);
			// seat2FBtn[i].setBackground(new Color(0, 128, 255)); //seatAvail¿¡µû¶ó º¯°æ
			try {
				if (findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i])) == 0) {// »ç¿ë°¡´É
					seat2FBtn[i].setBackground(Color.CYAN);
				} else
					try {
						if (findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i])) == 1) {// »ç¿ëÁß
							seat2FBtn[i].setBackground(Color.ORANGE);
						} else if (findSeatTable.seatAvail(Integer.parseInt(seat2Farr[i])) == 2) {// »ç¿ëºÒ°¡
							seat2FBtn[i].setBackground(Color.RED);
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
			panel2F.add(seat2FBtn[i]);
		}

		seat2FBtn[0].setBounds(190, 0, 72, 60); // 200¹ø ÀÇÀÚ
		seat2FBtn[1].setBounds(264, 0, 72, 60);
		seat2FBtn[2].setBounds(338, 0, 72, 60);
		seat2FBtn[3].setBounds(414, 0, 72, 60);
		seat2FBtn[4].setBounds(489, 0, 72, 60);
		seat2FBtn[5].setBounds(563, 0, 72, 60);
		seat2FBtn[6].setBounds(636, 0, 72, 60);
		seat2FBtn[7].setBounds(215, 184, 72, 60);
		seat2FBtn[8].setBounds(310, 184, 72, 60);
		seat2FBtn[9].setBounds(402, 184, 72, 60);
		seat2FBtn[10].setBounds(215, 264, 72, 60);
		seat2FBtn[11].setBounds(310, 264, 72, 60);
		seat2FBtn[12].setBounds(402, 264, 72, 60);
		seat2FBtn[13].setBounds(600, 184, 72, 60);
		seat2FBtn[14].setBounds(690, 184, 72, 60);
		seat2FBtn[15].setBounds(600, 264, 72, 60);
		seat2FBtn[16].setBounds(690, 264, 72, 60);
		seat2FBtn[17].setBounds(0, 294, 72, 60);
		seat2FBtn[18].setBounds(0, 355, 72, 60);
		seat2FBtn[19].setBounds(0, 416, 72, 60);
		seat2FBtn[20].setBounds(0, 478, 72, 60);
		seat2FBtn[21].setBounds(0, 539, 72, 60);
		seat2FBtn[22].setBounds(74, 539, 72, 60);
		seat2FBtn[23].setBounds(258, 539, 72, 60);
		seat2FBtn[24].setBounds(332, 539, 72, 60);
		seat2FBtn[25].setBounds(406, 539, 72, 60);
		seat2FBtn[26].setBounds(583, 539, 72, 60);
		seat2FBtn[27].setBounds(656, 539, 72, 60);
		seat2FBtn[28].setBounds(797, 539, 72, 60);
		seat2FBtn[29].setBounds(871, 539, 72, 60);
		seat2FBtn[30].setBounds(871, 478, 72, 60);
		seat2FBtn[31].setBounds(871, 416, 72, 60);
		seat2FBtn[32].setBounds(871, 184, 72, 60);
		
		for (int i = 0; i < seat1FBtn.length; i++) {
			seat2FBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame fs = new JFrame();
					fs.setTitle("ÀÚ¸® ¼±ÅÃ ¿©ºÎ");
					fs.setVisible(true);
					fs.setIconImage(Toolkit.getDefaultToolkit().getImage(
							"C:\\Users\\dita810\\Desktop\\DÆÀ ÇÁ·ÎÁ§Æ® ÀÚ·á\\FamilyStudycafe\\src\\img\\family.jpg"));
					fs.setFont(new Font("±¼¸²", Font.PLAIN, 12));
					fs.setResizable(false);
					fs.setBounds(370, 289, 465, 260);
					fs.getContentPane().setLayout(null);

					JButton seatSource = (JButton) e.getSource();
					JLabel guideLabel = new JLabel(seatSource.getText() + "¹ø ÀÚ¸®¸¦ ¼±ÅÃ ÇÏ½Ã°Ú½À´Ï±î?");
					guideLabel.setHorizontalAlignment(SwingConstants.CENTER);
					guideLabel.setFont(new Font("ÇÔÃÊ·Ò¹ÙÅÁ", Font.PLAIN, 18));
					guideLabel.setBounds(75, 40, 317, 78);
					fs.getContentPane().add(guideLabel);

					// È®ÀÎ¹öÆ°
					JButton checkBtn = new JButton("È®ÀÎ");
					checkBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String checkStat;
							// Object obj = new Object();
							fs.setVisible(false);
							fs.dispose(); // ¹öÆ° ´©¸¦¶§ ±× Ã¢¸¸ Á¾·áÇÏ°Ô ÇÏ´Â ¸Þ¼Òµå
							new Pay(membertel);

							// use Å×ÀÌºí¿¡¼­ »ç¿ëÁßÀÎÁö °Ë»ç
							FindUseTable fut = new FindUseTable();
							LocalDateTime nowDateTime = LocalDateTime.now();
							DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							String formatNow = nowDateTime.format(dfm);
							try {
								checkStat = fut.findUse(Integer.parseInt(seatSource.getText()));
								if (checkStat == "0")// »ç¿ëÁßÀÎ ÁÂ¼®ÀÌ ¾Æ´Ï¸é
								{
									// »ç¿ë¹øÈ£ ,Ã¼Å©ÀÎ½Ã°£, ÀüÈ­¹øÈ£, ÀÇÀÚ¹øÈ£
									// TODO Ã¼Å©ÀÎ½Ã°£ ÇöÀç½Ã°£ÀÌ¶û µ¿±âÈ­/ÀüÈ­¹øÈ£ Áßº¹¹æÁö Àû¿ëÇÊ¿ä
									fut.insertUse(formatNow, "010-1234-1234", Integer.parseInt(seatSource.getText()));
								} else {
									System.out.println("Already using seat");
								}
							} catch (NumberFormatException e1) {
								e1.printStackTrace();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					});
					checkBtn.setSelected(true);
					checkBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
					checkBtn.setBounds(99, 139, 109, 50);
					fs.getContentPane().add(checkBtn);

					// ´Ù½Ã¼±ÅÃ¹öÆ°
					JButton reChoiceBtn = new JButton("´Ù½Ã ¼±ÅÃ");
					reChoiceBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							fs.setVisible(false);
							fs.dispose();
						}
					});
					reChoiceBtn.setSelected(true);
					reChoiceBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
					reChoiceBtn.setBounds(258, 139, 109, 50);
					fs.getContentPane().add(reChoiceBtn);
				}
			});
		}

		JLabel doorLabel2_1 = new JLabel("¹®");
		doorLabel2_1.setOpaque(true);
		doorLabel2_1.setHorizontalAlignment(JLabel.CENTER);
		doorLabel2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		doorLabel2_1.setBackground(new Color(128, 0, 0));
		doorLabel2_1.setBounds(882, 72, 61, 69);
		panel2F.add(doorLabel2_1);

		// È­Àå½Ç
		JLabel toiletLabel2_1 = new JLabel("<html><body><center>È­<br>Àå<br>½Ç</center></body></html>");
		toiletLabel2_1.setOpaque(true);
		toiletLabel2_1.setHorizontalAlignment(JLabel.CENTER);
		toiletLabel2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		toiletLabel2_1.setBackground(new Color(255, 210, 0));
		toiletLabel2_1.setBounds(0, 60, 72, 180);
		panel2F.add(toiletLabel2_1);

		// ¾²·¹±âÅë ÀÌ¹ÌÁö
		JLabel trashcanLabel2_1 = new JLabel(); // È­Àå½Ç¿·
		trashcanLabel2_1.setBounds(76, 184, 57, 54);
		trashcanLabel2_1.setIcon(updatetrashcanIcon);
		panel2F.add(trashcanLabel2_1);

		JLabel trashcanLabel2_2 = new JLabel(); // ¹®¿·
		trashcanLabel2_2.setBounds(871, 6, 57, 54);
		trashcanLabel2_2.setIcon(updatetrashcanIcon);
		panel2F.add(trashcanLabel2_2);

		// Á¤¼ö±â ÀÌ¹ÌÁö
		JLabel waterPFLabel2_1 = new JLabel(); // È­Àå½Ç¿·
		waterPFLabel2_1.setBounds(152, 0, 35, 70);
		waterPFLabel2_1.setIcon(updateWaterPFIcon);
		panel2F.add(waterPFLabel2_1);

		JLabel waterPFLabel2_2 = new JLabel(); // ¹®¿·
		waterPFLabel2_2.setBounds(839, 6, 35, 54);
		waterPFLabel2_2.setIcon(updateWaterPFIcon);
		panel2F.add(waterPFLabel2_2);

		// 2Ãþ º®¶óº§ »ý¼º, À§Ä¡ÁöÁ¤
		// String[] wall2Farr = {};
		JLabel[] wall2FLabel = new JLabel[13];

		for (int i = 0; i < wall2FLabel.length; i++) {
			wall2FLabel[i] = new JLabel();
			wall2FLabel[i].setBounds(871, 184, 72, 60);
			wall2FLabel[i].setOpaque(true);
			wall2FLabel[i].setBackground(Color.GRAY);
			panel2F.add(wall2FLabel[i]);
		}

		wall2FLabel[0].setBounds(148, 539, 108, 60);
		wall2FLabel[1].setBounds(0, 0, 148, 60);
		wall2FLabel[2].setBounds(0, 241, 122, 54);
		wall2FLabel[3].setBounds(477, 539, 108, 60);
		wall2FLabel[4].setBounds(728, 539, 72, 60);
		wall2FLabel[5].setBounds(871, 241, 72, 176);
		wall2FLabel[6].setBounds(871, 141, 72, 47);
		wall2FLabel[7].setBounds(709, 0, 57, 60);
		wall2FLabel[8].setBounds(215, 241, 259, 23);
		wall2FLabel[9].setBounds(600, 244, 162, 23);
		wall2FLabel[10].setBounds(670, 184, 23, 140);
		wall2FLabel[11].setBounds(380, 184, 23, 140);
		wall2FLabel[12].setBounds(285, 184, 27, 140);

		// ±¸¿ª(1Ãþ) ¼±ÅÃ ¹öÆ°
		JButton firstFloorBtn = new JButton("1Ãþ");
		firstFloorBtn.setBounds(0, 759, 116, 38);
		firstFloorBtn.setBackground(new Color(245, 134, 52));
		firstFloorBtn.setFont(logoutBtnFont);
		firstFloorBtn.setFocusPainted(false);// hide focus rectangle
		firstFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2F.setEnabled(false); // 2Ãþ ¹èÄ¡µµ ºñÈ°¼ºÈ­
				panel2F.setVisible(false); // 2Ãþ ¹èÄ¡µµ °¨Ãß±â
				panel1F.setEnabled(true); // 1Ãþ ¹èÄ¡µµ ºñÈ°¼ºÈ­
				panel1F.setVisible(true); // 1Ãþ ¹èÄ¡µµ °¨Ãß±â
			}
		});
		contentPane.add(firstFloorBtn);

		// ±¸¿ª(2Ãþ) ¼±ÅÃ ¹öÆ°
		JButton secondFloorBtn = new JButton("2Ãþ");
		secondFloorBtn.setBounds(0, 725, 116, 38);
		secondFloorBtn.setBackground(new Color(248, 211, 129));
		secondFloorBtn.setFont(logoutBtnFont);
		secondFloorBtn.setFocusPainted(false);// hide focus rectangle
		secondFloorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1F.setEnabled(false); // 1Ãþ ¹èÄ¡µµ ºñÈ°¼ºÈ­
				panel1F.setVisible(false); // 1Ãþ ¹èÄ¡µµ °¨Ãß±â
				panel2F.setEnabled(true); // 2Ãþ ¹èÄ¡µµ ºñÈ°¼ºÈ­
				panel2F.setVisible(true); // 2Ãþ ¹èÄ¡µµ °¨Ãß±â
			}
		});
		contentPane.add(secondFloorBtn);
		
		//È­¸é »õ·Î°íÄ§ ¹öÆ°
		JButton refreshBtn = new JButton("»õ·Î°íÄ§");
		refreshBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		refreshBtn.setFocusPainted(false);
		refreshBtn.setBackground(Color.WHITE);
		refreshBtn.setBounds(1047, 745, 150, 50);
		refreshBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new SeatSelect(membertel);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(refreshBtn);

		//È­¸é ¾Æ·¡ÂÊ »ö»óº° »óÅÂ ¾È³» ÆÐ³Î, ¶óº§
		
		//ÇÏ´Ã»ö
		JPanel cyanPanel = new JPanel();
		cyanPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cyanPanel.setBackground(Color.CYAN);
		cyanPanel.setBounds(384, 696, 55, 56);
		contentPane.add(cyanPanel);
		//ÁÖÈ²»ö
		JPanel orangePanel = new JPanel();
		orangePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		orangePanel.setBackground(Color.ORANGE);
		orangePanel.setBounds(510, 696, 55, 56);
		contentPane.add(orangePanel);
		//»¡°­»ö
		JPanel redPanel = new JPanel();
		redPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		redPanel.setBackground(Color.RED);
		redPanel.setBounds(636, 696, 55, 56);
		contentPane.add(redPanel);
		//"»ç¿ë°¡´É" ±ÛÀÚ
		JLabel useavailLabel = new JLabel("»ç¿ë°¡´É");
		useavailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		useavailLabel.setBounds(384, 759, 57, 15);
		contentPane.add(useavailLabel);
		//"»ç¿ëÁß" ±ÛÀÚ
		JLabel useAlreadyLabel = new JLabel("»ç¿ëÁß");
		useAlreadyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		useAlreadyLabel.setBounds(510, 759, 57, 15);
		contentPane.add(useAlreadyLabel);
		//"»ç¿ëºÒ°¡" ±ÛÀÚ
		JLabel useDenyLabel = new JLabel("»ç¿ëºÒ°¡");
		useDenyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		useDenyLabel.setBounds(625, 759, 75, 15);
		contentPane.add(useDenyLabel);

		// µÚ·Î°¡±â ¹öÆ°
		JButton btnBack = new JButton();
		btnBack.setBounds(0, 0, 115, 60);
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(
				"C:\\Users\\dita810\\Desktop\\DÆÀ ÇÁ·ÎÁ§Æ® ÀÚ·á\\FamilyStudycafe\\src\\img\\Button_image\\back.jpg"));
		btnBack.setFocusPainted(false);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserLogin(); // È¸¿ø·Î±×ÀÎ È­¸éÀ¸·Î ÀÌµ¿
				dispose();
			}
		});
		// --------------------------------------------------------------------------------------------------
	}
}