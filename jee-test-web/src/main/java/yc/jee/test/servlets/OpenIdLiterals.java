package yc.jee.test.servlets;

import java.io.File;

public class OpenIdLiterals {
	
	public static final String USER_INFO = "user_info";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String REDIRECT_URL = "redirect_url";
	public static final String IDENTITY_PROVIDER_INPUT_NAME="identity_provider"; 
	public static final String USER_GROUPS = "user_groups";
	public static final String IMPLEMENTED_IDENTITY_PROVIDERS_INPUT_NAME = "available_identity_providers";

	public static final String ID_PROVIDERS_FILE_PATH = System.getProperty("user.home")+File.separator+"my_id_provider_config";

}
