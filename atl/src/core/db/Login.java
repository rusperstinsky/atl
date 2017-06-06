package core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;

import model.EmpAdmin;

public class Login {

	
	public static Boolean verificaCredenciales( String usuario, String pass ){
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 EmpAdmin empAdmin = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM emp_adm WHERE id_emp = %d AND pass = %s;",
	        		 NumberFormat.getInstance().parse(usuario), pass.trim() ));
	         empAdmin = new EmpAdmin();
	         while ( rs.next() ) {
	             empAdmin = empAdmin.parse(rs);
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
		 return empAdmin != null;
	}
	
}