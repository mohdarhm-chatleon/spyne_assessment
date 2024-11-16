package com.spyne.backend.config.auth;

import com.spyne.backend.entity.Customer;
import com.spyne.backend.entity.Dealer;
import com.spyne.backend.model.enums.CustomerStatus;
import com.spyne.backend.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DealerAuthDetails implements CustomUserDetails{

    private final Dealer dealer;

    private final Role role;

    public DealerAuthDetails(Dealer dealer, Role role) {
        this.dealer = dealer;
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
        return this.dealer.getDealerId();
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

    public Dealer getDealer(){
        return dealer;
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
