package com.example.okulproje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OgretmenEkleRequest {
    private String ad;
    private String soyad;
    private String dogumYeri;
    private String username;
    private String password;
    private int bolumId;
    private int accountId;


}
