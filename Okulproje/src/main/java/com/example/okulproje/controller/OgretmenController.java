package com.example.okulproje.controller;

import com.example.okulproje.model.OgrenciEkleRequest;
import com.example.okulproje.model.OgretmenEkleRequest;
import com.example.okulproje.security.TokenService;
import com.example.okulproje.service.OgretmenService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class OgretmenController {

    private final OgretmenService ogretmenService;
    private final TokenService tokenService;


    @PostMapping("/ogretmen")
    public void ogretmenEkle(@RequestBody OgretmenEkleRequest ogretmen, @RequestHeader (value = "Authorization") String token){
        tokenService.validateToken(token);
        ogretmenService.ogretmenEkle(ogretmen);
    }





}
