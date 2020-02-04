package yc.jee.test.servlets;

public enum OpenIdIdentityProvider {
	GOOGLE {
		@Override
		public String getAuthorizationEndpoint() {
			return "https://accounts.google.com/o/oauth2/auth";
		}
		@Override
		public String getTokenEndPoint() {
			return "https://oauth2.googleapis.com/token";
		}
		@Override
		public String getUserInfoEndPoint() {
			return "https://www.googleapis.com/plus/v1/people/me/openIdConnect";
		}
		@Override
		public String getClientId() {
			return OpenIdLiterals.GOOGLE_CLIENT_ID;
		}
		@Override
		public String getClientSecret() {
			return OpenIdLiterals.GOOGLE_SECRET;
		}
	},
	FACEBOOK {
		@Override
		public String getAuthorizationEndpoint() {
			return "https://www.facebook.com/v6.0/dialog/oauth";
		}
		@Override
		public String getTokenEndPoint() {
			return "https://graph.facebook.com/v6.0/oauth/access_token";
		}
		@Override
		public String getUserInfoEndPoint() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getClientId() {
			return "";
		}
		@Override
		public String getClientSecret() {
			return "";
		}
	},
	MICROSOFT {
		@Override
		public String getAuthorizationEndpoint() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getTokenEndPoint() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getUserInfoEndPoint() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getClientId() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getClientSecret() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	;
	
	public abstract String getAuthorizationEndpoint();
	public abstract String getTokenEndPoint();
	public abstract String getUserInfoEndPoint();
	public abstract String getClientId();
	public abstract String getClientSecret();
}
