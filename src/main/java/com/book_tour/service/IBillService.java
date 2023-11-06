package com.book_tour.service;

import com.book_tour.model.Bill;

import java.util.List;

public interface IBillService extends ICrudService<Bill>{

     String createBill2 (Bill bill);
     List<Bill> getBillFilterAcc(long idStatus, long idAcc);
     List<Bill> getBillByIdAcc(long idAcc);
     List<Bill> getBillByIdUser(long idUser);
}
