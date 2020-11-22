import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
//import javax.activation.DataHandler;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.mail.MessagingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstname;
	private JTextField tfMidname;
	private JTextField tfLastname;
	private JTextField tfContactno;
	private JTextField tfEmail;
	private JPasswordField pwd;
	private JPasswordField cnfirmpwd;
	private JTextField tfShopname;
	private JLabel errorMail, errorPhone, errorPwd;
	static Connection connection= null;
	private boolean flag=false;
	private JButton btnNewButton;
	private int i=0;
    public static Registration frame = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 741, 70);
		layeredPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("REGISTER YOURSELF !!");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstname.setBounds(10, 98, 83, 27);
		layeredPane.add(lblFirstname);
		
		tfFirstname = new JTextField();
		tfFirstname.setBounds(110, 105, 86, 20);
		layeredPane.add(tfFirstname);
		tfFirstname.setColumns(10);
		
		JLabel lblMidname = new JLabel("Middle Name");
		lblMidname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMidname.setBounds(241, 100, 95, 27);
		layeredPane.add(lblMidname);
		
		tfMidname = new JTextField();
		tfMidname.setBounds(346, 103, 86, 20);
		layeredPane.add(tfMidname);
		tfMidname.setColumns(10);
		
		JLabel lbLastname = new JLabel("Last Name");
		lbLastname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbLastname.setBounds(482, 106, 75, 14);
		layeredPane.add(lbLastname);
		
		JLabel lbContactno = new JLabel("Contact no.");
		lbContactno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbContactno.setBounds(10, 155, 83, 14);
		layeredPane.add(lbContactno);
		
		tfLastname = new JTextField();
		tfLastname.setBounds(603, 103, 86, 20);
		layeredPane.add(tfLastname);
		tfLastname.setColumns(10);
		
		tfContactno = new JTextField();
		tfContactno.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try {
					Long.parseLong(tfContactno.getText());
					errorPhone.setText("");
					flag=false;
					int len = tfContactno.getText().length();
					if (len > 10) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
	                    flag= true;
	                }
				}
				catch(NumberFormatException e1) {
					errorPhone.setText("Invalid contact !!");
					flag=true;
				}
			}
		});
		tfContactno.setBounds(110, 154, 86, 20);
		layeredPane.add(tfContactno);
		tfContactno.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(241, 157, 46, 14);
		layeredPane.add(lblGender);
		
		final JComboBox cBgender = new JComboBox();
		cBgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBgender.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male"}));
		cBgender.setBounds(352, 153, 80, 22);
		layeredPane.add(cBgender);
		
		JLabel lblEmail = new JLabel("E-Mail Address");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 214, 95, 14);
		layeredPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String regex = "^(.+)@(.+)$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(tfEmail.getText());
				if(!matcher.matches()) {
					errorMail.setText("Invail E-Mail Address !!");
					flag=true;
				}
				else {
					errorMail.setText("");
					flag=false;
				}
			}
		});
		tfEmail.setBounds(161, 213, 175, 20);
		layeredPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPwd.setBounds(10, 266, 83, 14);
		layeredPane.add(lblPwd);
		
		pwd = new JPasswordField();
		pwd.setBounds(218, 265, 118, 20);
		layeredPane.add(pwd);
		
		JLabel lblConfirmpwd = new JLabel("Confirm Password");
		lblConfirmpwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmpwd.setBounds(10, 315, 110, 14);
		layeredPane.add(lblConfirmpwd);
		
		cnfirmpwd = new JPasswordField();
	    cnfirmpwd.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(!(Arrays.equals(pwd.getPassword(), cnfirmpwd.getPassword()))) {
					errorPwd.setText("Both passwords need to match !!");
					flag=true;
				}
				else {
					errorPwd.setText("");
					flag=false;
				}
			}
		});
		cnfirmpwd.setBounds(218, 314, 118, 20);
		layeredPane.add(cnfirmpwd);
		
		JLabel lblShopname = new JLabel("Shop Name");
		lblShopname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShopname.setBounds(447, 212, 110, 19);
		layeredPane.add(lblShopname);
		
		tfShopname = new JTextField();
		tfShopname.setBounds(603, 213, 86, 20);
		layeredPane.add(tfShopname);
		tfShopname.setColumns(10);
		
		JLabel lblDesign = new JLabel("Designation");
		lblDesign.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesign.setBounds(447, 263, 110, 20);
		layeredPane.add(lblDesign);
		
		final JComboBox cBdesign = new JComboBox();
		cBdesign.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBdesign.setModel(new DefaultComboBoxModel(new String[] {"Owner", "Employee", "Customer"}));
		cBdesign.setBounds(603, 264, 86, 22);
		layeredPane.add(cBdesign);
		
		btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = tfFirstname.getText();
				String midName= tfMidname.getText();
				String gender= cBgender.getSelectedItem().toString();
				String design= cBdesign.getSelectedItem().toString();
                String lastName = tfLastname.getText();
                String emailId = tfEmail.getText();
                //String userName = username.getText();
                String mobileNumber = tfContactno.getText();
                int len = mobileNumber.length();
                String password = String.valueOf(pwd.getPassword());
                String shop= tfShopname.getText();

                String msg = "" + firstName;
                msg += " \n";
                
                
				if(!flag) {
					sendMail mail= new sendMail();
					
					try {
						String message= "Congratulation!,\n You have successfully registered to Jeweler shop app";
						mail.sendMail(emailId,firstName+midName+lastName,password,message);
						JOptionPane.showMessageDialog(contentPane,"Mail Sent!!!","Alert",JOptionPane.WARNING_MESSAGE);
			            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "root");
						//Connection connection= 
			            //String query = "INSERT INTO register values('" + firstName +midName+ lastName + "','" +
			            	//	emailId + "','" + mobileNumber + "','" + password + "','"+ gender+ "','"+ design+ "','"+ shop+ "')";
						mysql connect = new mysql();
						Connection connection= mysql.dbconnector();
						System.out.println("Connection successfull");
						String query="INSERT INTO register(user_ID,Name,Email,Contact,Password,Gender,Designation,ShopName) VALUES(?,?,?,?,?,?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setInt(1, i++);
						if(midName.equals("")) {
							pst.setNString(2,firstName+" "+lastName);
						}
						else {
							pst.setString(2,firstName+" "+midName+" "+lastName);
						}
			            
			            pst.setString(3,emailId);
			            pst.setString(4,mobileNumber);
			            pst.setString(5,password);
			            pst.setString(6,gender);
			            pst.setString(7,design);
			            pst.setString(8,shop);
	                    //Statement sta = connection.createStatement();
	                    int x = pst.executeUpdate();
	                    System.out.println(x);
	                    if (x == 0) {
			                 JOptionPane.showMessageDialog(contentPane, "This already exist");
			                } 
	                    else {
			                  JOptionPane.showMessageDialog(contentPane,"Welcome, " + msg + "Your account is sucessfully created");
			                  Main_page mp = new Main_page(firstName);
			                  mp.frame.setVisible(true);
			                  mp.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			                  frame.setVisible(false);
			                  frame.dispose();
			                 
			                  
			        
			                    }
			            connection.close();
					   
					} 
					catch (MessagingException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane,"Mail not sent !! Try Again Later... ","Alert",JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					 JOptionPane.showMessageDialog(contentPane,"Invalid Data !!!","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(315, 377, 105, 23);
		layeredPane.add(btnNewButton);
		
		errorPhone = new JLabel("");
		errorPhone.setForeground(Color.RED);
		errorPhone.setBounds(110, 185, 125, 14);
		layeredPane.add(errorPhone);
		
		errorMail = new JLabel("");
		errorMail.setForeground(Color.RED);
		errorMail.setBounds(267, 240, 125, 14);
		layeredPane.add(errorMail);
		
		errorPwd = new JLabel("");
		errorPwd.setForeground(Color.RED);
		errorPwd.setBounds(359, 317, 252, 17);
		layeredPane.add(errorPwd);
	}
}
