package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSlider;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Admin_login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		setBackground(Color.WHITE);
		setTitle("Admin  Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 280, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setBounds(-248, 0, 538, 463);
		panel.add(lblImage);
		lblImage.setIcon(new ImageIcon(Admin_login.class.getResource("/images/226-2260470_transparent-admin-icon-png-admin-logo-png-png.png")));
		
		JLabel lblAdminlogin = new JLabel("ADMIN LOGIN");
		lblAdminlogin.setForeground(Color.WHITE);
		lblAdminlogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblAdminlogin.setBounds(52, 505, 182, 48);
		panel.add(lblAdminlogin);
		
		Button buttonBack = new Button("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if (cmd.equals("Back")) {
		            dispose();

		            new Main().setVisible(true);
		        }
			}
		});
		buttonBack.setBounds(335, 474, 112, 40);
		contentPane.add(buttonBack);
		
		Label labelUser = new Label("Username");
		labelUser.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelUser.setBounds(335, 63, 214, 47);
		contentPane.add(labelUser);
		
		textUsername = new JTextField();
		textUsername.setBounds(335, 116, 318, 47);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		Label labelPass = new Label("Password");
		labelPass.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelPass.setBounds(335, 213, 214, 47);
		contentPane.add(labelPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(335, 266, 319, 47);
		contentPane.add(passwordField);
		
		Button buttonLogin = new Button("Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textUsername.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "Insert the Username!");
					}else if(passwordField.getText().length()==0) {
						JOptionPane.showMessageDialog(null, "Insert the Password!");
					}else {
						String username=textUsername.getText();
						String password=passwordField.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					pst=con.prepareStatement("select * from admin where username=? and password=?");
					pst.setString(1, username);
					pst.setString(2, password);
					rs=pst.executeQuery();
					
					if(rs.next()) {
						Home m=new Home();
						Admin_login.this.dispose();
						m.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password Blank");
						textUsername.setText("");
						passwordField.setText("");
						textUsername.requestFocus();
					}
					
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
	
			}
		});
		buttonLogin.setBounds(541, 474, 112, 40);
		contentPane.add(buttonLogin);
	}
}
