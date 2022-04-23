package com.example.okulproje.controller;

import com.example.okulproje.entities.Ders;

import com.example.okulproje.model.DersEkleRequest;
import com.example.okulproje.service.DersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class DersController {
    private final DersService dersService;

    @GetMapping("/dersGetir/{id}")
    public Ders dersGetir(@PathVariable int id){
        return  dersService.dersGetir(id);
    }
    @DeleteMapping("/dersSil/{id}")
    public void dersSil(@PathVariable int id){
        dersService.dersSil(id);
    }
    @PostMapping("/ders")
    public void dersEkle(@RequestBody DersEkleRequest ders){
        dersService.dersEkle(ders);
    }
    @PutMapping("/dersGuncelle")
    public void dersGuncelle(@PathVariable int id,@RequestBody Ders ders){
        dersService.dersGuncelle(id,ders);
    }

}
