package com.logical.tronixpayadmin.model.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logical.tronixpayadmin.entity.Transaction;
import com.logical.tronixpayadmin.enums.PaymentMode;
import com.logical.tronixpayadmin.enums.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionWrapper {
    private Long id;
    private String transactionId;
    private double amount;
    private PaymentMode paymentMode;
    private TransactionStatus transactionStatus;
    private String transactionDateTime;
    private String memberId;
    private String vendorGenId;
    private String vendorName;
    private String memberName;
    private String businessName;


    public TransactionWrapper(Transaction transaction , String dateTime ) {
        this.id = transaction.getId();
        this.transactionId = transaction.getTransactionId();
        this.amount = transaction.getAmount();
        this.paymentMode = transaction.getPaymentMode();
        this.transactionStatus = transaction.getTransactionStatus();
        this.transactionDateTime = dateTime;
        this.memberId = transaction.getUser().getMemberId();
        this.vendorGenId = transaction.getVendor().getVendorGenId();
        this.vendorName = transaction.getVendor().getUser().getUserName();
        this.memberName = transaction.getUser().getUserName();
        this.businessName = transaction.getVendor().getBusinessName();
    }
}
