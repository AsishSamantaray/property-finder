package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.AgentRequestDto;
import com.asish.propertyfinder.dto.AgentResponseDto;
import com.asish.propertyfinder.entity.Agent;
import com.asish.propertyfinder.exception.BusinessException;
import com.asish.propertyfinder.repository.AgentRepository;
import com.asish.propertyfinder.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {

    public static final String AGENT_NOT_FOUND = "Agent not found with id {0}";

    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public void createAgent(AgentRequestDto agentRequestDto) {
        Agent agent = agentRequestDtoToAgentEntity(agentRequestDto);
        Set<UUID> propertyIds = agentRequestDto.getPropertyIds();
        if (propertyIds != null && !propertyIds.isEmpty()) {
            propertyRepository.findAllById(propertyIds).forEach(agent::addProperty);
        }
        agentRepository.save(agent);
    }

    @Override
    public List<AgentResponseDto> getAllAgents() {
        return agentRepository.findAll().stream()
                .map(this::agentEntityToAgentResponseDto).collect(Collectors.toList());
    }

    @Override
    public AgentResponseDto getAgentById(UUID agentId) {
        return agentEntityToAgentResponseDto(agentRepository.findById(agentId)
                .orElseThrow(() -> new BusinessException(MessageFormat.format(AGENT_NOT_FOUND, agentId))));
    }

    @Override
    public void updateAgent(UUID agentId, AgentRequestDto agentRequestDto) {
        Agent agentById = agentRepository.findById(agentId)
                .orElseThrow(() -> new BusinessException(MessageFormat.format(AGENT_NOT_FOUND, agentId)));
        Agent agent = agentRequestDtoToAgentEntity(agentRequestDto);
        agent.setAgentId(agentById.getAgentId());
        agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(UUID agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new BusinessException(MessageFormat.format(AGENT_NOT_FOUND, agentId)));
        agentRepository.delete(agent);
    }

    private Agent agentRequestDtoToAgentEntity(AgentRequestDto agentRequestDto) {
        return modelMapper.map(agentRequestDto, Agent.class);
    }

    private AgentResponseDto agentEntityToAgentResponseDto(Agent agent) {
        return modelMapper.map(agent, AgentResponseDto.class);
    }
}

