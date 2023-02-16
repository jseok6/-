package ��ɱ���;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

// ����
// ���� â���� ���̾�α׿� �����͸� �����ϰ�
// ���̾�α�â���� ����â���� �ٽ� �����͸� �����ϴ� ����

// �¼��� ������ ���̾�α� ��ü�� �Ѱ��ֱ� ���� Ŭ����
class SeatInfoDTO {
    // �¼���ȣ
    private Integer seatId;

    public SeatInfoDTO(Integer seatId) {
        this.seatId = seatId;
    }

    // getter
    public Integer getSeatId() {
        return seatId;
    }

    // seatId�� ������ ���� ���⶧���� setter�� ������ ����

}

// ����â�� �¼� ��ư�� Ŀ�����ϱ� ���� JButton ��ӹ޾Ƽ� ���
class SeatButton extends JButton {

    // �¼���ȣ
    private Integer seatId;

    public SeatButton(Integer x, Integer y, Integer width, Integer height, Integer seatId, MyApp app) {
        // JButton�� �����ڸ� ȣ��
        super(seatId + "�� �¼�");
        super.setBounds(x, y, width, height);
        super.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // ���̾�α� â�� ����
                MyDialog dialog = new MyDialog("�¼� ����", true, new SeatInfoDTO(seatId), app);
                dialog.setVisible(true);
            }
        });

        this.seatId = seatId;
    }

    // getter
    public Integer getSeatId() {
        return seatId;
    }

    // seatId�� ������ ���� ���⶧���� setter�� ������ ����

}

// ���̾�α� â�� Ŀ�����ϱ� ���� JDialog ��ӹ޾Ƽ� ���
class MyDialog extends JDialog {

    // JDialog�� �ʼ� ������ �޾ƿ��� ���ÿ� SeatInfo�� ���� �޾ƿ�
    public MyDialog(String title, boolean modal, SeatInfoDTO seatInfo, MyApp app) {
        // JDialog�� �����ڸ� ȣ��
        super(app.getFrame(), title, modal);

        // JDialog�� �⺻ ����

        // ������ư�� ������ ������ ���
        // this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // â�� ������ ����â�� �󺧿� ǥ�õ� �¼���ȣ�� ����
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                // ���̾�α�â�� ���� �� ����â�� �󺧿� ǥ�õ� �¼���ȣ�� ����
                app.getLabel().setText("�¼��� �������� �ʾҽ��ϴ�.");
                MyDialog.this.dispose();

            }
        });
        this.setBounds(100, 100, 300, 200);
        this.setLocationRelativeTo(app.getFrame());
        this.setResizable(false);

        // �����ӿ� �г� �߰�
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setContentPane(panel);

        // �гο� �� �߰�
        // SeatInfo�� ������ �޾ƿͼ� �󺧿� ǥ��
        JLabel label = new JLabel(seatInfo.getSeatId() + "�� �¼� �Դϴ�.");
        label.setBounds(0, 0, 100, 30);
        panel.add(label);

        // �гο� ��ư �߰�
        // �¼� ���� ��ư
        JButton button = new JButton("����");
        button.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // ��ư�� ������ ����â�� �󺧿� �¼���ȣ�� ǥ��
                app.getLabel().setText(seatInfo.getSeatId() + "�� �¼��� �����ϼ̽��ϴ�.");
                MyDialog.this.dispose();
            }
        });
        button.setBounds(10, 50, 100, 30);
        panel.add(button);
    }
}

class MyApp {

    // ���� â ������
    // ���� â�� �����͸� ���̾�α׿� this�� �����ϱ� ���� ���
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    public MyApp() {

        // ����â
        frame = new JFrame("Parent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        // �����ӿ� �г� �߰�
        panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel, "Center");

        // �гο� �� �߰�
        label = new JLabel("�¼��� �������� �ʾҽ��ϴ�.");
        label.setBounds(0, 0, 200, 30);
        panel.add(label);

        // �гο� �¼� ��ư �߰�
        // this �ڱ��ڽ��� �����Ͽ� frame label ���� ��밡���ϰ� ��
        SeatButton seatButton1 = new SeatButton(0, 50, 100, 30, 1, this);
        SeatButton seatButton2 = new SeatButton(0, 100, 100, 30, 2, this);
        panel.add(seatButton1);
        panel.add(seatButton2);

    }

    // getter
    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabel() {
        return label;
    }

    // �ڽ��� �θ� ��ü ��ü�� ������ ���� �����Ƿ� setter�� ������ ����
    // label.setText("�¼��� �������� �ʾҽ��ϴ�."); �̷������δ� ���氡��

}

// ���� Ŭ����
public class Dtest {

    public static void main(String[] args) throws Exception {
        // ���� �����Ѵ�
        new MyApp();
    }
}