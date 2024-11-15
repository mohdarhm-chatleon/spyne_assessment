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
@Table(name="car")
public class Car extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_id", nullable = false, unique = true, length = 50)
    private String companyId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id", referencedColumnName = "company_id",insertable = false, updatable = false)
    private Company company;

    @Column(name = "car_id", nullable = false, unique = true, length = 50)
    private String carId;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "varchar()")
    private CarStatus status;



}
