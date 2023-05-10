package com.saiful.restApi.dtos;

import lombok.Data;

@Data
public class CancellationDTO {
    private String bookingId;
    private String billingId;
    private String customerId;

    private String refundReason ;
    private Integer RefundAmount;
    private String CancellationDate;
    private String status;

}
