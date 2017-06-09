package core.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;

public class Connection {

	public static java.sql.Connection connect( ){
		java.sql.Connection c = null;
	    try {
	       Class.forName("org.postgresql.Driver");
	       c = DriverManager.getConnection(getDbProperties("url"),getDbProperties("username"), getDbProperties("password"));
	    } catch (Exception e) {
	       e.printStackTrace();
	       System.err.println(e.getClass().getName()+": "+e.getMessage());
	       System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    return c;
	}
    
	private static String getDbProperties( String data ) throws FileNotFoundException, IOException{
		String result = "";
		FileReader f = new FileReader(new File("database.properties"));
	    BufferedReader b = new BufferedReader(f);
	    while((result = b.readLine())!=null) {
	      if( result != null && result.trim().startsWith(data) ){
	    	  break;
	      }
	    }
	    b.close();
		return result.replace(data.trim()+"=", "");
	}
	
}
