package yc.jee.test.ws.rest.filter;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class BearerTokenFilter implements ContainerRequestFilter {
	
	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println(requestContext.getPropertyNames());
		System.out.println(requestContext.getUriInfo().getPath());
		Method resourceMethod = resourceInfo.getResourceMethod();
		if(resourceMethod != null) {
			System.out.println(resourceMethod.getName());
		}
		int i = 0;
	}

}
