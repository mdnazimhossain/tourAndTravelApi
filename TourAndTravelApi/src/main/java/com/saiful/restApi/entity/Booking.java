package com.saiful.restApi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
