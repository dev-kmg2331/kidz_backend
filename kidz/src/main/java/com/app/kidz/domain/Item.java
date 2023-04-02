package com.app.kidz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Item {

    @Id
    @Column(name = "item_id")
    private Long id;
    private String name;
    private Integer price;
    private Integer stockQunatity;
}
