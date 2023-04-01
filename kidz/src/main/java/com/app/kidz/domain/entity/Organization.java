package com.app.kidz.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_dream_organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long id;

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
    private User member;
}
