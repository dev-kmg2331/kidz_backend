package com.app.kidz.domain.member;

import com.app.kidz.domain.Payment;
import com.app.kidz.domain.Point;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "dtype")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@RequiredArgsConstructor
public class Member {

    protected Member() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NonNull
    private String identification;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
    @NonNull
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    @NonNull
    private MemberStatus isAdmin;

    private LocalDateTime joinedAt;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Point> points = new ArrayList<>();

    @PrePersist
    public void setJoinedAt() {
        this.joinedAt = LocalDateTime.now();
    }
}
