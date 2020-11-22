import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class costumerGUI extends JFrame{

	public JFrame frame;
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
					costumerGUI window = new costumerGUI();
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
	private JTextField textField;
	public costumerGUI() {
		initialize(); 
		conn=mysql.dbconnector();
	}
	public void refreshtable()
	{
		try
		{
			String query="select Order_no,Firstname,Lastname,Address,Contact_No from customer_details";
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
		frame.setPreferredSize(new Dimension(400, 300));
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
					
					String query="select * from customer_details where Order_no='"+loc+"'";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs =pst.executeQuery();
					while(rs.next())
					{
						textField.setText(rs.getString("Order_no"));
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
					String query="select Order_no,Firstname,Lastname,Address,Contact_No from customer_details";
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
		lblNewLabel.setBounds(10, 162, 65, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LastName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 196, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 231, 65, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 256, 65, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_first = new JTextField();
		textField_first.setBounds(118, 163, 115, 20);
		frame.getContentPane().add(textField_first);
		textField_first.setColumns(10);
		
		textField_last = new JTextField();
		textField_last.setBounds(118, 194, 115, 20);
		frame.getContentPane().add(textField_last);
		textField_last.setColumns(10);
		
		textField_no = new JTextField();
		textField_no.setBounds(118, 225, 115, 20);
		frame.getContentPane().add(textField_no);
		textField_no.setColumns(10);
		
		textField_address = new JTextField();
		textField_address.setBounds(118, 253, 115, 20);
		frame.getContentPane().add(textField_address);
		textField_address.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="insert into customer_details (id,Order_no,Firstname,Lastname,Address,Contact_No) values(?,?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setInt(1,i++);
					pst.setString(2,textField.getText());
					pst.setString(3,textField_first.getText());
					pst.setString(4,textField_last.getText());
					pst.setString(5,textField_address.getText());
					pst.setString(6,textField_no.getText());
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
					String query="Update customer_details set Order_no='"+textField.getText()+"',Firstname='"+textField_first.getText()+"', Lastname='"+textField_last.getText()+"',Address='"+textField_address.getText()+"',Contact_No='"+textField_no.getText()+"' where id='"+table.getSelectedRow()+"'";
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setForeground(Color.BLUE);
		panel.setBounds(0, 0, 735, 69);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTOMER DETAILS :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		
		JLabel lblOrder = new JLabel("Order No.");
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrder.setBounds(10, 137, 65, 14);
		frame.getContentPane().add(lblOrder);
		
		textField = new JTextField();
		textField.setBounds(118, 134, 115, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		frame.setBounds(100, 100, 751, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refreshtable();
	}
}

