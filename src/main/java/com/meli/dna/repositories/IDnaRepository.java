package com.meli.dna.repositories;

import com.meli.dna.entities.DnaEntity;
import com.meli.dna.projections.IStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDnaRepository extends JpaRepository<DnaEntity, Long> {
    Optional<DnaEntity> findFirstByDna(String dna);

    @Query("select count(d.kindId) as count from DnaEntity d where d.kindId = :kind")
    IStats getStatsOf(@Param("kind") Long kindId);
}
