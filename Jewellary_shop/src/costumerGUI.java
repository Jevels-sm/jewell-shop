import java.awt.EventQueue;
import java.awt.Color;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerDetails {

	private JFrame frame;
	private JTable table;
	private int i=0;
	private int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails window = new CustomerDetails();
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
	private JTextField textField_first;
	private JTextField textField_last;
	private JTextField textField_no;
	private JTextField textField_address;
	public CustomerDetails() {
		initialize(); 
		conn=mysql.dbconnector();
	}
	public void refreshtable()
	{
		try
		{
			String query="select * from customer_details";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			st.close();
			rs.close();
			
		}
		catch(Exception o)
		{
			o.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 101, 482, 284);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					row=table.getSelectedRow();
					String loc=(table.getModel().getValueAt(row,0)).toString();
					
					String query="select * from customer_details where id='"+loc+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs =pst.executeQuery();
					while(rs.next())
					{
						textField_first.setText(rs.getString("Firstname"));
						textField_last.setText(rs.getString("Lastname"));
						textField_address.setText(rs.getString("Address"));
						textField_no.setText(rs.getString("Contact_No"));
					}
					pst.close();
					
				}
				catch(Exception o)
				{
					o.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnShowTable = new JButton("Table");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="select * from customer_details";
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					st.close();
					rs.close();
					
				}
				catch(Exception o)
				{
					o.printStackTrace();
				}
				
			}
		});
		btnShowTable.setBounds(136, 391, 89, 23);
		frame.getContentPane().add(btnShowTable);
		
		JLabel lblNewLabel = new JLabel("FirstName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 120, 65, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 154, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 191, 65, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 230, 65, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_first = new JTextField();
		textField_first.setBounds(110, 121, 115, 20);
		frame.getContentPane().add(textField_first);
		textField_first.setColumns(10);
		
		textField_last = new JTextField();
		textField_last.setBounds(110, 151, 115, 20);
		frame.getContentPane().add(textField_last);
		textField_last.setColumns(10);
		
		textField_no = new JTextField();
		textField_no.setBounds(110, 188, 115, 20);
		frame.getContentPane().add(textField_no);
		textField_no.setColumns(10);
		
		textField_address = new JTextField();
		textField_address.setBounds(110, 221, 115, 20);
		frame.getContentPane().add(textField_address);
		textField_address.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="insert into customer_details (id,Firstname,Lastname,Address,Contact_No) values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setInt(1,i++);
					pst.setString(2,textField_first.getText());
					pst.setString(3,textField_last.getText());
					pst.setString(4,textField_address.getText());
					pst.setString(5,textField_no.getText());
					pst.execute();
					pst.close();
					refreshtable();
				}
				catch(Exception ex)
				{ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 357, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="Update customer_details set Firstname='"+textField_first.getText()+"', Lastname='"+textField_last.getText()+"',Address='"+textField_address.getText()+"',Contact_No='"+textField_no.getText()+"' where id='"+table.getSelectedRow()+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					pst.close();
					refreshtable();
				}
				catch(Exception ex)
				{ex.printStackTrace();
				}
			}
			
		});
		btnNewButton_1.setBounds(136, 357, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="delete from customer_details where id='"+table.getSelectedRow()+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.execute();
					pst.close();
					refreshtable();
				}
				catch(Exception ex)
				{ex.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(10, 391, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		frame.setBounds(100, 100, 751, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refreshtable();
	}
}
/*import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class costumerGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					costumerGUI frame = new costumerGUI();
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
/*	public costumerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}*/
