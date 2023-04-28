package com.bill.controller.DTO;

import com.bill.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Getter
@AllArgsConstructor
public class BillResponseDTO {
    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationDate;

    private Boolean overDraftEnabled;

    public BillResponseDTO (Bill bill){
        this.billId = bill.getBillId();
        this.accountId = bill.getAccountId();
        this.amount = bill.getAmount();
        this.isDefault = bill.getIsDefault();
        this.creationDate = bill.getCreationDate();
        this.overDraftEnabled = bill.getOverDraftEnabled();
    }
}
