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

import com.nimbusds.jwt.JWT;
import com.nimbusds.oauth2.sdk.AuthorizationCode;
import com.nimbusds.oauth2.sdk.AuthorizationCodeGrant;
import com.nimbusds.oauth2.sdk.AuthorizationGrant;
import com.nimbusds.oauth2.sdk.AuthorizationResponse;
import com.nimbusds.oauth2.sdk.AuthorizationSuccessResponse;
import com.nimbusds.oauth2.sdk.ParseException;
import com.nimbusds.oauth2.sdk.TokenErrorResponse;
import com.nimbusds.oauth2.sdk.TokenRequest;
import com.nimbusds.oauth2.sdk.TokenResponse;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.token.AccessToken;
import com.nimbusds.oauth2.sdk.token.RefreshToken;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponse;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponseParser;

@SuppressWarnings("serial")
@WebServlet(name = "oauth2callback", value = "/oauth2callback")
public class OpenIdCallbackServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			OpenIdIdentityProvider provider = OpenIdIdentityProvider.GOOGLE;

			StringBuffer buf = req.getRequestURL();
			if (req.getQueryString() != null) {
				buf.append('?').append(req.getQueryString());
			}

			// Parse the authorisation response from the callback URI
			AuthorizationResponse authrizationResponse = AuthorizationResponse.parse(new URI(buf.toString()));

			if (! authrizationResponse.indicatesSuccess()) {
				// The request was denied or some error may have occurred
			}

			AuthorizationSuccessResponse successResponse = (AuthorizationSuccessResponse)authrizationResponse;

			// The returned state parameter must match the one send with the request
			if (successResponse.getState() != null) {
				// Unexpected or tampered response, stop!!!
			}


			// Retrieve the authorisation code, to be used later to exchange the code for
			// an access token at the token endpoint of the server
			AuthorizationCode code = successResponse.getAuthorizationCode();
			
			
			URI callback = new URI(req.getRequestURL().toString().replaceFirst(req.getServletPath(),"/oauth2callback"));
			AuthorizationGrant codeGrant = new AuthorizationCodeGrant(code, callback);

			// The credentials to authenticate the client at the token endpoint
			ClientID clientID = new ClientID(provider.getClientId());
			Secret clientSecret = new Secret(provider.getClientSecret());
			ClientAuthentication clientAuth = new ClientSecretBasic(clientID, clientSecret);

			// The token endpoint
			URI tokenEndpoint = new URI(provider.getTokenEndPoint());

			// Make the token request
			TokenRequest request = new TokenRequest(tokenEndpoint, clientAuth, codeGrant);

			TokenResponse tokenResponse = OIDCTokenResponseParser.parse(request.toHTTPRequest().send());

			if (! tokenResponse.indicatesSuccess()) {
			    // We got an error response...
			    TokenErrorResponse tokenErrorResponse = tokenResponse.toErrorResponse();
			    resp.getWriter().write("error");
			}

			OIDCTokenResponse tokenSuccessResponse = (OIDCTokenResponse)tokenResponse.toSuccessResponse();
			
			// Get the ID and access token, the server may also return a refresh token
			JWT idToken = tokenSuccessResponse.getOIDCTokens().getIDToken();
			AccessToken accessToken = tokenSuccessResponse.getOIDCTokens().getAccessToken();
			RefreshToken refreshToken = tokenSuccessResponse.getOIDCTokens().getRefreshToken();

			// Get the access token, the server may also return a refresh token
			resp.sendRedirect(req.getRequestURL().toString().replaceFirst(req.getServletPath(),"")+"/openid?user="+idToken.getJWTClaimsSet().getStringClaim("email"));
			
			Principal userPrincipal = req.getUserPrincipal();
			
			System.out.println(userPrincipal);
			
			
		} catch (ParseException | URISyntaxException | java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
