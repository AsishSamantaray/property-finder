package com.asish.propertyfinder.dto;

import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentDto {

    private Long agentId;
    private String name;
    private String image;
    private String description;
    private String email;
    private String mobileNumber;
    private boolean isMvp;
    private Set<Long> propertyIds;
}
