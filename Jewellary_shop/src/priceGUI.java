import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Choice;
import javax.swing.ButtonGroup;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class priceGUI extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPrice = new JLabel("PRICE :");
	private Choice choice;
	private JTextField tfjwlname;
	public JFrame frame;
	private JComboBox comboBox;
	private JTable table;
	static Connection con =null;
	private JTextField tfdescp;
	private JTextField tfprice;
	private JTextField tfunit;
	private JTextField searchItem;
	private int i=0;
	private int row;
	private JLabel label1;
	private JTextField textField;
	//protected Object frame;
	public void refreshtable()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Order No");
		model.addColumn("Item Name");
		model.addColumn("Weight");
		model.addColumn("Amount");
		model.addColumn("Making Cost");
		model.addColumn("ID");
		
		try
		{
			String query="select * from price_details";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("Order_no"),
						rs.getString("Item_name"),
						rs.getString("Weight"),
						rs.getString("Amount"),
						rs.getString("Making"),
						rs.getInt("ID")
						
				});
			}
			st.close();
			rs.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(85);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(50);
			
			
			
		}
		catch(Exception o)
		{
			o.printStackTrace();
		}
	}
	private void SaveToDatabase() {
		try {
			String query="INSERT INTO price_details(id,Order_no,Item_name,Weight,Amount,Making) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,i++);
			ps.setString(2,textField.getText());
			ps.setString(3, tfjwlname.getText());
			ps.setString(4, tfdescp.getText());
			ps.setInt(5, Integer.valueOf(tfprice.getText()));
			ps.setInt(6, Integer.valueOf(tfunit.getText()));
			ps.execute();
			JOptionPane.showMessageDialog(null,"Saved !!!");
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}


	/**
	 * Launch the application.
	  @throws ClassNotFoundException 
	  @throws IllegalAccessException 
	  @throws InstantiationException 
	 * @throws SQLException 
	**/
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					priceGUI frame = new priceGUI();
					frame.setVisible(true);
					frame.refreshtable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mysql connect= new mysql();
		con=connect.dbconnector();
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public priceGUI() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				refreshtable();
			}
		});
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(Color.BLUE);
		toppanel.setBounds(0, 0, 809, 78);
		frame.getContentPane().add(toppanel);
		toppanel.setLayout(null);
		
		JLabel lblwelcome = new JLabel("PRICE :");
		lblwelcome.setForeground(Color.WHITE);
		lblwelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblwelcome.setBounds(10, 11, 238, 61);
		toppanel.add(lblwelcome);
		
		JLabel lblNewLabel = new JLabel("JEWEL NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 200, 123, 19);
		frame.getContentPane().add(lblNewLabel);
		
		tfjwlname = new JTextField();
		tfjwlname.setBounds(143, 201, 163, 20);
		frame.getContentPane().add(tfjwlname);
		tfjwlname.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ADD NEW ROW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SaveToDatabase();
					refreshtable();
					
				}
				catch(Exception e1){
					System.out.println(e1);
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 407, 139, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 167, 447, 210);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					row=table.getSelectedRow();
					String loc=(table.getModel().getValueAt(row,5)).toString();
					
					String query="select * from price_details where id='"+loc+"'";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs =pst.executeQuery();
					while(rs.next())
					{
						textField.setText(rs.getString("Order_no"));
						tfjwlname.setText(rs.getString("Item_name"));
						tfdescp.setText(rs.getString("Weight"));
						tfprice.setText(rs.getString("Amount"));
						tfunit.setText(rs.getString("Making"));
					}
					pst.close();
					
				}
				catch(Exception o)
				{
					o.printStackTrace();
				}
			}
		});
		//table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//table.setColumnSelectionAllowed(true);
		//table.setCellSelectionEnabled(true);
		
				
		JButton btnNewButton_3 = new JButton("EDIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					row=table.getSelectedRow();
					String loc=(table.getModel().getValueAt(row,5)).toString();
					//Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
					String query="Update price_details set  Order_no='"+textField.getText()+"',Item_name='"+tfjwlname.getText()+"', Weight='"+tfdescp.getText()+"',Amount='"+tfprice.getText()+"',Making='"+tfunit.getText()+"' where id='"+loc+"'";
					PreparedStatement pst=con.prepareStatement(query);
					
					pst.execute();
					pst.close();
					refreshtable();
				}
				catch(Exception ex)
				{ex.printStackTrace();
				}
			}
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(181, 407, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("WEIGHT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 234, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfdescp = new JTextField();
		tfdescp.setBounds(143, 232, 163, 20);
		frame.getContentPane().add(tfdescp);
		tfdescp.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AMOUNT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 269, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MAKING COST");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setBounds(10, 294, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfprice = new JTextField();
		tfprice.setBounds(143, 263, 163, 19);
		frame.getContentPane().add(tfprice);
		tfprice.setColumns(10);
		
		tfunit = new JTextField();
		tfunit.setBounds(143, 292, 163, 20);
		frame.getContentPane().add(tfunit);
		tfunit.setColumns(10);
		
		searchItem = new JTextField();
		searchItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select * from price_details where "+selection+"=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, searchItem.getText());
					ResultSet rs =pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					}
					catch(Exception ex) {ex.printStackTrace();}
			}
		});
		searchItem.setBounds(652, 118, 123, 20);
		frame.getContentPane().add(searchItem);
		searchItem.setColumns(10);
		
		JButton btnNewButton = new JButton("TABLE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtable();
			}
		});
		btnNewButton.setBounds(10, 360, 139, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					row=table.getSelectedRow();
					String loc=(table.getModel().getValueAt(row,5)).toString();
					String query="delete from price_details where id='"+loc+"'";
					PreparedStatement pst=con.prepareStatement(query);
					
					pst.execute();
					pst.close();
					refreshtable();
				}
				catch(Exception ex)
				{ex.printStackTrace();
				}
			
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(181, 360, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Order_no", "Item_name", "Weight", "Amount","Making"}));
		comboBox.setBounds(536, 117, 86, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("ORDER NO.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 175, 86, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(141, 170, 165, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.show();
		frame.setBounds(100, 100, 807, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refreshtable();
	}
}
