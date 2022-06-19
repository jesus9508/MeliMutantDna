package com.meli.dna.repositories;

import com.meli.dna.entities.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDnaRepository extends JpaRepository<DnaEntity, Long> {
    Optional<DnaEntity> findFirstByDna(String dna);
}
