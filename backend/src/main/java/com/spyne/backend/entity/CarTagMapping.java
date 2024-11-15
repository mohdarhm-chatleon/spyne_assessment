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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car_tag_mapping")
public class CarTagMapping extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_id", nullable = false, unique = true, length = 50)
    private String carId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false,insertable = false, updatable = false)
    private Car car;

    @Column(name = "tag_id", nullable = false, unique = true, length = 50)
    private String tagId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id", nullable = false, insertable = false, updatable = false)
    private Tag tag;
}
