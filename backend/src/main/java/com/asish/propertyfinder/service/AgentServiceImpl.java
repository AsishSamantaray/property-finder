package com.asish.propertyfinder.service;

import com.asish.propertyfinder.dto.AgentDto;
import com.asish.propertyfinder.entity.Agent;
import com.asish.propertyfinder.repository.AgentRepository;
import com.asish.propertyfinder.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final ModelMapper modelMapper;
    private final AgentRepository agentRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public void createAgent(AgentDto agentDto) {
        Agent agent = agentDtoToAgentEntity(agentDto);
        propertyRepository.findAllById(agentDto.getPropertyIds()).forEach(agent::addProperty);
        agentRepository.save(agent);
    }

    @Override
    public List<AgentDto> getAllProperties() {
        return agentRepository.findAll().stream()
                .map(this::agentEntityToAgentDto).collect(Collectors.toList());
    }

    @Override
    public AgentDto getAgentById(Long agentId) {
        return agentEntityToAgentDto(agentRepository.findById(agentId).orElseThrow());
    }

    @Override
    public void updateAgent(Long agentId, AgentDto agentDto) {
        Agent agentById = agentRepository.findById(agentId).orElseThrow();
        Agent agent = agentDtoToAgentEntity(agentDto);
        agent.setAgentId(agentById.getAgentId());
        agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId).orElseThrow();
        agentRepository.delete(agent);
    }

    private AgentDto agentEntityToAgentDto(Agent agent) {
        return modelMapper.map(agent, AgentDto.class);
    }

    private Agent agentDtoToAgentEntity(AgentDto agentDto) {
        return modelMapper.map(agentDto, Agent.class);
    }
}

