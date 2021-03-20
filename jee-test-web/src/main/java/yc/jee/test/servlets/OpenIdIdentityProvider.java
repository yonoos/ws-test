package yc.jee.test.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OpenIdIdentityProvider {

	private static final String AUTHRORIZATION_ENDPOINT_PARAM = "authorizationEndpoint";
	private static final String TOKEN_ENDPOINT_PARAM = "tokenEndPoint";
	private static final String USER_INFO_ENDPOINT_PARAM = "userInfoEndPoint";
	private static final String CLIENT_ID_PARAM = "clientId";
	private static final String CLIENT_SECRET_ENDPOINT_PARAM = "clientSecret";

	private String authorizationEndpoint;
	private String tokenEndPoint;
	private String userInfoEndPoint;
	private String clientId;
	private String clientSecret;
	private String name;

	public OpenIdIdentityProvider() {

	}

	public OpenIdIdentityProvider(String _name, String _authorizationEndpoint, String _tokenEndPoint, String _userInfoEndPoint, String _clientId, String _clientSecret) {
		this.authorizationEndpoint = _authorizationEndpoint;
		this.tokenEndPoint = _tokenEndPoint;
		this.userInfoEndPoint = _userInfoEndPoint;
		this.clientId = _clientId;
		this.clientSecret = _clientSecret;
		this.name = _name;
	}

	public void setAuthorizationEndpoint(String authorizationEndpoint) {
		this.authorizationEndpoint = authorizationEndpoint;
	}
	public void setTokenEndPoint(String tokenEndPoint) {
		this.tokenEndPoint = tokenEndPoint;
	}
	public void setUserInfoEndPoint(String userInfoEndPoint) {
		this.userInfoEndPoint = userInfoEndPoint;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorizationEndpoint() {
		return authorizationEndpoint;
	}
	public String getTokenEndPoint() {
		return tokenEndPoint;
	}
	public String getUserInfoEndPoint() {
		return userInfoEndPoint;
	}
	public String getClientId() {
		return clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static Map<String, OpenIdIdentityProvider> loadIdProviders(InputStream is) throws IOException{
		Map<String, Map<String, String>> configMap = new HashMap<>();
		Properties config =  new Properties();
		config.load(is);
		for (Object key : config.keySet()) {
			String[] split = key.toString().split("\\.");
			String providerName = split[0].toUpperCase();
			String paramName = getParamName(split[1].toLowerCase());
			Map<String, String> providerMap = configMap.get(providerName);
			if(providerMap == null) {
				providerMap = new HashMap<>();
				configMap.put(providerName, providerMap);
			}
			providerMap.put(paramName, config.getProperty(key.toString()));
		}

		return configMap.entrySet().stream()
				.map(providerEntry ->  new OpenIdIdentityProvider(
						providerEntry.getKey(), 
						getNotNullParam(providerEntry.getValue().get(AUTHRORIZATION_ENDPOINT_PARAM)),
						getNotNullParam(providerEntry.getValue().get(TOKEN_ENDPOINT_PARAM)),
						getNotNullParam(providerEntry.getValue().get(USER_INFO_ENDPOINT_PARAM)),
						getNotNullParam(providerEntry.getValue().get(CLIENT_ID_PARAM)),
						getNotNullParam(providerEntry.getValue().get(CLIENT_SECRET_ENDPOINT_PARAM))
						)
				)
				.collect(Collectors.toMap(provider -> provider.getName(), Function.identity()));
	}
	
	private static String getNotNullParam(String value){
		return value==null ? "" : value;
	}

	private static String getParamName(String paramName) {
		if(AUTHRORIZATION_ENDPOINT_PARAM.equalsIgnoreCase(paramName)) {
			return AUTHRORIZATION_ENDPOINT_PARAM;
		} else if(TOKEN_ENDPOINT_PARAM.equalsIgnoreCase(paramName)) {
			return TOKEN_ENDPOINT_PARAM;
		} else if(USER_INFO_ENDPOINT_PARAM.equalsIgnoreCase(paramName)) {
			return USER_INFO_ENDPOINT_PARAM;
		} else if(CLIENT_ID_PARAM.equalsIgnoreCase(paramName)) {
			return CLIENT_ID_PARAM;
		} else if(CLIENT_SECRET_ENDPOINT_PARAM.equalsIgnoreCase(paramName)) {
			return CLIENT_SECRET_ENDPOINT_PARAM;
		}
		return paramName;
	}

	public static Map<String, OpenIdIdentityProvider> loadIdProviders() throws IOException{
		File file = new File(OpenIdLiterals.ID_PROVIDERS_FILE_PATH);
		if(file.exists()) {
			return loadIdProviders(new FileInputStream(file));
		}
		return Collections.emptyMap();
	}





}
