package com.spyne.backend.config.auth;

import com.spyne.backend.entity.Company;
import com.spyne.backend.entity.Customer;
import com.spyne.backend.entity.Dealer;
import com.spyne.backend.model.enums.Role;
import com.spyne.backend.repo.CompanyRepo;
import com.spyne.backend.repo.CustomerRepo;
import com.spyne.backend.repo.DealerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CommonJwtDetailsService implements UserDetailsService {

    @Autowired
    DealerRepo dealerRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByEmail(String email, Role role) {
        switch (role) {
            case CUSTOMER -> {
                Customer customer = customerRepo.findByUserEmail(email);
                return new CustomerAuthDetails(customer, role);
            }
            case DEALER -> {
                Dealer dealer = dealerRepo.findByUserEmail(email);
                return new DealerAuthDetails(dealer, role);
            }
            case COMPANY -> {
                Company company = companyRepo.findByUserEmail(email);
                return new CompanyAuthDetails(company, role);
            }
            default -> {
                return null;
            }
        }
    }
}
