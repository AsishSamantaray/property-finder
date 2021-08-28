package com.asish.propertyfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentRequestDto {

    private String name;
    private String image;
    private String description;
    private String email;
    private String mobileNumber;
    private boolean isMvp;
    private Set<UUID> propertyIds;
}
