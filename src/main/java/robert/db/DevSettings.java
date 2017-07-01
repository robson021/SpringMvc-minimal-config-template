package robert.db;

import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import robert.db.entities.User;
import robert.db.repo.UserRepository;

@Component
@Profile("dev")
public class DevSettings {

	private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DevSettings(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        init();
    }

	private void init() {
		User user = new User();
		user.setEmail("test@t.com");
        user.setPassword(passwordEncoder.encode("password"));

		User saved = userRepository.save(user);
		System.out.println("saved user: " + saved);
	}
}
