package com.example.okulproje.controller;

import com.example.okulproje.entities.Bolum;
import com.example.okulproje.service.BolumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BolumController {
    private final BolumService bolumService;
    @GetMapping("/bolumGetir/{id}")
    public Bolum bolumGetir(@PathVariable int id){
        return bolumService.bolumGetir(id);
    }
    @DeleteMapping("/bolumSil/{id}")
    public void bolumSil(@PathVariable int id){
        bolumService.bolumSil(id);
    }
    @PostMapping("/bolum")
    public void bolumEkle(@RequestBody Bolum bolum){
        bolumService.bolumEkle(bolum);
    }
    @PutMapping("/bolumGuncelle/{id}")
    public void bolumGuncelle(@PathVariable int id ,@RequestBody Bolum bolum){
        bolumService.bolumGuncelle(id, bolum);
    }

}
