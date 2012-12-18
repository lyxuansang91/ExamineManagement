package com.examine.ui;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

import com.examine.data.MongoDBConnection;
import com.examine.data.PhongThi;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.awt.dnd.Autoscroll;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Statement;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class PhongThiUI implements ActionListener{

	private JFrame frmTmKimPhng;
	private JTextField txtMaPT;
	private JTextField txtTenPT;
	private JTable tblPhongThi;
	private DefaultTableModel dtm; 
	private int curPos = 0;
	private JLabel statusBar;
	private int NoExistRecord;
	private ArrayList<PhongThi> lst = new ArrayList<PhongThi>();
	

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
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while(cursor.hasNext()) {
			Vector<Object> row = new Vector<Object>();
			final BasicDBObject currObj = (BasicDBObject)cursor.next();
			row.add(currObj.getString("MaPhong"));
			row.add(currObj.getString("TenPhong"));
			data.add(row);
		}
		Vector<String> title = new Vector<String>();
		title.add("Mã phòng");
		title.add("Tên phòng");
		DefaultTableModel dm = new DefaultTableModel(data, title);
		
		tblPhongThi.setModel(dm);
		//tblPhongThi.getColumn("XemThem").setCellRenderer(new ButtonRenderer());
	//	ButtonEditor btnEdit = new ButtonEditor(new JCheckBox(), "123");
	//	tblPhongThi.getColumn("XemThem").setCellEditor(btnEdit);
	}
		
	private void initializeDataTable(){
		//final DBCursor cursor = PhongThi.displayAllPhongThi();
		lst = PhongThi.getallRows();
		Object[] title = {"Mã phòng", "Tên phòng"};
		dtm = new DefaultTableModel(title, 0) {
			public boolean isCellEditable(int row, int column){
				if(column == 0 && (row >= 0 && row < lst.size()))
					return false;
				return true;
			}
		};
		tblPhongThi.setModel(dtm);
		tblPhongThi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				curPos = tblPhongThi.getSelectedRow();
				statusBar.setText((curPos+ 1) + "/" + dtm.getRowCount());
			}
		});
		//addDataToTable(cursor);
		FillData(lst);
		
	}
	
	private void FillData(ArrayList<PhongThi> lst) {
		try {
			for(PhongThi lh: lst){
				String[] row = {lh.getMaPhong(), lh.getTenPhong()};
				dtm.addRow(row);
			}
			NoExistRecord = lst.size();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTmKimPhng = new JFrame();
		frmTmKimPhng.setResizable(false);
		frmTmKimPhng.getContentPane().setBackground(SystemColor.activeCaption);
		frmTmKimPhng.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmTmKimPhng.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frmTmKimPhng.setTitle("T\u00ECm Ki\u1EBFm Ph\u00F2ng Thi");
		frmTmKimPhng.setBounds(100, 100, 634, 517);
		frmTmKimPhng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTmKimPhng.getContentPane().setLayout(null);
		
		
		
		JLabel lblNhpMPt = new JLabel("Nh\u1EADp m\u00E3 PT");
		lblNhpMPt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhpMPt.setBounds(130, 138, 112, 14);
		frmTmKimPhng.getContentPane().add(lblNhpMPt);
		
		JLabel lblTenPhongThi = new JLabel("Nh\u1EADp T\u00EAn PT");
		lblTenPhongThi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenPhongThi.setBounds(130, 170, 112, 14);
		frmTmKimPhng.getContentPane().add(lblTenPhongThi);
		
		txtMaPT = new JTextField();
		txtMaPT.setBounds(288, 136, 210, 20);
		frmTmKimPhng.getContentPane().add(txtMaPT);
		txtMaPT.setColumns(10);
		
		txtTenPT = new JTextField();
		txtTenPT.setBounds(288, 168, 210, 20);
		frmTmKimPhng.getContentPane().add(txtTenPT);
		txtTenPT.setColumns(10);
		
		JButton btnSearch = new JButton("T\u00ECm Ki\u1EBFm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//MongoDBConnection mongoConnection = new MongoDBConnection("userdb", "user", 27017, "localhost");
				String maPT=txtMaPT.getText();
				String tenPT=txtTenPT.getText();
				//String mongodb="db.Phong_ThiSinh.find( { $or : [ {MaPhong:+maPT} , {TenPhong:+tenPT} ] } )";
				DBCursor cursor = null;
				if(maPT.equals("") && tenPT.equals("")){
					cursor = PhongThi.displayAllPhongThi();
				} else
					cursor = PhongThi.displayPhongThi(maPT, tenPT);
				addDataToTable(cursor);
			}
		});
		
		
		
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		//btnSearch.setIcon(new ImageIcon(PhongThiUI.class.getResource("/icon/Find.gif")));
		btnSearch.setBounds(262, 212, 120, 32);
		frmTmKimPhng.getContentPane().add(btnSearch);
		
		tblPhongThi = new JTable();
		tblPhongThi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPhongThi.setFillsViewportHeight(true);
		tblPhongThi.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(tblPhongThi);
		scrollPane.setBounds(9, 291, 608, 214);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		frmTmKimPhng.getContentPane().add(scrollPane);
		//scrollPane.setColumnHeaderView(tblPhongThi);

		
		
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
		
		JToolBar toolbar = new JToolBar();
		toolbar.setBounds(0, 0, 632, 80);
		frmTmKimPhng.getContentPane().add(toolbar);
		
		JButton btnFirst = new JButton("");
		btnFirst.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/skip_backward.png"));
		toolbar.add(btnFirst);
		btnFirst.setActionCommand("First");
		
		toolbar.add(new JToolBar.Separator());
		
		JButton btnPrev = new JButton("");
		btnPrev.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/arrow_left.png"));
		toolbar.add(btnPrev);
		btnPrev.setActionCommand("Prev");
		btnPrev.addActionListener(this);
		toolbar.add(new JToolBar.Separator());
		
		statusBar = new JLabel("ABC");
		toolbar.add(statusBar);
		toolbar.add(new JToolBar.Separator());
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/arrow_right.png"));
		btnNext.setActionCommand("Next");
		btnNext.addActionListener(this);
		toolbar.add(btnNext);
		toolbar.add(new JToolBar.Separator());
		
		JButton btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/skip_forward.png"));
		toolbar.add(btnLast);
		btnLast.setActionCommand("Last");
		btnLast.addActionListener(this);
		toolbar.add(new JToolBar.Separator());
		
		JButton btnAdd = new JButton("Add New");
		btnAdd.setActionCommand("Add");
		btnAdd.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/plus_button.png"));
		toolbar.add(btnAdd);
		btnAdd.addActionListener(this);
		toolbar.add(new JToolBar.Separator());
		
		JButton btnSave = new JButton("Save");
		btnSave.setActionCommand("Save");
		btnSave.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/document_save.png"));
		toolbar.add(btnSave);
		btnSave.addActionListener(this);
		toolbar.add(new JToolBar.Separator());
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setActionCommand("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/button_cancel.png"));
		toolbar.add(btnDelete);
		toolbar.add(new JToolBar.Separator());
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/gnome_logout.png"));
		toolbar.add(btnThoat);
		toolbar.add(new JToolBar.Separator());
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmTmKimPhng.dispose();
			}
		});
	}
	
	private void update(){
		int rows = dtm.getRowCount();
		for(int i = 0; i < rows; i++) {
			String maphong = dtm.getValueAt(i, 0).toString();
			String tenphong = dtm.getValueAt(i, 1).toString();
			PhongThi newPT = new PhongThi(maphong, tenphong);
			if(i < NoExistRecord) {
				PhongThi pt = PhongThi.getRowById(maphong);
				PhongThi.updateRow(newPT);
			} else {
				
				if(maphong.trim().equals(""))continue;
				//System.out.println(maphong.trim());
				
				//System.out.println(1);
				PhongThi.addNew(newPT);
				}
			}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String actCommand = arg0.getActionCommand();
		
		if(actCommand.equals("Add")) {
			String[] row = {"", ""};
			dtm.addRow(row);
		} else if(actCommand.equals("Delete")) {
			try {
				//System.out.println("1");
				int selRow = tblPhongThi.getSelectedRow();
				String id = dtm.getValueAt(selRow, 0).toString();
				if(id.trim().equals("")){
					dtm.removeRow(selRow);
					JOptionPane.showMessageDialog(frmTmKimPhng, "delete row completed!");
				} else {
					int rs = JOptionPane.showConfirmDialog(frmTmKimPhng, "Do you want to delete?", "Delete Confirm?", JOptionPane.YES_NO_OPTION);
					if (rs == JOptionPane.YES_OPTION) {
						PhongThi.deleteRowByID(id);
						dtm.removeRow(selRow);
						JOptionPane.showMessageDialog(frmTmKimPhng, "delete row completed!");
					} else {
						JOptionPane.showMessageDialog(frmTmKimPhng, "delete row failed!");
					}

			}	
						
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if(actCommand.equals("Save")) {
			try {
				update();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			xulydichuyen(arg0);
		}
	}

	private void xulydichuyen(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String actCommand = arg0.getActionCommand();
		if(actCommand.equals("First")){
			curPos = 0;
			tblPhongThi.setRowSelectionInterval(curPos, curPos);
			return;
		}
		if(actCommand.equals("Last")) {
			curPos = dtm.getRowCount() - 1;
			tblPhongThi.setRowSelectionInterval(curPos, curPos);
			return;
		}
		if(actCommand.equals("Next")) {
			if(curPos < dtm.getRowCount() - 1)
				curPos++;
			tblPhongThi.setRowSelectionInterval(curPos, curPos);
			return;
		} 
			if(curPos > 0) curPos--;
			tblPhongThi.setRowSelectionInterval(curPos, curPos);
	}
}
