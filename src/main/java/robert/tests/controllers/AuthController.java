package robert.tests.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/")
	public String homePage() {
		return "redirect:/index.html";
	}

	@GetMapping(value = "/logout") //TODO
	public String logoutPage(HttpServletRequest request) {
		SecurityContextHolder.clearContext();
		HttpSession session = request.getSession(false);
		if ( session != null ) {
			session.invalidate();
		}

		return "redirect:/index.html";
	}
}
