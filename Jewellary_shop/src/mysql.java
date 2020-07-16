import java.sql.*;
import javax.swing.*;
public class mysql {
	Connection conn=null;
	public static Connection dbconnector()
	{
		try
		{
			String url="jdbc:mysql://127.0.0.1:3306/jewell_shop";
			 String driver="com.mysql.jdbc.Driver";
			 String uname="root";
			 String pass="tikiparteek123@";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,uname,pass);
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
			} 
	}
}
