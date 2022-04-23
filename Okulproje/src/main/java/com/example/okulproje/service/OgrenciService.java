package com.example.okulproje.service;

import com.example.okulproje.entities.Account;
import com.example.okulproje.entities.Bolum;
import com.example.okulproje.entities.Ogrenci;
import com.example.okulproje.model.OgrenciEkleRequest;
import com.example.okulproje.repository.OgrenciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OgrenciService {
    private final OgrenciRepository ogrenciRepository;


   public String ogrenciBilgieriniGuncelle(int id, Ogrenci ogrenci){
       if(ogrenciRepository.findById(id).isPresent()){
           Ogrenci kayitliOgrenci= ogrenciRepository.findById(id).get();
           kayitliOgrenci.setAd(ogrenci.getAd());
           kayitliOgrenci.setSoyad(ogrenci.getSoyad());
           kayitliOgrenci.setDogumYeri(ogrenci.getDogumYeri());
           ogrenciRepository.save(kayitliOgrenci);
       }
       else{
           throw new RuntimeException("Kullanıcı Sisteme Kayıtlı Değil!!");
       }
       return "Kayıt güncellendi";
   }
   public String ogrenciBolumGuncelle(int id,Bolum bolumyeni){
          if(ogrenciRepository.findById(id).isPresent()){
           Ogrenci kayitliOgrenci= ogrenciRepository.findById(id).get();
           kayitliOgrenci.setBolum(bolumyeni);
           ogrenciRepository.save(kayitliOgrenci);
       }
       else{
           throw new RuntimeException("Kullanıcı Sisteme Kayıtlı Değil!!");
       }
       return "Kayıt güncellendi";
   }
    public String ogrenciHesapGuncelle(int id,Account accountyeni){
        if(ogrenciRepository.findById(id).isPresent()){
            Ogrenci kayitliOgrenci= ogrenciRepository.findById(id).get();
            kayitliOgrenci.setAccount(accountyeni);
            ogrenciRepository.save(kayitliOgrenci);
        }
        else{
            throw new RuntimeException("Kullanıcı Sisteme Kayıtlı Değil!!");
        }
        return "Kayıt güncellendi";
    }

    public String ogrenciekle(OgrenciEkleRequest ogrenci){
        Ogrenci ogrenci1 = new Ogrenci();
        ogrenci1.setAd(ogrenci.getAd());
        ogrenci1.setSoyad(ogrenci.getSoyad());
        ogrenci1.setDogumYeri(ogrenci.getDogumYeri());
        Account account = new Account();
        account.setUsername(ogrenci.getUsername());
        account.setPassword(ogrenci.getPassword());
        Bolum bolum1= new Bolum();
        bolum1.setBolumId(ogrenci.getBolumId());
        ogrenci1.setBolum(bolum1);
        ogrenci1.setAccount(account);
        ogrenciRepository.save(ogrenci1);
        return "oluştu";
    }
    public Ogrenci ogrenciGetir(int id){
        return ogrenciRepository.findById(id).orElseThrow(()-> new RuntimeException("Aranan id değerinde öğrenci bulunamadı "));
    }
    public void ogrencisil(int id){
        ogrenciRepository.deleteById(id);
    }
    public String ogrencisil2(int id){
        ogrenciRepository.deleteById(id);
         return "sildi";
    }




}
