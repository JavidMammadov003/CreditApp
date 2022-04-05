package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.repository.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CreditServiceInter {
    public List<Credit> getCredits();




}
