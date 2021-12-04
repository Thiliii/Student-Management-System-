package sms;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 726, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/shutterstock_529502872.jpg")));
		lblNewLabel.setBounds(42, 13, 684, 248);
		panel.add(lblNewLabel);
		
		Button button = new Button("CREATE NEW ADMIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				newAdmin m=new newAdmin();
				Home.this.dispose();
				m.setVisible(true);
			}
		});
		button.setBackground(new Color(0, 153, 153));
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		button.setBounds(40, 317, 222, 64);
		contentPane.add(button);
		
		Button Students = new Button("STUDENT DETAILS");
		Students.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student m = new Student();
				Home.this.dispose();
				m.setVisible(true);
				
			}
		});
		Students.setForeground(new Color(0, 0, 0));
		Students.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		Students.setBackground(new Color(0, 153, 153));
		Students.setBounds(459, 317, 222, 64);
		contentPane.add(Students);
		
		Button back = new Button("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               String cmd = e.getActionCommand();
				
				if (cmd.equals("BACK")) {
					dispose();
					
					new Admin_login().setVisible(true);
				}
				
			}
		});
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		back.setBackground(Color.LIGHT_GRAY);
		back.setBounds(292, 521, 145, 53);
		contentPane.add(back);
		
		Button Students_1 = new Button("VIEW PAYMENTS");
		Students_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPayment m=new ViewPayment();
				Home.this.dispose();
				m.setVisible(true);
				
			}
		});
		
		Students_1.setForeground(Color.BLACK);
		Students_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		Students_1.setBackground(new Color(0, 153, 153));
		Students_1.setBounds(111, 410, 222, 64);
		contentPane.add(Students_1);
		
		Button button_1 = new Button("MARKS");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mark m = new Mark();
				Home.this.dispose();
				m.setVisible(true);
				
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		button_1.setBackground(new Color(0, 153, 153));
		button_1.setBounds(404, 410, 222, 64);
		contentPane.add(button_1);
	}
}
