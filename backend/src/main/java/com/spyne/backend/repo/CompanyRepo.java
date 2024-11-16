package com.spyne.backend.repo;

import com.spyne.backend.entity.Company;
import com.spyne.backend.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {

    Company findByUserEmail(String email);

    Company findByCompanyId(String companyId);
}
