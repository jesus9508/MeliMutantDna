package com.meli.dna.repositories;

import com.meli.dna.entities.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDnaRepository extends JpaRepository<DnaEntity, Long> {
}
