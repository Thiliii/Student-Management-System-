package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class newAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JPasswordField CpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newAdmin frame = new newAdmin();
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
	Connection con;
	PreparedStatement pat;
	public newAdmin() {
		setTitle("New Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button buttonAdd =  new Button("Add");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textUsername.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert the Username!");
				}else if(passwordField.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert the Password!");
				}else if(CpasswordField.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Confirm the Password!");
				}else if(passwordField.getText().equals(CpasswordField.getText())==false) {
					JOptionPane.showMessageDialog(null,"Password Missmatches!");	
				}else{
					try {
						
						String username=textUsername.getText();
						String confirmpass=CpasswordField.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
						pat=con.prepareStatement("insert into admin(username,password)values(?,?)");
						pat.setString(1, username);
						pat.setString(2, confirmpass);
						pat.executeUpdate();
						JOptionPane.showMessageDialog(null, "Admin created");
						textUsername.setText("");
						passwordField.setText("");
						CpasswordField.setText("");
						textUsername.requestFocus();
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
		buttonAdd.setBounds(565, 511, 121, 40);
		contentPane.add(buttonAdd);
		
		Button buttonBack = new Button("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	                String cmd = e.getActionCommand();
					if (cmd.equals("Back")) {
						dispose();
						
					new Home().setVisible(true);
			}
			}
		});
		buttonBack.setBounds(349, 511, 112, 40);
		contentPane.add(buttonBack);
		
		Label labelUsername = new Label("Username");
		labelUsername.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelUsername.setBounds(247, 51, 214, 47);
		contentPane.add(labelUsername);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(251, 104, 318, 47);
		contentPane.add(textUsername);
		
		Label labelPassword = new Label("Password");
		labelPassword.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelPassword.setBounds(251, 178, 214, 47);
		contentPane.add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 231, 319, 47);
		contentPane.add(passwordField);
		
		CpasswordField = new JPasswordField();
		CpasswordField.setBounds(250, 366, 319, 47);
		contentPane.add(CpasswordField);
		
		Label labelCPassword = new Label("Confirm Password");
		labelCPassword.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelCPassword.setBounds(247, 313, 214, 47);
		contentPane.add(labelCPassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 214, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Admin");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblNewLabel.setBounds(29, 422, 144, 117);
		panel.add(lblNewLabel);
	}

}
