package com.aeontanvir.propertymanagementsystem.controllers;


import com.aeontanvir.propertymanagementsystem.apiresponse.ApiResponse;
import com.aeontanvir.propertymanagementsystem.dtos.PropertyDto;
import com.aeontanvir.propertymanagementsystem.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PropertyDto>>> getAll() {
        List<PropertyDto> properties = propertyService.getAll();
        return ResponseEntity.ok(ApiResponse.success("Properties retrieved successfully.", properties));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PropertyDto>> geById(@PathVariable Long id) {
        PropertyDto property = propertyService.getById(id);
        return ResponseEntity.ok(ApiResponse.success("Property retrieved successfully.", property));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PropertyDto>> create(@RequestBody PropertyDto propertyDto) {
        PropertyDto createdProperty = propertyService.create(propertyDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Property created successfully.", createdProperty));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<PropertyDto>> update(@PathVariable Long id,
            @RequestBody PropertyDto propertyDto) {
        PropertyDto updatedProperty = propertyService.update(id, propertyDto);
        return ResponseEntity.ok(ApiResponse.success("Property updated successfully.", updatedProperty));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PropertyDto>> replace(@PathVariable Long id,
            @RequestBody PropertyDto propertyDto) {
        PropertyDto updatedProperty = propertyService.replace(id, propertyDto);
        return ResponseEntity.ok(ApiResponse.success("Property updated successfully.", updatedProperty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        propertyService.removeById(id);
        return ResponseEntity.ok(ApiResponse.success("Property deleted successfully.", null));
    }

}
