package com.saiful.restApi.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customer extends BaseModel {

    private String name;
    private String mobileNo;
    private String passportNo;
    private String address;
    @OneToMany
    private List<Booking> booking;


    





}
