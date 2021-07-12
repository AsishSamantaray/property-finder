package com.asish.propertyfinder.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String fullAddress;
    private String city;
    private String state;
    private String zipCode;
}
