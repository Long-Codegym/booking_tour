package com.book_tour.service.impl;

import com.book_tour.model.Account;
import com.book_tour.model.Bill;
import com.book_tour.repository.IAccountRepository;
import com.book_tour.repository.IBillRepository;
import com.book_tour.service.IAccountService;
import com.book_tour.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IAccountRepository iAccountRepository;
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public List<Bill> getAll() {
        return null;
    }

    @Override
    public Bill getById(long id) {
        return null;
    }

    @Override
    public Bill create(Bill bill) {
        iBillRepository.save(bill);
        return null;
    }

    @Override
    public Bill edit(Bill bill) {
        return null;
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public String createBill2(Bill bill) {
        Account user = iAccountRepository.findById( bill.getAccountUser().getId()).get();
        if (!user.getIsActive() && Objects.equals(user.getStatus().getName(), "Active")) {
            return "Bạn đang bị khóa ";
        } else if (user.getBalance() < bill.getTotal()) {
            return "Bạn không đủ số dư ";
        } else {
            user.setBalance(user.getBalance() - bill.getTotal());
            iAccountService.edit(user);
            create(bill);
            return "Bạn đã đăng ký Tour thành công";
        }
    }
}
