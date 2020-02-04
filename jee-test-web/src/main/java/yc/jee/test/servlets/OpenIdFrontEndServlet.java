package yc.jee.test.servlets;

import java.io.IOException;
import java.util.Arrays;

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
	public static final String IDENTITY_PROVIDER_INPUT_NAME="identity_provider"; 
	private static final String IMPLEMENTED_IDENTITY_PROVIDERS_INPUT_NAME = "available_identity_providers";
	public static final String USER_INFO = "user_info";

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setView(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String providerName = request.getParameter(OpenIdFrontEndServlet.IDENTITY_PROVIDER_INPUT_NAME);
		request.getSession().setAttribute(OpenIdFrontEndServlet.IDENTITY_PROVIDER_INPUT_NAME, providerName);
		response.sendRedirect(request.getContextPath()+"/login2");
	}
	
	private void setView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String operator = request.getParameter(IDENTITY_PROVIDER_INPUT_NAME);
		Object userInfo = request.getSession().getAttribute(USER_INFO);
		request.setAttribute(USER_INFO, userInfo);
		request.setAttribute(IDENTITY_PROVIDER_INPUT_NAME, operator);
		request.setAttribute(IMPLEMENTED_IDENTITY_PROVIDERS_INPUT_NAME, getImplementedIdentityProviders());
		this.getServletContext().getRequestDispatcher("/WEB-INF/openid.jsp").forward(request, response);
	}
	
	
	private String [] getImplementedIdentityProviders(){
		return Arrays.stream(OpenIdIdentityProvider.values()).map(e->e.name()).toArray(String[]::new);
	}

}
