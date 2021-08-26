package com.asish.propertyfinder.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    private Integer userId;
    private String propertyName;
    private Integer propertyId;
    private String name;
    private String email;
    private String phone;
    private String message;
}
