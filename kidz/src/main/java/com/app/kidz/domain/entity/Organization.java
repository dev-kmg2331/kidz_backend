package com.app.kidz.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Organization")
@Getter @Setter @NoArgsConstructor
@Table(name = "tbl_dream_organization")
public class Organization extends Member {

    @Column(name = "organization_name", nullable = false)
    private String name;

    @Column(name = "organization_address")
    private String address;

    @Column(name = "organization_phone")
    private String phone;

    @Column(name = "organization_email")
    private String email;

    @Column(name = "organization_registration_number", nullable = false)
    private String registrationNumber;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
