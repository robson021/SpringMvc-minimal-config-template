package robert.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import robert.db.entities.User;
import robert.db.repo.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Set<GrantedAuthority> ROLES = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(s);
        return new UserDetailsImpl(user);
    }

    private class UserDetailsImpl implements UserDetails {
        private final User user;
        private final Set<GrantedAuthority> roles;

        UserDetailsImpl(User user) {
            this.user = user;
            this.roles = ROLES;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.roles;
        }

        @Override
        public String getPassword() {
            return this.user.getPassword();
        }

        @Override
        public String getUsername() {
            return this.user.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
