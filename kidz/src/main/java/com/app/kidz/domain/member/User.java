package com.app.kidz.domain.member;

import com.app.kidz.domain.Address;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER")
@Getter
public class User extends Member {

    protected User() {
    }

    private String name;
    private String nickName;
    private String mobile;

    @Embedded
    private Address address;

    public User(String identification, String password, String email, MemberStatus status, MemberStatus isAdmin,
                String name, String nickName, String mobile, Address address) {
        super(identification, password, email, status, isAdmin);
        this.name = name;
        this.nickName = nickName;
        this.mobile = mobile;
        this.address = address;
    }
}
