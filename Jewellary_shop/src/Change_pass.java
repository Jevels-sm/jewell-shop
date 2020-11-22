import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Change_pass {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_pass window = new Change_pass();
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
	Connection conn=null;
	private JTextField textField_user;
	private JPasswordField prevPwd;
	private JPasswordField newPwd;
	private JPasswordField cnfrmPwd;
	private String pass1;
	public Change_pass() {
		initialize();
		conn=mysql.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private boolean checkuser() {

		String password=String.copyValueOf(prevPwd.getPassword());
		try {
			String query="select * from register where Name= '"+textField_user.getText()+ "' AND password= '"+password + "'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			boolean flag =rs.next();
			if(flag==false) {
				JOptionPane.showMessageDialog(frame,"Username or password is invalid","Alert",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		catch(Exception o) {System.out.println(o);} 
		
		return true;
		
	}
		
	private void update() {
		String query="Update register set Password='"+pass1+"' where Name='"+textField_user.getText()+"'";
		try {
			PreparedStatement pst;
			pst = conn.prepareStatement(query);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial Black", Font.BOLD, 11));
		frame.setBounds(100, 100, 461, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 445, 55);
		frame.getContentPane().add(panel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		panel.add(layeredPane);
		
		JLabel lblNewLabel_4 = new JLabel("CHANGE PASSWORD");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_4.setForeground(Color.WHITE);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 84, 120, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Previous password");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 119, 162, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 160, 147, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass1=String.copyValueOf(newPwd.getPassword());
				String pass2=String.copyValueOf(cnfrmPwd.getPassword());
				if(pass1.equals(pass2)) {
					boolean ans = checkuser();//checks user
					if(ans==true){
						update(); //updates
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Password doesn't match");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.setBounds(151, 242, 107, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 195, 147, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_user = new JTextField();
		textField_user.setBounds(262, 82, 138, 20);
		frame.getContentPane().add(textField_user);
		textField_user.setColumns(10);
		
		prevPwd = new JPasswordField();
		prevPwd.setBounds(262, 118, 138, 20);
		frame.getContentPane().add(prevPwd);
		
		newPwd = new JPasswordField();
		newPwd.setBounds(262, 159, 138, 20);
		frame.getContentPane().add(newPwd);
		
		cnfrmPwd = new JPasswordField();
		cnfrmPwd.setBounds(262, 194, 138, 20);
		frame.getContentPane().add(cnfrmPwd);
	}
}
