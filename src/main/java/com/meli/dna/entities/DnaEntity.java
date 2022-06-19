package com.meli.dna.entities;

import javax.persistence.*;

@Entity
@Table(name = DnaEntity.TABLE_NAME)
public class DnaEntity {
    public static final String TABLE_NAME = "dna";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dna")
    private String dna;
    @Column(name = "kindId")
    private Long kindId;


}
