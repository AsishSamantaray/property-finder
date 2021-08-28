package com.asish.propertyfinder.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentResponseDto {

    private UUID agentId;
    private String name;
    private String image;
    private String description;
    private String email;
    private String mobileNumber;
    private boolean isMvp;
    private Set<PropertyRequestDto> properties;
}
