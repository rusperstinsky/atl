package core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import model.EmpCallCenter;

public class Tables {

	public static List<String> verificaTabla( String tabla ){
		List<String> campos = new ArrayList<String>();
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT column_name FROM information_schema.columns WHERE table_name = '%s';",
	        		 tabla.trim() ));	         
	         while ( rs.next() ) {
	        	 campos.add( rs.getString("column_name") );	        	 
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }		 		
		  
		  return campos;
	}
	
	
	public static void insertaTablaEdit( String tabla ){
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         stmt.executeUpdate(String.format("INSERT INTO tablas_edit (tabla) VALUES('%s');",
	        		 tabla.trim() ));	         
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }		 				 		 
	}
	
	
	public static Boolean validaTablaEdit( String tabla ){
		Boolean valida = true;
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM tablas_edit WHERE table_name = '%s';",
	        		 tabla.trim() ));	         
	         while ( rs.next() ) {
	        	 valida = false;	        	 
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }		 		
		  
		  return valida;
	}
	
	
}
