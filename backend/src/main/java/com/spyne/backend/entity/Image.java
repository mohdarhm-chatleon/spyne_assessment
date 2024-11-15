package com.spyne.backend.entity;

import com.spyne.backend.entity.common.Base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image_id", nullable = false)
    private String imageId;

    @Column(name = "image_signed_url", nullable = false)
    private String imageSignedUrl;
}
