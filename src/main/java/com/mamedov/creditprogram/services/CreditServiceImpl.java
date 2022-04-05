package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.repository.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditServiceInter{
    @Autowired
    private CreditRepo creditRepo;

    @Override
    public List<Credit> getCredits() {
        return creditRepo.findAll();
    }
}
