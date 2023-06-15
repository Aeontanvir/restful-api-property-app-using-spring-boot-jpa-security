package com.aeontanvir.propertymanagementsystem.services;

import com.aeontanvir.propertymanagementsystem.dtos.PropertyDto;

import java.util.List;

public interface PropertyService {
    public List<PropertyDto> getAll();
    public PropertyDto getById(Long id);
    public PropertyDto create(PropertyDto propertyDto);
    public PropertyDto replace(Long id, PropertyDto propertyDto);
    public PropertyDto update(Long id, PropertyDto propertyDto);
    public void removeById(Long id);
}
