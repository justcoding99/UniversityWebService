package com.example.okulproje.repository;

import com.example.okulproje.entities.Bolum;
import com.example.okulproje.entities.Ders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BolumRepository extends JpaRepository<Bolum,Integer> {

    Optional<Ders> findByBolumId(int id);
}
