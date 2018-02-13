package MatrixCipher;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	
	private JButton encryptButton, decryptButton, clearButton;
	public static JTextArea textField, result;
	
	public GUI(){
		createView();
		
		setTitle("Encryptor v1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 300));
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void createView(){
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		textField = new JTextArea();
		JScrollPane scrollField = new JScrollPane (textField);
		scrollField.setPreferredSize(new Dimension(375, 100));
		panel.add(scrollField);
		//Border border = BorderFactory.createLineBorder(Color.GRAY);
		//textField.setBorder(border);
		textField.setLineWrap(true);
	    Box box = Box.createVerticalBox(); 
	    panel.add(box);
		encryptButton = new JButton("Encrypt");
		encryptButton.putClientProperty("mode", 1);
		encryptButton.addActionListener(
			new EncryptCommand()
		);
		box.add(encryptButton);
		box.add(Box.createVerticalStrut(10));
		decryptButton = new JButton("Decrypt");
		decryptButton.putClientProperty("mode", -1);
		decryptButton.addActionListener(
				new EncryptCommand()
			);
		box.add(decryptButton);
		result = new JTextArea();
		result.setEditable(false);
		result.setLineWrap(true);
		JScrollPane scrollArea = new JScrollPane(result);
		scrollArea.setPreferredSize(new Dimension(450, 120));
		scrollArea.setBorder(null);
		panel.add(scrollArea);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					GUI.setResult("");
				}
			});
		panel.add(clearButton);
	}
	
	public static String getTextField(){
		return textField.getText();
	}
	
	public static void setResult(String output){
		result.setText(output);
	}
	
}


class EncryptCommand implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton)arg0.getSource();
		String message = GUI.getTextField();
		int[][] encryptedMatrix = new int[0][0];
		MatrixCipher.setMessageLength(message.length());
		if (MatrixCipher.getMessageLength()%3 !=0){
			MatrixCipher.setMessageLength(MatrixCipher.getMessageLength() + (3 - MatrixCipher.getMessageLength()%3));
		}
		message = message.toUpperCase();
		int[][] matrixNumbers = MatrixCipher.stringToNumberMatrix(message);
		if((int)source.getClientProperty("mode") == 1){
			encryptedMatrix = MatrixCipher.matrixEncrypt(matrixNumbers);
		}
		else if((int)source.getClientProperty("mode")==-1){
			encryptedMatrix = MatrixCipher.matrixDecrypt(matrixNumbers);
		}
		String newMessage = MatrixCipher.numberMatrixToString(encryptedMatrix);
		GUI.setResult(newMessage);
	}
	
}
