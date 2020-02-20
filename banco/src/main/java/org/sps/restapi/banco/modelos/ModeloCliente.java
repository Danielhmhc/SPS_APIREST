package org.sps.restapi.banco.modelos;

import java.util.Date;

public class ModeloCliente {

	private int id;
	private String nombre;
	private Date fecharegistro;
	private String ocupacion;
	private String ingresomensual;
	
	public ModeloCliente() {
		
	}
	
	public ModeloCliente(int id, String nombre, Date fecharegistro, String ocupacion, String ingresomenusal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecharegistro = fecharegistro;
		this.ocupacion = ocupacion;
		this.ingresomensual = ingresomenusal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public String getIngresomensual() {
		return ingresomensual;
	}
	public void setIngresomensual(String ingresomenusal) {
		this.ingresomensual = ingresomenusal;
	}
	
	
}
