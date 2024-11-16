package com.spyne.backend.repo;

import com.spyne.backend.entity.EmailHashMapping;
import com.spyne.backend.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailHashMappingRepo extends JpaRepository<EmailHashMapping, Long> {

    EmailHashMapping findByEmailAndHashAndRole(String email, String hash, Role role);
}
