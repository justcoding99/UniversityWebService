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
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ogrenciNo;
    @Column(name = "ad")
    public String ad;
    @Column(name = "soyad")
    public String soyad;
    @Column(name = "dogumYeri")
    public String dogumYeri;

    @ManyToOne (cascade = CascadeType.ALL)
    private Bolum bolum;
    @ManyToMany (fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<Ders> dersler ;
    @OneToOne (cascade = CascadeType.ALL)
    private Account account;





}
