import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JList;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		
		JButton Customer_Details = new JButton("");
		Customer_Details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image costumer=new ImageIcon(this.getClass().getResource("/costumer.jpeg")).getImage();	
		Customer_Details.setIcon(new ImageIcon(costumer));
		Customer_Details.setBackground(new Color(192, 192, 192));
		Customer_Details.setBounds(152, 195, 148, 99);
		frame.getContentPane().add(Customer_Details);
		
		JButton Bill = new JButton("");
		Bill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image billpic=new ImageIcon(this.getClass().getResource("/purchase.png")).getImage();
		Bill.setIcon(new ImageIcon(billpic));
		Bill.setBackground(Color.LIGHT_GRAY);
		Bill.setBounds(379, 195, 148, 99);
		frame.getContentPane().add(Bill);
		
		JButton Price = new JButton("");
		Image pricepic=new ImageIcon(this.getClass().getResource("/billing.png")).getImage();
		Price.setIcon(new ImageIcon(pricepic));
		Price.setBackground(Color.LIGHT_GRAY);
		Price.setBounds(606, 195, 148, 99);
		frame.getContentPane().add(Price);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(152, 329, 148, 99);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton Settings = new JButton("");
		Image set=new ImageIcon(this.getClass().getResource("/settings.png")).getImage();
		Settings.setIcon(new ImageIcon(set));
		
		
		Settings.setBackground(Color.LIGHT_GRAY);
		Settings.setBounds(379, 329, 148, 99);
		frame.getContentPane().add(Settings);
		
		JButton Logout = new JButton("");
		Logout.setHorizontalAlignment(SwingConstants.LEFT);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image logPic=new ImageIcon(this.getClass().getResource("/download.jpg")).getImage();
		Logout.setIcon(new ImageIcon(logPic));
		
		
	
		Logout.setBackground(Color.LIGHT_GRAY);
		Logout.setBounds(606, 329, 148, 99);
		frame.getContentPane().add(Logout);
		frame.setBounds(100, 100, 825, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
