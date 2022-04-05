package com.mamedov.creditprogram.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int kreditMeblegi,illikFaiz,cerimeFaizi,kreditinMuddeti;
    @NotNull
    private Date kreditinBaslamaTarixi,kreditinBitmeTarixi;
    private String musteriElaqeNomlar;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    public Credit() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit(int kreditMeblegi, int illikFaiz, int cerimeFaizi, int kreditinMuddeti, Date kreditinBaslamaTarixi,
                  Date kreditinBitmeTarixi, String musteriElaqeNomlar) {
        this.kreditMeblegi = kreditMeblegi;
        this.illikFaiz = illikFaiz;
        this.cerimeFaizi = cerimeFaizi;
        this.kreditinMuddeti = kreditinMuddeti;
        this.kreditinBaslamaTarixi = kreditinBaslamaTarixi;
        this.kreditinBitmeTarixi = kreditinBitmeTarixi;
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

    public int getCerimeFaizi() {
        return cerimeFaizi;
    }

    public void setCerimeFaizi(int cerimeFaizi) {
        this.cerimeFaizi = cerimeFaizi;
    }

    public int getKreditinMuddeti() {
        return kreditinMuddeti;
    }

    public void setKreditinMuddeti(int kreditinMuddeti) {
        this.kreditinMuddeti = kreditinMuddeti;
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

    public String getMusteriElaqeNomlar() {
        return musteriElaqeNomlar;
    }

    public void setMusteriElaqeNomlar(String musteriElaqeNomlar) {
        this.musteriElaqeNomlar = musteriElaqeNomlar;
    }
}
