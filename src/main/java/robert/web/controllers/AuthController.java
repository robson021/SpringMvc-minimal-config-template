package robert.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	private static final String HOME_PAGE = "redirect:/index.html";

	@GetMapping("/")
	public String homePage() {
		return HOME_PAGE;
	}

	@GetMapping(value = "/logout") //TODO
	public String logout(HttpServletRequest request) {
		SecurityContextHolder.clearContext();
		HttpSession session = request.getSession(false);
		if ( session != null ) {
			session.invalidate();
		}

		return HOME_PAGE;
	}
}
