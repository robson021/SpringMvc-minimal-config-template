package robert.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import robert.tools.BaseTest;

public class ExampleServiceTest extends BaseTest {

	@Autowired
	private ExampleService service;

	@Test
	public void testService() {
		String text = service.saySomething();

		Assertions.assertThat(text)
				.isEqualTo("something...");
	}

}