import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Main_page extends JFrame{

	public JFrame frame;
	public static String user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page window = new Main_page(user);
					window.frame.setVisible(true);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_page(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300));
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
		
		JLabel lblUserName = new JLabel(user);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(10, 85, 269, 49);
		toppanel.add(lblUserName);
		
		JButton Customer_Details = new JButton("");
		Customer_Details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				costumerGUI frame1=new costumerGUI();
				
				frame1.frame.setVisible(true);
				frame1.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
				
			}
				catch(Exception o){
					
					System.out.println(o);
				}
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
				try {
					bill obj= new bill();
					obj.frame.setVisible(true);
					obj.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				catch(Exception m)
				{System.out.println(m);}
			}
		});
		Image billpic=new ImageIcon(this.getClass().getResource("/purchase.png")).getImage();
		Bill.setIcon(new ImageIcon(billpic));
		Bill.setBackground(Color.LIGHT_GRAY);
		Bill.setBounds(379, 195, 148, 99);
		frame.getContentPane().add(Bill);
		
		JButton Price = new JButton("");
		Price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					priceGUI obj1=new priceGUI();
					obj1.frame.setVisible(true);
					obj1.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				catch(Exception p)
				{System.out.println(p);}
			}
		});
		Image pricepic=new ImageIcon(this.getClass().getResource("/billing.png")).getImage();
		Price.setIcon(new ImageIcon(pricepic));
		Price.setBackground(Color.LIGHT_GRAY);
		Price.setBounds(606, 195, 148, 99);
		frame.getContentPane().add(Price);
		
		JButton Settings = new JButton("");
		Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Change_pass obj2=new Change_pass();
					obj2.frame.setVisible(true);
					obj2.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				catch(Exception p)
				{System.out.println(p);}
			}
		});
		Image set=new ImageIcon(this.getClass().getResource("/settings.png")).getImage();
		Settings.setIcon(new ImageIcon(set));
		
		
		Settings.setBackground(Color.LIGHT_GRAY);
		Settings.setBounds(241, 329, 148, 99);
		frame.getContentPane().add(Settings);
		
		JButton Logout = new JButton("");
		Logout.setHorizontalAlignment(SwingConstants.LEFT);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fame1 log = new Fame1();
				log.frame.setVisible(true);
				log.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		Image logPic=new ImageIcon(this.getClass().getResource("/download.jpg")).getImage();
		Logout.setIcon(new ImageIcon(logPic));
		
		
	
		Logout.setBackground(Color.LIGHT_GRAY);
		Logout.setBounds(487, 329, 148, 99);
		frame.getContentPane().add(Logout);
		
		JLabel lblNewLabel = new JLabel("Customer Details");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		lblNewLabel.setBounds(162, 305, 148, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Billing");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(429, 300, 98, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price Details");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(642, 300, 98, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		lblNewLabel_3.setBounds(251, 439, 124, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Log Out");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.ITALIC, 14));
		lblNewLabel_4.setBounds(529, 439, 84, 17);
		frame.getContentPane().add(lblNewLabel_4);
		frame.setBounds(100, 100, 825, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
