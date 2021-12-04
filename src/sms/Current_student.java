package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Current_student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Current_student frame = new Current_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	 * Create the frame.
	 */
	public Current_student() {
		setTitle("Current Student Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 245, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(245, 0, 487, 603);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("Username");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(24, 52, 214, 47);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(24, 120, 395, 47);
		panel_1.add(textField);
		
		Label label_1 = new Label("Password");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(24, 218, 214, 47);
		panel_1.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 288, 395, 47);
		panel_1.add(passwordField);
		
		Button button = new Button("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cmd = e.getActionCommand();

		        if (cmd.equals("Back")) {
		            dispose();

		            new Student_login().setVisible(true);
		        }
			}
		});
		button.setBounds(66, 442, 133, 40);
		panel_1.add(button);
		
		Button button_1 = new Button("View Profile");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please insert the Username");
				}else if(passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please insert the Password");
				}else{
					
					String username=textField.getText();
					String password=passwordField.getText();
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					
					pst=con.prepareStatement("select * from student where username=? and password=?");
					pst.setString(1, username);
					pst.setString(2, password);
					rs=pst.executeQuery();
					
					if(rs.next()) {
						ViewStudent m=new ViewStudent();
						Current_student.this.dispose();
						m.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password Incorrect");
						textField.setText("");
						passwordField.setText("");
						textField.requestFocus();
					}	
										
				}
				
			}
				catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
			}
		});
		button_1.setBounds(251, 442, 139, 40);
		panel_1.add(button_1);
	}

}
