package robert.web.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import robert.db.repo.UserRepository;
import robert.services.ExampleService;
import robert.tools.MvcTest;

public class TestControllerTest extends MvcTest {

	@Autowired
	private ExampleService exampleService;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void hello() throws Exception {
		String response = this.mockMvc.perform(get("/test/hello"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		Assertions.assertThat(response)
				.isEqualTo("Hello World!");
	}

	@Override
	protected Object getController() {
		return new TestController(exampleService, userRepository);
	}
}