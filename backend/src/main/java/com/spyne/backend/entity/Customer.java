package com.spyne.backend.entity;

import com.spyne.backend.entity.common.Base;

import com.spyne.backend.entity.common.User;

import com.spyne.backend.model.enums.CustomerStatus;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(name = "uc_customer_customer_email", columnNames = {"customer_email"}),
        @UniqueConstraint(name = "uk_username", columnNames = {"username"})
})
public class Customer extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_id", nullable = false, unique = true, length = 100)
    private String customerId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cognitoId", column = @Column(name = "customer_cognito_id")),
            @AttributeOverride(name = "email", column = @Column(name = "customer_email")),
            @AttributeOverride(name = "name", column = @Column(name = "customer_name"))
    })
    private User user;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "varchar()")
    private CustomerStatus status;

    @PrePersist
    public void onInsert() {
        this.customerId = UUID.randomUUID().toString();
    }
}
