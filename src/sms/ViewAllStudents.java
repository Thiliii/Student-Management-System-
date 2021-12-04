package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.conf.DatabaseUrlContainer;
import com.mysql.cj.xdevapi.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ViewAllStudents extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStudents frame = new ViewAllStudents();
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
	public ViewAllStudents() {
		setTitle("View Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Label label = new Label("View Students of");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		label.setBounds(12, 10, 174, 32);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 101, 697, 421);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Name", "NIC", "Phone", "E-mail", "Course"
			}
		));
		
		JButton btnNewButton = new JButton("ALL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					
					
							
							stmt=con.prepareStatement("select id,name,nic,phone,email from student");
							ResultSet re=stmt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(re));
							
							
					} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(12, 56, 128, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNetworkEng = new JButton("Network Eng.");
		btnNetworkEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					
					
							

					stmt=con.prepareStatement("select id,name,nic,phone,email from student where course='Network Engineering'");
					ResultSet re=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(re));
							
							
					} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnNetworkEng.setToolTipText("");
		btnNetworkEng.setBounds(152, 56, 128, 32);
		contentPane.add(btnNetworkEng);
		
		JButton btnSoftwareEng = new JButton("Software Eng.");
		btnSoftwareEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					
					stmt=con.prepareStatement("select id,name,nic,phone,email from student where course='Software Engineering'");
					ResultSet re=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(re));
							
							
					} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnSoftwareEng.setToolTipText("");
		btnSoftwareEng.setBounds(293, 55, 128, 32);
		contentPane.add(btnSoftwareEng);
		
		JButton btnCyberSecurity = new JButton("Cyber Security");
		btnCyberSecurity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					

					stmt=con.prepareStatement("select id,name,nic,phone,email from student where course='Cyber Security'");
					ResultSet re=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(re));
							
					} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnCyberSecurity.setToolTipText("");
		btnCyberSecurity.setBounds(437, 55, 128, 32);
		contentPane.add(btnCyberSecurity);
		
		JButton btnInfoSysEng = new JButton("Info. Sys. Eng.");
		btnInfoSysEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					

					stmt=con.prepareStatement("select id,name,nic,phone,email from student where course='Info. Sys. Engineering'");
					ResultSet re=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(re));
							
					} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnInfoSysEng.setToolTipText("");
		btnInfoSysEng.setBounds(577, 55, 128, 32);
		contentPane.add(btnInfoSysEng);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				
				if (cmd.equals("Back")) {
					dispose();
					
					new Student().setVisible(true);
				
			}
			}
			});
		btnBack.setBounds(518, 535, 191, 38);
		contentPane.add(btnBack);
	}
	
	
		
}


