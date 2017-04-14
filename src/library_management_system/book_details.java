package library_management_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class book_details extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book_details frame = new book_details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JTextField textField;
	
	
	public void refresh_book()
	{
		try
		{
			String str="select * from book";
			PreparedStatement ptr=connection.prepareStatement(str);
			ResultSet rs=ptr.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public book_details() {
		setResizable(false);
		connection=login_database.dbConnector();
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/1471284462_books.png")));
		setTitle("List of Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 98, 678, 278);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Books", null, panel, null);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 653, 228);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Books Information");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		label.setBounds(190, 0, 388, 55);
		contentPane.add(label);
		
		JButton button = new JButton("Log out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login_screen ls=new login_screen();
				ls.setVisible(true);
			}
		});
		button.setFont(new Font("Sitka Small", Font.BOLD, 13));
		button.setBounds(305, 387, 118, 39);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("Enter Book ID");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(167, 66, 78, 35);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(255, 69, 219, 28);
		contentPane.add(textField);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="select * from book where book_title=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField.getText());
					ResultSet rs=ptr.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Book not exists");
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(503, 71, 95, 23);
		contentPane.add(button_1);
		
		refresh_book();
	}
}
