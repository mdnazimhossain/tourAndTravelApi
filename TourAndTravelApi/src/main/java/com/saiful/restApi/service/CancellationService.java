package com.saiful.restApi.service;


import com.saiful.restApi.entity.Cancellation;
import com.saiful.restApi.repository.CancellationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class CancellationService {
    @Autowired
    CancellationRepo cancellationRepo;

    public List<Cancellation> findAll() {

        return cancellationRepo.findAll();
    }

    public void save(Cancellation cancellationNew) {
        if (cancellationNew.getId()!= null){
            cancellationRepo.findById(cancellationNew.getId())
                    .map(old -> {
//
//                        private String bookingId;
//                        private String billingId;
//                        private String customerId;
//
//                        private String refundReason ;
//                        private Integer RefundAmount;
//                        private String CancellationDate;
//                        private String status;

                        old.setBookingId(cancellationNew.getBookingId());
                        old.setBillingId(cancellationNew.getBillingId());
                        old.setCustomerId(cancellationNew.getCustomerId());
                        old.setRefundReason(cancellationNew.getRefundReason());
                        old.setCancellationDate(cancellationNew.getCancellationDate());
                        old.setStatus(cancellationNew.getStatus());


                        return cancellationRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return cancellationRepo.save(cancellationNew);
                    });
        }else {
            cancellationRepo.save(cancellationNew);
        }
    }

    public Cancellation getById(Long id) {
       return cancellationRepo.findById(id).orElse(new Cancellation());
    }

    public void delete(Long id) {
         cancellationRepo.deleteById(id);
    }

}
