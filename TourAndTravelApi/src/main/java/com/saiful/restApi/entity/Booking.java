package com.saiful.restApi.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Booking extends BaseModel {

    private String Date;
    private String details;
    private String bookedBy;
    private String billing;
    private String status;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private HajjPackage hajjPackage;



}
