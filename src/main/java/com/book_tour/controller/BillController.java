package com.book_tour.controller;

import com.book_tour.model.Account;
import com.book_tour.model.Bill;
import com.book_tour.model.Status;
import com.book_tour.repository.IAccountRepository;
import com.book_tour.repository.IBillRepository;
import com.book_tour.repository.IStatusRepository;
import com.book_tour.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    IBillService iBillService;
    @Autowired
    IBillRepository iBillRepository;
    @Autowired
    IStatusRepository iStatusRepository;
    @Autowired
    IAccountRepository iAccountRepository;

    @GetMapping("/createBill")
    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(iBillService.createBill2(bill), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addBill(@RequestBody Bill bill){
        return new ResponseEntity<>( iBillService.createBill2(bill),HttpStatus.OK);
    }
    @PostMapping("/getBillByIdAcc/{idStatus}/{idAcc}")
    public ResponseEntity<List<Bill>> getAllBillByIdAcc(@PathVariable String idStatus, @PathVariable long idAcc){
        if ("null".equals(idStatus)){
            return new ResponseEntity<>(iBillService.getBillByIdAcc(idAcc),HttpStatus.OK);
        }else {
            Long statusId = Long.parseLong(idStatus);
            return new ResponseEntity<>(iBillService.getBillFilterAcc(statusId, idAcc),HttpStatus.OK);
        }
    }
    @PostMapping("/getBillByIdUser/{idStatus}/{idAcc}")
    public ResponseEntity<List<Bill>> getAllBillByIdUser(@PathVariable String idStatus, @PathVariable long idAcc){
        if ("null".equals(idStatus)){
            return new ResponseEntity<>(iBillService.getBillByIdUser(idAcc),HttpStatus.OK);
        }else {
            Long statusId = Long.parseLong(idStatus);
            return new ResponseEntity<>(iBillService.getBillFilterAcc(statusId, idAcc),HttpStatus.OK);
        }
    }
    @PostMapping("/cancel/{idBill}")
    public ResponseEntity<String> cancelBill(@PathVariable Long idBill){
        Bill bill = iBillRepository.findById(idBill).get();
        Status status = iStatusRepository.findById(6L).get();
        bill.setStatus(status);
        iBillService.edit(bill);
        return new ResponseEntity<>("Hủy Tour thành công", HttpStatus.OK);
    }
    @PostMapping("/confirm/{idBill}")
    public ResponseEntity<String> confirmBill(@PathVariable Long idBill){
        Bill bill = iBillRepository.findById(idBill).get();
        Status status = iStatusRepository.findById(5L).get();
        bill.setStatus(status);
        iBillService.edit(bill);
        return new ResponseEntity<>("Xác nhận Tour thành công", HttpStatus.OK);
    }
    @PostMapping("/complete/{idBill}")
    public ResponseEntity<String> completeBill(@PathVariable Long idBill){
        Bill bill = iBillRepository.findById(idBill).get();
        Status status = iStatusRepository.findById(7L).get();
        bill.setStatus(status);
        iBillService.edit(bill);
        Account accountUser = bill.getAccountUser();
        accountUser.setBalance((long) ((bill.getTotal()*0.7)+accountUser.getBalance()));
        Account accountAcc = bill.getAccountCC();
        accountAcc.setBalance(accountAcc.getBalance()- (long)  (bill.getTotal()*0.7));
        iAccountRepository.save(accountAcc);
        iAccountRepository.save(accountUser);
        return new ResponseEntity<>("Tour đã hoàn thành", HttpStatus.OK);
    }
}
