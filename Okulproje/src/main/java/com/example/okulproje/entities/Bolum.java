package com.example.okulproje.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bolum {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int bolumId;
    @Column(name = "bolumAdi")
    public String bolumAdi;
    @Column (name = "aciklama")
    public String aciklama;
    @Column (name = "eposta")
    public String eposta;





}
