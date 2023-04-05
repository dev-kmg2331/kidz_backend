package com.app.kidz.domain.entity;

import com.app.kidz.domain.enums.MemberStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor @Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tbl_dream_member")
//@SequenceGenerator(name = "member_seq_generator", initialValue = 1, allocationSize = 50)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_identification", nullable = false)
    private String identification;

    @Column(name = "member_pw", nullable = false)
    private String password;

    @Column(name = "member_email", nullable = false)
    private String email;

    @Column(name = "member_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Column(name = "is_admin", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus isAdmin;

    @Column(name = "joined_at", updatable = false)
    private LocalDateTime joinedAt;

    @OneToOne(mappedBy = "member")
    private PersonalInfo personalInfo;

    @OneToOne(mappedBy = "member")
    private Organization organization;

    @OneToMany(mappedBy = "member")
    private List<Payment> paymentList;

    @OneToMany(mappedBy = "member")
    private List<Point> pointList;

    @PrePersist
    private void prePersist() {
        if (this.status == null) {
            this.status = MemberStatus.ACTIVE;
        }
        if (this.isAdmin == null) {
            this.isAdmin = MemberStatus.NOT_ADMIN;
        }
    }
}
