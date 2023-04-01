package com.app.kidz.domain.entity;

import com.app.kidz.domain.enums.MemberRank;
import lombok.Builder;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "tbl_dream_personal_info")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_info_id")
    private Long id;

    @NonNull
    @Column(name = "member_name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "member_nickname", nullable = false)
    private String nickname;

    @NonNull
    @Column(name = "member_mobile", nullable = false)
    private String mobile;

    @NonNull
    @Column(name = "member_address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_rank")
    private MemberRank rank;

    @OneToOne
    @JoinColumn(name = "member_id")
    private User member;

    @PrePersist
    public void prePersist(){
        if(this.rank == null){
            this.rank = MemberRank.BRONZE;
        }
    }
}
