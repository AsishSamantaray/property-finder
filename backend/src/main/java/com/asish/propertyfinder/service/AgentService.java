package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.AgentRequestDto;
import com.asish.propertyfinder.dto.AgentResponseDto;

import java.util.List;
import java.util.UUID;

public interface AgentService {

    void createAgent(AgentRequestDto agentRequestDto);

    List<AgentResponseDto> getAllAgents();

    AgentResponseDto getAgentById(UUID agentId);

    void updateAgent(UUID agentId, AgentRequestDto agentRequestDto);

    void deleteAgent(UUID agentId);
}
