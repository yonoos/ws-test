package yc.jee.test.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nimbusds.oauth2.sdk.AuthorizationRequest;
import com.nimbusds.oauth2.sdk.ResponseType;
import com.nimbusds.oauth2.sdk.Scope;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.id.State;

@SuppressWarnings("serial")
@WebServlet(name = "login2", value = "/login2")
public class LoginServlet2 extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OpenIdIdentityProvider provider = OpenIdIdentityProvider.GOOGLE;
		
		Principal userPrincipal = req.getUserPrincipal();
		
		System.out.println(userPrincipal);
		
		try {
			// The authorisation endpoint of the server
			URI authzEndpoint = new URI(provider.getAuthorizationEndpoint());

			// The client identifier provisioned by the server
			ClientID clientID = new ClientID(provider.getClientId());

			// The requested scope values for the token
			Scope scope = new Scope("openid", "profile", "email");
			
			// The client callback URI, typically pre-registered with the server
			URI callback = new URI(req.getRequestURL().toString().replaceFirst(req.getServletPath(),"/oauth2callback"));

			// Generate random state string for pairing the response to the request
			State state = new State(req.getSession().getId());

			// Build the request
			AuthorizationRequest request = new AuthorizationRequest.Builder(
			    new ResponseType(ResponseType.Value.CODE), clientID)
			    .scope(scope)
			    .state(state)
			    .redirectionURI(callback)
			    .endpointURI(authzEndpoint)
			    .build();

			// Use this URI to send the end-user's browser to the server
			URI requestURI = request.toURI();
			
			resp.sendRedirect(requestURI.toString());
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



}
