package com.spyne.backend.config.auth;

import com.spyne.backend.exception.BaseException;
import com.spyne.backend.model.enums.Role;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class AuthUtils<T extends CustomUserDetails> {

    public CustomUserDetails getLoggedInUser() throws BaseException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUserDetails userDetails = (CustomUserDetails) securityContext.getAuthentication().getPrincipal();

        switch (userDetails.getRole()){
            case CUSTOMER -> {
                CustomerAuthDetails customerAuthDetails = (CustomerAuthDetails) userDetails;
                return customerAuthDetails;
            }
            case DEALER -> {
                DealerAuthDetails dealerAuthDetails = (DealerAuthDetails) userDetails;
                return dealerAuthDetails;
            }
            case COMPANY -> {
                CompanyAuthDetails companyAuthDetails = (CompanyAuthDetails) userDetails;
                return companyAuthDetails;

            }
            default -> {
                return null;
            }
        }
    }

    public T getLoggedInUser(Role role){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        T userDetails = (T) securityContext.getAuthentication().getPrincipal();

        switch (userDetails.getRole()){
            case CUSTOMER -> {
                CustomerAuthDetails customerAuthDetails = (CustomerAuthDetails) userDetails;
                return userDetails;
            }
            case DEALER -> {
                DealerAuthDetails dealerAuthDetails = (DealerAuthDetails) userDetails;
                return userDetails;
            }
            case COMPANY -> {
                CompanyAuthDetails companyAuthDetails = (CompanyAuthDetails) userDetails;
                return userDetails;

            }
            default -> {
                return null;
            }
        }
    }
}
