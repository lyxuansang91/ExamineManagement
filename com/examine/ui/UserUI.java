package com.examine.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.examine.data.MongoDBConnection;
import com.examine.data.User;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class UserUI {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI window = new UserUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setBounds(61, 50, 84, 42);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(60, 105, 70, 25);
		frame.getContentPane().add(lblPassword);
	
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(65, 176, 117, 25);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				User objUser = new User(txtUser.getText(), txtPassword.getText());
				if(objUser.isValidUser()) {
					JOptionPane.showMessageDialog(null, "login Successful");
				} else {
					JOptionPane.showMessageDialog(null, "login failed!");
				}
			}
		});
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(272, 176, 117, 25);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
		txtUser = new JTextField();
		txtUser.setBounds(272, 62, 114, 19);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(272, 108, 117, 19);
		frame.getContentPane().add(txtPassword);
	}
	
	
}
