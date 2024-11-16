package com.spyne.backend.repo;

import com.spyne.backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {

    Car findByCarId(String carId);
}
