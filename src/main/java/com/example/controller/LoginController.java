package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author saito
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/")
	public ModelAndView login(ModelAndView modelAndView) {

		modelAndView.setViewName("index");
		return modelAndView;
	}


	@RequestMapping("/home")
	public ModelAndView home(@AuthenticationPrincipal OidcUser oidcUser, Authentication authentication, ModelAndView modelAndView) {

		//Googleログイン情報
		modelAndView.addObject("subject", oidcUser.getSubject());
		modelAndView.addObject("email", oidcUser.getEmail());
		modelAndView.addObject("emailVerified", oidcUser.getEmailVerified());
		modelAndView.addObject("fullName", oidcUser.getFullName());
		modelAndView.addObject("picture", oidcUser.getPicture());
		modelAndView.addObject("locale", oidcUser.getLocale());
		modelAndView.addObject("familyName", oidcUser.getFamilyName());
		modelAndView.addObject("givenName", oidcUser.getGivenName());
		//Authentication
		modelAndView.addObject("authenticationName", authentication.getName());
		modelAndView.addObject("userRole", authentication.getAuthorities().toString());

		modelAndView.setViewName("home");
		return modelAndView;
	}
}
