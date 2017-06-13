package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Puestos {

	private Integer idPuesto;
	private String descPuesto;
	private String idSync;
	private Date fechaMod;
	private String idMod;
	private Integer idSucursal;
	
	
	
	public Integer getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getDescPuesto() {
		return descPuesto;
	}
	public void setDescPuesto(String descPuesto) {
		this.descPuesto = descPuesto;
	}
	public String getIdSync() {
		return idSync;
	}
	public void setIdSync(String idSync) {
		this.idSync = idSync;
	}
	public Date getFechaMod() {
		return fechaMod;
	}
	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}
	public String getIdMod() {
		return idMod;
	}
	public void setIdMod(String idMod) {
		this.idMod = idMod;
	}
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}	
	
	
	public Puestos parse(ResultSet rs) throws SQLException{
		
		this.setIdPuesto(rs.getInt("id_puesto"));
		this.setDescPuesto(rs.getString("desc_puesto"));
		this.setIdSync(rs.getString("id_sync"));
		this.setFechaMod(rs.getDate("fecha_mod"));
		this.setIdMod(rs.getString("id_mod"));
		this.setIdSucursal(rs.getInt("id_sucursal"));
		return this;
	}
	
	
}
