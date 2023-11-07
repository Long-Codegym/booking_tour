package com.book_tour.repository;

import com.book_tour.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Bill b JOIN Status s ON b.status_id = s.id JOIN" +
            " Account a on b.accountcc_id = a.id WHERE (s.id = :idStatus) and (s.id IN (4, 5, 6,7)) and a.id = :idAcc" +
            " ORDER BY b.id DESC")
    List<Bill> findBillsByStatusIds(@Param("idStatus") long idStatus,
                                    @Param("idAcc") long idAcc);
    @Query(nativeQuery = true, value = "SELECT * FROM Bill b JOIN Status s ON b.status_id = s.id JOIN" +
            " Account a on b.account_user_id = a.id WHERE (s.id = :idStatus) and (s.id IN (4, 5, 6,7)) and a.id = :idAcc" +
            " ORDER BY b.id DESC")
    List<Bill> findBillsByStatusAndByIdUser(@Param("idStatus") long idStatus,
                                    @Param("idAcc") long idAcc);
    @Query(value = "select b from Bill b join Account a on b.accountCC.id = a.id where a.id = :idAcc order by b.id desc ")
    List<Bill> getAllByAccountCC_Id(@Param("idAcc") long idAcc);
    @Query(value = "select b from Bill b join Account a on b.accountUser.id = a.id where a.id = :idAcc order by b.id desc ")
    List<Bill> getAllByAccountUser_Id(@Param("idAcc") long idAcc);
}
