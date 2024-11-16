package com.spyne.backend.service.contract;


import com.spyne.backend.entity.Car;
import com.spyne.backend.exception.BaseException;
import com.spyne.backend.model.request.car.CarCreateRequest;
import com.spyne.backend.model.request.car.CarUpdateRequest;
import com.spyne.backend.model.response.CommonResponse;
import com.spyne.backend.model.response.user.CarResponse;

import java.util.List;

public interface CarService {

    CommonResponse deleteCarById(String carId) throws BaseException;

    CarResponse createCar(CarCreateRequest request) throws BaseException;

    CarResponse updateCar(String carId, CarUpdateRequest request);

    CarResponse getCarById (String carId);

    List<CarResponse> getAllCars();

    List<CarResponse> getAllCarsAddedByCurrentUser();
}
