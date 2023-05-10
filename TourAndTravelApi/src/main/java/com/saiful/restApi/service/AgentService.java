package com.saiful.restApi.service;


import com.saiful.restApi.entity.Agent;
import com.saiful.restApi.repository.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class AgentService {
    @Autowired
    AgentRepo agentRepo;

    public List<Agent> findAll() {

        return agentRepo.findAll();
    }

    public void save(Agent agentNew) {
        if (agentNew.getId()!= null){
            agentRepo.findById(agentNew.getId())
                    .map(old -> {

//                        private String name;
//                        private String email;
//                        private String address;
//                        private String bankAccountNo;
//                        private String mobileNo;

                        old.setName(agentNew.getName());
                        old.setEmail(agentNew.getEmail());
                        old.setAddress(agentNew.getAddress());
                        old.setBankAccountNo(agentNew.getBankAccountNo());
                        old.setMobileNo(agentNew.getMobileNo());

                        return agentRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return agentRepo.save(agentNew);
                    });
        }else {
            agentRepo.save(agentNew);
        }
    }

    public Agent getById(Long id) {
       return agentRepo.findById(id).orElse(new Agent());
    }

    public void delete(Long id) {
         agentRepo.deleteById(id);
    }

}
