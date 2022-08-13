package lt.autoservis.u5.service;

import lt.autoservis.u5.model.User;
import lt.autoservis.u5.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
