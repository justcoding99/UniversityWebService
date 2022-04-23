package com.example.okulproje.repository;

import com.example.okulproje.entities.Account;
import com.example.okulproje.entities.Ogretmen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OgretmenRepository extends JpaRepository<Ogretmen,Integer> {
    //Ogretmen getById(Ogretmen accountId);
    Ogretmen findByAccount(Account account);


}
