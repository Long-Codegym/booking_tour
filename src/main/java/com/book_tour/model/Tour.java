package com.book_tour.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Long price;
    private String convenientWard;
    private int tourTime;
    private String schedule;
    private int bookings;
    private long discount;
    @Lob
    private String img;
    @Lob
    private String describes;
    @ManyToOne
    private Account account;
    @ManyToOne
    private City city;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Supply> supplies;
    @ManyToMany
    private List<TourSchedule> tourSchedule;
    private Boolean isActive;
}
