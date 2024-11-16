package com.spyne.backend.config.auth;

import com.spyne.backend.entity.Company;
import com.spyne.backend.entity.Dealer;
import com.spyne.backend.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CompanyAuthDetails implements CustomUserDetails{

    private final Company company;

    private final Role role;

    public CompanyAuthDetails(Company company, Role role) {
        this.company = company;
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
        return this.company.getCompanyId();
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

    public Company getCompany(){
        return company;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Role getRole() {
        return role;
    }
}
