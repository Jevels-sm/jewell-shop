import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;

public class CustomerDetails {

	private JFrame frame;
	private JTable table;

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
	public CustomerDetails() {
		initialize();
		conn=mysql.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 114, 423, 284);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShowTable = new JButton("Table");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="select * from customers";
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery(query); 
				}
				catch(Exception o)
				{
					o.printStackTrace();
				}
				
			}
		});
		btnShowTable.setBounds(44, 273, 89, 23);
		frame.getContentPane().add(btnShowTable);
		frame.setBounds(100, 100, 751, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
