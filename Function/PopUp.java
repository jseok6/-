package Function;

import javax.swing.*;

public class PopUp {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        int result = JOptionPane.showConfirmDialog(jFrame, "OO�� �ڸ��� ���� �Ͻðڽ��ϱ�?");

        if (result == 0)
            System.out.println("You pressed Ȯ��");
        else if (result == 1)
        	 System.out.println("You pressed �ڸ� ���� ȭ������");
    }

}
