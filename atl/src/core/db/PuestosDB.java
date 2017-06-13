package core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Puestos;
import model.PuestosTransacciones;

public class PuestosDB {
	
	
	public static List<Puestos> obtienePuestos( ){
		List<Puestos> puestos = new ArrayList<Puestos>();
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM puestos;"));	         
	         while ( rs.next() ) {
	        	 Puestos puesto = new Puestos();
	        	 puestos.add( puesto.parse(rs) );	        	 
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );	         
	      }		 		
		  
		  return puestos;
	}
	
	
	
	public static Boolean insertaUsuario( Integer idPuesto, String nombre, String pass, Integer idEmp ){
		Boolean valid = true;
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         stmt.executeUpdate(String.format("INSERT INTO emp_call_center (id_puesto,nombre,pass,id_emp) VALUES(%d,'%s','%s',%d);",
	        		 idPuesto, nombre.trim(), pass.trim(), idEmp ));	         
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         valid = false;
	      }
		 return valid;
	}
	
	

}
