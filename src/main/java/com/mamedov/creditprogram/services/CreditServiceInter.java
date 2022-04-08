package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.repository.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

public interface CreditServiceInter {
     List<Credit> getAllCredits();
     void saveCredit(Credit credit);
     int getAnaMebleg(Credit credit);
     Date getSonOdenis(Credit credit);
     int getillikFaiz(Credit credit);




}
