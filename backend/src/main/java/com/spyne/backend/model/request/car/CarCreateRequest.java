package com.spyne.backend.model.request.car;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class CarCreateRequest {
    private String name;
    private String dealerId;
    private String companyId;
    private String description;
    private List<String> tags;
    private List<MultipartFile> images;
}
