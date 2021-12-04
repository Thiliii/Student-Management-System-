package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 255, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon(Admin_login.class.getResource("/images/600-06899815en_Masterfile.jpg")));
		lblImage.setBounds(0, -14, 255, 480);
		panel.add(lblImage);
		
		Label label = new Label("Student");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		label.setBounds(21, 472, 156, 28);
		panel.add(label);
		
		Label label_1 = new Label("Management");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		label_1.setBounds(21, 506, 177, 33);
		panel.add(label_1);
		
		Label label_2 = new Label("System");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		label_2.setBounds(21, 545, 177, 33);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(255, 0, 477, 603);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Button buttonStudent = new Button("Student Login");
		buttonStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_login m=new Student_login();
				Main.this.dispose();
				m.setVisible(true);
			}
		});
		buttonStudent.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		buttonStudent.setBounds(101, 189, 227, 58);
		panel_1.add(buttonStudent);
		
		Button buttonAdmin = new Button("Admin Login");
		buttonAdmin.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		buttonAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Admin_login m=new Admin_login();
				Main.this.dispose();
				m.setVisible(true);
				
			}
		});
		buttonAdmin.setBounds(101, 303, 227, 58);
		panel_1.add(buttonAdmin);
	}
}
