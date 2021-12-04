package sms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textNIC;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textCourse;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	/**
	 * Create the frame.
	 */
	public Student() {
		setTitle("Student Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 731, 608);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText("");
				textName.setText("");
				textNIC.setText("");
				textPhone.setText("");
				textEmail.setText("");
				textCourse.setText("");
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(395, 542, 144, 31);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					int sId=Integer.parseInt(textId.getText());
					stmt=con.prepareStatement("delete from student where id='"+sId+"'");
					
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student Deleted");
					textId.setText("");
					textName.setText("");
					textNIC.setText("");
					textPhone.setText("");
					textEmail.setText("");
					textCourse.setText("");
					textId.requestFocus();
					
				
				}catch(Exception e3) {
					System.out.println(e3);
				}
				
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(57, 542, 125, 31);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Name Please");
				}else if(textNIC.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the NIC Please");
				}else if(textPhone.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Phone Please");
				}else if(textEmail.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Email Please");
				}else if(textCourse.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "Enter the Course Please");
				}else {
					try {
						String id=textId.getText();
						String name=textName.getText();
						String nic=textNIC.getText();
						String phone=textPhone.getText();
						String email=textEmail.getText();
						String password=textEmail.getText();
						String cpassword=textEmail.getText();
						String course=textEmail.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
						int sId=Integer.parseInt(textId.getText());
						stmt=con.prepareStatement("update student set id=?,name=?,nic=?,phone=?,email=?,username=?,password=?,course=? where id='"+sId+"'");
						
											
						stmt.setString(1, id);
						stmt.setString(2, name);
						stmt.setString(3, nic);
						stmt.setString(4, phone);
						stmt.setString(5, email);
						stmt.setString(6, password);
						stmt.setString(7, cpassword);
						stmt.setString(8, course);
						
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student Updated");
						textId.setText("");
						textName.setText("");
						textNIC.setText("");
						textPhone.setText("");
						textEmail.setText("");
						textCourse.setText("");
						
						textName.requestFocus();
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setBounds(224, 542, 125, 31);
		panel.add(btnUpdate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				
				if (cmd.equals("BACK")) {
					dispose();
					
					new Home().setVisible(true);
				}
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(566, 542, 133, 31);
		panel.add(btnBack);
		
		JButton btnViewStudents = new JButton("VIEW ALL STUDENTS");
		btnViewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllStudents m=new ViewAllStudents();
				Student.this.dispose();
				m.setVisible(true);
			}
		});
		btnViewStudents.setForeground(Color.BLACK);
		btnViewStudents.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnViewStudents.setBackground(Color.LIGHT_GRAY);
		btnViewStudents.setBounds(395, 465, 304, 31);
		panel.add(btnViewStudents);
		
		Label label = new Label("ID");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(10, 37, 214, 41);
		panel.add(label);
		
		Label label_1 = new Label("Name");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(10, 93, 214, 41);
		panel.add(label_1);
		
		Label label_2 = new Label("NIC");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_2.setBounds(10, 147, 214, 41);
		panel.add(label_2);
		
		Label label_3 = new Label("Phone");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_3.setBounds(10, 206, 199, 40);
		panel.add(label_3);
		
		Label label_4 = new Label("E-Mail");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_4.setBounds(10, 265, 199, 40);
		panel.add(label_4);
		
		Label label_5 = new Label("Course");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_5.setBounds(10, 325, 186, 40);
		panel.add(label_5);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(244, 93, 455, 40);
		panel.add(textName);
		
		textNIC = new JTextField();
		textNIC.setColumns(10);
		textNIC.setBounds(244, 147, 455, 40);
		panel.add(textNIC);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(244, 206, 455, 40);
		panel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(244, 265, 455, 40);
		panel.add(textEmail);
		
		textCourse = new JTextField();
		textCourse.setColumns(10);
		textCourse.setBounds(244, 325, 455, 40);
		panel.add(textCourse);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(244, 37, 208, 40);
		panel.add(textId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					stmt=con.prepareStatement("select* from student");
					int sId=Integer.parseInt(textId.getText());
					
					rs=stmt.executeQuery();
					
					while(rs.next()) {
						
						if (sId==rs.getInt("id")) {
							textName.setText(rs.getString("name"));
							textNIC.setText(rs.getString("nic"));
							textPhone.setText(rs.getString("phone"));
							textEmail.setText(rs.getString("email"));
							textCourse.setText(rs.getString("course"));
						}/*
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
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSearch.setBackground(Color.CYAN);
		btnSearch.setBounds(483, 37, 216, 41);
		panel.add(btnSearch);
	}
}
