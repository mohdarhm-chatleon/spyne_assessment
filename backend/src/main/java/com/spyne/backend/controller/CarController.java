package com.spyne.backend.controller;

import com.spyne.backend.exception.BaseException;
import com.spyne.backend.model.request.car.CarCreateRequest;
import com.spyne.backend.model.request.car.CarUpdateRequest;
import com.spyne.backend.model.response.CommonResponse;
import com.spyne.backend.model.response.user.CarResponse;
import com.spyne.backend.service.contract.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "v1/cars",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Cars", description = "APIs related to CRUD operations for cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Operation(summary = "Get a list of all cars for the authenticated user")
    @GetMapping
    public List<CarResponse> getALLCarsForThisUser() throws BaseException {
        return carService.getAllCarsAddedByCurrentUser();
    }

    @Operation(summary = "Get a list of all available cars")
    @GetMapping("/all")
    public List<CarResponse> getALLCars() throws BaseException {
        return carService.getAllCars();
    }

    @Operation(summary = "Update car details")
    @PutMapping("/{carId}")
    public CarResponse updateCar(@PathVariable String carId,
                                 @RequestParam @Valid CarUpdateRequest request){
        return carService.updateCar(carId,request);
    }

    @Operation(summary = "Delete a car by ID")
    @DeleteMapping("/{carId}")
    public CommonResponse deleteCar(@PathVariable String carId) throws BaseException{
        return carService.deleteCarById(carId);
    }

    @Operation(summary = "Get details of a specific car by ID")
    @GetMapping("/{carId}")
    public CarResponse getCarById(@PathVariable String carId) throws BaseException {
        return carService.getCarById(carId);
    }

    @Operation(summary = "Add a new car with images, title, description, and tags")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CarResponse addCar(@RequestParam @Valid CarCreateRequest request) throws BaseException {
        return carService.createCar(request);
    }


}
