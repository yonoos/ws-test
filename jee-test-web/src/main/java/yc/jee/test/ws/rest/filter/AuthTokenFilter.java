package yc.jee.test.ws.rest.filter;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthTokenFilter implements ContainerRequestFilter {
	
	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println(requestContext.getPropertyNames());
		System.out.println(requestContext.getAcceptableMediaTypes());
		Method resourceMethod = resourceInfo.getResourceMethod();
		if(resourceMethod != null) {
			System.out.println(resourceMethod.getName()+" "+resourceInfo.getResourceClass().getName());
		}
		int i = 0;

	}

}
