package yc.jee.test.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.http.GenericUrl;

@SuppressWarnings("serial")
@WebServlet(name = "login", value = "/login")
public class LoginServlet extends AbstractAuthorizationCodeServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
	}

	@Override
	protected AuthorizationCodeFlow initializeFlow() throws IOException {
		return OpenIdAuthorizationBuilder.newFlow(OpenIdIdentityProvider.GOOGLE, "profile", "email");
	}
	@Override
	protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
		GenericUrl url = new GenericUrl(req.getRequestURL().toString());
		url.setRawPath(req.getContextPath()+"/oauth2callback");
		return url.build();
	}

	@Override
	protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
		return "me";
	}



}
