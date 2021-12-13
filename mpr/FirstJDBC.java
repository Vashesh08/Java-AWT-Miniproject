package mpr;
import java.sql.*;
public class FirstJDBC {
	
	
	final String url ="jdbc:mysql://localhost:3306/Newarkstore";
	final String username="root";
	
	
	 public Connection connectDB()  {
		
		 
		 Connection con=null;
		 
		 
		 try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String password ="B@rcelona123";
			
					
					 con= DriverManager.getConnection(url,username,password);
					if(con.isClosed())
					{
						System.out.println("Connection closes");
						
					}
					else
					{
						System.out.println("Connection done");
					}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

}
