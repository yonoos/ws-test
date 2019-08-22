package yc.jee.test.ws.rest.endpoint;

import javax.ws.rs.Path;

@Path("/dates")
public class HelloDates2 extends HelloDates {
	
	@Override
	public String getParamo() {
		return HelloDates2.class.getName();
	}

}
