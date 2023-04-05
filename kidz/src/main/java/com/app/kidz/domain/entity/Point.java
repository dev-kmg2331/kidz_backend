package com.app.kidz.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "tbl_dream_point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private int amount;

//    @Column(name = "total_point", nullable = false)
//    private int totalPoint;

    @Column(name = "point_date")
    private LocalDateTime pointDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @PrePersist
    public void prePersist(){
        this.pointDate = LocalDateTime.now();
    }

    /* 연관관계 편의 메소드 */
    public void setMember(Member member){
        this.member = member;
        member.getPointList().add(this);
    }
}
