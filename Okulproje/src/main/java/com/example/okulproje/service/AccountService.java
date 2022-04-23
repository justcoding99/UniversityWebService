package com.example.okulproje.service;

import com.example.okulproje.entities.Account;

import com.example.okulproje.repository.AccountRepository;

import com.example.okulproje.security.TokenService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
     private final AccountRepository accountRepository;

   public Account accountEkle(Account account){
      Account account1= new Account();
      account1.setUsername(account.getUsername());
      account1.setPassword(account.getPassword());
      return account1;
   }

   public Boolean checkAccountByUsernameAndPassword(String username, String password){
      return accountRepository.findAccountByUsernameAndPassword(username,password).isPresent();
   }

   public Account login(String username, String password) {
      Optional<Account> accountOptional = accountRepository.findAccountByUsernameAndPassword(username, password);
      if (accountOptional.isPresent()) {
         return  accountOptional.get();
      }
      else {
         throw new RuntimeException("Kullanıcı adı veya şifre yanlış!");
      }
   }
   //account tablosunda araştıralacak username.
   public String loginWithUsernameToken(String username, String password){
      Optional<Account> accountOptional = accountRepository.findAccountByUsernameAndPassword(username, password);
      Account account = accountOptional.get();
      String birlesmisEncode= new String(Base64.getEncoder().encode(( new String(Base64.getEncoder().encode(account.getUsername().getBytes(StandardCharsets.UTF_8)))
              +new String(Base64.getEncoder().encode(account.getPassword().getBytes(StandardCharsets.UTF_8)))).getBytes(StandardCharsets.UTF_8))) ;
      return birlesmisEncode;
   }
//account tablosunda araştıralacak username.




   //   String kısaEncode = new String(Base64.getEncoder().encode(account.getUsername().getBytes(StandardCharsets.UTF_8)));
   //encode password
       /*  String passwordEncode= account.getPassword();
         String passwordEnc = new String(Base64.getEncoder().encode(passwordEncode.getBytes(StandardCharsets.UTF_8)));
          //DECODER
         Base64.Decoder dec = Base64.getDecoder();
         String decoded = new String(dec.decode(encode));
         System.out.println("decoded value is \t" + decoded);

         Base64.Decoder dec2 =Base64.getDecoder();
         String decoded2= new String(dec2.decode(passwordEnc));
         System.out.println("decoded value is \t" + decoded2);

         //encode username and password
         String birlesmis=usernameEncode+passwordEncode;
         String birlesmisEncode= new String(Base64.getEncoder().encode(birlesmis.getBytes(StandardCharsets.UTF_8))) ;
         String decodedbirlesmis=decoded+decoded2;
         Base64.Decoder dec3 = Base64.getDecoder();
         System.out.println("decoded value is with \t" + new String(dec3.decode(birlesmisEncode)));

         if (decoded.equals(account.getUsername())) {
            System.out.println("Kayıt bulundu !");
         } else {
            return "Kullanıcı adı veya şifre yanlış";
         }

*/






}
