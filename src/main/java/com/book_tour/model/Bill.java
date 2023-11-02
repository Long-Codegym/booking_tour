package com.book_tour.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateCreate;
    private Date dateStart;
    private Date dateEnd;
    private long price;
    private long total;
    private int persons;
    private int children;
    private String note;
    private String numberPhone;
    private String address;
    private String fullName;
    @ManyToOne
    private Tour tour;
    @ManyToOne
    private Account accountCC;
    @ManyToOne
    private Account accountUser;
    @ManyToOne
    private Status status;
    private Boolean isActive;
}
