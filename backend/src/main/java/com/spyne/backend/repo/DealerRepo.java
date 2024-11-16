package com.spyne.backend.repo;

import com.spyne.backend.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepo extends JpaRepository<Dealer, Long> {

    Dealer findByUserEmail(String email);

    Dealer findByDealerId(String dealerId);
}
