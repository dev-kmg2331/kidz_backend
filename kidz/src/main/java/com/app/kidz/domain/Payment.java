package com.app.kidz.domain;

import com.app.kidz.domain.member.Member;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @RequiredArgsConstructor
public class Payment {

    protected Payment(){}

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @NonNull
    private Integer amount;

    @NonNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime paymentDateTime; // 결제일시

    @PrePersist
    public void setPaymentDate(){
        this.paymentDateTime = LocalDateTime.now();
    }
}
