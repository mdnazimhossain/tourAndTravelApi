package com.saiful.restApi.entity;


import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UmrahPackage extends BaseModel {

    private String name;
    private String type;
    private String price;
    private String startDate;
    private String endDate;
    private String description;
    private String location;
    private String imageLink;



}
