package com.asish.propertyfinder.controller;

import com.asish.propertyfinder.dto.PropertyRequestDto;
import com.asish.propertyfinder.dto.PropertyResponseDto;
import com.asish.propertyfinder.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
@Api("REST API for Properties.")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/add-property")
    @ApiOperation(value = "API for add new Property.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Void> addProperty(@RequestBody PropertyRequestDto propertyRequestDto) {
        propertyService.createProperty(propertyRequestDto);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping("/properties")
    @ApiOperation(value = "API for get all Properties.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content")
    })
    public ResponseEntity<List<PropertyResponseDto>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/property/{propertyId}")
    @ApiOperation(value = "API for get Property by property ID.", response = PropertyRequestDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<PropertyResponseDto> getPropertyById(@PathVariable UUID propertyId) {
        return ResponseEntity.ok(propertyService.getPropertyById(propertyId));
    }

    @PutMapping("/property/{propertyId}")
    @ApiOperation(value = "API for update Property by property ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Void> updatePropertyById(@PathVariable UUID propertyId, @RequestBody PropertyRequestDto propertyRequestDto) {
        propertyService.updateProperty(propertyId, propertyRequestDto);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/property/{propertyId}")
    @ApiOperation(value = "API for delete Property by property ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Void> deletePropertyById(@PathVariable UUID propertyId) {
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.status(OK).build();
    }
}
