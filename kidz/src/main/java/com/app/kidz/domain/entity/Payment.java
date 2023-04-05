package com.app.kidz.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "tbl_dream_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "payment_date")
    private LocalDateTime date;

    @Column(name = "payment_amount", nullable = false)
    private int amount;

    @Column(name = "payment_method")
    private String method;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
