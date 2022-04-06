package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Credit;
import com.mamedov.creditprogram.repository.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditServiceInter{
    @Autowired
    private CreditRepo creditRepo;

    @Override
    public List<Credit> getAllCredits() {
        return creditRepo.findAll();
    }

    @Override
    public int getAnaMebleg(Credit credit) {
        return creditRepo.getByAnaMebleg(credit);
    }

    @Override
    public void saveCredit(Credit credit) {
        creditRepo.save(credit);
    }

    @Override
    public Date getSonOdenis(Credit credit) {
        return creditRepo.getBySonOdenisTarixi(credit);
    }

    @Override
    public int getillikFaiz(Credit credit) {
        return creditRepo.getByIllikFaiz(credit);
    }
}
