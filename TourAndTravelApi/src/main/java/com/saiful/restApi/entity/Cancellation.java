package com.saiful.restApi.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Cancellation extends BaseModel {

    private String bookingId;
    private String billingId;
    private String customerId;

    private String refundReason ;
    private Integer RefundAmount;
    private String CancellationDate;
    private String status;





}
