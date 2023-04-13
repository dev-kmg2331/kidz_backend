package com.app.kidz.domain;

import com.app.kidz.domain.member.Member;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @RequiredArgsConstructor
public class Point {

    protected Point(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @NonNull
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer currentAmount;

    @NonNull
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer totalAmount;

    private LocalDateTime pointDate;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @PrePersist
    public void setPointDate(){
        this.pointDate = LocalDateTime.now();
    }
}
