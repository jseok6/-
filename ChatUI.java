package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatUI extends JFrame
implements ActionListener{
	
	private JPanel panel1;
	private JPanel bottomPanel;
	private JTextField textField;
	private JTextArea textArea;
	private JList<String> userList;
	private JButton sendButton;
	private JButton exitButton;
	
	
	public ChatUI() {
		 // setting
        setTitle("ChatUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		// panel
        JPanel panel1 = new JPanel();
        Chat(panel1);
		
		
		//initGUI
//		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		
	}
	
	public void Chat(JPanel panel)
	{
        textField = new JTextField(30);
        textArea = new JTextArea(10, 30);
        userList = new JList<String>(new String[]{"유저1", "유저2", "유저3"});
        JScrollPane scrollPane = new JScrollPane(textArea);
        JScrollPane userListScrollPane = new JScrollPane(userList);
        
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(700, 50));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(textField, BorderLayout.CENTER);
        sendButton = new JButton("전송");
        sendButton.setBackground(new Color(204,204,204));
        exitButton=new JButton("나가기");
        bottomPanel.add(sendButton, BorderLayout.EAST);
        
        userListScrollPane.setPreferredSize(new Dimension(100, 500));
        userListScrollPane.setMaximumSize(new Dimension(150, Integer.MAX_VALUE));
        sendButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(userListScrollPane, BorderLayout.EAST);
        
       
        pack();
        setVisible(true);
        
        sendButton.addActionListener(this);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = textField.getText();
        if (message.trim().length() > 0) {
            textArea.append("나: " + message + "\n");
            textField.setText("");
        }
	}
	
	public static void main(String[] args) {
		
		new ChatUI();
	}

}
