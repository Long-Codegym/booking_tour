package com.book_tour.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Account accountCC;
    @ManyToOne
    private Account accountUser;
    @ManyToOne
    private Tour tour;
    private Boolean isActive;
}
