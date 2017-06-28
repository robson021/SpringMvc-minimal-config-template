package robert.db;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import robert.db.entities.User;
import robert.db.repo.UserRepository;

@Component
@Profile("dev")
public class DevSettings {

	private final UserRepository userRepository;

	public DevSettings(UserRepository userRepository) {
		this.userRepository = userRepository;
		init();
	}

	private void init() {
		User user = new User();
		user.setEmail("test@t.com");
		user.setPassword("password");

		User saved = userRepository.save(user);
		System.out.println("saved user: " + saved);
	}
}
