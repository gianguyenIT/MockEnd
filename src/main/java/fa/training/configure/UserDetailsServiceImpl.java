package fa.training.configure;

import fa.training.dto.CustomerDTO;
import fa.training.entity.Customer;
import fa.training.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByEmail(email);



        if (customer != null) {
            return new CustomUserDetails(customer);
        }
        throw new UsernameNotFoundException("User not available");
    }
}
