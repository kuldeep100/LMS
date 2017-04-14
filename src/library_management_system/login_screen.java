package library_management_system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class login_screen extends JFrame {
	private JTextField txtLibraryManagementSystem;
	private JTextField txtUsername;
	private JTextField txtPass;
	private JTextField textField;
	private JPasswordField passwordField;
	private static login_screen frame;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new login_screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	Connection connection=null;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public login_screen() {
		setResizable(false);
		
		connection=login_database.dbConnector();
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		getContentPane().setBackground(Color.GRAY);
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		setBackground(Color.GRAY);
		setTitle("                                                                   Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 478);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String query="select * from '"+comboBox.getSelectedItem()+"' where Username=? and Password=?";
					PreparedStatement ptr=connection.prepareStatement(query);
					ptr.setString(1, textField.getText());
					ptr.setString(2, passwordField.getText());
					
					ResultSet rs=ptr.executeQuery();
					
					int count=0;
					
					while(rs.next())
					{
						count++;
					}
					
					if(count==1 && comboBox.getSelectedItem()=="admin")
					{
						JOptionPane.showMessageDialog(null, "Welcome Admin");
						frame.dispose();
						admin_panel ap=new admin_panel();
						ap.setVisible(true);
					}
					else if(count==1 && comboBox.getSelectedItem()=="student")
					{
						JOptionPane.showMessageDialog(null, "Welcome Student");
						frame.dispose();
						book_details ap=new book_details();
						ap.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Credentials");
					}
					
					ptr.close();
					rs.close();
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"admin", "student"}));
		comboBox.setBounds(231, 238, 203, 28);
		getContentPane().add(comboBox);
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnNewButton.setBounds(283, 397, 89, 23);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(231, 366, 203, 20);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(231, 302, 203, 20);
		getContentPane().add(textField);
		
		txtPass = new JTextField();
		txtPass.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtPass.setEditable(false);
		txtPass.setText("Password");
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtPass.setColumns(10);
		txtPass.setBackground(Color.LIGHT_GRAY);
		txtPass.setBounds(286, 335, 86, 20);
		getContentPane().add(txtPass);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsername.setEditable(false);
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtUsername.setBackground(Color.LIGHT_GRAY);
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBounds(286, 271, 86, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("NSimSun", Font.BOLD, 18));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(99, 224, 479, 201);
		label_1.setOpaque(true);
		getContentPane().add(label_1);
		
		txtLibraryManagementSystem = new JTextField();
		txtLibraryManagementSystem.setEditable(false);
		txtLibraryManagementSystem.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLibraryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		txtLibraryManagementSystem.setForeground(Color.WHITE);
		txtLibraryManagementSystem.setBackground(Color.DARK_GRAY);
		txtLibraryManagementSystem.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		txtLibraryManagementSystem.setText("Library Management System");
		txtLibraryManagementSystem.setBounds(99, 167, 479, 39);
		getContentPane().add(txtLibraryManagementSystem);
		txtLibraryManagementSystem.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(getClass().getResource("/1471269347_MB__LIBRARY.png")));
		label.setBounds(270, 32, 128, 128);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		label_1.setOpaque(true);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 11, 658, 427);
		getContentPane().add(lblNewLabel);
	}
}
