package core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;

import model.EmpAdmin;
import model.EmpCallCenter;

public class Login {

	
	public static Boolean verificaCredenciales( String usuario, String pass ){
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 EmpCallCenter empCallCenter = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM emp_call_center WHERE id_puesto = %d AND pass = '%s';",
	        		 NumberFormat.getInstance().parse(usuario), pass.trim() ));
	         empCallCenter = new EmpCallCenter();
	         while ( rs.next() ) {
	        	 empCallCenter = empCallCenter.parse(rs);
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
		 if( empCallCenter.getId() != null ){
			 
		 } else {
			 empCallCenter = null;
		 }
		 return empCallCenter != null;
	}
	
}
