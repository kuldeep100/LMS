package library_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class collection_of_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					collection_of_books frame = new collection_of_books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	Connection connection=null;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	
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
	public collection_of_books() {
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_panel ap=new admin_panel();
				ap.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setIcon(new ImageIcon(getClass().getResource("/1471291689_restart-1 (1).png")));
		btnBack.setBounds(604, 381, 107, 26);
		contentPane.add(btnBack);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Add New Book", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(41, 22, 52, 14);
		lblBookId.setForeground(Color.WHITE);
		panel_1.add(lblBookId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 19, 139, 20);
		panel_1.add(textField);
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setForeground(Color.WHITE);
		lblBookTitle.setBounds(41, 61, 68, 14);
		panel_1.add(lblBookTitle);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 58, 139, 20);
		panel_1.add(textField_1);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(Color.WHITE);
		lblIsbn.setBounds(41, 98, 52, 14);
		panel_1.add(lblIsbn);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 95, 139, 20);
		panel_1.add(textField_2);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setForeground(Color.WHITE);
		lblEdition.setBounds(41, 134, 52, 14);
		panel_1.add(lblEdition);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 131, 139, 20);
		panel_1.add(textField_3);
		
		JLabel lblAuthorId = new JLabel("Author Name");
		lblAuthorId.setForeground(Color.WHITE);
		lblAuthorId.setBounds(411, 19, 84, 14);
		panel_1.add(lblAuthorId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(505, 19, 139, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(505, 58, 139, 20);
		panel_1.add(textField_5);
		
		JLabel lblPublisherId = new JLabel("Publisher ID");
		lblPublisherId.setForeground(Color.WHITE);
		lblPublisherId.setBounds(411, 58, 68, 14);
		panel_1.add(lblPublisherId);
		
		JLabel lblAvail = new JLabel("Availability");
		lblAvail.setForeground(Color.WHITE);
		lblAvail.setBounds(411, 95, 68, 14);
		panel_1.add(lblAvail);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(505, 95, 139, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(505, 131, 139, 20);
		panel_1.add(textField_7);
		
		JLabel lblShelfId = new JLabel("Shelf ID");
		lblShelfId.setForeground(Color.WHITE);
		lblShelfId.setBounds(411, 131, 52, 14);
		panel_1.add(lblShelfId);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String str="insert into book (book_id,book_title,isbn,edition,Author_Name,publisher_id,Availability,shelf_id) values (?,?,?,?,?,?,?,?)";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1,textField.getText() );
					ptr.setString(2,textField_1.getText() );
					ptr.setString(3,textField_2.getText() );
					ptr.setString(4,textField_3.getText() );
					ptr.setString(5,textField_4.getText() );
					ptr.setString(6,textField_5.getText() );
					ptr.setString(7,textField_6.getText() );
					ptr.setString(8,textField_7.getText() );
					ptr.execute();
					
					
					JOptionPane.showMessageDialog(null, "Record Stored");
				
					refresh_book();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Record not Stored");
					e.printStackTrace();
				}
			}
		});
		btnAddBook.setIcon(new ImageIcon(getClass().getResource("/1471288850_sign-add (1).png")));
		btnAddBook.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnAddBook.setBounds(237, 185, 194, 43);
		panel_1.add(btnAddBook);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Update Details", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(453, 166, 139, 20);
		panel_2.add(textField_14);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(453, 134, 139, 20);
		panel_2.add(textField_13);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setBounds(354, 166, 78, 20);
		panel_2.add(lblAvailability);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(116, 101, 139, 20);
		panel_2.add(textField_9);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(453, 103, 139, 20);
		panel_2.add(textField_12);
		
		JLabel lblAuthorId_1 = new JLabel("Author Name");
		lblAuthorId_1.setForeground(Color.WHITE);
		lblAuthorId_1.setBounds(354, 101, 78, 23);
		panel_2.add(lblAuthorId_1);
		
		JLabel lblIsbn_1 = new JLabel("ISBN");
		lblIsbn_1.setForeground(Color.WHITE);
		lblIsbn_1.setBounds(28, 130, 78, 23);
		panel_2.add(lblIsbn_1);
		
		JLabel lblEdition_1 = new JLabel("Edition");
		lblEdition_1.setForeground(Color.WHITE);
		lblEdition_1.setBounds(28, 164, 78, 23);
		panel_2.add(lblEdition_1);
		
		JButton button = new JButton("Update");
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int action=JOptionPane.showConfirmDialog(null, "Do You Want to Update?","UPDATE",JOptionPane.YES_NO_CANCEL_OPTION);
				String str="update book set book_title='"+textField_9.getText()+"',isbn='"+textField_10.getText()+"',edition='"+textField_11.getText()+"',Author_Name='"+textField_12.getText()+"',publisher_id='"+textField_13.getText()+"',availability='"+textField_14.getText()+"' where book_id='"+textField_8.getText()+"'";
				PreparedStatement ptr=connection.prepareStatement(str);
				
				if(action==0)
				{
					ptr.execute();
					JOptionPane.showMessageDialog(null, "Record Updated");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Record not Updated");
				}
				
				refresh_book();
				
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon(getClass().getResource("/pencil-icon (1).png")));
		button.setBounds(270, 194, 120, 35);
		panel_2.add(button);
		
		JLabel lblBookName = new JLabel("Book Title");
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setBounds(28, 100, 78, 20);
		panel_2.add(lblBookName);
		
		JLabel lblPublisherId_1 = new JLabel("Publisher ID");
		lblPublisherId_1.setForeground(Color.WHITE);
		lblPublisherId_1.setBounds(354, 135, 78, 20);
		panel_2.add(lblPublisherId_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(116, 133, 139, 20);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(116, 164, 139, 20);
		panel_2.add(textField_11);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(Color.GRAY);
		label_1.setBounds(10, 86, 636, 153);
		panel_2.add(label_1);
		
		JLabel lblEnterBookId = new JLabel("Enter Book ID");
		lblEnterBookId.setForeground(Color.WHITE);
		lblEnterBookId.setBounds(107, 11, 78, 35);
		panel_2.add(lblEnterBookId);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int action=JOptionPane.showConfirmDialog(null, "Do You Want to Delete?","DELETE",JOptionPane.YES_NO_CANCEL_OPTION);
					String str="delete from book where book_id=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField_8.getText());
					
					if(action==0)
					{
						ptr.execute();
						JOptionPane.showMessageDialog(null, "Record Deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Record Not Deleted");
					}
					refresh_book();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong while Deleting");
					ex.printStackTrace();
				}
			}
		});
		btnDeleteBook.setIcon(new ImageIcon(getClass().getResource("/actions-window-close-icon (1).png")));
		btnDeleteBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteBook.setBounds(229, 53, 148, 24);
		panel_2.add(btnDeleteBook);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(195, 14, 219, 28);
		panel_2.add(textField_8);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="select * from book where book_id=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField_8.getText());
	
					ResultSet rs=ptr.executeQuery();
					
					int count=0;
					while(rs.next())
					{
						textField_9.setText(rs.getString("book_title"));
						textField_10.setText(rs.getString("ISBN"));
						textField_11.setText(rs.getString("edition"));
						textField_12.setText(rs.getString("Author_Name"));
						textField_13.setText(rs.getString("publisher_id"));
						textField_14.setText(rs.getString("availability"));
						count++;
					}
					if(count!=1)
					{
						JOptionPane.showMessageDialog(null, "Record not Exist");
					}
					
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Something Went Wrong while Searching");
					ex.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon(getClass().getResource("/1471284006_search_magnifying_g.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(443, 16, 95, 23);
		panel_2.add(button_1);
		
		JLabel lblBooksInformation = new JLabel("Books Information");
		lblBooksInformation.setForeground(Color.WHITE);
		lblBooksInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooksInformation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblBooksInformation.setBounds(181, 21, 388, 55);
		contentPane.add(lblBooksInformation);
		
		JLabel label = new JLabel("");
		label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black,8));
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(10, 11, 735, 413);
		contentPane.add(label);
		refresh_book();
	}
}
