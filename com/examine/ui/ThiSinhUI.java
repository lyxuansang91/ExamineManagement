package com.examine.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.examine.data.ThiSinh;
import com.examine.entity.KhoiEntity;
import com.examine.entity.PhongThiEntity;
import com.examine.entity.SoBaoDanhEntity;
import com.examine.entity.ThiSinhEntity;
import com.examine.entity.TruongEntity;
import com.mongodb.BasicDBObject;

import javax.swing.ListSelectionModel;

public class ThiSinhUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm;
	private int curPos = 0;
	private int NoExistsRecord = 0;
	private JLabel lblPos;
	private JButton btnFirst;
	private JButton btnLast; 
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnThoat;
	private JButton btnDelete;
	
	private ArrayList<ThiSinh> arrThiSinh = new ArrayList<ThiSinh>();
	private JButton btnExportToExcel;
	private JButton btnImport;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThiSinhUI frame = new ThiSinhUI();
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
	public ThiSinhUI() {
		setTitle("Thi Sinh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				curPos = 0;
				table.setRowSelectionInterval(curPos, curPos);
			}
		});
		btnFirst.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/skip_backward.png"));
		toolBar.add(btnFirst);
		toolBar.add(new JToolBar.Separator());
		
		btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(curPos > 0)
					curPos--;
				table.setRowSelectionInterval(curPos, curPos);
			}
		});
		
		
		btnPrev.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/arrow_left.png"));
		toolBar.add(btnPrev);
		toolBar.add(new JToolBar.Separator());
		
		lblPos = new JLabel("1/9");
		toolBar.add(lblPos);
		toolBar.add(new JToolBar.Separator());
		
		btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(curPos < arrThiSinh.size() - 1)
					curPos++;
				table.setRowSelectionInterval(curPos, curPos);
			}
		});
		
		btnNext.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/arrow_right.png"));
		toolBar.add(btnNext);
		toolBar.add(new JToolBar.Separator());
		
		btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curPos= dtm.getRowCount() - 1;
				table.setRowSelectionInterval(curPos, curPos);
			}
		});
		btnLast.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/skip_forward.png"));
		toolBar.add(btnLast);
		toolBar.add(new JToolBar.Separator());
		
		btnAdd = new JButton("Add new");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] row = {"", "", "", "", "", "", "", "", "", ""};
				dtm.addRow(row);
			}
		});
		btnAdd.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/plus_button.png"));
		toolBar.add(btnAdd);
		toolBar.add(new JToolBar.Separator());
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnSave.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/document_save.png"));
		toolBar.add(btnSave);
		toolBar.add(new JToolBar.Separator());
		
		btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/button_cancel.png"));
		toolBar.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int curRow = table.getSelectedRow();
				String id = dtm.getValueAt(curRow, 0).toString();
				if(id.trim().equals("")) {
					dtm.removeRow(curRow);
					JOptionPane.showMessageDialog(null, "Delete Completed");
				} else {
					String sobaodanh = dtm.getValueAt(curRow, 6).toString();
					ThiSinh.deleteRecord(sobaodanh);
					dtm.removeRow(curRow);
				}
				
			}
		});
		toolBar.add(new JToolBar.Separator());
		
		btnThoat = new JButton("Quit");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setIcon(new ImageIcon("/home/sang/workspace/ExamineManagement/images/gnome_logout.png"));
		toolBar.add(btnThoat);
		toolBar.add(new JToolBar.Separator());
		
		btnExportToExcel = new JButton("Export");
		toolBar.add(btnExportToExcel);
		
		btnImport = new JButton("import");
		toolBar.add(btnImport);
		
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.SOUTH);
		//scrollPane.setColumnHeaderView(table);
		
		//System.out.println(1);,
		arrThiSinh =ThiSinh.getAllRows(); 
		Object[] title = {"Họ đệm", "Tên", "Quê quán", "Khối", "Ngày sinh", "Phòng", "Số báo danh", "Mã Trường", "Tên Trường", "Khu vực ưu tiên"};
		dtm = new DefaultTableModel(title, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				
				return super.isCellEditable(row, column);
			}
		};
		table.setModel(dtm);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				curPos = table.getSelectedRow();
				lblPos.setText((curPos + 1) + "/" + dtm.getRowCount());
				table.setRowSelectionInterval(curPos, curPos);
			}
		});
		FillData(arrThiSinh);
	}
	
	
	/*update data */
	
	private void update(){
		int row = dtm.getRowCount();
		for(int i = 0; i < row; i++) {
			ThiSinh newElement = new ThiSinh();
			//BasicDBObject curObj = (BasicDBObject)cursor.next();
			String hodem = dtm.getValueAt(i, 0).toString();
			String ten =  dtm.getValueAt(i, 1).toString();
			
			String quequan = dtm.getValueAt(i, 2).toString(); 
			String khoi = dtm.getValueAt(i, 3).toString();
			String ngaysinh = dtm.getValueAt(i, 4).toString();
			String phong = dtm.getValueAt(i, 5).toString();
			String sobaodanh = dtm.getValueAt(i, 6).toString();
			String matruong = dtm.getValueAt(i, 7).toString();
			String tentruong = dtm.getValueAt(i, 8).toString();
			String khuvucuutien = dtm.getValueAt(i, 9).toString();
			
			Date NgaySinh = new Date(ngaysinh);
			newElement.setThisinh(new ThiSinhEntity(hodem, ten,NgaySinh, quequan, khuvucuutien));
			newElement.setSobaodanh(new SoBaoDanhEntity(sobaodanh));
			newElement.setTruong(new TruongEntity(matruong, tentruong));
			newElement.setKhoi(new KhoiEntity(khoi));
			newElement.setPhong(new PhongThiEntity(phong));
			
			
			
			
			//System.out.println(truong.getString("TenTruong"));
			
		}
	}
	
	/*Fill Data into jTable */

	private void FillData(ArrayList<ThiSinh> arr) {
		// TODO Auto-generated method stub
		try {
			for(ThiSinh ts : arr) {
				String[] row = {ts.getThisinh().getHoDem(), ts.getThisinh().getTen(), ts.getThisinh().getQueQuan(), ts.getKhoi().getMaKhoi(), ts.getThisinh().getNgaySinh().toString(), ts.getPhong().getTenPhong(), ts.getSobaodanh().getSoBaoDanh(), ts.getTruong().getMaTruong(), ts.getTruong().getTenTruong(), ts.getThisinh().getKhuVucUuTien()};
				dtm.addRow(row);
			}
			NoExistsRecord = arr.size();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/* ActionLisnter implementation */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
