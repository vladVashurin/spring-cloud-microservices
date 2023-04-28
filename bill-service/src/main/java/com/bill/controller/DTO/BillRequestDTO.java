package com.bill.controller.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor
public class BillRequestDTO {

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationDate;

    private Boolean overDraftEnabled;
}
