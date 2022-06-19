package com.meli.dna.repositories;

import com.meli.dna.entities.KindEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKindRepository extends JpaRepository<KindEntity, Long> {
}
