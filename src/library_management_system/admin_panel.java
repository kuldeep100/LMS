package library_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings({ "unused", "serial" })
public class admin_panel extends JFrame {

	private JPanel contentPane;
	private static admin_panel frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new admin_panel();
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
	public admin_panel() {
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/1471282989_Library.png")));
		setResizable(false);
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 670);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBorrowBooks = new JButton("Borrow Books");
		btnBorrowBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				borrow_books bb=new borrow_books();
				bb.setVisible(true);
			}
		});
		
		JButton btnStudentInfo = new JButton("Student Info");
		btnStudentInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					student_information si=new student_information();
					dispose();
					
					si.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnStudentInfo.setBounds(95, 486, 128, 23);
		contentPane.add(btnStudentInfo);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(getClass().getResource("/1471284462_books.png")));
		label_8.setBounds(604, 344, 128, 133);
		contentPane.add(label_8);
		btnBorrowBooks.setBounds(604, 486, 128, 23);
		contentPane.add(btnBorrowBooks);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setBounds(537, 321, 225, 200);
		contentPane.add(label_9);
	
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(getClass().getResource("/1471282989_Library.png")));
		label_4.setBounds(344, 344, 118, 133);
		contentPane.add(label_4);
		
		JButton btnCollectionOfBooks = new JButton("Collection of Books");
		btnCollectionOfBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				collection_of_books cob=new collection_of_books();
				cob.setVisible(true);
			}
		});
		btnCollectionOfBooks.setBounds(324, 486, 151, 23);
		contentPane.add(btnCollectionOfBooks);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(true);
		label_5.setBounds(295, 321, 225, 200);
		contentPane.add(label_5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/1471282656_Graduate-male-24.png")));
		lblNewLabel_2.setBounds(95, 342, 118, 133);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(46, 321, 225, 200);
		label_3.setOpaque(true);
		contentPane.add(label_3);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login_screen ls=new login_screen();
				ls.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnNewButton.setBounds(357, 572, 118, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryManagementSystem.setForeground(Color.WHITE);
		lblLibraryManagementSystem.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblLibraryManagementSystem.setBounds(176, 534, 479, 39);
		contentPane.add(lblLibraryManagementSystem);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(33, 309, 735, 222);
		label_2.setOpaque(true);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setBounds(24, 296, 755, 245);
		label_1.setOpaque(true);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("Departmental Library Admin Panel");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(176, 246, 479, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(getClass().getResource("/bibliografia (2).png")));
		label.setBounds(316, 25, 172, 215);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black,8));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(10, 11, 784, 612);
		contentPane.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
	}

}
