package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.Checkbox;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextPane;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField text_Username;
	private JTextField text_ID;
	private JTextField text_Course;
	private JTextField text_Bank;
	private JTextField text_Branch;
	private JTextField text_Slipno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	
	public Register() {
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label Title = new Label("Course Registration");
		Title.setAlignment(Label.CENTER);
		Title.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		Title.setBackground(Color.LIGHT_GRAY);
		Title.setBounds(0, 0, 734, 99);
		contentPane.add(Title);
		
		JLabel lbl_Username = new JLabel("Username : ");
		lbl_Username.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lbl_Username.setBounds(44, 145, 104, 21);
		contentPane.add(lbl_Username);
		
		JLabel lbl_ID = new JLabel("ID no. :");
		lbl_ID.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lbl_ID.setBounds(44, 208, 160, 21);
		contentPane.add(lbl_ID);
		
		JLabel lbl_Course = new JLabel("Course name :");
		lbl_Course.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lbl_Course.setBounds(44, 271, 134, 21);
		contentPane.add(lbl_Course);
		
		JLabel lbl_Bank = new JLabel("Bank name :");
		lbl_Bank.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lbl_Bank.setBounds(44, 334, 134, 21);
		contentPane.add(lbl_Bank);
		
		JLabel lbl_Branch = new JLabel("Branch name :");
		lbl_Branch.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lbl_Branch.setBounds(44, 397, 114, 20);
		contentPane.add(lbl_Branch);
		
		JLabel lbl_Slipno = new JLabel("Slip no. :");
		lbl_Slipno.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lbl_Slipno.setBounds(44, 459, 114, 21);
		contentPane.add(lbl_Slipno);
		
		
		text_Username = new JTextField();
		text_Username.setBounds(72, 177, 232, 20);
		contentPane.add(text_Username);
		text_Username.setColumns(10);
		
		text_ID = new JTextField();
		text_ID.setBounds(72, 240, 232, 20);
		contentPane.add(text_ID);
		text_ID.setColumns(10);
		
		text_Course = new JTextField();
		text_Course.setBounds(72, 303, 232, 20);
		contentPane.add(text_Course);
		text_Course.setColumns(10);
		
		text_Bank = new JTextField();
		text_Bank.setBounds(72, 366, 232, 20);
		contentPane.add(text_Bank);
		text_Bank.setColumns(10);
		
		text_Branch = new JTextField();
		text_Branch.setBounds(72, 428, 232, 20);
		contentPane.add(text_Branch);
		text_Branch.setColumns(10);
		
		text_Slipno = new JTextField();
		text_Slipno.setBounds(72, 491, 232, 21);
		contentPane.add(text_Slipno);
		text_Slipno.setColumns(10);
		
		
		JButton btn_Cancel = new JButton("Back");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

		        if (cmd.equals("Back")) {
		            dispose();

		            new Student_login().setVisible(true);
		        }
			}
		});
		btn_Cancel.setBounds(228, 552, 89, 23);
		contentPane.add(btn_Cancel);
		
		JButton btn_Ok = new JButton("Ok");
		btn_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sms", "root", "");
					
					String sql ="insert into register values (?, ?, ?, ?, ?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, text_Username.getText());
					pstmt.setString(2, text_ID.getText());
					pstmt.setString(3, text_Course.getText());
					pstmt.setString(4, text_Bank.getText());
					pstmt.setString(5, text_Branch.getText());
					pstmt.setString(6, text_Slipno.getText());
					
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Click next button to upload Bank slip");
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		btn_Ok.setBounds(480, 552, 89, 23);
		contentPane.add(btn_Ok);
		
		JButton btn_Reset = new JButton("Reset");
		btn_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Username.setText("");
				text_ID.setText("");
				text_Course.setText("");
				text_Bank.setText("");
				text_Branch.setText("");
			}
		});
		btn_Reset.setBounds(365, 552, 89, 23);
		contentPane.add(btn_Reset);
		
		JButton btn_Next = new JButton("Next");
		btn_Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inputText = text_ID.getText();
				Bank_slip slip = new Bank_slip();
				slip.textID.setText(inputText);
				slip.setVisible(true);
				dispose();
			}
			
		});
		btn_Next.setBounds(601, 552, 89, 23);
		contentPane.add(btn_Next);
		
		JLabel lbl_image = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/images/register.jfif")) .getImage();
		lbl_image.setIcon(new ImageIcon(img));
		lbl_image.setBounds(393, 129, 297, 170);
		contentPane.add(lbl_image);
		
		JTextPane txtpnPaymentDetails = new JTextPane();
		txtpnPaymentDetails.setBackground(new Color(153, 204, 102));
		txtpnPaymentDetails.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		txtpnPaymentDetails.setText("\r\n   Payment Details :-\r\n\r\n          Networking\t       -  25000/=\r\n          CCNA\t\t       -  30000/=\r\n          Cyber Security\t       -  25000/=\r\n          Info. Sys. Engineering  -  45000/=");
		txtpnPaymentDetails.setBounds(418, 362, 246, 160);
		contentPane.add(txtpnPaymentDetails);
		
		
		
	

	}
}
