package com.example.okulproje.repository;

import com.example.okulproje.entities.Account;
import com.example.okulproje.entities.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OgrenciRepository extends JpaRepository<Ogrenci,Integer>{
    Ogrenci findByAccount(Account account);
}

