package com.example.okulproje.security;

import com.example.okulproje.entities.Account;
import com.example.okulproje.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final AccountService accountService;

    public String generateToken(Account account){
        String token = account.getAccountId()+":"+account.getUsername()+":"+account.getPassword();
        return Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }

    private Account decodeToken(String token){
        String decryptedToken = new String(Base64.getMimeDecoder().decode(token));
        String[] splitToken = decryptedToken.split(":");
        return new Account(Integer.valueOf(splitToken[0]),splitToken[1],splitToken[2]);
    }

    public void validateToken(String token){
        Account account = decodeToken(token);
        if(!accountService.checkAccountByUsernameAndPassword(account.getUsername(), account.getPassword())){
            throw new RuntimeException("Kullanıcı Sisteme Kayıtlı Değil!!");
        }
    }
}
