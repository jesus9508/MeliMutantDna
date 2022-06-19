package com.meli.dna.repositories;

import com.meli.dna.entities.KindEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKindRepository extends JpaRepository<KindEntity, Long> {
}
