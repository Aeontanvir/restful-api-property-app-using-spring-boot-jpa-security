package com.aeontanvir.propertymanagementsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String size;
    private String room;
    private String bath;
    private String ketchen;
    private String status;
    private double price;
}
