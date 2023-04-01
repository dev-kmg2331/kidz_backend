package com.app.kidz.helloJpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY/*, generator = "member_seq_generator"*/)
    private Long id;

    @Column(/*name = "name", */updatable = false, nullable = false/*,unique = true, length = 10, */)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModifiedDate;

    // DB에 반영 X
    @Transient
    private Integer temp;

    // 큰 내용?
    @Lob
    private String description;

    @PrePersist
    public void setDate() {
        this.lastModifiedDate = LocalDateTime.now();
        this.createDate = LocalDateTime.now();
    }
}
