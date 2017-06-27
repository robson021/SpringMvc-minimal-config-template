package robert.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robert.services.ExampleService;

@RestController
@RequestMapping("/test")
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	private final ExampleService exampleService;

	public TestController(ExampleService exampleService) {
		this.exampleService = exampleService;
	}

	@GetMapping("/hello")
	public String hello() {
		log.debug(exampleService.saySomething());
		return "Hello World!";
	}
}
