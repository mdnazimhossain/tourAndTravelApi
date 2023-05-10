package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.AgentDTO;
import com.saiful.restApi.entity.Agent;
import com.saiful.restApi.service.AgentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AgentController {
    @Autowired
    AgentService agentService;
    @PostMapping("/agent")
    public void save(@RequestBody AgentDTO agentDTO){
        if (agentDTO != null){
            Agent Agent = new Agent();
            BeanUtils.copyProperties(agentDTO, Agent);
            agentService.save(Agent);
        }
    }
    @PutMapping("/agent")
    public void update( @RequestBody AgentDTO agentDTO){
        if (agentDTO != null){
            Agent Agent = new Agent();
            BeanUtils.copyProperties(agentDTO, Agent);
            agentService.save(Agent);
        }
    }
    @GetMapping("/agent")
    List<AgentDTO> all() {
        List<Agent> Agents = agentService.findAll();
        List<AgentDTO> agentDTOList = new ArrayList<>();
        for (Agent Agent : Agents
        ) {
            AgentDTO agentDTO = new AgentDTO();
            BeanUtils.copyProperties(Agent, agentDTO);
            agentDTOList.add(agentDTO);
        }
        return agentDTOList;
    }
    @DeleteMapping("/agent/{id}")
    public void delete(@PathVariable("id") Long id){
        agentService.delete(id);
    }


    @GetMapping("/agent/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        Agent Agent;
        Agent = agentService.getById(id);
        if (Agent.getId() != null){
            AgentDTO agentDTO = new AgentDTO();
            BeanUtils.copyProperties(Agent, agentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(agentDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
