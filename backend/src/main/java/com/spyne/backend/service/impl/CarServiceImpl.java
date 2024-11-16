package com.spyne.backend.service.impl;

import com.spyne.backend.config.auth.AuthUtils;
import com.spyne.backend.config.auth.CustomUserDetails;
import com.spyne.backend.config.auth.CustomerAuthDetails;
import com.spyne.backend.entity.Car;
import com.spyne.backend.entity.CarUserMapping;
import com.spyne.backend.entity.Company;
import com.spyne.backend.entity.Customer;
import com.spyne.backend.entity.Dealer;
import com.spyne.backend.exception.BadRequestException;
import com.spyne.backend.exception.BaseException;
import com.spyne.backend.exception.NotFoundException;
import com.spyne.backend.model.enums.Role;
import com.spyne.backend.model.request.car.CarCreateRequest;
import com.spyne.backend.model.request.car.CarUpdateRequest;
import com.spyne.backend.model.response.CommonResponse;
import com.spyne.backend.model.response.user.CarResponse;
import com.spyne.backend.repo.CarRepo;
import com.spyne.backend.repo.CarUserMappingRepo;
import com.spyne.backend.repo.CompanyRepo;
import com.spyne.backend.repo.DealerRepo;
import com.spyne.backend.service.contract.CarService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    DealerRepo dealerRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    CarUserMappingRepo carUserMappingRepo;

    @Autowired
    private AuthUtils<CustomerAuthDetails> authUtils;

    @Override
    public CommonResponse deleteCarById(String carId) throws BaseException {
        Car car = carRepo.findByCarId(carId);
        if (Objects.isNull(car)){
            throw new NotFoundException(HttpStatus.BAD_REQUEST.value(), "Car not found with the given Id");
        }
        else {
            // Alternatively, we can set a flag called 'isDeleted'
            carRepo.delete(car);
            return new CommonResponse("Car deleted");
        }
    }

    @Override
    @Transactional
    public CarResponse createCar(CarCreateRequest request) throws BaseException {
        String customerId = authUtils.getLoggedInUser(Role.CUSTOMER).getCustomer().getCustomerId();
        Car car = new Car();
        Dealer dealer = dealerRepo.findByDealerId(request.getDealerId());
        Company company = companyRepo.findByCompanyId(request.getCompanyId());

        if(Objects.isNull(dealer)|| Objects.isNull(company)){
            throw new BadRequestException(HttpStatus.BAD_REQUEST.value(),"Bad dealer ID and/or company Id");
        }

        car.setDealerId(dealer.getDealerId());
        car.setCompanyId(company.getCompanyId());
        car.setName(request.getName());
        car.setDescription(request.getDescription());
        Car savedCar = carRepo.save(car);

        CarUserMapping carUserMapping = new CarUserMapping();
        carUserMapping.setCarId(savedCar.getCarId());
        carUserMapping.setDealerId(savedCar.getDealerId());
        carUserMapping.setCompanyId(savedCar.getCompanyId());
        carUserMapping.setUserId(customerId);
        carUserMappingRepo.save(carUserMapping);

        // TODO: add functionality for image processing and upload, maybe through S3?
        return new CarResponse(savedCar);

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
        List<Car> cars = new ArrayList<>();
        cars = carRepo.findAll();
        List<CarResponse> response = new ArrayList<>();
        for (Car car: cars){
            response.add(new CarResponse(car));
        }
        return response;
    }

    @Override
    public List<CarResponse> getAllCarsAddedByCurrentUser() {
        return List.of();
    }
}
