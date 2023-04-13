package com.app.kidz.domain.member;

import com.app.kidz.domain.Address;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ORG")
@Getter
public class Organization extends Member {

    protected Organization() {
    }

    private String name;
    private Address address;
    private String phone;
    private String registrationNumber;

    public Organization(String identification, String password, String email, MemberStatus status, MemberStatus isAdmin,
                        String name, Address address, String phone, String registrationNumber) {
        super(identification, password, email, status, isAdmin);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.registrationNumber = registrationNumber;
    }
}
