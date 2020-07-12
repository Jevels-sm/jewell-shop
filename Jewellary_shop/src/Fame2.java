import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;

public class Fame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtLogOut;
	private ImageIcon callog;
	private JLabel label1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fame2 frame = new Fame2();
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
	public Fame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px,grow][]", "[30px][][][][][221px,grow][grow]"));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, "cell 0 0,growx,aligny top");
		Image callog=new ImageIcon(this.getClass().getResource("/call logo.png")).getImage();
		
		JLabel label1 = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel.add(label1);
		
		textField = new JTextField();
		textField.setBackground(Color.BLUE);
		panel.add(textField);
		textField.setColumns(10);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.BLUE);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);
		
		txtLogOut = new JTextField();
		txtLogOut.setForeground(new Color(255, 255, 240));
		txtLogOut.setText("LOG OUT");
		txtLogOut.setEditable(false);
		txtLogOut.setBackground(new Color(0, 0, 255));
		panel.add(txtLogOut);
		txtLogOut.setColumns(1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(Color.PINK);
		contentPane.add(panel_1, "flowx,cell 0 4");
		panel_1.setLayout(new MigLayout("", "[55px]", "[][][14px][]"));
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER");
		panel_1.add(lblNewLabel_1, "cell 0 1,aligny top");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(216, 191, 216));
		contentPane.add(panel_3, "cell 0 4");
		
		JLabel lblNewLabel_4 = new JLabel("PURCHASE");
		lblNewLabel_4.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 218, 185));
		contentPane.add(panel_4, "flowx,cell 0 5");
		
		JLabel lblNewLabel_5 = new JLabel("MANAGE JEWELS");
		lblNewLabel_5.setForeground(Color.WHITE);
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 139));
		contentPane.add(panel_5, "cell 0 5");
		
		JLabel lblNewLabel_6 = new JLabel("REPORT ");
		lblNewLabel_6.setForeground(Color.WHITE);
		panel_5.add(lblNewLabel_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(250, 128, 114));
		contentPane.add(panel_6, "cell 0 5");
		
		JLabel lblNewLabel_7 = new JLabel("SETTINGS");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBackground(Color.WHITE);
		panel_6.add(lblNewLabel_7);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(135, 206, 250));
		contentPane.add(panel_7, "cell 0 6,alignx center");
		
		JLabel lblNewLabel_8 = new JLabel("BILLING");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_7.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(Color.ORANGE);
		contentPane.add(panel_2, "cell 0 4 2 2,alignx right");
		
		JLabel lblNewLabel_3 = new JLabel("SUPPLIER");
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
	}

}
