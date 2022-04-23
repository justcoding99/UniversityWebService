package com.example.okulproje.service;

import com.example.okulproje.entities.Bolum;
import com.example.okulproje.entities.Ogrenci;
import com.example.okulproje.repository.BolumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BolumService {
    private final BolumRepository bolumRepository;

    public void bolumEkle(Bolum bolum){
        Bolum bolum1 = new Bolum();
        bolum1.setBolumAdi(bolum.getBolumAdi());
        bolum1.setAciklama(bolum.getAciklama());
        bolum1.setEposta(bolum.getEposta());
        bolumRepository.save(bolum1);
    }


    public void bolumSil(int id){
        bolumRepository.deleteById(id);
    }
    public void bolumGuncelle(int id,Bolum bolum){
        Bolum bolum1= new Bolum();
        bolum1.setBolumId(id);
        bolum1.setBolumAdi(bolum.getBolumAdi());
        bolum1.setAciklama(bolum.getAciklama());
        bolum1.setEposta(bolum.getEposta());
        bolumRepository.save(bolum1);

    }
    public Bolum bolumGetir(int id){
         return bolumRepository.findById(id).orElseThrow(()-> new RuntimeException("Aranan id değerinde ders bulunamadı "));
    }


}
