package yc.jee.test.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.http.GenericUrl;

@SuppressWarnings("serial")
@WebServlet(name = "oauth2callback", value = "/oauth2callback")
public class OpenIdCallbackServlet extends AbstractAuthorizationCodeCallbackServlet{

	@Override
	protected AuthorizationCodeFlow initializeFlow() throws IOException {
		AuthorizationCodeFlow flow = OpenIdAuthorizationBuilder.newFlow(OpenIdIdentityProvider.GOOGLE, "profile", "email");
		return flow;
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

	@Override
	protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
			throws ServletException, IOException {
		String accessToken = credential.getAccessToken();
		req.getSession().setAttribute(OpenIdLiterals.ACCESS_TOKEN, accessToken);
		req.getSession().setAttribute(OpenIdLiterals.USER_INFO, accessToken);
		resp.sendRedirect(req.getServletContext().getContextPath()+"/openid?token="+accessToken);
	}


	@Override
	protected void onError(
			HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
					throws ServletException, IOException {
		// handle error
		resp.getWriter().println("error");
	}

}
