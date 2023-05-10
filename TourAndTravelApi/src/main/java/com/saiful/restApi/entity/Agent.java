package com.saiful.restApi.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Agent extends BaseModel {

    private String name;
    private String email;
    private String address;
    private String bankAccountNo;
    private String mobileNo;




}
