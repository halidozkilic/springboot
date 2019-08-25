package com.toyota.faultdetection.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ARIZATOYOTA")
public class Fault {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kayit_no")
    private Long id;

    @Column(name = "kayit_tarihi")
    private String registerDate;

    @Column(name = "kayit_yapan")
    private String recorder;

    @Column(name = "bildiren")
    private String reporter;

    @Column(name = "bildiren_tel")
    private String reporterTel;

    @Column(name = "ariza")
    private String faultType;

    @Column(name = "yeri")
    private String location;

    @Column(name = "shop")
    private String shop;

    @Column(name = "atanan")
    private String assigned;

    @Column(name = "acil")
    private String emergency;

    @Column(name = "is_bitimi_aciklama")
    private String explanation;

    @Column(name = "tamamlama_tarihi")
    private String endDay;

    @Column(name = "kayit_turu")
    private String kayitTuru;
}