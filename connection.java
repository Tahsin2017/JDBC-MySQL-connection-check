import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ora_DBTest_Demo {

	public ora_DBTest_Demo (){
		
	}

	public Connection testconnection_mysql () {        
        Connection connect = null;
		try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");		      
		      
		      /**
		       * LOCALHOST	
		       * Change your database name, user and password	      
		       */
	    	 
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYDB?"+ "user=user&password=password" + "&verifyServerCertificate=false&requireSSL=false&useSSL=false");
		      
		      
		      
		      currentTime(connect);
		      
		      return connect;
	    	  
		}catch(Exception e) {
			System.out.println("Could not create connection");
			
			return null;
		}
	}
	
	/**
	 * A Method to fetch the current time of the database
	 * @param connect
	 */
	public static void currentTime(Connection connect) {
		 		
		String qry1a = "SELECT NOW()";
	      		
		String curTime = "";
		
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(qry1a);
   	  
			ResultSet r1=preparedStatement.executeQuery();
   	  
			System.out.print("The current date and time is: ");
   	  
   	  		while(r1.next()) {
   	  			System.out.println(r1.getString(1));
   	  			curTime = r1.getString(1);
   	  		}
		}catch(Exception e) {
   		  System.out.println("Cannot update the time");
   	  }  
	}
}




