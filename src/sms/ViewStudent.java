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
import javax.swing.JTextField;

public class ViewStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	private JComboBox comboBox;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
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
	public ViewStudent() {
		setTitle("View Your Marks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 101, 697, 421);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Student ID", "Module 01", "Module 02", "Module 03", "Module 04"
			}
		));
		
		JButton btnNewButton = new JButton("VIEW MARKS OF ALL STUDENTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					
					
							
							stmt=con.prepareStatement("select id,m1,m2,m3,m4 from marks");
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
		btnNewButton.setBounds(479, 33, 230, 32);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				
				if (cmd.equals("Back")) {
					dispose();
					
					new Current_student().setVisible(true);
				
			}
			}
			});
		btnBack.setBounds(518, 535, 191, 38);
		contentPane.add(btnBack);
		
		Label label = new Label("Enter Your ID");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(12, 33, 105, 38);
		contentPane.add(label);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(123, 29, 136, 40);
		contentPane.add(textId);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					int sId=Integer.parseInt(textId.getText());
					stmt=con.prepareStatement("select* from marks where id='"+sId+"'");
					ResultSet re=stmt.executeQuery();

					table.setModel(DbUtils.resultSetToTableModel(re));
					
					
					/*while(rs.next()) {
						
						stmt=con.prepareStatement("select id,name,nic,phone,email from student where course='Networking Engineering'");
						
						if (sId==rs.getInt("id")) {
							textName.setText(rs.getString("name"));
							textNIC.setText(rs.getString("nic"));
							textPhone.setText(rs.getString("phone"));
							textEmail.setText(rs.getString("email"));
							textCourse.setText(rs.getString("course"));
						}
						else if (sId!=rs.getInt("id")){
							//JOptionPane.showMessageDialog(null, "No Student Exist");
							textId.setText("");
							textName.setText("");
							textNIC.setText("");
							textPhone.setText("");
							textEmail.setText("");
							textCourse.setText("");
							//textId.requestFocus();
						}*/
					}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
		
			}
		});
		btnSearch.setBounds(297, 33, 150, 32);
		contentPane.add(btnSearch);
	}
	
	/*public void showRecord() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
			
			if(comboBox.getSelectedItem().equals("All")) {
					
					stmt=con.prepareStatement("select id,name,nic,phone,email from student");
					ResultSet re=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(re));
					
			}		
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
}


