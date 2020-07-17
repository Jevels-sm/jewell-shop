import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

public class priceGUI extends JFrame {

	private JPanel contentPane;
	private final JLabel lblPrice = new JLabel("PRICE :");
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					priceGUI frame = new priceGUI();
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
	public priceGUI() {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 108, 123, 19);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(143, 107, 127, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 147, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(131, 147, 108, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(22, 204, 753, 173);
		frame.getContentPane().add(table);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(667, 399, 108, 37);
		frame.getContentPane().add(btnNewButton_2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setForeground(Color.BLUE);
		layeredPane_1.setBackground(Color.BLUE);
		layeredPane_1.setBounds(0, 33, 414, -35);
		layeredPane.add(layeredPane_1);
		lblPrice.setBackground(Color.BLUE);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblPrice.setBounds(10, 9, 98, 31);
		layeredPane.add(lblPrice);
		*/
	}
}
