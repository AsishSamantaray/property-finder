package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.AgentDto;

import java.util.List;

public interface AgentService {

    void createAgent(AgentDto agentDto);

    List<AgentDto> getAllProperties();

    AgentDto getAgentById(Long agentId);

    void updateAgent(Long agentId, AgentDto agentDto);

    void deleteAgent(Long agentId);
}
