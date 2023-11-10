package com.book_tour.service.impl;

import com.book_tour.model.Account;
import com.book_tour.model.Bill;
import com.book_tour.model.Status;
import com.book_tour.repository.IAccountRepository;
import com.book_tour.repository.IBillRepository;
import com.book_tour.repository.IStatusRepository;
import com.book_tour.service.IAccountService;
import com.book_tour.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Service
public class BillServiceImpl implements IBillService {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IAccountRepository iAccountRepository;
    @Autowired
    IBillRepository iBillRepository;
    @Autowired
    IStatusRepository iStatusRepository;

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
        return iBillRepository.save(bill);
    }

    @Override
    public void deleteById(long id) {
    }

    @Override
    public String createBill2(Bill bill) {
        Account user = iAccountRepository.findById( bill.getAccountUser().getId()).get();
        if (!user.getIsActive() && Objects.equals(user.getStatus().getName(), "Active")) {
            return "Bạn đang bị khóa";
        } else if (user.getBalance() < bill.getTotal()) {
            return "Bạn không đủ số dư";
        } else {
            user.setBalance(user.getBalance() - bill.getTotal());
            iAccountService.edit(user);
            create(bill);
            return "1";
        }
    }

    @Override
    public List<Bill> getBillFilterAcc(long idStatus, long idAcc) {
        List<Bill> billList = iBillRepository.findBillsByStatusIds(idStatus,idAcc);
        return billList;
    }

    @Override
    public List<Bill> getBillFilterUser(long idStatus, long idUser) {
        List<Bill> billList = iBillRepository.findBillsByStatusAndByIdUser(idStatus,idUser);
        return billList;
    }

    @Override
    public List<Bill> getBillByIdAcc(long idAcc) {

        return iBillRepository.getAllByAccountCC_Id(idAcc);
    }

    @Override
    public List<Bill> getBillByIdUser(long idUser) {
        return iBillRepository.getAllByAccountUser_Id(idUser);
    }

    @Override
    public Bill getLatestBillBy2Acc(Long tourId, Long userId) {
        try {
            List<Bill>  results= entityManager.createQuery("select b from  Bill b " +
                    "where b.accountUser.id = :userId and b.tour.id = :tourId and b.isActive = true " +
                    "and  b.status.id = 7 order by  b.id desc ")
                    .setMaxResults(1)
                    .setParameter("tourId", tourId)
                    .setParameter("userId", userId)
                    .getResultList();
            return results.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
