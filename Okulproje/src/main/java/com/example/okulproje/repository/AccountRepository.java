package com.example.okulproje.repository;

import com.example.okulproje.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findAccountByUsernameAndPassword(String username, String password);

}
