package com.saiful.restApi.repository;

import com.saiful.restApi.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepo extends JpaRepository<Agent, Long> {


}
