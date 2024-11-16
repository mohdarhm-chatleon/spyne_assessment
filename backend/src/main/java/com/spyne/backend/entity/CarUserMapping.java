package com.spyne.backend.entity;

import com.spyne.backend.entity.common.Base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car_user_mapping", uniqueConstraints = {
        @UniqueConstraint(name = "uc_carId_userId", columnNames = {"car_id", "user_id"})
})
public class CarUserMapping extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_id", nullable = false, unique = true, length = 50)
    private String carId;

    @Column(name = "user_id", nullable = false, unique = true, length = 50)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id", referencedColumnName = "dealer_id", insertable = false, updatable = false)
    private Dealer dealer;

    @Column(name = "dealer_id", nullable = false, unique = true, length = 50)
    private String dealerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false)
    private Company company;

    @Column(name = "company_id", nullable = false, unique = true, length = 50)
    private String companyId;

}
