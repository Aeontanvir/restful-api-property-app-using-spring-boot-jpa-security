package com.aeontanvir.propertymanagementsystem.services.impl;

import com.aeontanvir.propertymanagementsystem.domains.Property;
import com.aeontanvir.propertymanagementsystem.dtos.PropertyDto;
import com.aeontanvir.propertymanagementsystem.exceptions.ResourceNotFoundException;
import com.aeontanvir.propertymanagementsystem.helpers.ModelMapperHelper;
import com.aeontanvir.propertymanagementsystem.repositories.PropertyRepository;
import com.aeontanvir.propertymanagementsystem.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final ModelMapperHelper modelMapperHelper;
    @Override
    public List<PropertyDto> getAll() {
        List<Property> properties = propertyRepository.findAll();
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
        Property savedProperty = propertyRepository.save(property);
        return modelMapperHelper.convertToDto(savedProperty, PropertyDto.class);
    }

    @Override
    public PropertyDto replace(Long id, PropertyDto propertyDto) {
        return null;
    }

    @Override
    public PropertyDto update(Long id, PropertyDto propertyDto) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
