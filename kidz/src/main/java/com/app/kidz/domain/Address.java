package com.app.kidz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor
@Embeddable
public class Address {

    protected Address(){}

    private String addressMain;
    private String addressDetail;
    private String zipcode;
}
