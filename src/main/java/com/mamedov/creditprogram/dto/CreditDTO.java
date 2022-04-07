package com.mamedov.creditprogram.dto;

import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.entities.Credit;

import org.apache.commons.math3.util.Precision;


import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class CreditDTO {
    private final LocalDate bugunkiTarix=new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate();
    private LocalDate sonOdenis;
    private String musteriElaqeNomlar;
    private double ayligOdenis,cerimeMeblegi,faizMeblegi,cerimeFaizi,anaMebleg;
    private int id,kreditMeblegi,illikFaiz,kreditinMuddeti;
    private Date kreditinBaslamaTarixi,kreditinBitmeTarixi;
    private Client client;

    public CreditDTO(Credit credit){
        this.musteriElaqeNomlar=credit.getMusteriElaqeNomlar();
        this.id=credit.getId();
        this.cerimeFaizi= credit.getCerimeFaizi();
        this.kreditMeblegi=credit.getKreditMeblegi();
        this.illikFaiz=credit.getIllikFaiz();
        this.kreditinMuddeti=credit.getKreditinMuddeti();
        this.kreditinBaslamaTarixi=credit.getKreditinBaslamaTarixi();
        this.kreditinBitmeTarixi=credit.getKreditinBitmeTarixi();
        this.anaMebleg= credit.getAnaMebleg();
        this.faizMeblegi= Precision.round(faizMeblegi(credit),2);
        this.ayligOdenis= Precision.round(ayligOdenis(credit),2);
        this.cerimeMeblegi=Precision.round(cerimeMeblegi(credit),2);
        this.client=credit.getClient();
    }
    private double faizMeblegi(Credit credit) {
        double gunFaizi=credit.getIllikFaiz()/12.0/30.0;
        double anaMebleg=credit.getAnaMebleg();
        try {
            this.sonOdenis = credit.getSonOdenisTarixi().toLocalDate();
        }catch(NullPointerException e){
            int gunSayi= (int) ChronoUnit.DAYS.between(credit.getKreditinBaslamaTarixi().toLocalDate(),bugunkiTarix);
            System.out.println(bugunkiTarix);
            return (anaMebleg*gunSayi*gunFaizi)/100.0;
        }
        int gunSayi2=(int) ChronoUnit.DAYS.between(sonOdenis,bugunkiTarix);

        return anaMebleg*(gunSayi2*gunFaizi)/100.0;

    }
    private double cerimeMeblegi(Credit credit) {
        LocalDate baslamaTarixi = credit.getKreditinBaslamaTarixi().toLocalDate();
        double anaMebleg = credit.getAnaMebleg();
        double cerimeFaizi = credit.getCerimeFaizi();
        try {
            this.sonOdenis = credit.getSonOdenisTarixi().toLocalDate();

        } catch (NullPointerException e) {
            if (baslamaTarixi.plusDays(30).isAfter(bugunkiTarix)) {
                return 0;
            } else if (baslamaTarixi.plusDays(30).isBefore(bugunkiTarix)) {
                int gecikmeGunleri = (int) ChronoUnit.DAYS.between(baslamaTarixi.plusDays(30), bugunkiTarix);
                return anaMebleg * (gecikmeGunleri * cerimeFaizi)/100.0;
            }
        }
        if (sonOdenis.plusDays(30).isAfter(bugunkiTarix))
            return 0;
        int gecikmeGunleri = (int) ChronoUnit.DAYS.between(sonOdenis.plusDays(30), bugunkiTarix);
        return anaMebleg * (gecikmeGunleri * cerimeFaizi)/100.0;
    }

    private  double ayligOdenis(Credit credit){
        double anaMebleg=credit.getKreditMeblegi();
        double faiz=credit.getIllikFaiz();
        double aylar=credit.getKreditinMuddeti();
        return (anaMebleg+(anaMebleg*(faiz/1.75/12*aylar)/100))/aylar;
    }
    public double getAyligOdenis() {
        return ayligOdenis;
    }

    public void setAyligOdenis(double ayligOdenis) {
        this.ayligOdenis = ayligOdenis;
    }

    public String getMusteriElaqeNomlar() {
        return musteriElaqeNomlar;
    }

    public void setMusteriElaqeNomlar(String musteriElaqeNomlar) {
        this.musteriElaqeNomlar = musteriElaqeNomlar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKreditMeblegi() {
        return kreditMeblegi;
    }

    public void setKreditMeblegi(int kreditMeblegi) {
        this.kreditMeblegi = kreditMeblegi;
    }

    public int getIllikFaiz() {
        return illikFaiz;
    }

    public void setIllikFaiz(int illikFaiz) {
        this.illikFaiz = illikFaiz;
    }

    public double getCerimeFaizi() {
        return cerimeFaizi;
    }

    public void setCerimeFaizi(double cerimeFaizi) {
        this.cerimeFaizi = cerimeFaizi;
    }

    public int getKreditinMuddeti() {
        return kreditinMuddeti;
    }

    public void setKreditinMuddeti(int kreditinMuddeti) {
        this.kreditinMuddeti = kreditinMuddeti;
    }

    public double getAnaMebleg() {
        return anaMebleg;
    }

    public void setAnaMebleg(double anaMebleg) {
        this.anaMebleg = anaMebleg;
    }

    public double getCerimeMeblegi() {
        return cerimeMeblegi;
    }

    public void setCerimeMeblegi(double cerimeMeblegi) {
        this.cerimeMeblegi = cerimeMeblegi;
    }

    public double getFaizMeblegi() {
        return faizMeblegi;
    }

    public void setFaizMeblegi(double faizMeblegi) {
        this.faizMeblegi = faizMeblegi;
    }

    public Date getKreditinBaslamaTarixi() {
        return kreditinBaslamaTarixi;
    }

    public void setKreditinBaslamaTarixi(Date kreditinBaslamaTarixi) {
        this.kreditinBaslamaTarixi = kreditinBaslamaTarixi;
    }

    public Date getKreditinBitmeTarixi() {
        return kreditinBitmeTarixi;
    }

    public void setKreditinBitmeTarixi(Date kreditinBitmeTarixi) {
        this.kreditinBitmeTarixi = kreditinBitmeTarixi;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
