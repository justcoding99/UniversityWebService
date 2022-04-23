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
public class Ogretmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long ogretmenNo;
    @Column(name = "ad")
    public String ad;
    @Column(name = "soyad")
    public String soyad;
    @Column(name = "dogumYeri")
    public String dogumYeri;
    @ManyToOne
    private Bolum bolum;
    @ManyToMany (fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<Ders> dersler ;
    @OneToOne (cascade = CascadeType.PERSIST)
    private Account account;
}
