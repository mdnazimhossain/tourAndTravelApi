package com.saiful.restApi.dtos;

import lombok.Data;

@Data
public class AgentDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String bankAccountNo;
    private String mobileNo;

}
