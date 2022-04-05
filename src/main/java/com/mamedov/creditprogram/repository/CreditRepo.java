package com.mamedov.creditprogram.repository;

import com.mamedov.creditprogram.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepo extends JpaRepository<Credit,Integer> {
}
