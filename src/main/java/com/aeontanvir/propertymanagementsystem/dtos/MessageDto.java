package com.aeontanvir.propertymanagementsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    private String message;
    private UserDto user;
    private PropertyDto property;
}
