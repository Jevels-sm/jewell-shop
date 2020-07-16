import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fame1 {

	private JFrame frame;
	private JTextField textUserName;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fame1 window = new Fame1();
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
	Connection connection=null;
	public Fame1() {
		initialize();
		connection=mysql.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 660, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane Image_login = new JLayeredPane();
		Image_login.setBounds(0, 27, 294, 243);
		frame.getContentPane().add(Image_login);
		
		JLayeredPane login_panel = new JLayeredPane();
		login_panel.setBounds(314, 108, 302, 162);
		frame.getContentPane().add(login_panel);
		
		textUserName = new JTextField();
		textUserName.setBounds(88, 32, 172, 20);
		login_panel.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setBackground(Color.BLACK);
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(10, 33, 68, 17);
		login_panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(10, 77, 68, 17);
		login_panel.add(lblPassword);
		
		
		////////////////////////////////////
		//Login button
		///////////////////////////////////
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textUserName.getText();
				String password=passwordField.getText();
				try {
					String query="select * from login where id=1";
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(query);
					rs.next();
					String namedb=rs.getString("userName");
					String passdb=rs.getString("password");
					if(username.equals(namedb) && password.equals(passdb)) 
					{
						JOptionPane.showMessageDialog(frame,"Valid info","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Username or password is invalid","Alert",JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(Exception o) {System.out.println(o);} 
				
				
			}
		});
		
		
		
		
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(88, 128, 68, 23);
		login_panel.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fame2 frame = new Fame2();
				frame.setVisible(true);
			}
		});
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(192, 128, 68, 23);
		login_panel.add(btnClose);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 75, 172, 20);
		login_panel.add(passwordField);
		
		JLayeredPane logo_panel = new JLayeredPane();
		logo_panel.setBounds(332, 11, 283, 116);
		frame.getContentPane().add(logo_panel);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo_nanak.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(89, 0, 154, 105);
		logo_panel.add(lblNewLabel);
	}
}
