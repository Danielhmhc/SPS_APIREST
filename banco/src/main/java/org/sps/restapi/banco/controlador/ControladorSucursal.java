package org.sps.restapi.banco.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sps.restapi.banco.database.Database;
import org.sps.restapi.banco.modelos.ModeloSucursal;

public class ControladorSucursal {
	private Map<Integer , ModeloSucursal > sucursales = Database.getSucursales();
	
	


	public List<ModeloSucursal> getAllSucursales() {
		return new ArrayList<ModeloSucursal>(sucursales.values());
	}
	
	public ModeloSucursal getSucursal(int id) {
		return sucursales.get(id);
	}
	
	public ModeloSucursal addSucursal(ModeloSucursal suc) {
		suc.setId(sucursales.size() + 1);
		sucursales.put(suc.getId(), suc);
		return suc;
	}
	
	public ModeloSucursal updateSucursal(ModeloSucursal suc)  {
		if(suc.getId() <= 0) {
			return null;
		}
		sucursales.put(suc.getId(), suc);
		return suc;
	}


}
