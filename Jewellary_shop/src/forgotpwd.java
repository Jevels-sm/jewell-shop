import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.mail.MessagingException;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class forgotpwd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel errorMail;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotpwd frame = new forgotpwd();
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
	public forgotpwd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Enter your E-mail ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 106, 187, 21);
		layeredPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 138, 248, 20);
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String regex = "^(.+)@(.+)$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(textField.getText());
				if(!matcher.matches()) {
					errorMail.setText("Invail E-Mail Address !!");
					//flag=true;
				}
				else {
					errorMail.setText("");
					//flag=false;
				}
			}
		});
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		        String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
		        String numbers = "0123456789"; 
		        String symbols = "!@#$%^&*_=+-/.?<>)"; 
		        String values = Capital_chars + Small_chars + 
                        numbers + symbols; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] password = new char[10]; 
  
        for (int i = 0; i < 10; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            password[i] = 
              values.charAt(rndm_method.nextInt(values.length())); 
  
        }
        String pwd= password.toString();
        sendMail sd= new sendMail();
        try {
        	String msg= "Hello Sir/ Ma'am, \n We have generated a new password for you !! \n Kindly login.";
			sd.sendMail(textField.getText(),textField_1.getText(),pwd,msg);
			JOptionPane.showMessageDialog(contentPane,"Mail sent to reset your password !!","Alert",JOptionPane.WARNING_MESSAGE);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnNewButton.setBounds(158, 197, 105, 25);
		layeredPane.add(btnNewButton);
		
		errorMail = new JLabel("");
		errorMail.setForeground(Color.RED);
		errorMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		errorMail.setBounds(220, 169, 194, 14);
		layeredPane.add(errorMail);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 39, 123, 21);
		layeredPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 41, 150, 20);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
