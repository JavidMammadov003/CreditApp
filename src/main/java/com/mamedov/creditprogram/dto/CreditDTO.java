package com.mamedov.creditprogram.dto;

import com.mamedov.creditprogram.entities.Client;
import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.services.CreditProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

public class CreditDTO {
    @Autowired
    private CreditProcess process;
    private String musteriElaqeNomlar;
    private int id,kreditMeblegi,illikFaiz,cerimeFaizi,kreditinMuddeti,anaMebleg,cerimeMeblegi,faizMeblegi;
    private Date kreditinBaslamaTarixi,kreditinBitmeTarixi;
    private Client client;
    public CreditDTO(){}
    public CreditDTO(Credit credit){
        this.musteriElaqeNomlar=credit.getMusteriElaqeNomlar();
        this.id=credit.getId();
        this.cerimeFaizi= credit.getCerimeFaizi();
        this.kreditMeblegi=credit.getKreditMeblegi();
        this.illikFaiz=credit.getIllikFaiz();
        this.kreditinMuddeti=credit.getKreditinMuddeti();
        this.kreditinBaslamaTarixi=credit.getKreditinBaslamaTarixi();
        this.kreditinBitmeTarixi=credit.getKreditinBitmeTarixi();
//        this.faizMeblegi= process.faizMeblegi(credit);
        this.anaMebleg= credit.getAnaMebleg();
        this.client=credit.getClient();
    }

    public CreditProcess getProcess() {
        return process;
    }

    public void setProcess(CreditProcess process) {
        this.process = process;
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

    public int getAnaMebleg() {
        return anaMebleg;
    }

    public void setAnaMebleg(int anaMebleg) {
        this.anaMebleg = anaMebleg;
    }

    public int getCerimeMeblegi() {
        return cerimeMeblegi;
    }

    public void setCerimeMeblegi(int cerimeMeblegi) {
        this.cerimeMeblegi = cerimeMeblegi;
    }

    public int getFaizMeblegi() {
        return faizMeblegi;
    }

    public void setFaizMeblegi(int faizMeblegi) {
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
