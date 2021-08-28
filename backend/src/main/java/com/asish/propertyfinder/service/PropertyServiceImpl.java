package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.PropertyRequestDto;
import com.asish.propertyfinder.dto.PropertyResponseDto;
import com.asish.propertyfinder.entity.Property;
import com.asish.propertyfinder.exception.BusinessException;
import com.asish.propertyfinder.repository.AgentRepository;
import com.asish.propertyfinder.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    public static final String PROPERTY_NOT_FOUND = "Property not found with id {0}";
    public static final String AGENT_NOT_FOUND = "Agent not found with id {0}";

    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public void createProperty(PropertyRequestDto propertyRequestDto) {
//        Optional.ofNullable(propertyDto).orElseThrow()
        Property property = propertyRequestDtoToPropertyEntity(propertyRequestDto);
        property.setAgent(agentRepository.findById(propertyRequestDto.getAgentId())
                .orElseThrow(() -> new BusinessException(MessageFormat.format(AGENT_NOT_FOUND, propertyRequestDto.getAgentId()))));
        propertyRepository.save(property);
    }

    @Override
    public List<PropertyResponseDto> getAllProperties() {
        return propertyRepository.findAll().stream()
                .map(this::propertyEntityToPropertyResponseDto).collect(Collectors.toList());
    }

    @Override
    public PropertyResponseDto getPropertyById(UUID propertyId) {
        return propertyEntityToPropertyResponseDto(propertyRepository.findById(propertyId)
                .orElseThrow(() -> new BusinessException(MessageFormat.format(PROPERTY_NOT_FOUND, propertyId))));
    }

    @Override
    public void updateProperty(UUID propertyId, PropertyRequestDto propertyRequestDto) {
        Property propertyById = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new BusinessException(MessageFormat.format(PROPERTY_NOT_FOUND, propertyId)));
        Property property = propertyRequestDtoToPropertyEntity(propertyRequestDto);
        property.setPropertyId(propertyById.getPropertyId());
        propertyRepository.save(property);
    }

    @Override
    public void deleteProperty(UUID propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new BusinessException(MessageFormat.format(PROPERTY_NOT_FOUND, propertyId)));
        propertyRepository.delete(property);
    }

    private Property propertyRequestDtoToPropertyEntity(PropertyRequestDto propertyRequestDto) {
        return modelMapper.map(propertyRequestDto, Property.class);
    }

    private PropertyResponseDto propertyEntityToPropertyResponseDto(Property property) {
        return modelMapper.map(property, PropertyResponseDto.class);
    }

}
