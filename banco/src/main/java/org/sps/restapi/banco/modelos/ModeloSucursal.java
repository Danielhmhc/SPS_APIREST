package org.sps.restapi.banco.modelos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ModeloSucursal {

	private int id;
	private String nombre;
	private String direccion;
	private Date actEstado;
	private String estado;
	private Map<Integer,ModeloCliente> clientes = new HashMap<>();
	
	
	public Map<Integer, ModeloCliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<Integer, ModeloCliente> clientes) {
		this.clientes = clientes;
	}

	public ModeloSucursal() {
		
	}
	
	public ModeloSucursal(int id, String nombre, String direccion, Date actEstado, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.actEstado = actEstado;
		this.estado = estado;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getActEstado() {
		return actEstado;
	}
	public void setActEstado(Date actEstado) {
		this.actEstado = actEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
