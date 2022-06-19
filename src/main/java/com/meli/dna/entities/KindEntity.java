package com.meli.dna.entities;

import javax.persistence.*;

@Table
@Entity(name = KindEntity.TABLE_NAME )
public class KindEntity {
    public static final String TABLE_NAME = "kind";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
