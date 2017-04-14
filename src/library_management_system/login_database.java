package library_management_system;

import java.sql.*;
import javax.swing.*;

public class login_database {
		
		Connection con=null;
		public static Connection dbConnector()
		{
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite::resource:user_database.sqlite");
				//JOptionPane.showMessageDialog(null, "connection established");
				return con;
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Connection not established");
				return null;
			}
		}
}
