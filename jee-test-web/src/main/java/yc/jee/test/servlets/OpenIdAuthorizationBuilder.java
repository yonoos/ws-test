package yc.jee.test.servlets;

import java.util.Arrays;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

public class OpenIdAuthorizationBuilder {
	
	public static AuthorizationCodeFlow newFlow(OpenIdIdentityProvider provider, String ... scopes ){
		
		return new GoogleAuthorizationCodeFlow.Builder(
				new NetHttpTransport(), 
				new JacksonFactory(), 
				provider.getClientId(),
				provider.getClientSecret(),
				Arrays.asList(scopes))
				.setAuthorizationServerEncodedUrl(provider.getAuthorizationEndpoint())
				.setTokenServerUrl(new GenericUrl(provider.getTokenEndPoint()))
				.build();
	}

}
