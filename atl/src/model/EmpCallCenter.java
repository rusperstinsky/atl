package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpCallCenter {

	Integer id;
	Integer idPuesto;
	String nombre;
	String pass;
	Integer idEmp;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(Integer idEmp) {
		this.idEmp = idEmp;
	}
	
	
	
	
public EmpCallCenter parse( ResultSet rs ) throws SQLException{
		
		this.id = rs.getInt("id");
		this.idPuesto = rs.getInt("id_puesto");
		this.nombre = rs.getString("nombre");
		this.pass = rs.getString("pass");
		this.idEmp = rs.getInt("id_emp");
		return this;
	}
}
