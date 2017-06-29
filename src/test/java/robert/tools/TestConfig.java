package robert.tools;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ComponentScan(basePackages = { "robert" })
@PropertySource("classpath:test-application.properties")
@ActiveProfiles("test")
public class TestConfig {
}
