package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Service
@Scope("prototype")
public class CreditProcess {
    @Autowired
    private CreditServiceImpl creditService;
    private LocalDate sonOdenis;
    private LocalDate bugunkiTarix=new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate();
    public double cerimeMeblegi(Credit credit){
        LocalDate baslamaTarixi=credit.getKreditinBaslamaTarixi().toLocalDate();
        double anaMegleg=credit.getAnaMebleg();
        double cerimeFaizi=credit.getCerimeFaizi()/100;
        try{
            this.sonOdenis = credit.getSonOdenisTarixi().toLocalDate();

        }catch(NullPointerException e){
            if(baslamaTarixi.plusDays(30).isAfter(bugunkiTarix)) {
                return 0;
            }
            else if(baslamaTarixi.plusDays(30).isBefore(bugunkiTarix)){
                int gecikmeGunleri=(int) ChronoUnit.DAYS.between(baslamaTarixi.plusDays(30),bugunkiTarix);
                return anaMegleg*(gecikmeGunleri*cerimeFaizi);
            }
        }
        if(sonOdenis.plusDays(30).isAfter(bugunkiTarix))
            return 0;
        int gecikmeGunleri=(int) ChronoUnit.DAYS.between(sonOdenis.plusDays(30),bugunkiTarix);
        return anaMegleg*(gecikmeGunleri*cerimeFaizi);
    }
    public double ayligOdenis(Credit credit){
        double anaMebleg=credit.getKreditMeblegi();
        double faiz=credit.getIllikFaiz()/100;
        double aylar=credit.getKreditinMuddeti();
        double odenis=(anaMebleg+(anaMebleg*(faiz/1.75/12*aylar)))/aylar;
        return odenis;
    }
    public double faizMeblegi(Credit credit) {
        double gunFaizi=credit.getIllikFaiz()/12/30/100;
        double anaMebleg=credit.getAnaMebleg();
        try {
             this.sonOdenis = credit.getSonOdenisTarixi().toLocalDate();
        }catch(NullPointerException e){
            int gunSayi= (int) ChronoUnit.DAYS.between(credit.getKreditinBaslamaTarixi().toLocalDate(),bugunkiTarix);
            return anaMebleg*(gunSayi*gunFaizi);
        }
        int gunSayi2=(int) ChronoUnit.DAYS.between(sonOdenis,bugunkiTarix);

        return anaMebleg*(gunSayi2*gunFaizi);

    }

}
