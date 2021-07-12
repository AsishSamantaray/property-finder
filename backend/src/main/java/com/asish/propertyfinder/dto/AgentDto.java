package com.asish.propertyfinder.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AgentDto {

    private String name;
    private String image;
    private String description;
    private String email;
    private String mobileNumber;
    private boolean isMvp;
    private Set<Long> propertyIds;
}
