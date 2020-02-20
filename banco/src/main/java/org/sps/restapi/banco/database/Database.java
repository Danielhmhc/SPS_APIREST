package org.sps.restapi.banco.database;

import java.util.HashMap;
import java.util.Map;

import org.sps.restapi.banco.modelos.*; 
//Esta clase como tal no es la conexion a ninguna base de datos, si no a mapas hash que permiten
//las operaciones tipicas de un crud y fue implementado asi por cuestiones de tiempo

//SIN EMBARGO Ya para un proyecto real, se puede cambiar facilmente esta clase para usar algun tipo de bases de datos
public class Database {

	private static Map< Integer ,ModeloSucursal > sucursales = new HashMap<>();

	
	public static Map<Integer, ModeloSucursal> getSucursales() {
		return sucursales;
	}
	
}
