//package com.example.demo.cmm.enm;
//
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
//
//import lombok.Builder;
//
//public enum CommonOAuth2Provider {
//
//	GOOGLE {
//
//		@Override
//		public Builder getBuilder(String registrationId) {
//			ClientRegistration.Builder builder = getBuilder(registrationId, ClientAuthenticationMethod.BASIC,
//					DEFAULT_REDIRECT_URL);
//			builder.scope("openid", "profile", "email");
//			builder.authorizationUri("https://accounts.google.com/o/oauth2/v2/auth");
//			builder.tokenUri("https://www.googleapis.com/oauth2/v4/token");
//			builder.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs");
//			builder.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo");
//			builder.userNameAttributeName(IdTokenClaimNames.SUB);
//			builder.clientName("Google");
//			return builder;
//		}
//
//		private static final String DEFAULT_REDIRECT_URL = "{baseUrl}/{action}/oauth2/code/{registrationId}";
//
//	}
//}