package robert.tests.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import robert.tests.services.ExampleService;
import robert.tools.MvcTest;

public class TestControllerTest extends MvcTest {

	@Autowired
	private ExampleService exampleService;

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
		return new TestController(exampleService);
	}
}