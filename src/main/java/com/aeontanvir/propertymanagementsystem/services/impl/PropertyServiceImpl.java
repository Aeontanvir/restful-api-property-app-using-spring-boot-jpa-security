package com.aeontanvir.propertymanagementsystem.services.impl;

import com.aeontanvir.propertymanagementsystem.domains.Address;
import com.aeontanvir.propertymanagementsystem.domains.Property;
import com.aeontanvir.propertymanagementsystem.domains.Role;
import com.aeontanvir.propertymanagementsystem.domains.User;
import com.aeontanvir.propertymanagementsystem.dtos.PropertyDto;
import com.aeontanvir.propertymanagementsystem.exceptions.ApiRequestException;
import com.aeontanvir.propertymanagementsystem.exceptions.ResourceNotFoundException;
import com.aeontanvir.propertymanagementsystem.helpers.ModelMapperHelper;
import com.aeontanvir.propertymanagementsystem.repositories.PropertyRepository;
import com.aeontanvir.propertymanagementsystem.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final ModelMapperHelper modelMapperHelper;
    @Override
    public List<PropertyDto> getAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authUser = (User) authentication.getPrincipal();
        List<Property> properties;
        if(!authUser.getRole().equals(Role.OWNER)){
            properties = propertyRepository.findAll();
        }else{
            properties = propertyRepository.findByOwnerId(authUser.getId());
        }
        return modelMapperHelper.convertToDtoList(properties, PropertyDto.class);
    }

    @Override
    public PropertyDto getById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));
        return modelMapperHelper.convertToDto(property, PropertyDto.class);
    }

    @Override
    public PropertyDto create(PropertyDto propertyDto) {
        Property property = modelMapperHelper.convertToEntity(propertyDto, Property.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User authUser = (User) authentication.getPrincipal();
        if(authUser.getRole().equals(Role.OWNER)){
            property.setOwner(authUser);
            Property savedProperty = propertyRepository.save(property);
            return modelMapperHelper.convertToDto(savedProperty, PropertyDto.class);
        }else {
            throw new ApiRequestException("Only owner can add property");
        }

    }

    @Override
    public PropertyDto replace(Long id, PropertyDto propertyDto) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));
        Property updatedProperty = propertyRepository.save(existingProperty);
        return modelMapperHelper.convertToDto(updatedProperty, PropertyDto.class);
    }

    @Override
    public PropertyDto update(Long id, PropertyDto propertyDto) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));

        if (propertyDto.getName() != null) {
            existingProperty.setName(propertyDto.getName());
        }
        if (propertyDto.getDescription() != null) {
            existingProperty.setDescription(propertyDto.getDescription());
        }
        if (propertyDto.getAddress() != null) {
            existingProperty.setAddress(modelMapperHelper.convertToEntity(propertyDto.getAddress(), Address.class));
        }
        if (propertyDto.getSize() != null) {
            existingProperty.setSize(propertyDto.getSize());
        }
        if (propertyDto.getRoom() != null) {
            existingProperty.setRoom(propertyDto.getRoom());
        }
        if (propertyDto.getBath() != null) {
            existingProperty.setBath(propertyDto.getBath());
        }
        if (propertyDto.getKitchen() != null) {
            existingProperty.setKitchen(propertyDto.getKitchen());
        }
        if (propertyDto.getStatus() != null) {
            existingProperty.setStatus(propertyDto.getStatus());
        }
        if (propertyDto.getPrice() > 0) {
            existingProperty.setPrice(propertyDto.getPrice());
        }

        Property updatedProperty = propertyRepository.save(existingProperty);
        return modelMapperHelper.convertToDto(updatedProperty, PropertyDto.class);
    }


    @Override
    public void removeById(Long id) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id: " + id));

        propertyRepository.delete(existingProperty);
    }
}
