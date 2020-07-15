import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JList;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Main_page extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page window = new Main_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(Color.BLUE);
		toppanel.setBounds(0, 0, 809, 161);
		frame.getContentPane().add(toppanel);
		toppanel.setLayout(null);
		
		JLabel lblwelcome = new JLabel("Welcome Back");
		lblwelcome.setForeground(Color.WHITE);
		lblwelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblwelcome.setBounds(10, 11, 238, 61);
		toppanel.add(lblwelcome);
		
		JLabel lblUserName = new JLabel("(Username)");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(20, 85, 259, 49);
		toppanel.add(lblUserName);
		
		JButton Customer_Details = new JButton("Customer Details");
		Customer_Details.setBackground(Color.LIGHT_GRAY);
		Customer_Details.setBounds(152, 195, 148, 99);
		frame.getContentPane().add(Customer_Details);
		
		JButton Bill = new JButton("Bill");
		Bill.setBackground(Color.LIGHT_GRAY);
		Bill.setBounds(379, 195, 148, 99);
		frame.getContentPane().add(Bill);
		
		JButton Price = new JButton("Price");
		Price.setBackground(Color.LIGHT_GRAY);
		Price.setBounds(606, 195, 148, 99);
		frame.getContentPane().add(Price);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(152, 329, 148, 99);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Settings");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(379, 329, 148, 99);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton Logout = new JButton("Logout");
		Logout.setBackground(Color.LIGHT_GRAY);
		Logout.setBounds(606, 329, 148, 99);
		frame.getContentPane().add(Logout);
		frame.setBounds(100, 100, 825, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
