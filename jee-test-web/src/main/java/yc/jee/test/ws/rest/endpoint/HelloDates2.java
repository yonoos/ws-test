package yc.jee.test.ws.rest.endpoint;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dates")
public class HelloDates2 extends HelloDates {
	
	
	@Override
	public String getParamo() {
		return HelloDates2.class.getName();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String service1(@PathParam("id")  String id) {
		return id;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}/label/{id2}")
	public String service2(@PathParam("id")  String id1, @PathParam("id2") String  id2) {
		return id1+"   "+id2;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}/label3/{id2}")
	public Response service3(@PathParam("id")  String id1, @PathParam("id2") String  id2) {
		List<String> list = new LinkedList<>();
		list.add("text");
		list.add("aaaa");
		return Response.ok(list).build();
	}

}
