package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.PropertyDto;

import java.util.List;

public interface PropertyService {

    void createProperty(PropertyDto propertyDto);

    List<PropertyDto> getAllProperties();

    PropertyDto getPropertyById(Long propertyId);

    void updateProperty(Long propertyId, PropertyDto propertyDto);

    void deleteProperty(Long propertyId);
}
