package com.bill.controller;

import com.bill.controller.DTO.BillRequestDTO;
import com.bill.controller.DTO.BillResponseDTO;
import com.bill.service.BillService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/billId")
    public BillResponseDTO getBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount(), billRequestDTO.getIsDefault(), billRequestDTO.getOverDraftEnabled());
    }
    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId, @RequestBody BillRequestDTO billRequestDTO){
     return new BillResponseDTO(billService.updateBill(billId, billRequestDTO.getAccountId(), billRequestDTO.getAmount(), billRequestDTO.getIsDefault(), billRequestDTO.getOverDraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId){
        return new BillResponseDTO(billService.deleteById(billId));
    }
}
