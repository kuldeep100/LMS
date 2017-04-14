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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JPasswordField;
public class student_information extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTextField textField_8;
	private JTextField textField_11;
	JComboBox comboBox;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_information frame = new student_information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refresh_student()
	{
		try
		{
			String query="select * from student ";
			PreparedStatement ptr=connection.prepareStatement(query);
			ResultSet rs=ptr.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Something went wrong while Refreshing");
			ex.printStackTrace();
		}
		
	}
	
	
	
	Connection connection=null;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	
	
	/**
	 * Create the frame.
	 */
	public student_information() {
		connection=login_database.dbConnector();
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/1471282656_Graduate-male-24.png")));
		setTitle("Student Information");
		setResizable(false);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 478);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin_panel ap=new admin_panel();
				ap.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setIcon(new ImageIcon(getClass().getResource("/1471291689_restart-1 (1).png")));
		btnNewButton_2.setBounds(601, 392, 102, 29);
		contentPane.add(btnNewButton_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(42, 87, 661, 294);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Add New Student", null, panel, null);
		panel.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"}));
		comboBox_1.setBounds(476, 28, 139, 28);
		panel.add(comboBox_1);
		
		JLabel lblStudentId = new JLabel("Student  ID");
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setBounds(55, 21, 78, 35);
		panel.add(lblStudentId);
		
		JLabel lblFirstName = new JLabel("First  Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(55, 72, 78, 35);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last  Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(55, 118, 78, 35);
		panel.add(lblLastName);
		
		textField = new JTextField();
		textField.setBounds(146, 28, 139, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 75, 139, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 121, 139, 28);
		panel.add(textField_2);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setBounds(377, 21, 78, 35);
		panel.add(lblSemester);
		
		JLabel lbl = new JLabel("Username");
		lbl.setForeground(Color.WHITE);
		lbl.setBounds(377, 67, 78, 35);
		panel.add(lbl);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(377, 118, 78, 35);
		panel.add(lblPassword);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(476, 72, 139, 28);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="insert into student (Student_ID,First_Name,Last_Name,Semester,Username,Password) values (?,?,?,?,?,?)";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1, textField.getText());
					ptr.setString(2, textField_1.getText());
					ptr.setString(3,textField_2.getText());
					ptr.setString(4,(String)comboBox_1.getSelectedItem());
					ptr.setString(5,textField_4.getText());
					ptr.setString(6, passwordField.getText());
					
					ptr.execute();
					
					ptr.close();
					JOptionPane.showMessageDialog(null, "Record added");
					refresh_student();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Record already Exists");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/1471288850_sign-add (1).png")));
		btnNewButton.setBounds(241, 197, 194, 43);
		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(476, 121, 139, 28);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("View Details", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 636, 140);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(189, 28, 41, 35);
		lblSearch.setForeground(Color.WHITE);
		panel_1.add(lblSearch);
		
		textField_5 = new JTextField();
		textField_5.setBounds(240, 31, 219, 28);
		textField_5.setColumns(10);
		panel_1.add(textField_5);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String str="Select * from Student where Student_ID=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1,textField_5.getText());
					ResultSet rs=ptr.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Something Went Wrong while Searching");
				}
				
			}
		});
		btnSearch.setBounds(488, 33, 95, 23);
		btnSearch.setIcon(new ImageIcon(getClass().getResource("/1471284006_search_magnifying_g.png")));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnSearch);
		
		JButton btnRefreshTable = new JButton("Refresh");
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="select * from student where Student_ID=? ";
					PreparedStatement ptr=connection.prepareStatement(query);
					ptr.setString(1,textField_5.getText() );
					ResultSet rs=ptr.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					refresh_student();
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong while Displaying Data");
					ex.printStackTrace();
				}
			}
		});
		btnRefreshTable.setBounds(304, 71, 89, 23);
		btnRefreshTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnRefreshTable);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Update Details", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String str="update student set First_Name='"+textField_8.getText()+"',Last_Name='"+textField_11.getText()+"',Username='"+textField_9.getText()+"',Password='"+passwordField_1.getText()+"' where Student_ID='"+textField_6.getText()+"'";
					PreparedStatement ptr=connection.prepareStatement(str);
					int action=JOptionPane.showConfirmDialog(null, "Do you want to update?","Update",JOptionPane.YES_NO_CANCEL_OPTION);
					if(action==0)
					{
						ptr.execute();
						JOptionPane.showMessageDialog(null, "Record updated");
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "Record not updated");
					}
					refresh_student();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Errow while updating");
					ex.printStackTrace();
				}
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(116, 180, 139, 20);
		panel_2.add(textField_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(453, 149, 139, 20);
		panel_2.add(passwordField_1);
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/pencil-icon (1).png")));
		btnNewButton_1.setBounds(270, 210, 120, 35);
		panel_2.add(btnNewButton_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(116, 149, 139, 20);
		panel_2.add(textField_11);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(116, 117, 139, 20);
		panel_2.add(textField_8);
		
		JLabel lblEnterId = new JLabel("Enter Id");
		lblEnterId.setForeground(Color.WHITE);
		lblEnterId.setBounds(116, 11, 78, 35);
		panel_2.add(lblEnterId);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(204, 14, 219, 28);
		panel_2.add(textField_6);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.setIcon(new ImageIcon(getClass().getResource("/actions-window-close-icon (1).png")));
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action=JOptionPane.showConfirmDialog(null, "Do You want to Delete?","DELETE",JOptionPane.YES_NO_CANCEL_OPTION);
				if(action==0)
				{
					try
					{
						String str="delete from Student where Student_ID='"+textField_6.getText()+"'";
						PreparedStatement ptr=connection.prepareStatement(str);
						ptr.execute();
						
						JOptionPane.showMessageDialog(null, "Record deleted");
						refresh_student();
						
					}catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "something went wrong while deleting");
						ex.printStackTrace();
					}}
			}
		});
		btnDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteStudent.setBounds(236, 53, 167, 23);
		panel_2.add(btnDeleteStudent);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					String str="Select * from Student where Student_ID=?";
					PreparedStatement ptr=connection.prepareStatement(str);
					ptr.setString(1,textField_6.getText());
					ResultSet rs=ptr.executeQuery();
					int count=0;
					while(rs.next())
					{
						textField_8.setText(rs.getString("First_Name"));
						textField_11.setText(rs.getString("Last_Name"));
						textField_3.setText(rs.getString("Semester"));
						passwordField_1.setText(rs.getString("Password"));
						textField_9.setText(rs.getString("Username"));
						count++;
					}
					if(count!=1)
					{
						JOptionPane.showMessageDialog(null, "Record not Exist");
					}
					rs.close();
					ptr.close();
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		button_1.setIcon(new ImageIcon(getClass().getResource("/1471284006_search_magnifying_g.png")));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(452, 16, 95, 23);
		panel_2.add(button_1);
		
		JLabel label_3 = new JLabel("Semester");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(28, 180, 78, 23);
		panel_2.add(label_3);
		
		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setForeground(Color.WHITE);
		lblFirstName_1.setBounds(28, 116, 78, 20);
		panel_2.add(lblFirstName_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(354, 117, 78, 23);
		panel_2.add(lblUsername);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(453, 119, 139, 20);
		panel_2.add(textField_9);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(354, 151, 78, 20);
		panel_2.add(label_6);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setForeground(Color.WHITE);
		lblLastName_1.setBounds(28, 146, 78, 23);
		panel_2.add(lblLastName_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.GRAY);
		label_1.setOpaque(true);
		label_1.setBounds(10, 102, 636, 153);
		panel_2.add(label_1);
		
		JLabel lblStudentUser = new JLabel("Student / User Information");
		lblStudentUser.setForeground(Color.WHITE);
		lblStudentUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentUser.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStudentUser.setBounds(138, 26, 462, 62);
		contentPane.add(lblStudentUser);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setBounds(10, 11, 752, 427);
		label.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black,8));
		contentPane.add(label);
		refresh_student();
	}
}
