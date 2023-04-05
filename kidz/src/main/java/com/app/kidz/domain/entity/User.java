package com.app.kidz.domain.entity;

import com.app.kidz.domain.enums.MemberRank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PersonalInfo")
@Getter @SuperBuilder @NoArgsConstructor
@Table(name = "tbl_dream_personal_info")
public class User extends Member {

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_nickname", nullable = false)
    private String nickname;

    @Column(name = "member_mobile", nullable = false)
    private String mobile;

    @Column(name = "member_address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_rank")
    private MemberRank rank;

    @PrePersist
    public void prePersist(){
        if(this.rank == null){
            this.rank = MemberRank.BRONZE;
        }
    }
}
