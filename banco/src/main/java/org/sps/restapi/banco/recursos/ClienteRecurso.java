package org.sps.restapi.banco.recursos;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sps.restapi.banco.controlador.ControladorCliente;
import org.sps.restapi.banco.modelos.ModeloCliente;

@Path("/")
public class ClienteRecurso {
ControladorCliente cc = new ControladorCliente();
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ModeloCliente> getAllCliente(@PathParam("sucursalId") int suc,@QueryParam("nombre") String nombre) {
		if(nombre == null)
			return new ArrayList<ModeloCliente>(cc.getAllclientes(suc));
		if(!nombre.isEmpty())
			return cc.getClientesForName(suc,nombre);
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{clienteId}")
	public ModeloCliente getCliente(@PathParam("sucursalId") int suc, @PathParam("clienteId") int id) {
		return cc.getClientes(suc,id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCliente(@PathParam("sucursalId") int suc,ModeloCliente cli, @Context UriInfo uriInfo) {
		ModeloCliente cliagr =cc.addCliente(suc,cli);;
		String newId = String.valueOf(cliagr.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(cliagr)
				.build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{clienteId}")
	public ModeloCliente updateCliente(@PathParam("sucursalId") int suc,@PathParam("clienteId") int id, ModeloCliente cli) {
		cli.setId(id);
		return cc.updateCliente(suc,cli);
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{clienteId}")
	public void deleteCliente(@PathParam("sucursalId") int suc,@PathParam("clienteId") int id) {
		cc.deleteCliente(suc,id);
	}
		

}
