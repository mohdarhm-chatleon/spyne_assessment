package com.spyne.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "v1/cars",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Cars", description = "APIs related to CRUD operations for cars")
public class CarController {

}
