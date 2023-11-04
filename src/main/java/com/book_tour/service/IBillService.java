package com.book_tour.service;

import com.book_tour.model.Bill;

public interface IBillService extends ICrudService<Bill>{

     String createBill2 (Bill bill);
}
