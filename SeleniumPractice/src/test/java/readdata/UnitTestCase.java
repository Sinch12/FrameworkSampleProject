/*package readdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class UnitTestCase {

	@Test 
	public void ProjectCheckTest() throws Throwable {
		String expectedname = "AaBC";
		boolean flag = false;
		Driver  driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager .getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		Statement stat =con.createStatement();
		ResultSet rset =stat.executeQuery("select * from studenttable;");
		while(rset.next()) {
			String actualname = rset.getString(2);
			if(expectedname.equals(actualname)) {
				flag = true;
				System.out.println(expectedname + "is available");
			}
		}
		if(flag==false) {
			System.out.println(expectedname + "is not available");
			  Assert.fail();
		}
		
		rset.next(); 
		con.close();
	}

	

}*/
