package com.example.okulproje.service;
import com.example.okulproje.entities.Ders;
import com.example.okulproje.model.DersEkleRequest;
import com.example.okulproje.repository.DersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DersService {
    private final DersRepository dersRepository;
    private final BolumService bolumService;
    public Ders dersGetir(int id){
        return dersRepository.findById(id).orElseThrow(()-> new RuntimeException("Aranan id değerinde öğrenci bulunamadı "));
    }
    public void dersEkle(DersEkleRequest ders) {
        Ders ders1 = new Ders();
        ders1.setDersAdi(ders.getDersAdi());
        ders1.setDersKodu(ders.getDersKodu());
        ders1.setKredi(ders.getKredi());
        ders1.setBolum(bolumService.bolumGetir(ders.bolumId));
        dersRepository.save(ders1);
    }

    public void dersSil(int id){
        dersRepository.deleteById(id);
    }
    public void dersGuncelle(int id, Ders ders){
        Ders ders1 = new Ders();
        ders1.setKredi(id);
        ders1.setDersAdi(ders.getDersAdi());
        ders1.setDersKodu(ders.getDersKodu());
        ders1.setBolum(ders.getBolum());
        ders1.setKredi(ders.getKredi());
        dersRepository.save(ders1);
    }


}
