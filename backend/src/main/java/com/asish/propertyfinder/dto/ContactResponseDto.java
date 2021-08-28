package com.asish.propertyfinder.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDto {

    private UUID contactId;
    private Integer userId;
    private String propertyName;
    private PropertyResponseDto property;
    private String name;
    private String email;
    private String phone;
    private String message;
}
