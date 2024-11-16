package com.spyne.backend.service.impl;

import com.spyne.backend.model.request.car.CarCreateRequest;
import com.spyne.backend.model.request.car.CarUpdateRequest;
import com.spyne.backend.model.response.CommonResponse;
import com.spyne.backend.model.response.user.CarResponse;
import com.spyne.backend.service.contract.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public CommonResponse deleteCarById(String carId) {
        return null;
    }

    @Override
    public CarResponse createCar(CarCreateRequest request) {
        return null;
    }

    @Override
    public CarResponse updateCar(String carId, CarUpdateRequest request) {
        return null;
    }

    @Override
    public CarResponse getCarById(String carId) {
        return null;
    }

    @Override
    public List<CarResponse> getAllCars() {
        return List.of();
    }

    @Override
    public List<CarResponse> getAllCarsAddedByCurrentUser() {
        return List.of();
    }
}
