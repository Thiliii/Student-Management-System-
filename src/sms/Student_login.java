package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_login frame = new Student_login();
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
	public Student_login() {
		setTitle("Student Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 252, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentLogin = new JLabel("STUDENT LOGIN");
		lblStudentLogin.setForeground(Color.WHITE);
		lblStudentLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 28));
		lblStudentLogin.setBounds(22, 492, 206, 48);
		panel.add(lblStudentLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Student_login.class.getResource("/images/istockphoto-1174311642-612x612.jpg")));
		lblNewLabel.setBounds(-179, 0, 459, 479);
		panel.add(lblNewLabel);
		
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(252, 0, 480, 603);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
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
		buttonBack.setBounds(167, 490, 133, 40);
		panel_1.add(buttonBack);
		
		Button button = new Button("Current Student");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Current_student m=new Current_student();
				Student_login.this.dispose();
				m.setVisible(true);
			}
		});
		button.setBackground(Color.CYAN);
		button.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		button.setBounds(96, 200, 274, 73);
		panel_1.add(button);
		
		Button button_1 = new Button("New Student");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				New_student m=new New_student();
				Student_login.this.dispose();
				m.setVisible(true);
			}
		});
		button_1.setBackground(Color.CYAN);
		button_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		button_1.setBounds(96, 79, 274, 73);
		panel_1.add(button_1);
		
		Button button_2 = new Button("Course Registration");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register m=new Register();
				Student_login.this.dispose();
				m.setVisible(true);
			}
		});
		button_2.setBackground(Color.CYAN);
		button_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		button_2.setBounds(96, 329, 274, 73);
		panel_1.add(button_2);
	}
}
