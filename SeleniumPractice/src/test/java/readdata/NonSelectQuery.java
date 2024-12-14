package readdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws SQLException {
		Driver  driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager .getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement stat =con.createStatement();
		int result = stat.executeUpdate("insert into studenttable values('1','abcd','4th','8','davangere');");
		System.out.println(result);
		
		//rset.next(); 
		con.close();
	}
  
}
