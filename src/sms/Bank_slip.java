package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Button;

public class Bank_slip extends JFrame{

	private JPanel contentPane;
	public JTextField text_Path;
	JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank_slip frame = new Bank_slip();
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
	ResultSet rs;
	
	public Bank_slip() {
		setTitle("Upload Bank Slip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label Title_1 = new Label("Upload Bank slip");
		Title_1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		Title_1.setBackground(Color.LIGHT_GRAY);
		Title_1.setAlignment(Label.CENTER);
		Title_1.setBounds(0, 0, 734, 116);
		contentPane.add(Title_1);
		
		JLabel lblID = new JLabel("ID No. :");
		lblID.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		lblID.setBounds(35, 137, 75, 23);
		contentPane.add(lblID);
		
		textID = new JTextField();
		textID.setBounds(120, 140, 229, 23);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lbl_Image = new JLabel("");
		lbl_Image.setLabelFor(lbl_Image);
		lbl_Image.setBackground(Color.WHITE);
		lbl_Image.setBounds(90, 205, 501, 203);
		contentPane.add(lbl_Image);
		
		text_Path = new JTextField();
		text_Path.setBackground(SystemColor.controlHighlight);
		text_Path.setBounds(120, 447, 443, 32);
		contentPane.add(text_Path);
		text_Path.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("You can search your Bank slip if you upload it already, and delete the uloaded slip and upload a new one....");
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 12));
		lblNewLabel.setBounds(33, 171, 640, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblImgPath = new JLabel("Image Path :");
		lblImgPath.setBounds(90, 430, 95, 14);
		contentPane.add(lblImgPath);
		
		JButton btn_Ok = new JButton("Ok");
		btn_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sms", "root", "");
					
					String sql ="insert into BankSlip values (?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, textID.getText());
					pstmt.setString(2, text_Path.getText());
					
					
					pstmt.executeUpdate();
					dispose();
					
					JOptionPane.showMessageDialog(null, " Your registration is successfully completed and \n we will give you a conformation after verification");
				
					String cmd = e.getActionCommand();

			        if (cmd.equals("Ok")) {
			            dispose();

			            new Student_login().setVisible(true);
			        }
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btn_Ok.setBounds(584, 566, 89, 23);
		contentPane.add(btn_Ok);
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Cancel.setBounds(474, 566, 89, 23);
		contentPane.add(btn_Cancel);
		
		Button btn_Slip = new Button("Upload Bank Slip");
		btn_Slip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				text_Path.setText(filename);
				Image getAbsolutePath = null;
				ImageIcon icon = new ImageIcon(filename);
				Image Image = icon.getImage().getScaledInstance(lbl_Image.getWidth(), lbl_Image.getHeight(), java.awt.Image.SCALE_SMOOTH);
				lbl_Image.setIcon(icon);
			
			}
		});
		btn_Slip.setFont(new Font("Microsoft JhengHei", Font.BOLD | Font.ITALIC, 18));
		btn_Slip.setBackground(new Color(154, 205, 50));
		btn_Slip.setBounds(238, 485, 211, 32);
		contentPane.add(btn_Slip);
		
		JButton btn_Search = new JButton("Search");
		btn_Search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sms", "root", "");
					int SID = Integer.parseInt(textID.getText());
					PreparedStatement pstmt = conn.prepareStatement("select* from bankslip where ID ="+SID);
					
					rs = pstmt.executeQuery();
						
						if( rs.next() && SID == rs.getInt("ID")) {
							text_Path.setText(rs.getString("Slip"));
							JOptionPane.showMessageDialog(null, "Bank Slip is uploaded....");
						}else {
							JOptionPane.showMessageDialog(null, "Bank Slip is not uploaded....");
						}
						
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
			}
		});
		btn_Search.setBounds(372, 134, 117, 34);
		contentPane.add(btn_Search);
		
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sms", "root", "");
					int SID = Integer.parseInt(textID.getText());
					PreparedStatement pstmt = conn.prepareStatement("delete from bankslip where ID ="+SID);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Bank Slip Deleted...");
					
					text_Path.setText("");

					
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
			}
		});
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Delete.setBounds(523, 133, 126, 35);
		contentPane.add(btn_Delete);
		
		
		JButton btn_Back = new JButton("Back");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Register().setVisible(true);
			}
		});
		btn_Back.setBounds(360, 566, 89, 23);
		contentPane.add(btn_Back);
		
		
				
	}
}
