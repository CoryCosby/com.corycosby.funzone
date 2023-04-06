package com.corycosby.funzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corycosby.funzone.model.Score;

@Repository //Indicates ScoreRepository interface as a @Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
