package com.mamedov.creditprogram.repository;

import com.mamedov.creditprogram.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
