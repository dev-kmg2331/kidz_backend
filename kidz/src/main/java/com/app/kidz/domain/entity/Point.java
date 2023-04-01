package com.app.kidz.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_dream_point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @Column(name = "current_point", nullable = false)
    private int currentPoint;

    @Column(name = "total_point", nullable = false)
    private int totalPoint;

    @Column(name = "point_date")
    private LocalDateTime pointDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User member;
}
