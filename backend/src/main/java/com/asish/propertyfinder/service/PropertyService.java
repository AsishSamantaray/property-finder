package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.PropertyRequestDto;
import com.asish.propertyfinder.dto.PropertyResponseDto;

import java.util.List;
import java.util.UUID;

public interface PropertyService {

    void createProperty(PropertyRequestDto propertyRequestDto);

    List<PropertyResponseDto> getAllProperties();

    PropertyResponseDto getPropertyById(UUID propertyId);

    void updateProperty(UUID propertyId, PropertyRequestDto propertyRequestDto);

    void deleteProperty(UUID propertyId);
}
