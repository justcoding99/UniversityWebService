package com.example.okulproje.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "ders")
public class Ders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int dersId;
    @Column(name = "dersAdi")
    public String dersAdi;
    @Column(name = "dersKodu")
    public String dersKodu;
    @Column(name = "kredi")
    public int kredi;
    @ManyToOne
    private Bolum bolum;
    @ManyToMany(fetch = FetchType.LAZY  ,  cascade = CascadeType.ALL)
    private Set<Ogrenci> ogrenciler ;
    @ManyToMany(fetch = FetchType.LAZY  ,  cascade = CascadeType.ALL)
    private Set<Ogretmen> ogretmenler;






}
