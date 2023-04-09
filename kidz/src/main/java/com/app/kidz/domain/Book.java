package com.app.kidz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
@DiscriminatorValue("BOOK")
public class Book extends Item {

    private String author;
    private String publisher;
}
