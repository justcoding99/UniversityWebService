package com.example.okulproje.controller;
import com.example.okulproje.entities.Account;
import com.example.okulproje.entities.Bolum;
import com.example.okulproje.entities.Ogrenci;
import com.example.okulproje.model.OgrenciEkleRequest;
import com.example.okulproje.security.TokenService;
import com.example.okulproje.service.OgrenciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class OgrenciController {
    private final OgrenciService ogrenciService;
    private final TokenService tokenService;

    @PutMapping("ogrenciBilgiGuncelle/{id}")
    public void ogrenciBilgiGuncelle(@PathVariable int id,@RequestBody Ogrenci ogrenci, @RequestHeader (value = "Authorization") String token){
        tokenService.validateToken(token);
        ogrenciService.ogrenciBilgieriniGuncelle(id, ogrenci);
    }
    @PutMapping("ogrenciBolumGuncelle/{id}")
    public void ogrenciBolumGuncelle(@PathVariable int id, @RequestBody Bolum bolum, @RequestHeader (value = "Authorization") String token){
        tokenService.validateToken(token);
        ogrenciService.ogrenciBolumGuncelle(id,bolum);
    }
    @PutMapping("ogrenciHesapGuncelle/{id}")
    public void ogrenciHesapGuncelle(@PathVariable int id, @RequestBody Account account, @RequestHeader (value = "Authorization") String token){
        tokenService.validateToken(token);
        ogrenciService.ogrenciHesapGuncelle(id,account);
    }
    @PostMapping("/ogrenciEkle")
    public void ogrenciEkle(@RequestBody OgrenciEkleRequest ogrenci, @RequestHeader (value = "Authorization") String token){
        tokenService.validateToken(token);
        ogrenciService.ogrenciekle(ogrenci);
    }
    @PostMapping("/ogrenci")
    public void ogrenciEkle(@RequestBody OgrenciEkleRequest ogrenci){
        ogrenciService.ogrenciekle(ogrenci);
    }
    @GetMapping("/{id}")
    public Ogrenci ogrenciGetir(@PathVariable int id){
        return  ogrenciService.ogrenciGetir(id);
    }
    @DeleteMapping("/ogrencisil/{id}")
    public void ogrencisil(@PathVariable int id){
        ogrenciService.ogrencisil(id);
    }
    @DeleteMapping("ogrenciSil/{id}")
    public void ogrenciSilTokenIle(@PathVariable int id,@RequestHeader (value = "Authorization")String token){
        tokenService.validateToken(token);
        ogrenciService.ogrencisil2(id);
    }
}
