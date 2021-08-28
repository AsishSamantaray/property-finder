package com.asish.propertyfinder.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDto {

    private Integer userId;
    private String propertyName;
    private UUID propertyId;
    private String name;
    private String email;
    private String phone;
    private String message;
}
