package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class New_student extends JFrame {

	private JPanel contentPane;
	private JPasswordField Cpassword;
	private JPasswordField password;
	private JTextField textName;
	private JTextField textNIC;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_student frame = new New_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;

	/**
	 * Create the frame.
	 */
	public New_student() {
		setTitle("New Student Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 732, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label = new Label("Dear Student, Complete below fields for the Registration..");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		label.setBounds(10, 0, 603, 63);
		panel.add(label);
		
		Label label_1 = new Label("Name");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(20, 69, 214, 41);
		panel.add(label_1);
		
		Label label_2 = new Label("NIC");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_2.setBounds(20, 119, 214, 41);
		panel.add(label_2);
		
		Label label_3 = new Label("Phone");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_3.setBounds(20, 173, 199, 40);
		panel.add(label_3);
		
		Label label_4 = new Label("E-Mail");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_4.setBounds(20, 226, 199, 40);
		panel.add(label_4);
		
		Label label_5 = new Label("Username");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_5.setBounds(20, 279, 199, 40);
		panel.add(label_5);
		
		Label label_6 = new Label("Password");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_6.setBounds(20, 332, 199, 40);
		panel.add(label_6);
		
		Label label_7 = new Label("Confirm Password");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_7.setBounds(20, 385, 199, 41);
		panel.add(label_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Networking Engineering", "Software Engineering ", "Cyber Security ", "Info. Sys. Engineering "}));
		comboBox.setBounds(246, 438, 268, 43);
		panel.add(comboBox);
		
		Button buttonBack = new Button("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cmd = e.getActionCommand();

		        if (cmd.equals("Back")) {
		            dispose();

		            new Student_login().setVisible(true);
		        }
			}
		});
		buttonBack.setBounds(69, 534, 133, 40);
		panel.add(buttonBack);
		
		Button button_1 = new Button("Register");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textName.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Name Please");
				}else if(textNIC.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the NIC Please");
				}else if(textPhone.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Phone Please");
				}else if(textEmail.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Email Please");
				}else if(textUsername.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Username Please");
				}else if(password.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Enter the Password Please");
				}else if(Cpassword.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Confirm the Password Please");
				}else if(password.getText().equals(Cpassword.getText())==false) {
					JOptionPane.showMessageDialog(null, "Password not matched!");
				}else {
					try {
						String name=textName.getText();
						String nic=textNIC.getText();
						String phone=textPhone.getText();
						String email=textEmail.getText();
						String username=textUsername.getText();
						String confirmpass=Cpassword.getText();
						String course=comboBox.getSelectedItem().toString();
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
						pst=con.prepareStatement("insert into student(name,nic,phone,email,username,password,course)values(?,?,?,?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, nic);
						pst.setString(3, phone);
						pst.setString(4, email);
						pst.setString(5, username);
						pst.setString(6, confirmpass);
						pst.setString(7, course);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Registration Successful! Make your payment Please..");
						textName.setText("");
						textNIC.setText("");
						textPhone.setText("");
						textEmail.setText("");
						textUsername.setText("");
						password.setText("");
						Cpassword.setText("");
						comboBox.setSelectedIndex(-1);
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
		button_1.setBounds(551, 534, 133, 40);
		panel.add(button_1);
		
		Cpassword = new JPasswordField();
		Cpassword.setBounds(246, 385, 438, 40);
		panel.add(Cpassword);
		
		password = new JPasswordField();
		password.setBounds(246, 332, 438, 40);
		panel.add(password);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(245, 67, 438, 40);
		panel.add(textName);
		
		textNIC = new JTextField();
		textNIC.setColumns(10);
		textNIC.setBounds(246, 120, 438, 40);
		panel.add(textNIC);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(246, 173, 438, 40);
		panel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(246, 226, 437, 40);
		panel.add(textEmail);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(246, 279, 438, 40);
		panel.add(textUsername);
		
		Label label_8 = new Label("Course");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_8.setBounds(23, 441, 186, 40);
		panel.add(label_8);
		
		
	}
}
