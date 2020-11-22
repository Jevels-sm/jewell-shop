import java.awt.EventQueue;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
public class bill {
	//database bugs
	JFrame frame;
	private JTextField textField_Cname;
	private final JPanel panel = new JPanel();
	private JTextField textField_Mobileno;
	private JTextField textField_Adrs;
	private JTextField textField_Orderno;
	private JTextField textField_ItemName;
	private JTextField textField_ItemNo;
	private JTextField textField_Weight;
	private JTextField textField_Amount;
	private JTextField textField_Rate;
	private JTextField textField_Making;
	private JTable table;
	List<String> boxContent = new ArrayList<>();
	DefaultTableModel modal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill window = new bill();
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
	private JTextField textField_Total;
	private JTextField textField_Metal;
	private JTextField textField_W;
	private JTextField textField_Per;
	private JTextField textField_NW;
	private JTextField textField_R;
	private JTextField textField_Price;
	private JTextField textField_Dis;
	private JTextField textField_Var;
	private JTextField textField_lname;
	public bill() {
		initialize();
		conn=mysql.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void save()
	{
		try
		{
			String query="insert into customer_details (Order_no.,Firstname,Lastname,Address,Contact_No,) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,textField_Orderno.getText());
			pst.setString(2,textField_Cname.getText());
			pst.setString(3, textField_lname.getText());
			pst.setString(4,textField_Adrs.getText());
			pst.setString(5,textField_Mobileno.getText());
			
			pst.execute();
			pst.close();
			String query2= "insert into price_details (Item_no.,Item_name,Adv_amount,Weight,PCS) values(?,?,?,?,?)";
			PreparedStatement pst2=conn.prepareStatement(query2);
			pst2.setString(2,textField_ItemName.getText());
			pst2.setString(1,textField_ItemNo.getText());
			pst2.setString(4,textField_Weight.getText());
			pst2.setString(3,textField_Amount.getText());
			pst2.execute();
			pst2.close();
			
		}
		catch(Exception ex)
		{ex.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 825, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Customer FirstName");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel.setBounds(263, 81, 132, 27);
		frame.getContentPane().add(lblNewLabel);
		
		textField_Cname = new JTextField();
		textField_Cname.setBounds(422, 85, 143, 20);
		frame.getContentPane().add(textField_Cname);
		textField_Cname.setColumns(10);
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 809, 58);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_17 = new JLabel("BILLING");
		lblNewLabel_17.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 33));
		panel.add(lblNewLabel_17);
		
		JLabel txt_altNo = new JLabel("Address");
		txt_altNo.setFont(new Font("Arial Black", Font.BOLD, 11));
		txt_altNo.setBounds(263, 128, 142, 27);
		frame.getContentPane().add(txt_altNo);
		
		textField_Mobileno = new JTextField();
		textField_Mobileno.setBounds(111, 132, 122, 20);
		frame.getContentPane().add(textField_Mobileno);
		textField_Mobileno.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile No.");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2.setBounds(20, 134, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_Adrs = new JTextField();
		textField_Adrs.setBounds(422, 132, 351, 20);
		frame.getContentPane().add(textField_Adrs);
		textField_Adrs.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Order No.");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 87, 62, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_Orderno = new JTextField();
		textField_Orderno.setBounds(111, 85, 122, 20);
		frame.getContentPane().add(textField_Orderno);
		textField_Orderno.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Item No.");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_4.setBounds(20, 242, 62, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Item Name");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_5.setBounds(20, 267, 73, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Weight");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_6.setBounds(20, 292, 62, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel txt_Making = new JLabel("Making");
		txt_Making.setFont(new Font("Arial Black", Font.BOLD, 11));
		txt_Making.setBounds(20, 342, 62, 14);
		frame.getContentPane().add(txt_Making);
		
		textField_ItemName = new JTextField();
		textField_ItemName.setBounds(127, 265, 152, 20);
		frame.getContentPane().add(textField_ItemName);
		textField_ItemName.setColumns(10);
		
		textField_ItemNo = new JTextField();
		textField_ItemNo.setBounds(127, 240, 152, 20);
		frame.getContentPane().add(textField_ItemNo);
		textField_ItemNo.setColumns(10);
		
		textField_Weight = new JTextField();
		textField_Weight.setBounds(127, 290, 152, 20);
		frame.getContentPane().add(textField_Weight);
		textField_Weight.setColumns(10);
		
		textField_Amount = new JTextField();
		textField_Amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				long totalAmount=0;
				try {
				totalAmount=Integer.valueOf(textField_Making.getText())+Integer.valueOf(textField_Amount.getText());
				textField_Total.setText(String.valueOf(totalAmount));
				}
				catch(Exception ex) {
					textField_Total.setText(textField_Amount.getText());
				}
				
			}
		});
		textField_Amount.setBounds(127, 315, 152, 20);
		frame.getContentPane().add(textField_Amount);
		textField_Amount.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modal = (DefaultTableModel) table.getModel();
				modal.addRow(new Object[] {textField_ItemNo.getText(),textField_ItemName.getText(),textField_Weight.getText(),textField_Rate.getText(),textField_Amount.getText(),textField_Making.getText(),textField_Total.getText()});
				boxContent.add(textField_ItemNo.getText());
				boxContent.add(textField_ItemName.getText());
				boxContent.add(textField_Weight.getText());
				boxContent.add(textField_Rate.getText());
				boxContent.add(textField_Amount.getText());
				boxContent.add(textField_Making.getText());
				boxContent.add(textField_Total.getText());
				JOptionPane.showMessageDialog(null,"Item Added");
				save();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(66, 427, 73, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bill_Layout bill = new Bill_Layout();
				bill.orderno=textField_Orderno.getText();
				bill.Mobileno=textField_Mobileno.getText();
				bill.Name=textField_Cname.getText()+" "+textField_lname.getText();
				bill.Adrs=textField_Adrs.getText();
				bill.box=boxContent;
				bill.Metal_Type=textField_Metal.getText();
				bill.Weight=textField_W.getText();
				bill.Percent=textField_Per.getText();
				bill.NetWeight=textField_NW.getText();
				bill.Rate=textField_R.getText();
				bill.Price=textField_Price.getText();
				bill.Dis=textField_Dis.getText();
				bill.Var=textField_Var.getText();
	
				try {
					bill.Layout();
					JOptionPane.showMessageDialog(null,"Saved in gallary");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(38, 477, 114, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("Rate");
		lblNewLabel_8.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_8.setBounds(20, 392, 52, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel txt_Amount = new JLabel("Amount");
		txt_Amount.setFont(new Font("Arial Black", Font.BOLD, 11));
		txt_Amount.setBounds(20, 317, 86, 14);
		frame.getContentPane().add(txt_Amount);
		
		textField_Rate = new JTextField();
		textField_Rate.setBounds(127, 390, 152, 20);
		frame.getContentPane().add(textField_Rate);
		textField_Rate.setColumns(10);
		
		textField_Making = new JTextField();
		textField_Making.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				long totalAmount=0;
				try {
				totalAmount=Integer.valueOf(textField_Making.getText())+Integer.valueOf(textField_Amount.getText());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Please Enter valid info");
					textField_Making.setText("");
					textField_Amount.setText("");
				}
				textField_Total.setText(String.valueOf(totalAmount));
			}
		});
		textField_Making.setBounds(127, 340, 152, 20);
		frame.getContentPane().add(textField_Making);
		textField_Making.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 189, 446, 205);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setFont(new Font("Arial Black", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item No","Item Name", "Weight", "Rate","Amount","Making","Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		textField_Total = new JTextField();
		textField_Total.setBounds(127, 364, 152, 20);
		frame.getContentPane().add(textField_Total);
		textField_Total.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total Amount");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 367, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Old (Exchange(Cash+Metal)");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_7.setBounds(400, 399, 249, 27);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Metal Type");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_9.setBounds(322, 430, 73, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Weight");
		lblNewLabel_10.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_10.setBounds(322, 455, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Percent");
		lblNewLabel_11.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_11.setBounds(322, 480, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Rate");
		lblNewLabel_12.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_12.setBounds(544, 430, 46, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Price");
		lblNewLabel_13.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_13.setBounds(544, 455, 46, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Dis(-)");
		lblNewLabel_14.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_14.setBounds(544, 480, 46, 14);
		frame.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Net Weight");
		lblNewLabel_15.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_15.setBounds(321, 508, 74, 14);
		frame.getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Var%(+)");
		lblNewLabel_16.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_16.setBounds(544, 509, 62, 14);
		frame.getContentPane().add(lblNewLabel_16);
		
		textField_Metal = new JTextField();
		textField_Metal.setBounds(410, 427, 86, 20);
		frame.getContentPane().add(textField_Metal);
		textField_Metal.setColumns(10);
		
		textField_W = new JTextField();
		textField_W.setBounds(410, 452, 86, 20);
		frame.getContentPane().add(textField_W);
		textField_W.setColumns(10);
		
		textField_Per = new JTextField();
		textField_Per.setBounds(410, 477, 86, 20);
		frame.getContentPane().add(textField_Per);
		textField_Per.setColumns(10);
		
		textField_NW = new JTextField();
		textField_NW.setBounds(410, 506, 86, 20);
		frame.getContentPane().add(textField_NW);
		textField_NW.setColumns(10);
		
		textField_R = new JTextField();
		textField_R.setBounds(624, 427, 86, 20);
		frame.getContentPane().add(textField_R);
		textField_R.setColumns(10);
		
		textField_Price = new JTextField();
		textField_Price.setBounds(624, 452, 86, 20);
		frame.getContentPane().add(textField_Price);
		textField_Price.setColumns(10);
		
		textField_Dis = new JTextField();
		textField_Dis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
				int disc=Integer.valueOf(textField_Dis.getText());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Please Enter valid info");
					textField_Dis.setText("");
				}
			}
		});
		textField_Dis.setBounds(624, 477, 86, 20);
		frame.getContentPane().add(textField_Dis);
		textField_Dis.setColumns(10);
		
		textField_Var = new JTextField();
		textField_Var.setBounds(624, 506, 86, 20);
		frame.getContentPane().add(textField_Var);
		textField_Var.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int action=JOptionPane.showConfirmDialog(null, "Do you Really want to Clear table","Clear",JOptionPane.YES_NO_OPTION);
					if(action==0) {
					//String query="delete from order_details where id='"+table.getSelectedRow()+"'";
					//PreparedStatement pst=conn.prepareStatement(query);
					
					//pst.execute();
					//pst.close();
					
						
						boxContent.clear();
						modal.setRowCount(0);						
				}
				}
				catch(Exception ex)
				{ex.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(207, 426, 72, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_18 = new JLabel("Last Name");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_18.setBounds(603, 88, 74, 14);
		frame.getContentPane().add(lblNewLabel_18);
		
		textField_lname = new JTextField();
		textField_lname.setBounds(687, 85, 86, 20);
		frame.getContentPane().add(textField_lname);
		textField_lname.setColumns(10);
	}
}
