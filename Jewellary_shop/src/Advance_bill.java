/*import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Advance_bill extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Advance_bill frame = new Advance_bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Advance_bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}*/
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Advance_bill extends JFrame {

	public JFrame frame;
	private JTextField textField_Cname;
	private final JPanel panel = new JPanel();
	private JTextField textField_Adv;
	private JTextField textField_Mno;
	private JTextField textField_Orderno;
	private JTextField textField_ItemNo;
	private JTextField textField_ItemName;
	private JTextField textField_Weight;
	private JTextField textField_PCS;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Advance_bill window = new Advance_bill();
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
	private JTextField textField;
	public Advance_bill() {
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
			String query="insert into customer_details (Order_no.,Firstname,Lastname,Address,Contact_No) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,textField_Orderno.getText());
			pst.setString(2,textField_Cname.getText());
			//pst.setString(4, textfield_Address.getText());
			pst.setString(5,textField_Mno.getText());
			pst.setString(4,textField_Adv.getText());
			pst.setString(5,textField_ItemNo.getText());
			pst.setString(6,textField_ItemName.getText());
			pst.setString(7,textField_Weight.getText());
			pst.setString(8,textField_PCS.getText());
			pst.execute();
			pst.close();
		}
		catch(Exception ex)
		{ex.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 825, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Customer FirstName");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 81, 135, 27);
		frame.getContentPane().add(lblNewLabel);
		
		textField_Cname = new JTextField();
		textField_Cname.setBounds(155, 85, 143, 20);
		frame.getContentPane().add(textField_Cname);
		textField_Cname.setColumns(10);
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 809, 49);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Adv. Amount");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 125, 100, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_Adv = new JTextField();
		textField_Adv.setBounds(155, 129, 143, 20);
		frame.getContentPane().add(textField_Adv);
		textField_Adv.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile No.");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_2.setBounds(369, 131, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_Mno = new JTextField();
		textField_Mno.setBounds(462, 125, 86, 20);
		frame.getContentPane().add(textField_Mno);
		textField_Mno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Order No.");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_3.setBounds(606, 87, 62, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_Orderno = new JTextField();
		textField_Orderno.setBounds(693, 85, 86, 20);
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
		
		JLabel lblNewLabel_7 = new JLabel("PCS");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_7.setBounds(20, 317, 62, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_ItemNo = new JTextField();
		textField_ItemNo.setBounds(127, 240, 152, 20);
		frame.getContentPane().add(textField_ItemNo);
		textField_ItemNo.setColumns(10);
		
		textField_ItemName = new JTextField();
		textField_ItemName.setBounds(127, 265, 152, 20);
		frame.getContentPane().add(textField_ItemName);
		textField_ItemName.setColumns(10);
		
		textField_Weight = new JTextField();
		textField_Weight.setBounds(127, 290, 152, 20);
		frame.getContentPane().add(textField_Weight);
		textField_Weight.setColumns(10);
		
		textField_PCS = new JTextField();
		textField_PCS.setBounds(127, 315, 152, 20);
		frame.getContentPane().add(textField_PCS);
		textField_PCS.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modal = (DefaultTableModel) table.getModel();
				modal.addRow(new Object[] {textField_ItemNo.getText(),textField_ItemName.getText(),textField_Weight.getText(),textField_PCS.getText()});
				JOptionPane.showMessageDialog(null,"Item Added");
				save();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(81, 359, 73, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_1.setBounds(58, 428, 114, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("Gold Rate");
		lblNewLabel_8.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_8.setBounds(643, 428, 73, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Gold Amount");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNewLabel_9.setBounds(334, 428, 86, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(721, 426, 78, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(436, 426, 114, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
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
				"Item No", "Item Name", "Weight", "PCS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_10 = new JLabel("LastName");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(369, 88, 73, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(462, 85, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}

