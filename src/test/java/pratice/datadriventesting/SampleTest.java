package pratice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
	    Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
          System.out.println("..........DONE.............");
          
         Statement stat= conn.createStatement();
         
         
         ResultSet resultset = stat.executeQuery("select * from employees");
         while (resultset.next()){
        	 System.out.println(resultset.getString(1) + "\t" + resultset.getString(2));
         }
         conn.close();
     }

}
