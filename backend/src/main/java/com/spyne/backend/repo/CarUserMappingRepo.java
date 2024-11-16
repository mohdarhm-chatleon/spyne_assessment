package com.spyne.backend.repo;

import com.spyne.backend.entity.CarUserMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarUserMappingRepo extends JpaRepository<CarUserMapping, Long> {
}
