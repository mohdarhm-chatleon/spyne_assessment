package com.spyne.backend.config.auth;

import com.spyne.backend.entity.Customer;
import com.spyne.backend.model.enums.CustomerStatus;
import com.spyne.backend.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerAuthDetails implements CustomUserDetails{

    private final Customer customer;

    private final Role role;

    public CustomerAuthDetails(Customer customer, Role role) {
        this.customer = customer;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> authorities = new HashSet<>(1);
        authorities.add(this.role);

        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return this.customer.getCustomerId();
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

    public Customer getCustomer(){
        return customer;
    }

    @Override
    public boolean isEnabled() {
        return CustomerStatus.ACTIVE.equals(customer.getStatus());
    }

    @Override
    public Role getRole() {
        return role;
    }
}
