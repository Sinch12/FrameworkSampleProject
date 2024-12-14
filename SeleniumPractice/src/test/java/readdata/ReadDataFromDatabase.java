package readdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		Driver  driverref = new Driver();  
DriverManager.registerDriver(driverref);
Connection con = DriverManager .getConnection("jdbc:mysql://localhost:3306/student", "root1", "root");
Statement stat =con.createStatement();
ResultSet rset =stat.executeQuery("select * from studenttable;");
while(rset.next()) {
	System.out.println(rset.getString(1)+"\t"+ rset.getString(2)+"\t"+rset.getString(3)+"\t"+ rset.getString(4)+"\t"+ rset.getString(5))  ;
}
rset.next(); 
con.close();
	
	}

}
