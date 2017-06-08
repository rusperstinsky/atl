package core.db;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class TransaccionesDB {

	
	public static String inserta( String tabla, List<String> lstColumnas, List<String> lstValores ){
		String error = "";
		String columnas = "";
		String valores = "";
		String sql = "";
		for(String columna : lstColumnas){
			columnas = columnas + "," + columna;
		}
		columnas = columnas.replaceFirst(",", "");
		for(String valor : lstValores){
			valores = valores + "," + "'" + valor + "'";
		}
		valores = valores.replaceFirst(",", "");
		sql = String.format("INSERT INTO %s (%s) VALUES(%s);",
       		 tabla, columnas, valores );
		System.out.println("SQL: " + sql);
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         stmt.executeUpdate(sql);	         
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	    	  error = e.getMessage();
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );	         
	      }
		 return error;
	}
	
	
	
	public static String actualiza( String tabla, List<String> lstColumnas, List<String> lstValores, String condicion ){
		String error = "";
		String valores = "";
		String sql = "";
		for(int i=0;i<lstColumnas.size();i++){
			valores = valores + "," + lstColumnas.get(i) + " = " + "'" + lstValores.get(i) + "'";
		}
		valores = valores.replaceFirst(",", "");
		sql = String.format("UPDATE %s SET %s WHERE %s;",
       		 tabla, valores, condicion );
		System.out.println("SQL: " + sql);
		 Connection con = core.db.Connection.connect();
		 Statement stmt = null;
		 try {
	         Class.forName("org.postgresql.Driver");
	         
	         stmt = con.createStatement();
	         stmt.executeUpdate(sql);	         
	         stmt.close();
	         con.close();
	      } catch ( Exception e ) {
	    	  error = e.getMessage();
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );	         
	      }
		 return error;
	}
	
	
}
