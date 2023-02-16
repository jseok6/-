package ��ɱ���;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameInFrame extends JFrame {

	JDesktopPane xDesktop; // JDesktopPane�� �����Ѵ�.
	ToolListener xToolListener = new ToolListener();

	public FrameInFrame(String title) {
		super(title);

		/* �������� ������ ���α׷��� �����Ű���� �����Ѵ�. */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* ���� �г��� BorderLayot���� ���Ѵ�. */
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		/* ���ٸ� ����� */
		JPanel tool_bar = new JPanel(new BorderLayout());
		JPanel tool_pnl = new JPanel(new GridLayout(1, 0));
		JButton btn;
		btn = new JButton("Maximize");
		btn.addActionListener(xToolListener); // �׼� �̺�Ʈ..
		tool_pnl.add(btn);
		btn = new JButton("Minimize");
		btn.addActionListener(xToolListener);
		tool_pnl.add(btn);
		btn = new JButton("Iconify");
		btn.addActionListener(xToolListener);
		tool_pnl.add(btn);
		btn = new JButton("Close");
		btn.addActionListener(xToolListener);
		tool_pnl.add(btn);
		tool_bar.add(tool_pnl, BorderLayout.WEST);
		cp.add(tool_bar, BorderLayout.NORTH);

		/* ����ũž �г��� �����. */
		xDesktop = new JDesktopPane();
		cp.add(xDesktop, BorderLayout.CENTER);

		/* �⺻ ������ ���� �������� �����. */
		JInternalFrame fr = new JInternalFrame("Internal Frame 1");
		fr.getContentPane().add(new JLabel(new ImageIcon("/root/Download/ICON/jeehaa1004_10.gif")),
				BorderLayout.CENTER);
		fr.setBounds(20, 20, 200, 100);
		fr.setVisible(true);
		xDesktop.add(fr);

		/* ��� �ɼ��� �����ִ� ���� �������� �����. */
		fr = new JInternalFrame("Internal Frame 2", true, true, true, true);
		fr.getContentPane().add(new JLabel(new ImageIcon("/root/Download/ICON/jeehaa1004_6.gif")), BorderLayout.CENTER);
		fr.setBounds(100, 100, 200, 100);
		fr.setVisible(true);
		xDesktop.add(fr);
	}

	class ToolListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			String cmd = ev.getActionCommand();
			JInternalFrame fr = xDesktop.getSelectedFrame(); // ���õ� �������� �����´�.

			/* ��ư�� ���� �ִ�ȭ, �ּ�ȭ, �ݱ� ���� �۾��� �Ѵ�. */

			try {
				if (cmd.equals("Maximize")) {
					fr.setMaximum(true); // �ִ�ȭ ����
				} else if (cmd.equals("Minimize")) {
					fr.setMaximum(false); // �ִ�ȭ ���
				} else if (cmd.equals("Iconify")) {
					fr.setIcon(true); // ������������ ������ȭ ����
				} else if (cmd.equals("Close")) {
					fr.setClosed(true); // ���������� �ݱ�
				}
			} catch (Exception e) {
			}

		}

	}

	public static void main(String args[]) {

		/* �������� �����. */
		FrameInFrame mf = new FrameInFrame("JInternalFrame ����");
		mf.setSize(400, 300);
		mf.setVisible(true);
	}
}