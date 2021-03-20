package yc.jee.test.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="openid", value = "/openid")
public class OpenIdFrontEndServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2288095285803803033L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setView(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String providerName = request.getParameter(OpenIdLiterals.IDENTITY_PROVIDER_INPUT_NAME);
		request.getSession().setAttribute(OpenIdLiterals.IDENTITY_PROVIDER_INPUT_NAME, providerName);
		String currentUrl = request.getRequestURL().toString();
		response.sendRedirect(request.getContextPath()+"/login2?"+OpenIdLiterals.REDIRECT_URL+"="+currentUrl);
	}
	
	private void setView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String operator = request.getParameter(OpenIdLiterals.IDENTITY_PROVIDER_INPUT_NAME);
		Object userInfo = request.getSession().getAttribute(OpenIdLiterals.USER_INFO);
		Object userGroups = request.getSession().getAttribute(OpenIdLiterals.USER_GROUPS);
		request.setAttribute(OpenIdLiterals.USER_INFO, userInfo);
		request.setAttribute(OpenIdLiterals.USER_GROUPS, userGroups);
		request.setAttribute(OpenIdLiterals.IDENTITY_PROVIDER_INPUT_NAME, operator);
		request.setAttribute(OpenIdLiterals.IMPLEMENTED_IDENTITY_PROVIDERS_INPUT_NAME, getImplementedIdentityProviders());
		this.getServletContext().getRequestDispatcher("/WEB-INF/openid.jsp").forward(request, response);
	}
	
	private String [] getImplementedIdentityProviders() throws IOException{
		Map<String, OpenIdIdentityProvider> providers = OpenIdIdentityProvider.loadIdProviders();
		return providers.keySet().stream().toArray(String [] :: new);
	}

}
