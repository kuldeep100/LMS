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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
@SuppressWarnings({ "unused", "serial" })
public class borrow_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrow_books frame = new borrow_books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void refresh_borrow()
	{
		try
		{
			String str="select * from borrow";
			PreparedStatement ptr=connection.prepareStatement(str);
			ResultSet rs=ptr.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e)
		{
			//e.printStackTrace();
		}
	}
	
	public void refresh_borrow1()
	{
		try
		{
			String str="select * from borrow";
			PreparedStatement ptr=connection.prepareStatement(str);
			ResultSet rs=ptr.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch(Exception e)
		{
			//e.printStackTrace();
		}
	}
	
	Connection connection=null;
	private JTable table;
	private JTable table_1;
	/**
	 * Create the frame.
	 */
	public borrow_books() {
		connection=login_database.dbConnector();
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/1471351709_book.png")));
		setTitle("Book Borrow");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(Color.DARK_GRAY);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 96, 797, 401);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Borrow Book", null, panel, null);
		panel.setLayout(null);
		
		JButton btnStudentTable = new JButton("Student Table");
		btnStudentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_information si=new student_information();
				si.setVisible(true);
				si.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnStudentTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStudentTable.setBounds(48, 103, 125, 23);
		panel.add(btnStudentTable);
		
		JLabel lblBookTitle = new JLabel("Book ID");
		lblBookTitle.setForeground(Color.WHITE);
		lblBookTitle.setBounds(405, 118, 107, 25);
		panel.add(lblBookTitle);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setBounds(405, 45, 107, 25);
		panel.add(lblStudentId);
		
		JLabel lblDateOfBorrow = new JLabel("Date of Borrow");
		lblDateOfBorrow.setForeground(Color.WHITE);
		lblDateOfBorrow.setBounds(405, 190, 107, 25);
		panel.add(lblDateOfBorrow);
		
		JLabel lblBookTitle_1 = new JLabel("Book Title");
		lblBookTitle_1.setForeground(Color.WHITE);
		lblBookTitle_1.setBounds(405, 153, 107, 25);
		panel.add(lblBookTitle_1);
		
		JLabel lblDateOfReturn = new JLabel("Date of Return");
		lblDateOfReturn.setForeground(Color.WHITE);
		lblDateOfReturn.setBounds(405, 226, 107, 25);
		panel.add(lblDateOfReturn);
		
		JLabel lblBookId_1 = new JLabel("Student Name");
		lblBookId_1.setForeground(Color.WHITE);
		lblBookId_1.setBounds(405, 81, 107, 25);
		panel.add(lblBookId_1);
		
		JLabel label_10 = new JLabel("");
		label_10.setOpaque(true);
		label_10.setBounds(560, 226, 166, 25);
		panel.add(label_10);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(true);
		label_8.setBounds(560, 153, 166, 25);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setBounds(560, 190, 166, 25);
		panel.add(label_9);
		
		JLabel label_7 = new JLabel("");
		label_7.setOpaque(true);
		label_7.setBounds(560, 118, 166, 25);
		panel.add(label_7);
		
		JLabel label_6 = new JLabel("");
		label_6.setOpaque(true);
		label_6.setBounds(560, 81, 166, 25);
		panel.add(label_6);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(true);
		label_5.setBounds(560, 45, 166, 25);
		panel.add(label_5);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="insert into borrow (borrower_id, borrower_name, book_id, book_title, date_of_issue, date_of_return) values (?,?,?,?,?,?)";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, label_5.getText());
					ptr.setString(2, label_6.getText());
					ptr.setString(3, label_7.getText());
					ptr.setString(4, label_8.getText());
					ptr.setString(5, label_9.getText());
					ptr.setString(6, label_10.getText());
					
					ptr.execute();
					
					JOptionPane.showMessageDialog(null, "Sucessfully Issued!!!!");
					refresh_borrow();
					refresh_borrow1();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrow.setBounds(638, 307, 107, 26);
		panel.add(btnBorrow);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(383, 11, 12, 351);
		panel.add(label_1);
		
		JButton btnBookTable = new JButton("Book Table");
		btnBookTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				collection_of_books cob=new collection_of_books();
				cob.setVisible(true);
				cob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnBookTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBookTable.setBounds(48, 258, 125, 23);
		panel.add(btnBookTable);
		
		JButton btnGetBook = new JButton("Get Book");
		btnGetBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="select * from book where book_id=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField_1.getText());
					
					ResultSet rs=ptr.executeQuery();
					
					int count=0;
					while(rs.next())
					{
						label_7.setText(rs.getString("book_id"));
						label_8.setText(rs.getString("book_title"));
						count++;
					}
					
					if(count!=1)
					{
						JOptionPane.showMessageDialog(null, "Book not Exist");
					}
					
					Calendar cal=new GregorianCalendar();
					
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					label_9.setText(day+"/0"+(month+1)+"/"+year);
					
					label_10.setText((day+10)+"/0"+(month+1)+"/"+(year));
					refresh_borrow();
					refresh_borrow1();
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnGetBook.setIcon(new ImageIcon(getClass().getResource("/1471284006_search_magnifying_g.png")));
		btnGetBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGetBook.setBounds(183, 258, 133, 23);
		panel.add(btnGetBook);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setBounds(48, 190, 78, 35);
		panel.add(lblBookId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(48, 219, 268, 28);
		panel.add(textField_1);
		
		JButton btnGetStudent = new JButton("Get Student");
		btnGetStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="select * from student where Student_ID=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField.getText());
					
					ResultSet rs=ptr.executeQuery();
					int count=0;
					while(rs.next())
					{
						label_5.setText(rs.getString("Student_ID"));
						label_6.setText(rs.getString("first_name"));
						count++;
					}
					if(count!=1)
					{
						JOptionPane.showMessageDialog(null, "Record not exist");
					}
					refresh_borrow();
					refresh_borrow1();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnGetStudent.setIcon(new ImageIcon(getClass().getResource("/1471284006_search_magnifying_g.png")));
		btnGetStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGetStudent.setBounds(185, 103, 131, 23);
		panel.add(btnGetStudent);
		
		JLabel label_2 = new JLabel("Student ID");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(48, 35, 78, 35);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(48, 64, 268, 28);
		panel.add(textField);
		
		JLabel label_3 = new JLabel("");
		label_3.setBorder(javax.swing.BorderFactory.createLineBorder(Color.lightGray,8));
		label_3.setOpaque(true);
		label_3.setBackground(Color.DARK_GRAY);
		label_3.setBounds(10, 11, 772, 351);
		panel.add(label_3);
		
		JButton button_2 = new JButton("Get Student");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_2.setBounds(48, 292, 125, 23);
		panel.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Borrowers List", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 772, 351);
		panel_1.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Return Book", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnReturned = new JButton("Returned");
		btnReturned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String str="delete from borrow where borrower_id=? ";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField_2.getText());
					ptr.execute();
					refresh_borrow();
					refresh_borrow1();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 772, 280);
		panel_2.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		btnReturned.setIcon(new ImageIcon(getClass().getResource("/1471462016_clean (1).png")));
		btnReturned.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReturned.setBounds(662, 318, 120, 26);
		panel_2.add(btnReturned);
		
		textField_2 = new JTextField();
		textField_2.setBounds(472, 318, 170, 26);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEnterBorrower = new JLabel("Enter Borrower ID");
		lblEnterBorrower.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterBorrower.setForeground(Color.WHITE);
		lblEnterBorrower.setBounds(333, 319, 129, 25);
		panel_2.add(lblEnterBorrower);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				admin_panel ap=new admin_panel();
				ap.setVisible(true);

			}
		});
		button.setIcon(new ImageIcon(getClass().getResource("/1471291689_restart-1 (1).png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(713, 508, 107, 26);
		contentPane.add(button);
		
		JLabel lblBookBorrow = new JLabel("Book Borrow");
		lblBookBorrow.setBounds(192, 27, 453, 66);
		lblBookBorrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookBorrow.setForeground(Color.WHITE);
		lblBookBorrow.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		contentPane.add(lblBookBorrow);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 844, 540);
		label.setOpaque(true);
		label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black,8));
		label.setBackground(Color.GRAY);
		contentPane.add(label);
		refresh_borrow();
		refresh_borrow1();
	}
}
