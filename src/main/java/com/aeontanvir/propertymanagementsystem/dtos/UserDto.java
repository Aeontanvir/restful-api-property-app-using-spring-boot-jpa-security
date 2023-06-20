package com.aeontanvir.propertymanagementsystem.dtos;

import com.aeontanvir.propertymanagementsystem.domains.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String email;
    private Boolean active;
    private Role role;

}
