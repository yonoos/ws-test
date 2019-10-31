package yc.jee.test.ws.rest.endpoint;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jboss")
public class HelloDates {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get")
	public DatesObject getDatesObject() {
		DatesObject d = new DatesObject();
		
		d.setLocalDateTime(LocalDateTime.now(ZoneId.of("Europe/Lisbon")));
		d.setSqlDate(new Date(System.currentTimeMillis()));
		d.setUtilDate(new GregorianCalendar().getTime());
		d.setSqlTimeStamp(new Timestamp(System.currentTimeMillis()));
		
		System.out.println(d);
		
		return d;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/p")
	public DatesObject getParamo(DatesObject date) {
		System.out.println(date);
		
		return date;
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/jboss")
	public String getParamo() {
		try {
			Class<?> clazz = Class.forName("younes.module.hello.Hello");
			
			Properties props = new Properties();
			InputStream is = HelloDates.class.getResourceAsStream("/hello.properties");
			props.load(is);
			
			
			Object object = clazz.newInstance();
			
			Method method = clazz.getMethod("hola");
			
			Object results = method.invoke(object);
			if(results != null) {
				return results.toString()+props.toString();
			} else {
				return clazz.getName();
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}


}
