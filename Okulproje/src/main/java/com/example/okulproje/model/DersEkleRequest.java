package com.example.okulproje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DersEkleRequest {
    public String dersAdi;
    public String dersKodu;
    public int kredi;
    public int bolumId;
}
