package robert.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robert.db.entities.User;
import robert.db.repo.UserRepository;
import robert.services.ExampleService;

@RestController
@RequestMapping("test")
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	private final ExampleService exampleService;

	private final UserRepository userRepository;

	public TestController(ExampleService exampleService, UserRepository userRepository) {
		this.exampleService = exampleService;
		this.userRepository = userRepository;
	}

	@GetMapping("hello")
	public String hello() {
		log.debug(exampleService.saySomething());
		return "Hello World!";
	}

	@GetMapping("users")
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
}
