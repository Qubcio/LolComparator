package com.qubcio.jsoup.repository;

import com.qubcio.jsoup.model.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository extends JpaRepository<Champion, Integer> {

    Champion findAllById(Integer id);
}
