package Function;

import javax.swing.*;

public class PopUp {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        int result = JOptionPane.showConfirmDialog(jFrame, "OO번 자리를 선택 하시겠습니까?");

        if (result == 0)
            System.out.println("You pressed 확인");
        else if (result == 1)
        	 System.out.println("You pressed 자리 선택 화면으로");
    }

}
