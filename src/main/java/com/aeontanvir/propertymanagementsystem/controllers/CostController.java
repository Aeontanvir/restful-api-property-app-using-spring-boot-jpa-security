package com.aeontanvir.propertymanagementsystem.controllers;


import com.aeontanvir.projectcosting.apiresponse.ApiResponse;
import com.aeontanvir.projectcosting.dtos.CostDto;
import com.aeontanvir.projectcosting.services.CostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/costs")
@RequiredArgsConstructor
public class CostController {
    private final CostService costService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CostDto>>> getAll() {
        List<CostDto> costs = costService.getAll();
        return ResponseEntity.ok(ApiResponse.success("Costs retrieved successfully.", costs));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CostDto>> geById(@PathVariable Long id) {
        CostDto cost = costService.getById(id);
        return ResponseEntity.ok(ApiResponse.success("Cost retrieved successfully.", cost));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CostDto>> create(@RequestBody CostDto CostDto) {
        CostDto createdCost = costService.create(CostDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Cost created successfully.", createdCost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CostDto>> update(@PathVariable Long id,
            @RequestBody CostDto CostDto) {
        CostDto updatedCost = costService.update(id, CostDto);
        return ResponseEntity.ok(ApiResponse.success("Cost updated successfully.", updatedCost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        costService.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Cost deleted successfully.", null));
    }

}
