package com.bill.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationDate;

    private Boolean overDraftEnabled;

    public Bill(Long accountId, BigDecimal amount, Boolean isDefault, OffsetDateTime creationDate, Boolean overDraftEnabled) {
        this.accountId = accountId;
        this.amount = amount;
        this.isDefault = isDefault;
        this.creationDate = creationDate;
        this.overDraftEnabled = overDraftEnabled;
    }

    public Bill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overDraftEnabled) {
        this.accountId = accountId;
        this.amount = amount;
        this.isDefault = isDefault;
        this.overDraftEnabled = overDraftEnabled;
    }
}
