package com.gaurav.loginserverjwt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private String splitter = "<br>";
	@GetMapping("/get_jwt_token")
	public String getAccessToken() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		DefaultOidcUser principal = (DefaultOidcUser)auth.getPrincipal();
		return "<h1>Mogran Stanley Identity Server</h1> <br> <B>Welcome, your login credentials are as follows: </B>" + splitter +  "Name: " + principal.getFullName() + splitter + 
				"Email: " + principal.getEmail() + splitter +
				"SubjectId: " + principal.getAttribute("sub") + splitter +
				"JWT: " + principal.getIdToken().getTokenValue();
	}

}
