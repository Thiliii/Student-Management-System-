package sms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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

public class Mark extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textM1;
	private JTextField textM2;
	private JTextField textM3;
	private JTextField textM4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mark frame = new Mark();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	/**
	 * Create the frame.
	 */
	public Mark() {
		setTitle("Add Student Marks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 0, 736, 613);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				if (textId.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert the ID number Of the student");
				}else if(textM1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 01");
				}else if(textM2.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 02");
				}else if(textM3.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 03");
				}else if(textM4.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 04");
					
				}else{
					
					try {
						
						String id=textId.getText();
						String m1=textM1.getText();
						String m2=textM2.getText();
						String m3=textM3.getText();
						String m4=textM4.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
						pat=con.prepareStatement("insert into marks(id,m1,m2,m3,m4)values(?,?,?,?,?)");
						pat.setString(1, id);
						pat.setString(2, m1);
						pat.setString(3, m2);
						pat.setString(4, m3);
						pat.setString(5, m4);
						pat.executeUpdate();
						JOptionPane.showMessageDialog(null, "Marks added");
						textId.setText("");
						textM1.setText("");
						textM2.setText("");
						textM3.setText("");
						textM4.setText("");
						textId.requestFocus();
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
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(531, 455, 154, 48);
		panel.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			 {
				
				
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				
				if (cmd.equals("BACK")) {
					dispose();
					
					new Home().setVisible(true);
				}
			    
                
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBack.setBackground(Color.CYAN);
		btnBack.setBounds(257, 529, 141, 48);
		panel.add(btnBack);
		
		Label label = new Label("Student ID");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(262, 33, 107, 31);
		panel.add(label);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(375, 25, 141, 40);
		panel.add(textId);
		
		Label label_1 = new Label("Module 01");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(262, 147, 154, 41);
		panel.add(label_1);
		
		Label label_2 = new Label("Module 02");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_2.setBounds(262, 214, 154, 41);
		panel.add(label_2);
		
		textM1 = new JTextField();
		textM1.setColumns(10);
		textM1.setBounds(458, 148, 208, 40);
		panel.add(textM1);
		
		textM2 = new JTextField();
		textM2.setColumns(10);
		textM2.setBounds(458, 214, 208, 40);
		panel.add(textM2);
		
		Label label_3 = new Label("Module 03");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_3.setBounds(262, 293, 154, 41);
		panel.add(label_3);
		
		Label label_4 = new Label("Module 04");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_4.setBounds(262, 372, 154, 41);
		panel.add(label_4);
		
		textM3 = new JTextField();
		textM3.setColumns(10);
		textM3.setBounds(458, 293, 208, 40);
		panel.add(textM3);
		
		textM4 = new JTextField();
		textM4.setColumns(10);
		textM4.setBounds(458, 372, 208, 40);
		panel.add(textM4);
		
		Label label_5 = new Label("Enter the Marks of the Student..");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Dialog", Font.ITALIC, 16));
		label_5.setBounds(262, 86, 323, 41);
		panel.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 175, 600);
		panel.add(panel_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textId.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert the ID number Of the student");
				}else if(textM1.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 01");
				}else if(textM2.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 02");
				}else if(textM3.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 03");
				}else if(textM4.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Insert Marks of Module 04");

					
				}else{
					
					try {
						
						String id=textId.getText();
						String m1=textM1.getText();
						String m2=textM2.getText();
						String m3=textM3.getText();
						String m4=textM4.getText();
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
						int sId=Integer.parseInt(textId.getText());
						pat=con.prepareStatement("update marks set id=?,m1=?,m2=?,m3=?,m4=? where id='"+sId+"'");
						
						pat.setString(1, id);
						pat.setString(2, m1);
						pat.setString(3, m2);
						pat.setString(4, m3);
						pat.setString(5, m4);
						
						pat.executeUpdate();
						JOptionPane.showMessageDialog(null, "Marks Updated");
						textId.setText("");
						textM1.setText("");
						textM2.setText("");
						textM3.setText("");
						textM4.setText("");
						
						textId.requestFocus();
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
		btnUpdate.setBounds(192, 455, 141, 48);
		panel.add(btnUpdate);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					pat=con.prepareStatement("select* from marks");
					int sId=Integer.parseInt(textId.getText());
					
					rs=pat.executeQuery();
					
					while(rs.next()) {
						
						if (sId==rs.getInt("id")) {
							textM1.setText(rs.getString("m1"));
							textM2.setText(rs.getString("m2"));
							textM3.setText(rs.getString("m3"));
							textM4.setText(rs.getString("m4"));
							
						}
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
		btnSearch.setBounds(544, 25, 141, 48);
		panel.add(btnSearch);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
					int sId=Integer.parseInt(textId.getText());
					pat=con.prepareStatement("delete from marks where id='"+sId+"'");
					
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Marks Deleted");
					textId.setText("");
					textM1.setText("");
					textM4.setText("");
					textM3.setText("");
					textM2.setText("");
					textId.requestFocus();
					
				
				}catch(Exception e3) {
					System.out.println(e3);
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBackground(Color.CYAN);
		btnDelete.setBounds(345, 455, 154, 48);
		panel.add(btnDelete);
		
		JButton button = new JButton("RESET");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textId.setText("");
				textM1.setText("");
				textM4.setText("");
				textM3.setText("");
				textM2.setText("");
				textId.requestFocus();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button.setBackground(Color.CYAN);
		button.setBounds(441, 529, 141, 48);
		panel.add(button);
	}
}
