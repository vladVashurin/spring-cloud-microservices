package com.bill.service;

import com.bill.entity.Bill;
import com.bill.exeptions.BillNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bill.repository.BillRepository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class BillService {
    private final BillRepository billRepository;
@Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long billId){
    return billRepository.findById(billId).orElseThrow(()->new BillNotFoundException("Unable to found bill with id: " +billId));
    }

    public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overDraftEnabled){
    Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overDraftEnabled);
    billRepository.save(bill);
    return bill.getBillId();
    }

    public Bill updateBill(Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overDraftEnabled){
Bill bill = getBillById(billId);
bill.setAccountId(accountId);
bill.setAmount(amount);
bill.setIsDefault(isDefault);
bill.setOverDraftEnabled(overDraftEnabled);
return billRepository.save(bill);
    }

    public Bill deleteById(Long billId){
    Bill bill = getBillById(billId);
    billRepository.deleteById(billId);
    return bill;
    }
}