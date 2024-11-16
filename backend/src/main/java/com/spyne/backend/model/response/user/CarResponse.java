package com.spyne.backend.model.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spyne.backend.entity.Car;
import com.spyne.backend.entity.CarTagMapping;
import com.spyne.backend.entity.Company;
import com.spyne.backend.entity.Dealer;
import com.spyne.backend.entity.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CarResponse {
    private String company;
    private String dealer;
    private String carName;
    private String description;

    public CarResponse(Car car){
        this.carName = car.getName();
        this.company = car.getCompany().getUser().getName();
        this.dealer = car.getDealer().getUser().getName();
        this.description = car.getDescription();
    }
}
