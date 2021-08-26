package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.PropertyDto;
import com.asish.propertyfinder.entity.Property;
import com.asish.propertyfinder.repository.AgentRepository;
import com.asish.propertyfinder.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public void createProperty(PropertyDto propertyDto) {
//        Optional.ofNullable(propertyDto).orElseThrow()
        Property property = propertyDtoToPropertyEntity(propertyDto);
        property.setAgent(agentRepository.findById(propertyDto.getAgentId()).orElseThrow());
        propertyRepository.save(property);
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        return propertyRepository.findAll().stream()
                .map(this::propertyEntityToPropertyDto).collect(Collectors.toList());
    }

    @Override
    public PropertyDto getPropertyById(Long propertyId) {
        return propertyEntityToPropertyDto(propertyRepository.findById(propertyId).orElseThrow());
    }

    @Override
    public void updateProperty(Long propertyId, PropertyDto propertyDto) {
        Property propertyById = propertyRepository.findById(propertyId).orElseThrow();
        Property property = propertyDtoToPropertyEntity(propertyDto);
        property.setPropertyId(propertyById.getPropertyId());
        propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(Long propertyId) {
        Property property = propertyRepository.findById(propertyId).orElseThrow();
        propertyRepository.delete(property);
    }

    private PropertyDto propertyEntityToPropertyDto(Property property) {
        return modelMapper.map(property, PropertyDto.class);
    }

    private Property propertyDtoToPropertyEntity(PropertyDto propertyDto) {
        return modelMapper.map(propertyDto, Property.class);
    }
}
