package com.book_tour.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class TourSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String day;
    @Lob
    private String content;
    @Lob
    private String img;
    @Lob
    private String start;
    @Lob
    private String morning;
    @Lob
    private String noon;
    @Lob
    private String afternoon;
    @Lob
    private String evening;
}
