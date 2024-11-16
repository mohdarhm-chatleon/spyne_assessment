package com.spyne.backend.repo;

import com.spyne.backend.entity.Company;
import com.spyne.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByUserEmail(String email);
}
