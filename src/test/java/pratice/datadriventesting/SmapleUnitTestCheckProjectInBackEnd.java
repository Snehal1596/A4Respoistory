

package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SmapleUnitTestCheckProjectInBackEnd {

	@Test
	
	public void projectCheckTest() throws SQLException  {
		String exceptedFirstName = "Snehal";
		boolean flag = false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
	    Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
          System.out.println("..........DONE.............");
          
         Statement stat= conn.createStatement();
         
         
         ResultSet resultset = stat.executeQuery("select * from employees");
         while (resultset.next()){
        	 String actFirstName = resultset.getString(3);
        	 if(exceptedFirstName.equals(actFirstName)) {
        		 flag = true;
        		System.out.println(exceptedFirstName + " is available==pass"); 
        	 }
         }
         
         if(flag==false) {
        	 System.out.println(exceptedFirstName + " is not available==pass");
        	 Assert.fail();
         }
         conn.close();
     }

}
