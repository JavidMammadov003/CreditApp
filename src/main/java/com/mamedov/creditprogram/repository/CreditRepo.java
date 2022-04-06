package com.mamedov.creditprogram.repository;

import com.mamedov.creditprogram.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface CreditRepo extends JpaRepository<Credit,Integer> {
    int getByAnaMebleg(Credit credit);
    Date getBySonOdenisTarixi(Credit credit);
    int getByIllikFaiz(Credit credit);
}
