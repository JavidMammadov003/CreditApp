package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Service
public class CreditProcess {
    @Autowired
    private CreditServiceImpl creditService;

    public int faizMeblegi(Credit credit){
        LocalDate sonOdenis=creditService.getSonOdenis(credit).toLocalDate();
        LocalDate bugunkiTarix=new java.sql.Date(Calendar.getInstance().getTime().getTime()).toLocalDate();
        int gunSayi= (int) ChronoUnit.DAYS.between(sonOdenis,bugunkiTarix);
        int gunFaizMeblegi=creditService.getillikFaiz(credit)/12/30;
        int anaMebleg=creditService.getAnaMebleg(credit);
        return 0;
    }

}
