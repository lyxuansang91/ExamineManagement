package com.examine.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;

import com.examine.data.MongoDBConnection;
import com.examine.data.PhongThi;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.util.Vector;

public class PhongThiUI {

	private JFrame frmTmKimPhng;
	private JTextField txtMaPT;
	private JTextField txtTenPT;
	private JTable tblPhongThi;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhongThiUI window = new PhongThiUI();
					window.frmTmKimPhng.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PhongThiUI() {
		initialize();
		initializeDataTable();
	}
	
	private void addDataToTable(DBCursor cursor){
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String>rowTitle = new Vector<String>();
		rowTitle.add("MaPhong");
		rowTitle.add("TenPhong");
		data.add(rowTitle);
		while(cursor.hasNext()) {
			Vector<String> row = new Vector<String>();
			BasicDBObject currObj = (BasicDBObject)cursor.next();
			row.add(currObj.getString("MaPhong"));
			row.add(currObj.getString("TenPhong"));
			data.add(row);
		}
		Vector<String> title = new Vector<String>();
		title.add("MaPhong");
		title.add("TenPhong");
		tblPhongThi.setModel(new DefaultTableModel(data, title));
	}
	
	private void initializeDataTable(){
		DBCursor cursor = PhongThi.displayAllPhongThi();
		addDataToTable(cursor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTmKimPhng = new JFrame();
		frmTmKimPhng.getContentPane().setBackground(SystemColor.activeCaption);
		frmTmKimPhng.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmTmKimPhng.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frmTmKimPhng.setTitle("T\u00ECm Ki\u1EBFm Ph\u00F2ng Thi");
		frmTmKimPhng.setBounds(100, 100, 628, 383);
		frmTmKimPhng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTmKimPhng.getContentPane().setLayout(null);
		
		JLabel lblNhpMPt = new JLabel("Nh\u1EADp m\u00E3 PT");
		lblNhpMPt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpMPt.setBounds(130, 30, 112, 14);
		frmTmKimPhng.getContentPane().add(lblNhpMPt);
		
		JLabel lblTenPhongThi = new JLabel("Nh\u1EADp T\u00EAn PT");
		lblTenPhongThi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenPhongThi.setBounds(130, 56, 112, 14);
		frmTmKimPhng.getContentPane().add(lblTenPhongThi);
		
		txtMaPT = new JTextField();
		txtMaPT.setBounds(288, 28, 210, 20);
		frmTmKimPhng.getContentPane().add(txtMaPT);
		txtMaPT.setColumns(10);
		
		txtTenPT = new JTextField();
		txtTenPT.setBounds(288, 54, 210, 20);
		frmTmKimPhng.getContentPane().add(txtTenPT);
		txtTenPT.setColumns(10);
		
		JButton btnSearch = new JButton("T\u00ECm Ki\u1EBFm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//MongoDBConnection mongoConnection = new MongoDBConnection("userdb", "user", 27017, "localhost");
				String maPT=txtMaPT.getText();
				String tenPT=txtTenPT.getText();
				//String mongodb="db.Phong_ThiSinh.find( { $or : [ {MaPhong:+maPT} , {TenPhong:+tenPT} ] } )";
				DBCursor cursor = PhongThi.displayPhongThi(maPT, tenPT);
				addDataToTable(cursor);
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//btnSearch.setIcon(new ImageIcon(PhongThiUI.class.getResource("/icon/Find.gif")));
		btnSearch.setBounds(130, 104, 120, 32);
		frmTmKimPhng.getContentPane().add(btnSearch);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//btnThoat.setIcon(new ImageIcon(PhongThiUI.class.getResource("/icon/Exit.gif")));
		btnThoat.setBounds(388, 104, 110, 32);
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmTmKimPhng.dispose();
			}
		});
		frmTmKimPhng.getContentPane().add(btnThoat);
		
		tblPhongThi = new JTable();
		tblPhongThi.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "Số Báo Danh", "Họ Đêm", "Tên", "Ngày Sinh", "Hộ Khẩu"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblPhongThi.setBounds(70, 173, 478, 110);
		frmTmKimPhng.getContentPane().add(tblPhongThi);
		
	}
}