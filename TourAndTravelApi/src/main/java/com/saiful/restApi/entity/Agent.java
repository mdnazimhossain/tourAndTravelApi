package com.saiful.restApi.entity;


import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Agent extends BaseModel {

    private String name;
    private String email;
    private String address;
    private String bankAccountNo;
    private String mobileNo;




}
