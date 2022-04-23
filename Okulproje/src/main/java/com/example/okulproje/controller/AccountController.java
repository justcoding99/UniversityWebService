package com.example.okulproje.controller;

import com.example.okulproje.entities.Account;
import com.example.okulproje.security.TokenService;
import com.example.okulproje.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final TokenService tokenService;
    @PostMapping("/account")
    public void accountEkle(@RequestBody Account account){
        accountService.accountEkle(account);
    }
    @PostMapping(path = "/auth")
    public ResponseEntity<String> login(@RequestBody Account account){
         return new ResponseEntity(tokenService.generateToken(accountService.login(account.getUsername(),account.getPassword())), HttpStatus.OK);
    }



}
