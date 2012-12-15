package com.examine.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import org.bson.BSONObject;

import com.examine.data.MongoDBConnection;
import com.examine.data.User;

public class UserDisplayUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTable tblUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDisplayUI frame = new UserDisplayUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserDisplayUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(247, 49, 114, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(65, 51, 100, 15);
		contentPane.add(lblUsername);
		
		tblUser = new JTable();
		tblUser.setModel(new DefaultTableModel(
			new Object[][] {
					{"User", "Password"}
			},
			new String[] {"user", "password"}
		));
		tblUser.setBounds(86, 180, 285, 48);
		contentPane.add(tblUser);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(txtUsername.getText().equals("")){
					//System.out.println("1");
					displayAllUser();
				}
				else {
					displayUser(txtUsername.getText());
				}
			}
		});
		btnDisplay.setBounds(244, 90, 117, 25);
		contentPane.add(btnDisplay);
	}
	
	private void displayUser(String userName){		
		DBCursor cursor = User.displayUser(userName);
		addDataToTable(cursor);
	}
	
	private void addDataToTable(DBCursor cursor){
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> rowTitle = new Vector<String>();
		rowTitle.add("User");
		rowTitle.add("Password");
		data.add(rowTitle);
		while(cursor.hasNext()){
			Vector<String> row = new Vector<String>();
			BasicDBObject currentObj = (BasicDBObject) cursor.next();
			row.add(currentObj.getString("user"));
			row.add(currentObj.getString("password"));
			data.add(row);
		}
		Vector<String> title = new Vector<String>();
		title.add("user");
		title.add("password");
		DefaultTableModel tableModel = new DefaultTableModel(data, title);
		tblUser.setModel(tableModel);
		
	}
	
	private void displayAllUser(){
		DBCursor cursor = User.displayAllUser();
		//addDataToTable(cursor);
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> rowTitle = new Vector<String>();
		rowTitle.add("User");
		rowTitle.add("Password");
		data.add(rowTitle);
		while(cursor.hasNext()){
			Vector<String> row = new Vector<String>();
			BasicDBObject currentObj = (BasicDBObject) cursor.next();
			row.add(currentObj.getString("user"));
			row.add(currentObj.getString("password"));
			data.add(row);
		}
		Vector<String> title = new Vector<String>();
		title.add("user");
		title.add("password");
		DefaultTableModel tableModel = new DefaultTableModel(data, title);
		tblUser.setModel(tableModel);
	}
}
