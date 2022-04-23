package com.example.okulproje.service;
import com.example.okulproje.entities.*;
import com.example.okulproje.model.OgrenciEkleRequest;
import com.example.okulproje.model.OgretmenEkleRequest;
import com.example.okulproje.repository.DersRepository;
import com.example.okulproje.repository.OgrenciRepository;
import com.example.okulproje.repository.OgretmenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
@RequiredArgsConstructor
public class OgretmenService {
    private final OgretmenRepository ogretmenRepository;


    public String ogretmenEkle(OgretmenEkleRequest ogretmen){
        Ogretmen ogretmen1 = new Ogretmen();
        ogretmen1.setAd(ogretmen.getAd());
        ogretmen1.setSoyad(ogretmen.getSoyad());
        ogretmen1.setDogumYeri(ogretmen.getDogumYeri());
        Account account = new Account();
        account.setUsername(ogretmen.getUsername());
        account.setPassword(ogretmen.getPassword());
        Bolum bolum1= new Bolum();
        bolum1.setBolumId(ogretmen.getBolumId());
        ogretmen1.setBolum(bolum1);
        ogretmen1.setAccount(account);
        ogretmenRepository.save(ogretmen1);
        return "Öğretmen oluştu";


    }
    public void ogretmenSil(int id){
        ogretmenRepository.deleteById(id);
    }











}
