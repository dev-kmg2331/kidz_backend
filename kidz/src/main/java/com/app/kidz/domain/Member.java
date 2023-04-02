package com.app.kidz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Member {

    @Id @GeneratedValue @Column(name = "member_id")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    // 객체의 양방향 관계는 사실 양방향이 아니라,
    // 두 개의 단방향 연관관계로 이루어진다.
    // 반면 테이블은 외래키 하나로 두 테이블을 참조할 수 있다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
