package com.saiful.restApi.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseModel {

    private String name;
    private String mobileNo;
    private String passportNo;
    private String address;
    @OneToMany
    private List<Booking> booking;








}
