package com.mamedov.creditprogram.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(min = 7,max = 7 ,message = "Duzgun fin daxil edin")
    private String fin;
    @NotBlank
    private String vesiqeSeria;
    @NotBlank
    private String ad;
    @NotBlank
    private String soyad;
    @NotBlank
    private String ataAdi;
    @NotBlank
    private String vesiqeVerilmeYeri;
    @NotBlank
    private String qeydiyyatUnvan;
    @NotBlank
    private String faktikiUnvan;
    @NotBlank
    private String dogumYeri;
    @NotBlank
    private String telefon;
    @NotBlank
    private String isYeri;
    @NotBlank
    private String vezife;
    @NotNull(message = "Dogum tarixini qeyd edin")
    private Date dogumTarixi;
    @NotNull(message = "Vesiqenin verilme tarixini qeyd edin")
    private Date vesiqeVerilTarixi;
    @NotNull(message = "Vesiqenin bitme tarixini qeyd edin")
    private Date vesiqeBitmeTarixi;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private List<Credit> credits;
    public void addCredit(Credit credit){
        credits.add(credit);
    }
    public String getAtaAdi() {
        return ataAdi;
    }

    public void setAtaAdi(String ataAdi) {
        this.ataAdi = ataAdi;
    }

    public Client() {
    }

    public Client(String fin,String ataAdi, String vesiqeSeria, String ad, String soyad, String vesiqeVerilmeYeri, String qeydiyyatUnvan,
                  String faktikiUnvan, String dogumYeri, String telefon, String isYeri, String vezife, Date dogumTarixi,
                  Date vesiqeVerilTarixi, Date vesiqeBitmeTarixi) {
        this.fin = fin;
        this.ataAdi=ataAdi;
        this.vesiqeSeria = vesiqeSeria;
        this.ad = ad;
        this.soyad = soyad;
        this.vesiqeVerilmeYeri = vesiqeVerilmeYeri;
        this.qeydiyyatUnvan = qeydiyyatUnvan;
        this.faktikiUnvan = faktikiUnvan;
        this.dogumYeri = dogumYeri;
        this.telefon = telefon;
        this.isYeri = isYeri;
        this.vezife = vezife;
        this.dogumTarixi = dogumTarixi;
        this.vesiqeVerilTarixi = vesiqeVerilTarixi;
        this.vesiqeBitmeTarixi = vesiqeBitmeTarixi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getVesiqeSeria() {
        return vesiqeSeria;
    }

    public void setVesiqeSeria(String vesiqeSeria) {
        this.vesiqeSeria = vesiqeSeria;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getVesiqeVerilmeYeri() {
        return vesiqeVerilmeYeri;
    }

    public void setVesiqeVerilmeYeri(String vesiqeVerilmeYeri) {
        this.vesiqeVerilmeYeri = vesiqeVerilmeYeri;
    }

    public String getQeydiyyatUnvan() {
        return qeydiyyatUnvan;
    }

    public void setQeydiyyatUnvan(String qeydiyyatUnvan) {
        this.qeydiyyatUnvan = qeydiyyatUnvan;
    }

    public String getFaktikiUnvan() {
        return faktikiUnvan;
    }

    public void setFaktikiUnvan(String faktikiUnvan) {
        this.faktikiUnvan = faktikiUnvan;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getIsYeri() {
        return isYeri;
    }

    public void setIsYeri(String isYeri) {
        this.isYeri = isYeri;
    }

    public String getVezife() {
        return vezife;
    }

    public void setVezife(String vezife) {
        this.vezife = vezife;
    }

    public Date getDogumTarixi() {
        return dogumTarixi;
    }

    public void setDogumTarixi(Date dogumTarixi) {
        this.dogumTarixi = dogumTarixi;
    }

    public Date getVesiqeVerilTarixi() {
        return vesiqeVerilTarixi;
    }

    public void setVesiqeVerilTarixi(Date vesiqeVerilTarixi) {
        this.vesiqeVerilTarixi = vesiqeVerilTarixi;
    }

    public Date getVesiqeBitmeTarixi() {
        return vesiqeBitmeTarixi;
    }

    public void setVesiqeBitmeTarixi(Date vesiqeBitmeTarixi) {
        this.vesiqeBitmeTarixi = vesiqeBitmeTarixi;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }
}
