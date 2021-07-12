package com.asish.propertyfinder.repository;

import com.asish.propertyfinder.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
