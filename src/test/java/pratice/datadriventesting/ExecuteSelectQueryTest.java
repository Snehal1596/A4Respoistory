package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
	      conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
          System.out.println("..........DONE.............");
          
         Statement stat= conn.createStatement();
         
         
         ResultSet resultset = stat.executeQuery("select * from employees");
         while (resultset.next()){
        	 System.out.println(resultset.getString(1) + "\t" + resultset.getString(2));
         }
	  }catch (Exception e) {
		  System.out.println("handled the exception");
	  }finally {
	         conn.close();
	         System.out.println("Close the Connection");
	  }
		
    }

}
