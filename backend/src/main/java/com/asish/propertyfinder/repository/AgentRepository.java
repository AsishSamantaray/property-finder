package com.asish.propertyfinder.repository;

import com.asish.propertyfinder.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgentRepository extends JpaRepository<Agent, UUID> {
}
