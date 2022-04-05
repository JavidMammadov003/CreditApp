package com.mamedov.creditprogram.services;

import com.mamedov.creditprogram.entities.Client;

import java.util.List;

public interface ClientServiceInter {
    public void saveClient(Client client);
    public Client getClientById(int id);
    public List<Client> getAllClients();
    }
}
