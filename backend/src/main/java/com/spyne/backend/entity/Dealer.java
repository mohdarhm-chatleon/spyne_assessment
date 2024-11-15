package com.spyne.backend.entity;

import com.spyne.backend.entity.common.Base;

import com.spyne.backend.entity.common.User;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "dealer")
public class Dealer extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dealer_id", nullable = false, unique = true, length = 100)
    private String dealerId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "dealer_email")),
            @AttributeOverride(name = "name", column = @Column(name = "dealer_name"))
    })
    private User user;

    @PrePersist
    public void onInsert() {
        this.dealerId= UUID.randomUUID().toString();
    }

}