package com.spyne.backend.repo;

import com.spyne.backend.entity.EmailHashMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailHashMappingRepo extends JpaRepository<EmailHashMapping, Long> {

    EmailHashMapping findByEmailAndHash(String email, String hash);
}
