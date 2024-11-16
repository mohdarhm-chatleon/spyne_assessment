package com.spyne.backend.entity;

import com.spyne.backend.entity.common.Base;

import com.spyne.backend.model.enums.CarStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_id", nullable = false, unique = true, length = 50)
    private String carId;

    @Column(name = "company_id", nullable = false, unique = true, length = 50)
    private String companyId;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "dealer_id", nullable = false, unique = true, length = 50)
    private String dealerId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dealer_id", referencedColumnName = "dealer_id",insertable = false, updatable = false)
    private Dealer dealer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id", referencedColumnName = "company_id",insertable = false, updatable = false)
    private Company company;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private CarStatus status;

}
