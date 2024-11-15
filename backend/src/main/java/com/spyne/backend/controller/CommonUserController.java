package com.spyne.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "v1/users",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User Onboarding", description = "APIs to Register,login and other account related operations, common to all types of users.")
public class CommonUserController {
}
