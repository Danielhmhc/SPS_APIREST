package org.sps.restapi.banco.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sps.restapi.banco.database.Database;
import org.sps.restapi.banco.modelos.ModeloCliente;
import org.sps.restapi.banco.modelos.ModeloSucursal;

public class ControladorCliente {

	private Map<Integer , ModeloSucursal > sucursales = Database.getSucursales();
	
	public List<ModeloCliente> getAllclientes(int sucursalId) {
		Map<Integer,ModeloCliente> clientes = sucursales.get(sucursalId).getClientes();
		return new ArrayList<ModeloCliente>(clientes.values());
	}
	
	public ModeloCliente getClientes(int sucursalId,int clienteId) {
		Map<Integer,ModeloCliente> clientes = sucursales.get(sucursalId).getClientes();
		return clientes.get(clienteId);
	}
	
	public List<ModeloCliente> getClientesForName(int sucursalId ,String nombre){
		Map<Integer,ModeloCliente> clientes = sucursales.get(sucursalId).getClientes();
		List<ModeloCliente> clientesForName = new ArrayList<>();
		Pattern patron = Pattern.compile(".*" + nombre + ".*" , Pattern.CASE_INSENSITIVE);
		for(ModeloCliente cli : clientes.values()) {
			Matcher comparador = patron.matcher(cli.getNombre());
			if(comparador.find())
				clientesForName.add(cli);
		}
		return clientesForName;
		
	}
	
	
	public ModeloCliente addCliente(int sucursalId, ModeloCliente cli) {
		Map<Integer,ModeloCliente> clientes = sucursales.get(sucursalId).getClientes();
		cli.setId(clientes.size() + 1);
		clientes.put(cli.getId(), cli);
		return cli;
	}
	
	public ModeloCliente updateCliente(int sucursalId, ModeloCliente cli)  {
		Map<Integer,ModeloCliente> clientes = sucursales.get(sucursalId).getClientes();
		if(cli.getId() <= 0) {
			return null;
		}
		clientes.put(cli.getId(), cli);
		return cli;
	}
	
	public ModeloCliente deleteCliente(int sucursalId, int id ) {
		Map<Integer,ModeloCliente> clientes = sucursales.get(sucursalId).getClientes();
		return clientes.remove(id);
	}
}
