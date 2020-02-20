package org.sps.restapi.banco.recursos;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sps.restapi.banco.controlador.ControladorSucursal;

import org.sps.restapi.banco.modelos.ModeloSucursal;

@Path("/sps/helloworld/v1/sucursales")
public class SucursalRecurso {
	
	ControladorSucursal sc = new ControladorSucursal();
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ModeloSucursal> getAllSucursales()  {
		return new ArrayList<ModeloSucursal>(sc.getAllSucursales());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sucursalId}")
	public ModeloSucursal getSucursal(@PathParam("sucursalId") int id) {
		return sc.getSucursal(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSucursal(ModeloSucursal sucursal,@Context UriInfo uriInfo) {
		ModeloSucursal sucagr =sc.addSucursal(sucursal);
		String newId = String.valueOf(sucagr.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(sucagr)
				.build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sucursalId}")
	public ModeloSucursal updateSucursal(@PathParam("sucursalId") int id, ModeloSucursal suc) {
		suc.setId(id);
		return sc.updateSucursal(suc);
	}
	
	@Path("/{sucursalId}/clientes")
	public ClienteRecurso getRecursosClientes() {
		return new ClienteRecurso();
	}
	
		
}
