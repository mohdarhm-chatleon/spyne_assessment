package com.spyne.backend.config.auth;

import com.spyne.backend.entity.Customer;
import com.spyne.backend.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class CustomerJwtDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    public UserDetails loadUserByEmail(String email, Role role) {
//        Customer customer = customerDAO.findByEmail(email);
//
//        if (Objects.isNull(customer)) {
//            throw new UsernameNotFoundException("User " + email + " not found.");
//        }
//
//        return new CustomerAuthDetails(customer, role);
//    }
}
