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
	
	
	
	
	public static Boolean insertaPuestosXUsuario( Integer idPuesto, String transacciones ){
		Boolean valid = true;
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         	         
	         String sql = "";
	         if( validaPuestoXUsuario(idPuesto) ){
	        	 sql = String.format("INSERT INTO puestos_transacciones (id_puesto,transacciones) VALUES(%d,'%s');",
		        		 idPuesto, transacciones.trim() );
	         } else {
	        	 sql = String.format("UPDATE puestos_transacciones SET transacciones = '%s' WHERE id_puesto = %d;",
	        			 transacciones.trim(), idPuesto );
	         }
	         System.out.println(sql);
	         stmt = con.createStatement();
	         stmt.executeUpdate(sql);	         
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         valid = false;
	      }
		 return valid;
	}
	
	
	
	public static Boolean validaPuestoXUsuario( Integer idPuesto ){
		Boolean valid = true;
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM puestos_transacciones WHERE id_puesto = %d;",
	        		 idPuesto));	         
	         while ( rs.next() ) {
	        	 valid = false;	        	 
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );	         
	      }		 		
		  
		  return valid;
	}
	
	
	
	public static String obtieneTransaccionesXPuesto( Integer idPuesto ){
		String lstTransacciones = "";
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM puestos_transacciones WHERE id_puesto = %d;",
	        		 idPuesto));	         
	         while ( rs.next() ) {
	        	 lstTransacciones = rs.getString("transacciones");	        	 
	          }
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );	         
	      }		 		
		  
		  return lstTransacciones;
	}
	
	

}
