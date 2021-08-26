package com.asish.propertyfinder.dto;

import lombok.*;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {

    private Long propertyId;
    private String fullAddress;
    private String city;
    private String state;
    private String zipCode;
    private String description;
    private BigInteger price;
    private Integer bedroom;
    private Integer garage;
    private Integer bathroom;
    private Integer totalArea;
    private boolean isPublished;
    private String mainImage;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
    private Long agentId;
}
