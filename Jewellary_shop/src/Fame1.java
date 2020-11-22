import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Fame1 {

	public JFrame frame;
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
		frame.setPreferredSize(new Dimension(400, 300));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 660, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane login_panel = new JLayeredPane();
		login_panel.setBounds(316, 35, 302, 236);
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
				String password=String.copyValueOf(passwordField.getPassword());
				try {
					String query="select * from register where Name= '"+username+ "' AND password= '"+password + "'";
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery(query);
					
					boolean flag =rs.next();
					if(flag==false) {
						JOptionPane.showMessageDialog(frame,"Username or password is invalid","Alert",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(frame,"Valid info","Alert",JOptionPane.WARNING_MESSAGE);
						Main_page obj = new Main_page(username);
						obj.frame.setVisible(true);
				        obj.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				        frame.setVisible(false); //you can't see me!
				        frame.dispose(); //Destroy the JFrame objectf
					}
					
						
					
					/*String namedb=rs.getString("userName");
					String passdb=rs.getString("password");
					if(username.equals(namedb) && password.equals(passdb)) 
					{
						JOptionPane.showMessageDialog(frame,"Valid info","Alert",JOptionPane.WARNING_MESSAGE);
						Main_page frame = new Main_page();
						frame.setVisible(true);
						
					}
					else
					{
						Main_page mp = new Main_page(username);
						mp.setVisible(true);
					}*/
				}
				catch(Exception o) {System.out.println(o);} 
				
				
			}
		});
		
		
		
		
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(88, 147, 68, 23);
		login_panel.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(192, 147, 68, 23);
		login_panel.add(btnClose);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 75, 172, 20);
		login_panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New User ?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 195, 113, 30);
		login_panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER HERE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration register =new Registration();
				register.setVisible(true);
				register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(103, 201, 157, 23);
		login_panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Forgot password ?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgotpwd fp = new forgotpwd();
				fp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(88, 106, 172, 23);
		login_panel.add(btnNewButton_1);
		Image img = new ImageIcon(this.getClass().getResource("/logo_nanak.jpg")).getImage();
		
		JLayeredPane logo_panel_1 = new JLayeredPane();
		logo_panel_1.setBounds(39, 48, 241, 170);
		frame.getContentPane().add(logo_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(67, 0, 176, 180);
		logo_panel_1.add(lblNewLabel_1);
	}
}
